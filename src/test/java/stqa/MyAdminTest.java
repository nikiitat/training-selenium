package stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by tertynik on 13/06/2017.
 */
public class MyAdminTest {
    private WebDriver driver;
    private WebDriverWait wait;

    boolean isElementPresent(By locator) {
        try {
            wait.until((WebDriver d) -> d.findElement(locator));
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
        driver.findElement(By.xpath("//li[@id='app-']/a/span[text()='Catalog']")).click();
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


        driver.findElement(By.xpath("//li[@id='doc-catalog']/a/span[text()='Catalog']")).click();
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
        driver.findElement(By.xpath("//li[@id='app-']/a/span[text()='Customers']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Customers']")));

        driver.findElement(By.xpath("//span[text()='CSV Import/Export']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' CSV Import/Export']")));

        driver.findElement(By.xpath("//span[text()='Newsletter']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Newsletter']")));

        driver.findElement(By.xpath("//li[@id='doc-customers']/a/span[text()='Customers']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Customers']")));
    }

    @Test
    public void myAdminSixthTest(){
        driver.findElement(By.xpath("//span[text()='Geo Zones']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Geo Zones']")));
    }

    @Test
    public void myAdminSeventhTest(){
        driver.findElement(By.xpath("//li[@id='app-']/a/span[text()='Languages']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Languages']")));

        driver.findElement(By.xpath("//span[text()='Storage Encoding']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Storage Encoding']")));

        driver.findElement(By.xpath("//li[@id='doc-languages']/a/span[text()='Languages']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Languages']")));
    }

    @Test
    public void myAdminEightTest(){
        driver.findElement(By.xpath("//span[text()='Modules']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Job Modules']")));

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

    @Test
    public void myAdminNinethTest(){
        driver.findElement(By.xpath("//li[@id='app-']/a/span[text()='Orders']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Orders']")));

        driver.findElement(By.xpath("//span[text()='Order Statuses']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Order Statuses']")));

        driver.findElement(By.xpath("//li[@id='doc-orders']/a/span[text()='Orders']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Orders']")));
    }

    @Test
    public void myAdminTenthTest(){
        driver.findElement(By.xpath("//span[text()='Pages']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Pages']")));
    }

    @Test
    public void myAdminEleventhTest(){
        driver.findElement(By.xpath("//span[text()='Reports']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Monthly Sales']")));

        driver.findElement(By.xpath("//span[text()='Most Sold Products']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Most Sold Products']")));

        driver.findElement(By.xpath("//span[text()='Most Shopping Customers']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Most Shopping Customers']")));

        driver.findElement(By.xpath("//span[text()='Monthly Sales']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Monthly Sales']")));
    }

    @Test
    public void myAdminTwelvethTest(){
        driver.findElement(By.xpath("//span[text()='Settings']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Settings']")));

        driver.findElement(By.xpath("//span[text()='Defaults']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Settings']")));

        driver.findElement(By.xpath("//span[text()='General']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Settings']")));

        driver.findElement(By.xpath("//span[text()='Listings']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Settings']")));

        driver.findElement(By.xpath("//span[text()='Images']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Settings']")));

        driver.findElement(By.xpath("//span[text()='Checkout']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Settings']")));

        driver.findElement(By.xpath("//span[text()='Checkout']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Settings']")));

        driver.findElement(By.xpath("//span[text()='Advanced']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Settings']")));

        driver.findElement(By.xpath("//span[text()='Security']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Settings']")));

        driver.findElement(By.xpath("//span[text()='Store Info']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Settings']")));
    }

    @Test
    public void myAdminThirteenTest(){
        driver.findElement(By.xpath("//span[text()='Slides']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Slides']")));
    }

    @Test
    public void myAdminFourteenTest(){
        assertTrue(isElementPresent(By.xpath("//span[text()='Tax']")));
        driver.findElement(By.xpath("//span[text()='Tax']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Tax Classes']")));

        driver.findElement(By.xpath("//span[text()='Tax Rates']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Tax Rates']")));

        driver.findElement(By.xpath("//span[text()='Tax Classes']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Tax Classes']")));
    }

    @Test
    public void myAdminFifteenTest(){
        assertTrue(isElementPresent(By.xpath("//span[text()='Translations']")));
        driver.findElement(By.xpath("//span[text()='Translations']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Search Translations']")));

        driver.findElement(By.xpath("//span[text()='Scan Files']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Scan Files For Translations']")));

        driver.findElement(By.xpath("//span[text()='CSV Import/Export']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' CSV Import/Export']")));

        driver.findElement(By.xpath("//span[text()='Search Translations']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Search Translations']")));
    }

    @Test
    public void myAdminSixteenTest(){
        assertTrue(isElementPresent(By.xpath("//span[text()='Users']")));
        driver.findElement(By.xpath("//span[text()='Users']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' Users']")));
    }

    @Test
    public void myAdminSeventeenTest(){
        assertTrue(isElementPresent(By.xpath("//li[@id='app-']/a/span[text()='vQmods']")));
        driver.findElement(By.xpath("//li[@id='app-']/a/span[text()='vQmods']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' vQmods']")));

        driver.findElement(By.xpath("//li[@id='doc-vqmods']/a/span[text()='vQmods']")).click();
        assertTrue(isElementPresent(By.xpath("//h1[text()=' vQmods']")));
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
