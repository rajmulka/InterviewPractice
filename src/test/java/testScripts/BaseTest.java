package testScripts;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public AppiumDriver driver;
    public String URL = "https://www.seleniumeasy.com/test/table-search-filter-demo.html";

    public void initialization() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");

        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8 Plus");

        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

        driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.get(URL);
    }
}
