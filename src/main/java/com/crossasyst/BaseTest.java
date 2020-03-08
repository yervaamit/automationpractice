package com.crossasyst;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BaseTest {

    private static BaseTest instance = null;
    public static WebDriver webDriver;
    private final static Logger logger = Logger.getLogger("BaseTest");
    private static Properties prop;
    private static int lastResult = 0;
    ChromeOptions chromeOptions = new ChromeOptions();


    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        loadPropertyFile("./config.properties");
    }

    public static BaseTest getInstance() {
        if (instance == null) {
            instance = new BaseTest();
        }
        return instance;
    }


    public void setDriver(String browser) {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
                //BaseTest.class.getResource("/src/main/resources/drivers/chromedriver").getPath());
//        chromeOptions.addArguments("--headless --disable-gpu");
//        chromeOptions.addArguments("--headless");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }


    public WebDriver getDriver() {
        setDriver(prop.getProperty("Browser"));
        return webDriver;
    }


    private static void loadPropertyFile(String... properties) {
        FileInputStream fis;
        prop = new Properties();
        try {
            for (String propertyFile : properties) {
                fis = new FileInputStream(propertyFile);
                prop.load(fis);
            }
        } catch (java.io.IOException e) {
            logger.log(Level.WARNING, "Could not load Property File : " + e.getMessage());
        }
    }

    public static String getValue(String key) {

        return prop.getProperty(key);
    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        webDriver.close();
        webDriver.quit();
    }
}

