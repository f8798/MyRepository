package com.jyh.crawler.domain.tmall;

import com.jyh.crawler.domain.BrowerContext;
import com.jyh.crawler.domain.Page;
import com.jyh.crawler.enums.PageNameEnum;
import com.jyh.crawler.tool.SeleniumTabSwitcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JordanManShoesPage extends Page {
    public JordanManShoesPage( ) {
        super(PageNameEnum.T_MALL_MERCHANT_JORDAN_MAN_SHOES);
    }

    @Override
    public String openSubPage(PageNameEnum name, BrowerContext browerContext) {
        return null;
    }

    @Override
    public String openCurrentPage(BrowerContext browerContext) {
        return null;
    }
}
