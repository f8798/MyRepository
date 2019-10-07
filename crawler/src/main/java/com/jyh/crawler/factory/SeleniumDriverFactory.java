package com.jyh.crawler.factory;

import com.google.common.collect.Lists;
import com.jyh.crawler.enums.SeleniumDriverEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDriverFactory {
    public static WebDriver getDirver(SeleniumDriverEnum driverEnum) {
        WebDriver webDriver = null;
        switch (driverEnum) {
            case CHROME: {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\f8798\\IdeaProjects\\MyRepository\\crawler\\src\\main\\resources\\drivers\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("excludeSwitches", Lists.newArrayList("enable-automation"));
                webDriver = new ChromeDriver(options);
                break;
            }
            case FIREFOX: {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\f8798\\IdeaProjects\\MyRepository\\crawler\\src\\main\\resources\\drivers\\geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
            }
            default:{

            }
        }
        return webDriver;
    }
}
