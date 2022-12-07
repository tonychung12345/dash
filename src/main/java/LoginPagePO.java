import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPagePO extends BasePagePO{

    private final WebDriver webDriver;

    public LoginPagePO(WebDriver webDriver, WebDriverWait webDriverWait){
        super(webDriver, webDriverWait);
        this.webDriver = webDriver;
    }
    public final By phoneNumberTextBox = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
    private final By helpButton = By.xpath("//android.widget.Button[@content-desc=\"幫助\"]");
    public final By confirmButton = By.xpath("//android.widget.Button[@content-desc=\"確認\"]");

    public final By otp = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
    public final By confirmOTPButton = By.xpath("//android.widget.Button[@content-desc=\"提交\"]");


    public void clickHelpButton()
    {
        webDriver.findElement(helpButton).click();
    }

    public void clickConfirmButton()
    {
        webDriver.findElement(confirmButton).click();
    }
    public void inputPhoneNumber(String phoneNum)
    {
        webDriver.findElement(phoneNumberTextBox).click();
        webDriver.findElement(phoneNumberTextBox).sendKeys(phoneNum);
    }

    public void loginDriverApp(String strPhoneNum)
    {
        inputPhoneNumber(strPhoneNum);
        clickConfirmButton();
    }

    public void inputOTP(String otpSMS)
    {
        webDriver.findElement(otp).click();
        webDriver.findElement(otp).sendKeys(otpSMS);
    }

    public void clickConfirmOTPButton()
    {
        webDriver.findElement(confirmOTPButton).click();
    }
}
