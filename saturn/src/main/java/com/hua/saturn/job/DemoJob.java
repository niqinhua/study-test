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

    /**
     * handleJavaJob方法的传入参数:
     * jobName：作业名；shardItem：分片编号（从0开始）分片参数（在Console配置)；shardParam：分片参数（在Console配置）；context：调用上下文
     * handleJavaJob方法是作业调用主入口，当调度周期到达时，Saturn会调用该方法。
     */
    @Override
    public SaturnJobReturn handleJavaJob(String jobName, Integer shardItem, String shardParam,
                                         SaturnJobExecutionContext shardingContext) throws InterruptedException {
        log.info("{} is running, item is {}", jobName, shardItem);
        demoService.doing();

        /*JavaJobReturn是作业结果返回的封装。里面三个成员变量，包括：
        returnCode: 结果码。0代表结果成功，其余值代表失败。默认为0。用户可以根据自己业务的情况设置返回值，但注意，如下返回码是保留字不能使用，包括：0，1，2，9999。
        returnMsg：返回信息。将显示在Console里面。没有默认值。
        errorGroup：异常码。详情参见教程。*/
        return new SaturnJobReturn();
    }

}