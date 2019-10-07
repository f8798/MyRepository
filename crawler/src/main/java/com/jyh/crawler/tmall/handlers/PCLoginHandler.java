package com.jyh.crawler.tmall.handlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PCLoginHandler implements ActionHandler {
    @Override
    public void handler(WebDriver driver) {
        try{
            driver.get("https://login.tmall.com");
            driver.switchTo().frame(driver.findElement(By.id("J_loginIframe")));
            Thread.sleep(2000);
            driver.findElement(By.id("J_Quick2Static")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("TPL_username_1")).sendKeys("joyce_mao88");
            Thread.sleep(2000);
            driver.findElement(By.id("TPL_password_1")).sendKeys("beibei880127");
            Thread.sleep(2000);
            WebElement slideButton = driver.findElement(By.id("nc_1_n1z"));
            WebElement slideBar = driver.findElement(By.id("nc_1__scale_text"));
            System.out.println(driver.getPageSource());

            Actions action = new Actions(driver);
            action.dragAndDropBy(slideButton, slideBar.getSize().width, slideBar.getSize().height).perform();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
