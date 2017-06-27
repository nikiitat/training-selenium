package stqa;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by nikitatertytskyi on 25.06.17.
 */
public class TestBase {
    protected WebDriver driver = null;
    protected WebDriverWait wait;
    protected String browser = "chrome";


    @Before
    public void beforeTest() {
//        if(browser.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver();
//        }else if (browser.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver();
//        }

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        driver = new ChromeDriver(caps);
        wait = new WebDriverWait(driver, 30);
        driver.get("http://localhost/litecart/en/");
    }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
