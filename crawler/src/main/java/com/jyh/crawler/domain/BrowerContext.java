package com.jyh.crawler.domain;

import com.jyh.crawler.enums.SeleniumDriverEnum;
import com.jyh.crawler.factory.SeleniumDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.Stack;

/**
 * 为了模拟人工操作，都按照页面浏览顺序去点击页面，BrowerContext封装了页面间跳转的逻辑
 */
public class BrowerContext {

    Page currentPage;

    Map<String, Page> pageNameMap;

    WebDriver driver;

    public BrowerContext(SeleniumDriverEnum browerType, Page homePage){
        this.driver = SeleniumDriverFactory.getDirver(browerType);
        this.currentPage = homePage;
        populateCurrentPageInfo(homePage);
    }

    /**
     * 页面跳转
     * @param pageName
     */
    public void gotoPage(String pageName){
        Page page = pageNameMap.get(pageName);

        if(page.getHandle() == null){
            Stack<Page> pathStack = new Stack();
            //找到距离垓页面层级最近的已打开的父页面, 并保存路径
            do{
                if(page.getParentPage() == null){
                    //已到达顶部，主页，退出循环
                    if(page.getHandle() == null)
                        pathStack.push(page);
                    break;
                }else{
                    pathStack.push(page);
                    if(page.getParentPage().getHandle() != null){
                        pathStack.push(page.getParentPage());
                        break;
                    }
                }
                page = page.getParentPage();
            }while(page.getParentPage() != null && page.getHandle() == null );

            while(!pathStack.isEmpty()){
                Page currentPage = pathStack.pop();
                if(currentPage.getHandle() == null){
                    page.gotoSubPage();
                }
            }
            populateCurrentPageInfo(page);

            //按page的关联层级，由上层浏览至该指定页面

        }else{
            //如果已存在已打开页面，浏览器直接切换tab
            driver.switchTo().window(page.getHandle());
        }
    }

    private void populateCurrentPageInfo(Page page) {
        driver.get(page.getUrl());
        page.setHandle(driver.getWindowHandle());
        page.setUrl(driver.getCurrentUrl());
        page.setTitle(driver.getTitle());
    }

    public String  getPageSource(){
        return driver.getPageSource();
    }
}
