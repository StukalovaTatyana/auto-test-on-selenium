package com.a1qa.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataConfiguration {
    protected static Properties PROPERTIES;

    static {
        try (FileInputStream fileInputStream = new FileInputStream(Configuration.getTestDataPath())) {
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * метод для возврата строки со значением из файла с настройками
     */
    private static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

}
