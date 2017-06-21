package stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by tertynik on 13/06/2017.
 */
public class MyAdminTest {
    private WebDriver driver;

    boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (InvalidSelectorException ex){
            throw ex;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    @Before
    public void start(){
//        System.setProperty("webdriver.chrome.driver",
//                "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.cssSelector("img[alt=\"My Store\"]"));
    }

    @Test
    public void myAdminFirstTest() {
        verifyTitlePresentForAllMenuLinks();
    }

     public void verifyTitlePresentForAllMenuLinks(){
        List<WebElement> links = driver.findElements(By.xpath("//li[@id='app-']/a/span[@class='name']"));
        List<WebElement> links2;

        for(int i=0;i<links.size();i++)
        {
            if(!(links.get(i).getText().isEmpty()))
            {
                links.get(i).click();
                assertTrue(isElementPresent(By.xpath("//h1")));
                links2 = driver.findElements(By.xpath("//li[@id='app-']//*[@id]"));
                for (int a = 0; a < links2.size(); a++) {
                    if (!(links2.get(a).getText().isEmpty())) {
                        links2.get(a).click();
                        assertTrue(isElementPresent(By.xpath("//h1")));
                        links2 = driver.findElements(By.xpath("//li[@id='app-']//*[@id]"));
                    }
                }
                links=driver.findElements(By.xpath("//li[@id='app-']/a/span[@class='name']"));
            }
        }
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
