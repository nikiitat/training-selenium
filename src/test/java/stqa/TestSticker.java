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
import static org.junit.Assert.assertTrue;

/**
 * Created by nikitatertytskyi on 19.06.17.
 */
public class TestSticker {
    private WebDriver driver;
    private WebDriverWait wait;

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
        List<WebElement> links = driver.findElements(By.xpath("//li[@class='product column shadow hover-light']"));

        for(int i=0;i<links.size();i++){
            WebElement element = links.get(i);
            assertTrue(isElementPresent(element, By.xpath(".//div[@class='image-wrapper']//div[@class][@title]")));
        }
    }

    boolean isElementPresent (WebElement el, By locator) {
        try {
            wait.until((WebDriver d) ->  el.findElements(locator).size() == 1);
            return true;
        } catch (TimeoutException ex){
            return false;
        }
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
