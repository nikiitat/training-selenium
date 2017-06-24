package stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by nikitatertytskyi on 23.06.17.
 */
public class MyCampaingTest {
    private WebDriver driver;

    @Before
    public void start(){
//        System.setProperty("webdriver.chrome.driver",
//                "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("img[alt=\"My Store\"]"));
        myCampaingTest();
    }

    @Test
    public void myCampaingTest(){
        List<WebElement> campaingRows = driver.findElements(By.cssSelector("div#box-campaigns li.product.column.shadow.hover-light"));
        for(int i = 0; i<campaingRows.size(); i++){
            WebElement element = driver.findElement(By.cssSelector(""));
        }
    }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
