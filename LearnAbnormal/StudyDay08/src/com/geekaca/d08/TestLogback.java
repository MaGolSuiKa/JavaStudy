package com.geekaca.d08;

//日志接口，入口类，由logback包提供实现
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * slf4j 定义了一系列日志规范
 * logback 实现这些规范
 */

public class TestLogback {
    public static final Logger LOGGER = LoggerFactory.getLogger(TestLogback.class);
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            LOGGER.info("这是一个info信息");
            LOGGER.debug("这是一条debug信息");
            LOGGER.error("这是一条error信息");
        }

    }
}
