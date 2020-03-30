package com.hua.saturn.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author niqinhua
 * @date 2020/3/30 11:45
 */
@Slf4j
@Service
public class DemoService {


    public void doing() {
        log.info("DemoService is doing...");
    }

}
