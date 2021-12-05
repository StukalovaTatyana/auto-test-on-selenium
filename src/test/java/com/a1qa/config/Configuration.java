package com.a1qa.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    protected static Properties PROPERTIES;

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/conf.properties")){
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

    public static int getScreenWidth() {
        return Integer.parseInt(getProperty("screenWidth"));
    }

    public static int getScreenHeight() {
        return Integer.parseInt(getProperty("screenHeight"));
    }

    public static String getUrl() {
        return getProperty("url");
    }

    public static int getDefaultLongTimeout() {
        return Integer.parseInt(getProperty("defaultLongTimeout"));
    }
    public static int getDefaultMiddleTimeout(){
        return Integer.parseInt(getProperty("defaultMiddleTimeout"));
    }
    public static int getDefaultShortTimeout() {
        return Integer.parseInt(getProperty("defaultShortTimeout"));
    }

    public static String getLang() {
        return getProperty("lang");
    }
    public static String getBrowserName(){
        return getProperty("browser");
    }
}

