package stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by nikitatertytskyi on 19.06.17.
 */
public class TestSticker {
    private WebDriver driver;

    boolean isOnlyOneElementPresent (By locator) {
        if (driver.findElements(locator).size() == 1) {
            System.out.println("Only 1 element present");
            return true;
        } else {
            System.out.println("More than 1");
            return false;
        }
    }
    boolean noSuchElement (By locator) {
        if (driver.findElements(locator).size() == 0) {
            System.out.println("No such element");
            return false;
        } else {
            System.out.println("There is 1 element");
            return true;
        }
    }

    @Before
    public void start(){
//        System.setProperty("webdriver.chrome.driver",
//                "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("img[alt=\"My Store\"]"));
    }

    @Test
    public void myAdminFirstTest(){
//        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='box-most-popular']//*[@title='Yellow Duck']//*[@class='sticker sale']"));
//        System.out.println("Total selected rows are " + rows.size());
        //Yellow Duck
        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-most-popular']//*[@title='Yellow Duck']//*[@class='sticker sale']")));
        //Green Duck
        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-most-popular']//*[@title='Green Duck']//*[@class='sticker new']")));
        //Purple Duck
        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-most-popular']//*[@title='Purple Duck']//*[@class='sticker new']")));
        //Red Duck
        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-most-popular']//*[@title='Red Duck']//*[@class='sticker new']")));
        //Blue Duck
        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-most-popular']//*[@title='Blue Duck']//*[@class='sticker new']")));
        //Yellow Duck Campaigns
        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-campaigns']//*[@title='Yellow Duck']//*[@class='sticker sale']")));
        //Yellow Duck Latest products
        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Yellow Duck']//*[@class='sticker sale']")));
        //Green Duck Latest products
        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Green " +
                "Duck']//*[@class='sticker new']")));
        //Red Duck Latest products
        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Red " +
                "Duck']//*[@class='sticker new']")));
        //Blue Duck Latest products
        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Blue " +
                "Duck']//*[@class='sticker new']")));
        //Purple Duck Latest products
        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Purple " +
                "Duck']//*[@class='sticker new']")));
        assertFalse(noSuchElement(By.xpath("//*[@id='box-latest-products']//*[@title='Purple " +
                "Duck']//*[@class='sticker sale']")));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
