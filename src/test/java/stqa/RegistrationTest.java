package stqa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by nikitatertytskyi on 25.06.17.
 */
public class RegistrationTest extends TestBase {
    @Test
    public void myregistrationTest (){
        registration();
    }
    public void registration(){
        WebElement clickOnRegistration = driver.findElement(By.cssSelector(""));

    }
}
