package stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by tertynik on 13/06/2017.
 */
public class MyFirstTest {
    private WebDriver driver;
    //    private WebDriver firefoxDriver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
//        firefoxDriver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 20);

    }

    @Test
    public void myFirstTest(){
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt=\"My Store\"]")));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}