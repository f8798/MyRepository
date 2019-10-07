import com.jyh.crawler.enums.SeleniumDriverEnum;
import com.jyh.crawler.factory.SeleniumDriverFactory;
import com.jyh.crawler.tool.SeleniumTabSwitcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test {
    public static void main(String[] args) {

        WebDriver driver = SeleniumDriverFactory.getDirver(SeleniumDriverEnum.CHROME);

        driver.get("https://jordan.tmall.com");
        WebElement manTab = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div/div/div/div[1]/div/div[2]/div/div/div/div[3]/a"));
        manTab.click();

        SeleniumTabSwitcher.switchToByUrl(driver,"category-1328804987");

        WebElement shoeCate = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/div[2]/div/div/span/div[1]/div[2]/div[2]/dl/dd[1]/a"));
        shoeCate.click();

        SeleniumTabSwitcher.switchToByUrl(driver,"category-1328804988");
    }
}
