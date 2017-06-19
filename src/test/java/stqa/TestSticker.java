package stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by nikitatertytskyi on 19.06.17.
 */
public class TestSticker {
    private WebDriver driver;
    private WebDriverWait wait;

    boolean isElementPresent(By locator) {
        try {
            wait.until((WebDriver d) -> d.findElement(locator));
//            driver.findElement(locator);
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    boolean isElementPresent1(By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.findElement(locator);
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    @Before
    public void start(){
//        System.setProperty("webdriver.chrome.driver",
//                "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/en/");
//        driver.findElement(By.cssSelector("img[alt=\"My Store\"]"));
    }

    @Test
    public void myAdminFirstTest(){
//        driver.findElement(By.xpath("//span[text()='Appearence']")).click();
//        assertTrue(isElementPresent(By.xpath("//h1[text()=' Template']")));
//
//        driver.findElement(By.xpath("//span[text()='Logotype']")).click();
//        assertTrue(isElementPresent(By.xpath("//h1[text()=' Logotype']")));
//
//        driver.findElement(By.xpath("//span[text()='Template']")).click();
//        assertTrue(isElementPresent(By.xpath("//h1[text()=' Template']")));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
