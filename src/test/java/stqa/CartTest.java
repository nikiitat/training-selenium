package stqa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


/**
 * Created by tertynik on 27/06/2017.
 */
public class CartTest extends TestBase {
    String firstItem = "Yellow Duck";
    String secondItem = "Blue Duck";
    String thirdItem = "Red Duck";

    @Test
    public void shoppingCart(){
        driver.navigate().to("http://localhost/litecart/en/");

        WebElement cartItems = driver.findElement(By.cssSelector("div#cart a.content span.quantity"));
        String cartItem = cartItems.getText();
        int previousNumber = Integer.parseInt(String.valueOf(cartItem));

        driver.navigate().to("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("div#box-most-popular a.link[title='"+ firstItem +"']")).click();
        wait.until(titleIs(firstItem + " | Subcategory | Rubber Ducks | My Store"));

        Select size = new Select (driver.findElement(By.cssSelector("div.buy_now select[name='options[Size]']")));
        size.selectByValue("Small");
        driver.findElement(By.cssSelector("div.buy_now button[name='add_cart_product']")).click();
        previousNumber++;
        String expectedNumber = String.valueOf(previousNumber);
        wait.until(textToBePresentInElementLocated(By.cssSelector("div#cart a.content span.quantity"), expectedNumber));

        cartItems = driver.findElement(By.cssSelector("div#cart a.content span.quantity"));
        cartItem = cartItems.getText();
        System.out.println("There are " + cartItem + " items in Shopping cart");


        driver.navigate().to("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("div#box-most-popular a.link[title='"+ secondItem +"']")).click();
        wait.until(titleIs(secondItem + " | Rubber Ducks | My Store"));

        driver.findElement(By.cssSelector("div.buy_now button[name='add_cart_product']")).click();
        previousNumber++;
        expectedNumber = String.valueOf(previousNumber);
        wait.until(textToBePresentInElementLocated(By.cssSelector("div#cart a.content span.quantity"), expectedNumber));

        cartItems = driver.findElement(By.cssSelector("div#cart a.content span.quantity"));
        cartItem = cartItems.getText();
        System.out.println("There are " + cartItem + " items in Shopping cart");



        driver.navigate().to("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("div#box-most-popular a.link[title='"+ thirdItem +"']")).click();
        wait.until(titleIs(thirdItem + " | Rubber Ducks | My Store"));

        driver.findElement(By.cssSelector("div.buy_now button[name='add_cart_product']")).click();
        previousNumber++;
        expectedNumber = String.valueOf(previousNumber);
        wait.until(textToBePresentInElementLocated(By.cssSelector("div#cart a.content span.quantity"), expectedNumber));

        cartItems = driver.findElement(By.cssSelector("div#cart a.content span.quantity"));
        cartItem = cartItems.getText();
        System.out.println("There are " + cartItem + " items in Shopping cart");


        driver.findElement(By.cssSelector("div#cart-wrapper a.link")).click();
        wait.until(titleIs("Checkout | My Store"));

        List<WebElement> rows = driver.findElements(By.cssSelector("table.dataTable tr"));
        int rowsSize = rows.size();;
        System.out.println("Order table contains:");
        for (int i = 1; i < rowsSize - 4; i++) {
            String itemName = rows.get(i).findElements(By.cssSelector("td")).get(1).getText();
            System.out.println(itemName);
        }

        WebElement buttonRemove = driver.findElement(By.cssSelector("button[name='remove_cart_item']"));
        buttonRemove.click();
        System.out.println("Removed one item");
        wait.until(numberOfElementsToBeLessThan(By.cssSelector("table.dataTable tr"), rowsSize));

        rows = driver.findElements(By.cssSelector("table.dataTable tr"));
        rowsSize = rows.size();
        System.out.println("Order  table contains:");
        for (int i = 1; i < rowsSize - 4; i++) {
            String itemName = rows.get(i).findElements(By.cssSelector("td")).get(1).getText();
            System.out.println(itemName);
        }

        buttonRemove = driver.findElement(By.cssSelector("button[name='remove_cart_item']"));
        buttonRemove.click();
        System.out.println("Removed one item");
        wait.until(numberOfElementsToBeLessThan(By.cssSelector("table.dataTable tr"), rowsSize));

        rows = driver.findElements(By.cssSelector("table.dataTable tr"));
        rowsSize = rows.size();
        System.out.println("Order table contains:");
        for (int i = 1; i < rowsSize - 4; i++) {
            String itemName = rows.get(i).findElements(By.cssSelector("td")).get(1).getText();
            System.out.println(itemName);
        }

        buttonRemove = driver.findElement(By.cssSelector("button[name='remove_cart_item']"));
        buttonRemove.click();
        System.out.println("Removed one item");
        wait.until(numberOfElementsToBeLessThan(By.cssSelector("table.dataTable tr"), rowsSize));
        wait.until(visibilityOfElementLocated(By.cssSelector("div#checkout-cart-wrapper p em")));
        WebElement noItems = driver.findElement(By.cssSelector("div#checkout-cart-wrapper p em"));
        String noItemsText = noItems.getText();
        System.out.println(noItemsText);
    }
}
