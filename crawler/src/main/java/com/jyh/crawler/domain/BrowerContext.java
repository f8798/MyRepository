package com.jyh.crawler.domain;

import com.jyh.crawler.enums.SeleniumDriverEnum;
import com.jyh.crawler.factory.SeleniumDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class BrowerContext {

    Page currentPage;

    Map<String, Page> pageMap;

    WebDriver driver = SeleniumDriverFactory.getDirver(SeleniumDriverEnum.CHROME);


}
