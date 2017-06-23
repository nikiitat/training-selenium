package stqa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by nikitatertytskyi on 19.06.17.
 */
public class TestSticker {
    private WebDriver driver;

    @Before
    public void start(){
//        System.setProperty("webdriver.chrome.driver",
//                "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("img[alt=\"My Store\"]"));
    }

    @Test
    public void myAdminFirstTest(){
        List<WebElement> ducks = driver.findElements(
                By.cssSelector("div.content li.product.column.shadow.hover-light"));

        for(int i=0;i<ducks.size();i++){
            WebElement element = ducks.get(i);
            if (! (element.findElements(By.cssSelector("div[class='sticker new']")).size() == 1 ||
                    element.findElements(By.cssSelector("div[class='sticker sale']")).size() == 1)) {
                AssertionError assertError = new AssertionError();
                System.out.println("Duck with no sticker or with more than one sticker. Item number is " + i + " ."
                        +assertError.getMessage());
                Assert.fail();;
            }
        }
        System.out.println("All ducks have stickers");
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
