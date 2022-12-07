import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SignUpPO extends BasePagePO {

    private final WebDriver webDriver;

    public SignUpPO(WebDriver webDriver, WebDriverWait webDriverWait){
        super(webDriver, webDriverWait);
        this.webDriver = webDriver;
    }
    private final By settingButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ImageView[3]");
    public final By driverSignUpButton = By.xpath("//android.widget.Button[@content-desc=\"司機註冊\"]");
    public final By phoneNum = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]");
    private final By englishName = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
    public final By chineseName = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[3]");
    private final By sex = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[3]/android.widget.RadioButton[1]");
    private final By hkidNum = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[4]");
    private final By driverLicenseNum = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
    private final By driverBank = By.xpath("//android.view.View[@content-desc=\"銀行\"]");

    public void clickDriverSignUpButton()
    {
        webDriver.findElement(driverSignUpButton).click();
    }

    public void clickSettingButton()
    {
        webDriver.findElement(settingButton).click();
    }

    public void inputPhoneNum(String phoneNumber)
    {
        webDriver.findElement(phoneNum).click();
        webDriver.findElement(phoneNum).sendKeys(phoneNumber);
    }

    public void inputEnglishName()
    {
        webDriver.findElement(englishName).click();
        String driverEnglishName;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        driverEnglishName = "abc "+formatter.format(date);
        webDriver.findElement(englishName).sendKeys(driverEnglishName);
    }

    public void inputChineseName()
    {
        webDriver.findElement(chineseName).click();
        String driverChineseName;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        driverChineseName = "中文 "+formatter.format(date);
        webDriver.findElement(chineseName).sendKeys(driverChineseName);
    }
    public void selectSex()
    {
        webDriver.findElement(sex).click();
    }
    public void inputHKIDNum()
    {


        String firstChars = RandomStringUtils.randomAlphabetic(1);
        String lastChars = RandomStringUtils.randomAlphabetic(1);
        int max = 999;
        int min = 0;
        int b = (int)(Math.random()*(max-min+1)+min);
        int c = (int)(Math.random()*(max-min+1)+min);
        String HKID;
        HKID = firstChars+b+c+lastChars;
        webDriver.findElement(hkidNum).click();
        webDriver.findElement(hkidNum).sendKeys(HKID);

    }
}
