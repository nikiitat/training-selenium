package stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by tertynik on 13/06/2017.
 */
public class MyAdminTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;

    boolean moreElementPresent (By locator) {
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
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.cssSelector("img[alt=\"My Store\"]"));
    }

    @Test
    public void myAdminFirstTest(){

        List<WebElement> links = driver.findElements(By.xpath("//li[@id='app-']"));
        List<WebElement> links2 = driver.findElements(By.xpath("//ul[@class='docs']"));

        String[] linkTexts = new String[links.size()];
        String[] linkTexts2 = new String[links.size()];
        int i = 0;

        for (WebElement elements : links) {
            linkTexts[i] = elements.getText();
            System.out.println(linkTexts[i]);
            i++;
        }
        for (String t : linkTexts) {
            driver.findElement(By.linkText(t)).click();

            if (driver.findElements(By.xpath("//ul[@class='docs']")).size() > 0){
                for (WebElement elements : links2) {
                    linkTexts2[i] = elements.getText();
                    System.out.println(linkTexts2[i]);
                    i++;
                }
            }else {
                driver.navigate().back();;
            }
        }

//        System.out.println("Total selected rows are " + links.size());
//        for(int i=0;i<links.size();i++)
//            System.out.println(links.get(i).getText());
//        for(int i=0;i<links.size();i++){
//            links.get(i).getText();
//            driver.get(links);
//            driver.navigate().back();
//        }

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
