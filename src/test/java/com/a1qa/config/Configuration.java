package com.a1qa.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    static {
        try {
            //указание пути до файла с настройками
            fileInputStream = new FileInputStream("src/test/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            //обработка возможного исключения (нет файла и т.п.)
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * метод для возврата строки со значением из файла с настройками
     */
    private static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

    public static int getScreenWidth() {
        return Integer.parseInt(getProperty("screenWidth"));
    }

    public static int getScreenHeight() {
        return Integer.parseInt(getProperty("screenHeight"));
    }

    public static String getUrl() {
        return getProperty("steamPage");
    }

    public static int getDefaultTimeout() {
        return Integer.parseInt(getProperty("defaultTimeout"));
    }

    public static String getLang() {
        return getProperty("lang");
    }
}
