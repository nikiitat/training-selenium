package stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by nikitatertytskyi on 19.06.17.
 */
public class TestSticker {
    private WebDriver driver;
    private WebDriverWait wait;

    boolean isOnlyOneElementPresent (By locator) {
        try {
            wait.until((WebDriver d) ->  driver.findElements(locator).size() == 1);
            System.out.println("Only 1 element present");
            return true;
        } catch (TimeoutException ex){
            System.out.println("More than 1 or not present");
            return false;
        }
    }

    @Before
    public void start(){
//        System.setProperty("webdriver.chrome.driver",
//                "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("img[alt=\"My Store\"]"));
    }

    @Test
    public void myAdminFirstTest(){
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='box-most-popular']//*[@title='Yellow Duck']//*[@class='sticker sale']"));
        System.out.println("Total selected rows are " + rows.size());
        //Yellow Duck
//        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-most-popular']//*[@title='Yellow Duck']//*[@class='sticker sale']")));
//        assertFalse(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Yellow " +
//                "Duck']//*[@class='sticker new']")));
//        //Green Duck
//        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-most-popular']//*[@title='Green Duck']//*[@class='sticker new']")));
//        assertFalse(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Green " +
//                "Duck']//*[@class='sticker sale']")));
//        //Purple Duck
//        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-most-popular']//*[@title='Purple Duck']//*[@class='sticker new']")));
//        assertFalse(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Purple " +
//                "Duck']//*[@class='sticker sale']")));
//        //Red Duck
//        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-most-popular']//*[@title='Red Duck']//*[@class='sticker new']")));
//        assertFalse(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Red " +
//                "Duck']//*[@class='sticker sale']")));
//        //Blue Duck
//        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-most-popular']//*[@title='Blue Duck']//*[@class='sticker new']")));
//        assertFalse(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Blue " +
//                "Duck']//*[@class='sticker sale']")));
//        //Yellow Duck Campaigns
//        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-campaigns']//*[@title='Yellow Duck']//*[@class='sticker sale']")));
//        assertFalse(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Yellow " +
//                "Duck']//*[@class='sticker new']")));
//        //Yellow Duck Latest products
//        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Yellow Duck']//*[@class='sticker sale']")));
//        assertFalse(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Yellow " +
//                "Duck']//*[@class='sticker new']")));
//        //Green Duck Latest products
//        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Green " +
//                "Duck']//*[@class='sticker new']")));
//        assertFalse(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Green " +
//                "Duck']//*[@class='sticker sale']")));
//        //Red Duck Latest products
//        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Red " +
//                "Duck']//*[@class='sticker new']")));
//        assertFalse(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Red " +
//                "Duck']//*[@class='sticker sale']")));
//        //Blue Duck Latest products
//        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Blue " +
//                "Duck']//*[@class='sticker new']")));
//        assertFalse(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Blue " +
//                "Duck']//*[@class='sticker sale']")));
//        //Purple Duck Latest products
//        assertTrue(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Purple " +
//                "Duck']//*[@class='sticker new']")));
//        assertFalse(isOnlyOneElementPresent(By.xpath("//*[@id='box-latest-products']//*[@title='Purple " +
//                "Duck']//*[@class='sticker sale']")));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
