package com.jyh.crawler.tool;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;

public class SeleniumTabSwitcher {
    public static void switchToByTitle(WebDriver driver, String titleName){
        Iterator it = driver.getWindowHandles().iterator();
        while(it.hasNext()){
            driver.switchTo().window((String)it.next());
            if(driver.getTitle().contains(titleName)){
                break;
            }
        }
    }

    public static void switchToByUrl(WebDriver driver, String url){
        Iterator it = driver.getWindowHandles().iterator();
        while(it.hasNext()){
            driver.switchTo().window((String)it.next());
            if(driver.getCurrentUrl().contains(url)){
                break;
            }
        }
    }
}
