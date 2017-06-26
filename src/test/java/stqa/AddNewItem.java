package stqa;

import org.openqa.selenium.support.ui.Select;
import org.junit.Test;
import org.openqa.selenium.*;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

/**
 * Created by tertynik on 26/06/2017.
 */
public class AddNewItem extends TestBase {
    private  String newItem = "Donald duck";

    @Test
    public void addItem() throws FileNotFoundException {
        driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");

        driver.findElement(By.name("login")).click();

        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog");

        driver.findElement(By.cssSelector("td#content a[href$='doc=edit_product']")).click();
        assertTrue(isElementPresent(By.xpath("//h1")));

        WebElement statusButton = driver.findElement(By.cssSelector("div#tab-general input[value='1'][type='radio']"));
        statusButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement nameElement = driver.findElement(By.cssSelector("div#tab-general input[name='name[en]'][type='text']"));
        nameElement.sendKeys(newItem);

        WebElement codeElement = driver.findElement(By.cssSelector("div#tab-general input[name='code'][type='text']"));
        codeElement.sendKeys("777");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement main = driver.findElement(By.cssSelector("div#tab-general input[value='0'][type='checkbox']"));
        String mainStatus = main.getAttribute("checked");
        if (mainStatus != null){
            main.click();
        }
        WebElement rubberDuck = driver.findElement(By.cssSelector("div#tab-general input[value='1'][type='checkbox']"));
        String rubberDuckStatus = rubberDuck.getAttribute("checked");
        if (rubberDuckStatus == null){
            rubberDuck.click();
        }
        WebElement subcategory = driver.findElement(By.cssSelector("div#tab-general input[value='2'][type='checkbox']"));
        String subcategoryStatus = subcategory.getAttribute("checked");
        if (subcategoryStatus != null){
            subcategory.click();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div#tab-general input[value='1-3'][type='checkbox']")).click();

        WebElement quantity = driver.findElement(By.cssSelector("div#tab-general input[name='quantity']"));
        quantity.clear();
        quantity.sendKeys("7");

        Select soldOut = new Select (driver.findElement(By.cssSelector("div#tab-general " +
                "select[name='sold_out_status_id']")));
        soldOut.selectByValue("2");

        WebElement uploadImage = driver.findElement(By.cssSelector("div#tab-general input[name='new_images[]']"));
        uploadImage.sendKeys(Paths.get(System.getProperty("user.dir")) + "\\Duck.png");

        WebElement validFrom = driver.findElement(By.cssSelector("div#tab-general " +
                "input[name='date_valid_from'][type='date']"));
        validFrom.sendKeys("25.06.2017");

        WebElement validTo = driver.findElement(By.cssSelector("div#tab-general input[name='date_valid_to'][type='date']"));
        validTo.sendKeys("25.08.2017");


        driver.findElement(By.cssSelector("div.tabs a[href='#tab-information']")).click();

        Select manufacturer = new Select(driver.findElement(By.cssSelector("div#tab-information " +
                "select[name='manufacturer_id']")));
        manufacturer.selectByValue("1");

        WebElement keywords = driver.findElement(By.cssSelector("div#tab-information input[name='keywords'][type='text']"));
        keywords.sendKeys(newItem);

        WebElement shortDescription = driver.findElement(By.cssSelector("div#tab-information " +
                "input[name='short_description[en]'][type='text']"));
        shortDescription.sendKeys("Donald Duck from cartoon)");


        WebElement description = driver.findElement(By.cssSelector("div#tab-information div.trumbowyg-editor"));
        description.click();
        description.sendKeys("Donald Duck best toy for your kid!");
        description.sendKeys(Keys.ENTER);
        description.sendKeys("Donald Duck is a cartoon character created in 1934 at Walt Disney Productions. Donald is an anthropomorphic white duck with a yellow-orange bill, legs, and feet. He typically wears a sailor shirt and cap with a bow tie");

        WebElement headTitle = driver.findElement(By.cssSelector("div#tab-information " +
                "input[name='head_title[en]'][type='text']"));
        headTitle.sendKeys(newItem);

        WebElement metaDescription = driver.findElement(By.cssSelector("div#tab-information " +
                "input[name='meta_description[en]'][type='text']"));
        metaDescription.sendKeys(newItem);

        driver.findElement(By.cssSelector("div.tabs a[href='#tab-prices']")).click();

        WebElement price = driver.findElement(By.cssSelector("div#tab-prices input[name='purchase_price'][type='number']"));
        price.clear();
        price.sendKeys("100");

        Select currency = new Select (driver.findElement(By.cssSelector("div#tab-prices " +
                "select[name='purchase_price_currency_code']")));
        currency.selectByValue("USD");

        WebElement price2 = driver.findElement(By.cssSelector("div#tab-prices input[data-type='currency']"));
        price2.clear();
        price2.sendKeys("100");

        System.out.println("Press Save button");
        driver.findElement(By.cssSelector("span.button-set button[type='submit'][value='Save']")).click();
        assertTrue(isElementPresent(By.cssSelector("div#notices-wrapper")));
        assertTrue(isNewElementPresent(driver));

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

    boolean isNewElementPresent(WebDriver driver){
        try{
            driver.findElement(By.linkText(newItem));
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
}
