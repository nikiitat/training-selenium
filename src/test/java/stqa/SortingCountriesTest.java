package stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by tertynik on 22/06/2017.
 */
public class SortingCountriesTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void mySortingCountriesTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        login();
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        sort();
    }

    public void sort() {
        List<WebElement> rows = driver.findElements(By.cssSelector("table.dataTable tr.row"));
        ArrayList<String> originalOrder = new ArrayList<String>();
        TreeSet<String> sortedOrder = new TreeSet<String>();

        System.out.print(rows.size());


        for (int j = 0; j < rows.size(); j++) {
            String countryName = rows.get(j).findElements(By.cssSelector("td")).get(4).findElement((By.cssSelector
                    ("a")))
                    .getText();
            System.out.print(countryName);
            originalOrder.add(countryName);
            sortedOrder.add(countryName);
        }
        assertTrue(compare(originalOrder, sortedOrder));
    }

    private boolean compare(ArrayList<String> originalOrder, TreeSet<String> sortedOrder) {
        String []str = sortedOrder.toArray(new String[sortedOrder.size()]);
        for(int i = 0; i<originalOrder.size(); i++) {
            System.out.println('\t' + originalOrder.get(i) + " <===> " + str[i]);
            if (!originalOrder.get(i).trim().toLowerCase().equals(str[i].trim().toLowerCase())) {
                return false;
            }
        }
        return true;
    }
    
    private void login(){
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
