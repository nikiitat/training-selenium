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
    @Test
    public void mySortingGeoZones(){
        driver.get("http://localhost/litecart/admin/login.php");
        login();
        driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        sortZones();
    }

    public void sortZones(){
        
    }

    public void sort() {
        List<WebElement> rows = driver.findElements(By.cssSelector("table.dataTable tr.row"));
        ArrayList<String> originalOrderCountries = new ArrayList<>();
        TreeSet<String> sortedOrderCountries = new TreeSet<>();
        ArrayList<String> originalOrderZones = new ArrayList<>();
        TreeSet<String> sortedOrderZones = new TreeSet<>();

        System.out.print(rows.size());
        for (int i = 0; i < rows.size(); i++) {
            String countryName = rows.get(i).findElements(By.cssSelector("td")).get(4).findElement((By.cssSelector
                    ("a")))
                    .getText();
            originalOrderCountries.add(countryName);
            sortedOrderCountries.add(countryName);
            if (!(rows.get(i).findElements(By.cssSelector("td")).get(5).getText()).equals("0")) {
                rows.get(i).findElements(By.cssSelector("td")).get(4).findElement((By.cssSelector
                        ("a"))).click();
                List<WebElement> rowsZones = driver.findElements(By.cssSelector("table#table-zones tr"));
                originalOrderZones.clear();
                sortedOrderZones.clear();
                for (int j = 1; j < rowsZones.size() - 1; j++) {
                    String zonesName = rowsZones.get(j).findElements(By.cssSelector("td")).get(2).getText();
                    originalOrderZones.add(zonesName);
                    sortedOrderZones.add(zonesName);
                }
                assertTrue(compare(originalOrderZones, sortedOrderZones));
                System.out.println(countryName + "'s zones are displayed in an alphabetical order");
                driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
                rows = driver.findElements(By.cssSelector("table.dataTable tr.row"));
            } else {
                System.out.println(countryName + " has not zones");
            }
            rows = driver.findElements(By.cssSelector("table.dataTable tr.row"));
        }
        assertTrue(compare(originalOrderCountries, sortedOrderCountries));
    }

    private boolean compare(ArrayList<String> originalOrder, TreeSet<String> sortedOrder) {
        String []sorted = sortedOrder.toArray(new String[sortedOrder.size()]);
        for(int i = 0; i<originalOrder.size(); i++) {
            System.out.println('\t' + originalOrder.get(i) + " == " + sorted[i]);
            if (!originalOrder.get(i).toLowerCase().equals(sorted[i].toLowerCase())) {
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
