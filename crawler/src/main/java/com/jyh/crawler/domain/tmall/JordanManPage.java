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
                WebElement shoeCate = driver.findElement(By.cssSelector("a[href=\"//jordan.tmall.com/category-1328804988.htm?scene=taobao_shop\"]"));

                try{
                    Thread.sleep(5000);
                    driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src*=\"login.taobao.com/member/login.jhtml\"]")));
                    WebElement loginNameInput = driver.findElement(By.id("TPL_username_1"));
                    loginNameInput.sendKeys("joyce_mao88");
                    WebElement passwordInput = driver.findElement(By.id("TPL_password_1"));
                    passwordInput.sendKeys("beibei880127");
                    WebElement submit = driver.findElement(By.id("J_SubmitStatic"));
                    submit.click();

                }catch(Exception e){
                    e.printStackTrace();
                }

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
