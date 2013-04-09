import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.junit.Assert.assertEquals;


public class SauceOnDemandTest {

    private WebDriver webDriver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("version", Utils.readPropertyOrEnv("SELENIUM_VERSION", ""));
        capabilities.setCapability("platform", Utils.readPropertyOrEnv("SELENIUM_PLATFORM", "XP"));
        capabilities.setCapability("browserName", Utils.readPropertyOrEnv("SELENIUM_BROWSER", "chrome"));
        String username = Utils.readPropertyOrEnv("SAUCE_USER_NAME", "");
        String accessKey = Utils.readPropertyOrEnv("SAUCE_API_KEY", "");
        this.webDriver = new RemoteWebDriver(
                new URL("http://" + username + ":" + accessKey + "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
    }

    @After
    public void tearDown() throws Exception {
        webDriver.quit();
    }

    
    @Test
    public void basic() throws Exception {
        String sessionId = ((RemoteWebDriver) webDriver).getSessionId().toString();
        System.out.println("SauceOnDemandSessionID=" + sessionId);
        webDriver.get("http://qa.ringdna.com/login");
        assertTrue(selenium.isElementPresent("//a[@class='button blue']"));
		//selenium.click();
		element = driver.findElement(By.xpath("//a[@class='button blue']"));
		element.click();
		selenium.waitForPageToLoad("50000");
		assertTrue(selenium.isElementPresent("//input[@id='username']"));
		assertTrue(selenium.isElementPresent("//input[@id='password']"));
		selenium.waitForPageToLoad("50000");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demoqa01@ringdna.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("ebmdna0198");
		//selenium.type("//input[@id='username']", "demoqa01@ringdna.com");
		//selenium.type("//input[@id='password']", "ebmdna0198");
		(driver.findElement(By.xpath("//input[@id='Login']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='main-nav']/ul/li[1]/a[text()='Home']")));
		//wait.until(visibilityOfElementLocated(By.id("some_id")));

    }

}
