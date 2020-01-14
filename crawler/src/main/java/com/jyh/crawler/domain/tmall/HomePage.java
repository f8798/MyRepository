package com.jyh.crawler.domain.tmall;

import com.jyh.crawler.domain.BrowerContext;
import com.jyh.crawler.domain.Page;
import com.jyh.crawler.enums.PageNameEnum;
import com.jyh.crawler.tool.SeleniumTabSwitcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;

public class HomePage extends Page {
    public HomePage() {
        super(PageNameEnum.T_MALL_HOME_PAGE);
        this.setUrl("https://www.tmall.com");
    }

    @Override
    public String openSubPage(PageNameEnum name, BrowerContext browerContext) {
        switch (name){
            case T_MALL_MERCHANT_JORDAN_HOME_PAGE:{
                WebDriver driver = browerContext.getDriver();
                driver.get("https://www.tmall.com");
                WebElement searchInput = driver.findElement(By.name("q"));
                searchInput.sendKeys("jordan官方旗舰店");
                WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/form/fieldset/div/button"));
                submitButton.click();

                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (driver.getTitle().contains("JORDAN官方旗舰店")) {
                        break;
                    }
                }
                WebElement enterIntoStoreButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/div[3]/a"));
                enterIntoStoreButton.click();
                SeleniumTabSwitcher.switchToByUrl(driver, "jordan.tmall.com/shop/view_shop.htm");
                Page subPage = this.getSubPageMap().get(PageNameEnum.T_MALL_MERCHANT_JORDAN_HOME_PAGE.name());
                subPage.setUrl(driver.getCurrentUrl());
                subPage.setTitle(driver.getTitle());
                subPage.setHandle(driver.getWindowHandle());
            }
        }
        return null;
    }

    @Override
    public String openCurrentPage(BrowerContext browerContext) {
        WebDriver driver = browerContext.getDriver();
        browerContext.getDriver().get(this.getUrl());
        this.setUrl(driver.getCurrentUrl());
        this.setTitle(driver.getTitle());
        this.setHandle(driver.getWindowHandle());
        return null;
    }
}
