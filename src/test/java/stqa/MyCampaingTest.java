package stqa;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by nikitatertytskyi on 23.06.17.
 */
public class MyCampaingTest extends TestBase {


    @Test
    public void myCampaingTest() {
        campaingTest();
    }
    public void campaingTest(){
        WebElement campaing = driver.findElement(By.cssSelector("div#box-campaigns.box ul.listing-wrapper.products " +
                "a:first-child"));
        int count = driver.findElements(By.cssSelector("div#box-campaigns.box ul.listing-wrapper.products " +
                "a:first-child")).size();
        System.out.println(count);

        for (int i=0; i<count; i++) {
            String name = campaing.findElement(By.cssSelector("div.name")).getAttribute("textContent");

            WebElement oldPriceElement = campaing.findElement(By.cssSelector("s"));

            String oldPrice = oldPriceElement.getAttribute("textContent");
            String oldPriceClass = oldPriceElement.getAttribute("class");
            String lineOldPrice = oldPriceElement.getCssValue("text-decoration-line");
            String fontOldPrice = oldPriceElement.getCssValue("font-size");
            System.out.println(lineOldPrice + fontOldPrice);
            assertTrue("No line", lineOldPrice.equals("line-through"));
            assertEquals(fontOldPrice,
                    "14.4px", fontOldPrice);

            WebElement newPriceElement = campaing.findElement(By.cssSelector("strong"));
            String newPrice = newPriceElement.getAttribute("textContent");
            String newPriceClass = newPriceElement.getAttribute("class");
            String fontNewPrice = newPriceElement.getCssValue("font-size");
            System.out.println(fontNewPrice);
            assertEquals(fontNewPrice,
                    "18px", fontNewPrice);

            campaing.click();

            WebElement product = driver.findElement(By.cssSelector("div#box-product h1.title"));
            String name2 = product.getAttribute("textContent");
            assertTrue("Name is not equal", name.equals(name2));

            WebElement productElement = driver.findElement(By.cssSelector("div#box-product"));
            WebElement priceProductElement = productElement.findElement(By.cssSelector("s"));
            String priceProductOld = priceProductElement.getAttribute("textContent");
            String oldPriceProductClass = priceProductElement.getAttribute("class");
            assertTrue("Old Price is not equal", priceProductOld.equals(oldPrice));
            assertTrue("Old price Class is not equal", oldPriceProductClass.equals(oldPriceClass));

            WebElement priceProductElementNew = productElement.findElement(By.cssSelector("strong"));
            String priceProductNew = priceProductElementNew.getAttribute("textContent");
            String newPriceProductClass = priceProductElementNew.getAttribute("class");
            assertTrue("New Price is not equal", priceProductNew.equals(newPrice));
            assertTrue("New price Class is not equal", newPriceProductClass.equals(newPriceClass));

            String lineOldPriceProduct = priceProductElement.getCssValue("text-decoration-line");
            String fontOldPriceProduct = priceProductElement.getCssValue("font-size");
            System.out.println(lineOldPrice + fontOldPrice);
            assertTrue("No line", lineOldPriceProduct.equals("line-through"));
            assertEquals(fontOldPriceProduct,
                    "16px", fontOldPriceProduct);

            String fontNewPriceProduct = priceProductElementNew.getCssValue("font-size");
            System.out.println(fontNewPriceProduct );
            assertEquals(fontNewPriceProduct,
                    "22px", fontNewPriceProduct);

            driver.navigate().back();
        }
    }
}
