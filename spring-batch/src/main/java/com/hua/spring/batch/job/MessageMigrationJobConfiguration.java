package com.hua.spring.batch.job;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.hua.spring.batch.pojo.Message;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import javax.persistence.EntityManagerFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * @author niqinhua
 * @date 2020/3/30 15:41
 */
@Configuration
public class MessageMigrationJobConfiguration {
    private static final String MESSAGE_FILE = "";
    private static final int CHUNK_SIZE = 50;
    private static final int SKIP_LIMIT = 1;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job messageMigrationJob(@Qualifier("messageMigrationStep") Step messageMigrationStep) {
        return jobBuilderFactory.get("messageMigrationJob")
                .start(messageMigrationStep)
                .build();
    }

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step messageMigrationStep(@Qualifier("jsonMessageReader") FlatFileItemReader<Message> jsonMessageReader,
                                     @Qualifier("messageItemWriter") JpaItemWriter<Message> messageItemWriter,
                                     @Qualifier("errorWriter") Writer errorWriter) {

        //我们的Step中可以构建很多东西，比如reader，processer，writer，listener等等。
        return stepBuilderFactory.get("messageMigrationStep")
                //每次读取一条数据，再处理一条数据，累积到一定数量CHUNK_SIZE后再一次性交给writer进行写入操作
                //spring batch处理了CHUNK_SIZE条数据后，再统一向数据库写入。
                .<Message, Message>chunk(CHUNK_SIZE)
                //Spring Batch给我们提供了很多好用实用的reader，基本能满足我们所有需求。比如FlatFileItemReader，JdbcCursorItemReader，JpaPagingItemReader等。
                //FlatFileItemReader是从文件里面一行一行的读取数据

                //Spring Batch提供了skip的机制，也就是说，如果出错了，可以跳过。如果你不设置skip，那么一条数据出错了，整个job都会挂掉。
                //设置skip的时候一定要设置什么Exception才需要跳过，并且跳过多少条数据。如果失败的数据超过你设置的skip limit，那么job就会失败。
                //Retry:失败之后可以重试，你同样需要设置重试的次数。如果同时设置了retry和skip，会先重试所有次数，然后再开始skip。比如retry是10次，skip是20，会先重试10次之后，再开始算第一次skip。
                .reader(jsonMessageReader).faultTolerant().skip(JsonParseException.class).skipLimit(SKIP_LIMIT)
                //listener很好理解，就是用来监听每个步骤的结果。比如可以有监听step的，有监听job的，有监听reader的，有监听writer的。
                //在本例子里面，我只关心，read的时候有没有出错，和write的时候有没有出错
                .listener(new ItemReadListener<Message>() {
                    @Override
                    public void beforeRead() {
                    }

                    @Override
                    public void afterRead(Message item) {
                    }

                    @Override
                    public void onReadError(Exception ex) {
                        try {
                            errorWriter.write(String.format("%s%n", ex.getMessage()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                })
                //Spring Batch同样给我们提供很多好用实用的writer。比如JpaItemWriter，FlatFileItemWriter，HibernateItemWriter，JdbcBatchItemWriter等。
                //JpaItemWriter，可以直接把Message对象写到数据库里面。但是需要设置一个EntityManagerFactory,可以注入进来。
                .writer(messageItemWriter).faultTolerant().skip(Exception.class).skipLimit(SKIP_LIMIT)
                .listener(new ItemWriteListener<Message>() {
                    @Override
                    public void beforeWrite(List<? extends Message> items) {
                    }

                    //write的listener传入参数是一个List，因为它是累积到一定的数量才一起写入。
                    @Override
                    public void afterWrite(List<? extends Message> items) {
                    }

                    @Override
                    public void onWriteError(Exception exception, List<? extends Message> items) {
                        try {
                            errorWriter.write(String.format("%s%n", exception.getMessage()));

                            for (Message message : items) {
                                errorWriter.write(String.format("Failed writing message id: %s", message.getObjectId()));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                })
                .build();
    }

    @Bean
    public FlatFileItemReader<Message> jsonMessageReader() {
        FlatFileItemReader<Message> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(new File(MESSAGE_FILE)));
        //LineMapper的输入 就是 获取一行文本，和行号，然后转换成Message。
        reader.setLineMapper(new LineMapper() {
            private MappingJsonFactory factory = new MappingJsonFactory();

            @Override
            public Message mapLine(String line, int lineNumber) throws Exception {
                JsonParser parser = factory.createParser(line);
                Map<String, Object> map = (Map) parser.readValueAs(Map.class);
                Message message = new Message();
                //... // 转换逻辑
                return message;
            }
        });
        return reader;
    }

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public JpaItemWriter<Message> messageItemWriter() {
        JpaItemWriter<Message> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory);
        return writer;
    }

    @Bean
    public Writer  errorWriter() {
        Writer writer = null;
        try {
            writer = new FileWriter("errorfile");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer;
    }
}
