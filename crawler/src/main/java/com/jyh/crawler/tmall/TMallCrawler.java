package com.jyh.crawler.tmall;

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

public class TMallCrawler {

    public static void main(String[] args) throws Exception {

        WebDriver driver = SeleniumDriverFactory.getDirver(SeleniumDriverEnum.CHROME);

        driver.get("https://jordan.tmall.com/category-1328804987.htm?spm=a1z10.1-b-s.w5001-16722994182.4.38157285NqIqsi&scene=taobao_shop");


        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("jordan官方旗舰店");
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/form/fieldset/div/button"));
        submitButton.click();

        while (true) {
            Thread.sleep(2000);
            System.out.println(driver.getTitle());
            if (driver.getTitle().contains("JORDAN官方旗舰店")) {
                break;
            }
        }

        WebElement enterIntoStoreButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/div[3]/a"));
        enterIntoStoreButton.click();

        SeleniumTabSwitcher.switchToByTitle(driver, "新版首页");

        WebElement manTab = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div/div/div/div[1]/div/div[2]/div/div/div/div[3]/a"));
        manTab.click();

        SeleniumTabSwitcher.switchToByUrl(driver, "category-1328804987");
        Thread.sleep(2000);
        WebElement shoeCate = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/div[2]/div/div/span/div[1]/div[2]/div[2]/dl/dd[1]/a"));
        shoeCate.click();

        SeleniumTabSwitcher.switchToByUrl(driver, "category-1328804988");

        List<WebElement> itemList = driver.findElements(By.cssSelector("a[class=\"item-name J_TGoldData\"]"));




        itemList.forEach(item -> {
            String itemUrl = item.getAttribute("href");
            item.click();
            SeleniumTabSwitcher.switchToByUrl(driver, itemUrl);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Document itemDetail = Jsoup.parse(driver.getPageSource());
            Elements colorElements = itemDetail.getElementsByAttributeValue("data-property", "颜色分类");
            colorElements.forEach(element -> {
//                if(!element.attr("class").equals("tb-out-of-stock")){
                element.children().forEach(element1 -> {
                    if (!element1.attr("class").equals("tb-out-of-stock")) {
                        WebElement colorElement = driver.findElement(By.cssSelector("li[title=\""+ element1.attr("title")+"\"]"));
                        colorElement.click();
                        Elements sizeElements = itemDetail.getElementsByAttributeValue("data-property", "鞋码");
                        sizeElements.get(0).children().forEach(sizeElement->{
                            if(!StringUtil.isBlank(sizeElement.attr("data-value"))){
                                WebElement webElement = driver.findElement(By.cssSelector("li[data-value=\""+ sizeElement.attr("data-value")+"\"]"));
                                if(webElement.getAttribute("class").equals("tb-out-of-stock")){
                                    System.out.println(webElement.getText());
                                }
                            }
                        });
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                });
            });
        });

        System.out.println(driver.getPageSource());

//        List<WebElement> itemLines = driver.findElements(By.className("item4line1"));
//        itemLines.forEach(line->{
//            line
//        });
    }
}
