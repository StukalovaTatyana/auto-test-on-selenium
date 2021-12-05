package com.a1qa;

import com.a1qa.config.Configuration;
import com.a1qa.utils.DriverManager;
import org.testng.annotations.Test;

public class BaseTest {
    @Test
    public void countPlayingLowerThenOnlineTest() {
        DriverManager instance = DriverManager.getInstance();
        instance.openBrowser();
        instance.getDriver().get(Configuration.getUrl());

    }
}
