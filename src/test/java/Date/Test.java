package Date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author niqinhua
 * @date 2020/4/7 11:02
 */
public class Test {
    public static void main(String[] args) {
        Long time = 15804864045678L;
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time),ZoneId.systemDefault());
        long l = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(l);
    }
}
