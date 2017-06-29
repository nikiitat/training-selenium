package stqa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Tertynik on 29/06/2017.
 */
public class LogTest extends TestBase {

    @Test
    public void logBrowser() {
        driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");

        driver.findElement(By.name("login")).click();

        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");

        String text = "Duck";

        List<WebElement> itemsList = driver.findElements(By.xpath(".//*[@id='content']/form/table//a[contains(text(),'" +
                text + "')]"));
        for (int i = 1; i < itemsList.size(); i++) {
            itemsList = driver.findElements(By.xpath(".//*[@id='content']/form/table//a[contains(text(),'" + text +
                    "')]"));

            WebElement duckElement = itemsList.get(i);
            duckElement.click();
            System.out.println("Checking the next duck: " + driver.getTitle());
            System.out.println(driver.manage().logs().get("browser").getAll());
            List<LogEntry> log = driver.manage().logs().get("browser").getAll();
            assertTrue(log.size()==0);
            driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        }
    }
}
