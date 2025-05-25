package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class WelcomeScreen extends BasePage {
    // Locators
    private static final By GET_STARTED_BUTTON = By.id("com.monefy.app.lite:id/buttonContinue");
    private static final By CLOSE_BUTTON = By.id("com.monefy.app.lite:id/buttonClose");

    public WelcomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public void clickGetStarted() {
        click(GET_STARTED_BUTTON);
    }

    public void clickClose() {
        click(CLOSE_BUTTON);
    }
} 