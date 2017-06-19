package stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.cssSelector("img[alt=\"My Store\"]"));
    }

    @Test
    public void myAdminFirstTest(){
        driver.findElement(By.xpath("//span[text()='Appearence']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Template']")));

        driver.findElement(By.xpath("//span[text()='Logotype']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Logotype']")));

        driver.findElement(By.xpath("//span[text()='Template']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Template']")));
    }

    @Test
    public void myAdminSecondTest() {
        driver.findElement(By.xpath("(//span[text()='Catalog'])[1]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Catalog']")));

        driver.findElement(By.xpath("//span[text()='Product Groups']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Product Groups']")));

        driver.findElement(By.xpath("//span[text()='Option Groups']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Option Groups']")));

        driver.findElement(By.xpath("//span[text()='Manufacturers']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Manufacturers']")));

        driver.findElement(By.xpath("//span[text()='Suppliers']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Suppliers']")));

        driver.findElement(By.xpath("//span[text()='Delivery Statuses']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Delivery Statuses']")));

        driver.findElement(By.xpath("//span[text()='Sold Out Statuses']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Sold Out Statuses']")));

        driver.findElement(By.xpath("//span[text()='Quantity Units']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Quantity Units']")));

        driver.findElement(By.xpath("//span[text()='CSV Import/Export']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' CSV Import/Export']")));


        driver.findElement(By.xpath("(//span[text()='Catalog'])[2]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Catalog']")));
    }

    @Test
    public void myAdminThirdTest(){
        driver.findElement(By.xpath("//span[text()='Countries']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Countries']")));
    }

    @Test
    public void myAdminFourthTest(){
        driver.findElement(By.xpath("//span[text()='Currencies']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Currencies']")));
    }

    @Test
    public void myAdminFifthTest(){
        driver.findElement(By.xpath("(//span[text()='Customers'])[1]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Customers']")));

        driver.findElement(By.xpath("//span[text()='CSV Import/Export']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' CSV Import/Export']")));

        driver.findElement(By.xpath("//span[text()='Newsletter']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Newsletter']")));

        driver.findElement(By.xpath("(//span[text()='Customers'])[2]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Customers']")));
    }

    @Test
    public void myAdminSixthTest(){
        driver.findElement(By.xpath("//span[text()='Geo Zones']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Geo Zones']")));
    }

    @Test
    public void myAdminSeventhTest(){
        driver.findElement(By.xpath("(//span[text()='Languages'])[1]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Languages']")));

        driver.findElement(By.xpath("//span[text()='Storage Encoding']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Storage Encoding']")));

        driver.findElement(By.xpath("(//span[text()='Languages'])[2]")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Languages']")));
    }

    @Test
    public void myAdminEightTest(){
        driver.findElement(By.xpath("//span[text()='Modules']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()='  Job Modules']")));

        driver.findElement(By.xpath("//span[text()='Customer']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Customer Modules']")));

        driver.findElement(By.xpath("//span[text()='Shipping']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Shipping Modules']")));

        driver.findElement(By.xpath("//span[text()='Payment']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Payment Modules']")));

        driver.findElement(By.xpath("//span[text()='Order Total']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Order Total Modules']")));

        driver.findElement(By.xpath("//span[text()='Order Success']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Order Success Modules']")));

        driver.findElement(By.xpath("//span[text()='Order Action']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Order Action Modules']")));

        driver.findElement(By.xpath("//span[text()='Background Jobs']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Job Modules']")));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
