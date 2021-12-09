package com.a1qa.utils;

import java.util.logging.Logger;

public class LoggerManager {
    final static Logger logger = Logger.getLogger(LoggerManager.class.toString());

    public static Logger getLogger() {
        return logger;
    }
}
