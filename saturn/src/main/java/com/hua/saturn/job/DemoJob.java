package com.hua.saturn.job;

import com.hua.saturn.service.DemoService;
import com.vip.saturn.job.AbstractSaturnJavaJob;
import com.vip.saturn.job.SaturnJobExecutionContext;
import com.vip.saturn.job.SaturnJobReturn;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author niqinhua
 * @date 2020/3/30 11:18
 */
@Slf4j
@Component
public class DemoJob extends AbstractSaturnJavaJob {


    @Resource
    private DemoService demoService;

    @Override
    public SaturnJobReturn handleJavaJob(String jobName, Integer shardItem, String shardParam,
                                         SaturnJobExecutionContext shardingContext) throws InterruptedException {
        log.info("{} is running, item is {}", jobName, shardItem);
        demoService.doing();
        return new SaturnJobReturn();
    }

}