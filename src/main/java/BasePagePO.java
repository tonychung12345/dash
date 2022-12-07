import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class BasePagePO {
    WebDriverWait webDriverWait;
    WebDriver webDriver;

    private final static PointerInput FINGER = new PointerInput(TOUCH, "finger");
    private float deadZone = (float) 0.3;
    private String direction = "Down";

    public BasePagePO(WebDriver webDriver, WebDriverWait webDriverWait){
        this.webDriverWait = webDriverWait;
        this.webDriver = webDriver;
    }

    public void scrollTo(By by, int scrollTries, int scrollTimeout){
        for (int i = 0; i < scrollTries; i++) {
            try{
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
            }catch (TimeoutException te){

                Dimension windowSize = webDriver.manage().window().getSize();
                Rectangle containerRect = new Rectangle(0, 0, windowSize.getHeight(), windowSize.getWidth());
                int x, yi, yf;
                x = (int) (containerRect.y + containerRect.height * 0.5);

                if(direction.equalsIgnoreCase("down")){
                    yi = (int) (containerRect.y + containerRect.height * (1 - deadZone));
                    yf = (int) (containerRect.y + containerRect.height * deadZone);
                }
                else if(direction.equalsIgnoreCase("up")){
                    yi = (int) (containerRect.y + containerRect.height * deadZone);
                    yf = (int) (containerRect.y + containerRect.height * (1 - deadZone));
                }
                else{
                    throw new RuntimeException("Direction not implemented: " + direction);
                }
                AppiumDriver appiumDriver = (AppiumDriver) webDriver;
                Sequence swipe = new Sequence(FINGER, 1)
                        .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), x, yi))
                        .addAction(FINGER.createPointerDown(LEFT.asArg()))
                        .addAction(FINGER.createPointerMove(ofMillis(1000), viewport(), x, yf))
                        .addAction(FINGER.createPointerUp(LEFT.asArg()));
                appiumDriver.perform(Collections.singletonList(swipe));
            }
        }
        throw new NoSuchElementException(String.format("Cannot locate Element %s after %s time of scrolling", by, scrollTries));
    }
}
