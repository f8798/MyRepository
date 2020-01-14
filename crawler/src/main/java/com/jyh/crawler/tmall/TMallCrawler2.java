package com.jyh.crawler.tmall;

import com.jyh.crawler.domain.BrowerContext;
import com.jyh.crawler.domain.Page;
import com.jyh.crawler.domain.tmall.HomePage;
import com.jyh.crawler.domain.tmall.JordanHomePage;
import com.jyh.crawler.domain.tmall.JordanManPage;
import com.jyh.crawler.domain.tmall.JordanManShoesPage;
import com.jyh.crawler.enums.PageNameEnum;
import com.jyh.crawler.enums.SeleniumDriverEnum;
import com.jyh.crawler.factory.SeleniumDriverFactory;
import com.jyh.crawler.tool.SeleniumTabSwitcher;
import org.jsoup.Jsoup;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TMallCrawler2 {

    public static void main(String[] args) throws Exception {

        Page page = new HomePage();
        JordanHomePage jordanHomePage = new JordanHomePage();
        JordanManPage jordanManPage = new JordanManPage();
        JordanManShoesPage jordanManShoesPage = new JordanManShoesPage();

        page.parentOf(jordanHomePage);
        jordanHomePage.parentOf(jordanManPage);
        jordanManPage.parentOf(jordanManShoesPage);

        BrowerContext context = new BrowerContext(SeleniumDriverEnum.CHROME, page);

        context.gotoPage(PageNameEnum.T_MALL_MERCHANT_JORDAN_MAN_SHOES);

    }
}
