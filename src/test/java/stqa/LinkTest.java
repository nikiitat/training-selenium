package stqa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by tertynik on 28/06/2017.
 */
public class LinkTest extends TestBase{

    @Test
    public void linksTest(){
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.xpath("//table[contains(@class, 'dataTable')]//tr[26]/td[7]/a")).click();

        String window = driver.getWindowHandle();
        System.out.println(driver.getTitle() + window);

        List<WebElement> linksList = driver.findElements(By.cssSelector("td#content table a[target='_blank']"));
        for (int i = 0; i < linksList.size(); i++) {
            WebElement link = linksList.get(i);
            String linkUrl = link.getAttribute("href");

            ((JavascriptExecutor) driver).executeScript("window.open(\"" + linkUrl + "\");");
            waitForNumberOfWindowsToEqual(2);
            for(String winHandle : driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }
            String windowNew = driver.getWindowHandle();
            System.out.println("Window is Open:" + driver.getTitle() + "Page URL is" + driver.getCurrentUrl());

            driver.close();
            driver.switchTo().window(window);
        }
    }

    public void waitForNumberOfWindowsToEqual(final int numberOfWindows) {
        new WebDriverWait(driver, 40) {
        }.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (driver.getWindowHandles().size() == numberOfWindows);
            }
        });
    }
}
