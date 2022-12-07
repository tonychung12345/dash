import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class Login {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    @Before
    public void beforeTest() throws MalformedURLException {
        // Set common desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); //android automation
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "false");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "600000"); //milliseconds
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/tony/Desktop/app-dev-debug-1205.apk");

        // Set android desired capabilities
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, "1253"); //must not in use

        // Launch Mobile App

        webDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

        // Create Webdriver Wait Object
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    @After
    public void afterTest(){
        // Close Chrome Browser
        webDriver.quit();
    }

    @Test
    public void Test1() throws InterruptedException {

        LoginPagePO loginPagePO = new LoginPagePO(webDriver, webDriverWait);
        loginPagePO.clickHelpButton();
        //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(loginPagePO.phoneNumberTextBox));
        //loginPagePO.loginDriverApp("20221122");
        loginPagePO.inputPhoneNumber("20221122");
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(loginPagePO.confirmButton));
        loginPagePO.clickConfirmButton();
        Thread.sleep(10000);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(loginPagePO.otp));
        loginPagePO.inputOTP("111111");
        Thread.sleep(6000);
        loginPagePO.clickConfirmOTPButton();
        Thread.sleep(10000);

    }

}