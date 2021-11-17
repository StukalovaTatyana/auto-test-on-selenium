package com.a1qa;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChromeTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass(){
        ChromeDriverManager.getInstance().setup();
    }

    @Test
    public void test(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://store.steampowered.com");
    }

}
