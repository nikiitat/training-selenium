package stqa;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.Random;
import static org.junit.Assert.assertTrue;

/**
 * Created by nikitatertytskyi on 25.06.17.
 */
public class RegistrationTest extends TestBase {
    String name ="Test";
    String lastN ="Tester";
    String address ="Tester ave";
    String postcode ="01234";
    String city ="Madrid";
    String country ="United States";
    String email ="some.random@email.com";
    String phone ="+012345678912";
    String password ="12345678";

    @Test
    public void myregistrationTest (){
        registration();
    }
    public void registration(){
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
        address1.sendKeys(address);

        WebElement postcode1 = driver.findElement(By.name("postcode"));
        postcode1.click();
        postcode1.clear();
        postcode1.sendKeys(postcode);

        WebElement city1 = driver.findElement(By.name("city"));
        city1.click();
        city1.clear();
        city1.sendKeys(city);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("span.selection")));
        actions.click();
        actions.sendKeys(country);
        actions.sendKeys(Keys.ENTER);
        actions.perform();

        Random randNumber = new Random();
        int uniqueNumber = randNumber.nextInt(100) + 1;

        WebElement emailElement = driver.findElement(By.name("email"));
        String newEmail = Integer.toString(uniqueNumber) + email;
        emailElement.click();
        emailElement.clear();
        emailElement.sendKeys(newEmail);
        System.out.println("The next email was used:  " + uniqueNumber + email);

        WebElement phoneElement = driver.findElement(By.name("phone"));
        phoneElement.click();
        phoneElement.clear();
        phoneElement.sendKeys(phone);

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.click();
        passwordElement.clear();
        passwordElement.sendKeys(password);

        WebElement confirmPassword = driver.findElement(By.name("confirmed_password"));
        confirmPassword.click();
        confirmPassword.clear();
        confirmPassword.sendKeys(password);

        WebElement submit = driver.findElement(By.cssSelector("button[type=submit]"));
        submit.click();

        assertTrue(isElementPresent(By.cssSelector("div#main div#notices-wrapper")));
        System.out.println("Account created.");

        logout();
        login(newEmail);
        logout();
    }

    private void logout(){
        WebElement logout = driver.findElement(By.cssSelector("div#box-account a[href*=logout]"));
        logout.click();

        assertTrue(isElementPresent(By.cssSelector("div#main div#notices-wrapper")));
        System.out.println("You logged out.");
    }

    private void login(String  newEmail){
        WebElement emailLogin = driver.findElement(By.cssSelector("div#box-account-login input[name=email]"));
        emailLogin.click();
        emailLogin.clear();
        emailLogin.sendKeys(newEmail);

        WebElement passwordLogin = driver.findElement(By.cssSelector("div#box-account-login input[name=password]"));
        passwordLogin.click();
        passwordLogin.clear();
        passwordLogin.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("div#box-account-login button[name=login]"));
        loginButton.click();

        assertTrue(isElementPresent(By.cssSelector("div#main div#notices-wrapper")));
        System.out.println("You logged in.");
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
