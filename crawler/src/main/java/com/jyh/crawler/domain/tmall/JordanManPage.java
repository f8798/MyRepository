package com.jyh.crawler.domain.tmall;

import com.jyh.crawler.domain.BrowerContext;
import com.jyh.crawler.domain.Page;
import com.jyh.crawler.enums.PageNameEnum;
import com.jyh.crawler.tool.SeleniumTabSwitcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JordanManPage extends Page {
    public JordanManPage( ) {
        super(PageNameEnum.T_MALL_MERCHANT_JORDAN_MAN);
    }

    @Override
    public String openSubPage(PageNameEnum name, BrowerContext browerContext) {
        switch (name){
            case T_MALL_MERCHANT_JORDAN_MAN_SHOES:{
                WebDriver driver = browerContext.getDriver();
                WebElement shoeCate = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/div[2]/div/div/span/div[1]/div[2]/div[2]/dl/dd[1]/a"));
                shoeCate.click();
                SeleniumTabSwitcher.switchToByUrl(driver, "category-1328804988");
                Page subPage = this.getSubPageMap().get(PageNameEnum.T_MALL_MERCHANT_JORDAN_MAN_SHOES.name());
                subPage.setUrl(driver.getCurrentUrl());
                subPage.setTitle(driver.getTitle());
                subPage.setHandle(driver.getWindowHandle());
                break;
            }
        }
        return null;
    }

    @Override
    public String openCurrentPage(BrowerContext browerContext) {
        return null;
    }
}
