package com.a1qa.utils;

import org.apache.log4j.Logger;

public class LoggerManager {
    final static Logger logger = Logger.getLogger(LoggerManager.class.toString());

    public static Logger getLogger() {
        return logger;
    }
}
