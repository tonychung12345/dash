import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPagePO {

    private WebDriver webDriver;

    public LoginPagePO(WebDriver webDriver){
        this.webDriver = this.webDriver;
    }
    private final By phoneNumberTextBox = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
    private final By helpButton = By.xpath("//android.widget.Button[@content-desc=\"幫助\"]");
    private final By confirmButton = By.xpath("//android.widget.Button[@content-desc=\"確認\"]");


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
        webDriver.findElement(phoneNumberTextBox).sendKeys(phoneNum);
    }

    public void loginDriverApp(String strPhoneNum)
    {
        //inputPhoneNumber(strPhoneNum);
        clickConfirmButton();
    }
}
