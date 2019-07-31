package com.xinyi.readdatafromhbase.runner;

import com.xinyi.readdatafromhbase.task.StartReadData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

/**
 * 功能说明:
 * author: haonan.bian
 * date: 2018/10/15 15:35
 * Copyright (C)1997-2018 深圳信义科技 All rights reserved.
 */
@Order(1)
public class StartupRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(StartupRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("startup runner");
        StartReadData readData = new StartReadData();
        Thread thread1 = new Thread(readData);
        thread1.start();
        logger.info("start read data listening over ");
    }
}
