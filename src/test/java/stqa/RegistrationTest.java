package stqa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

/**
 * Created by nikitatertytskyi on 25.06.17.
 */
public class RegistrationTest extends TestBase {
    String name ="Test";
    String lastN ="Tester";
    String addressValue ="Tester ave";
    String postcodeValue ="01234";
    String cityValue ="Madrid";
    String country ="Spaine";
    String email ="some.random@email.com";
    String phone ="+012345678912";
    String password ="12345678";

    @Test
    public void myregistrationTest (){
        registration();
    }
    public void registration(){
        WebElement clickOnRegistration = driver.findElement(By.cssSelector(""));
        WebElement link = driver.findElement(By.cssSelector("div#box-account-login a[href*=create_account]"));
        link.click();
        assertTrue(isElementPresent(By.cssSelector("div#create-account h1[class='title']")));

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys(name);

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys(lastN);

        WebElement address1 = driver.findElement(By.name("address1"));
        address1.click();
        address1.clear();
        address1.sendKeys(addressValue);

        WebElement postcode = driver.findElement(By.name("postcode"));
        postcode.click();
        postcode.clear();
        postcode.sendKeys(postcodeValue);

        WebElement city = driver.findElement(By.name("city"));
        city.click();
        city.clear();
        city.sendKeys(cityValue);
    }

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
}
