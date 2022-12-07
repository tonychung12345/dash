import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;



public class SignUp {
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
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
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
    public void Test2() throws InterruptedException {

        SignUpPO signUpPO = new SignUpPO(webDriver, webDriverWait);
        signUpPO.clickSettingButton();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(signUpPO.driverSignUpButton));
        signUpPO.clickDriverSignUpButton();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(signUpPO.phoneNum));
        signUpPO.inputPhoneNum("20221205");
        signUpPO.inputEnglishName();
        signUpPO.inputChineseName();
        signUpPO.selectSex();
//        TouchActions action = new TouchActions(webDriver);
//        action.flick(webDriver.findElement(signUpPO.chineseName), 1, -10, 10);
//        action.perform();
        signUpPO.scrollTo(signUpPO.chineseName, 5, 10);
        signUpPO.inputHKIDNum();
        Thread.sleep(5000);

    }

}