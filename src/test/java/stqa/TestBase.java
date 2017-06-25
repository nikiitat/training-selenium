package stqa;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by nikitatertytskyi on 25.06.17.
 */
public class TestBase {
    protected WebDriver driver = null;
    protected String browser = "firefox";


    @Before
    public void beforeTest() {
        if(browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/en/");
    }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
