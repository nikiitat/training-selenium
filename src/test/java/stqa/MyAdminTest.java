package stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by tertynik on 13/06/2017.
 */
public class MyAdminTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;

    @Before
    public void start(){
//        System.setProperty("webdriver.chrome.driver",
//                "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.cssSelector("img[alt=\"My Store\"]"));
    }

    @Test
    public void myAdminFirstTest(){
        List<WebElement> links = driver.findElements(By.xpath("//li[@id='app-']//*[@class='name']"));
        List<WebElement> links2;
        System.out.println(links.size());

        for(int i=0;i<links.size();i++)
        {
            if(!(links.get(i).getText().isEmpty()))
            {
                System.out.println(links.get(i).getText());
                links.get(i).click();
//                WebElement element =driver.findElement(By.xpath("//li[@id='app-']//*[@class='name']"));
                links2 = driver.findElements(By.xpath("//li[@id='app-']//*[@id]"));
                System.out.println(links2.get(1).getText());
                if (links2.size() > 0){
                for (int a = 0; a < links2.size(); a++) {
                    if (!(links2.get(a).getText().isEmpty())) {
                        System.out.println(links2.get(a).getText());
                        links2.get(a).click();
                    }
                }
            }
                driver.navigate().back();
                links=driver.findElements(By.xpath("//li[@id='app-']//*[@class='name']"));

            }
        }
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
