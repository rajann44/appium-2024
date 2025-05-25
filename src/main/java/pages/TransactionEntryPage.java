package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class TransactionEntryPage extends BasePage {
    // Calculator buttons
    private final By BUTTON_0 = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboard0");
    private final By BUTTON_1 = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboard1");
    private final By BUTTON_2 = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboard2");
    private final By BUTTON_3 = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboard3");
    private final By BUTTON_4 = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboard4");
    private final By BUTTON_5 = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboard5");
    private final By BUTTON_6 = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboard6");
    private final By BUTTON_7 = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboard7");
    private final By BUTTON_8 = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboard8");
    private final By BUTTON_9 = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboard9");
    private final By BUTTON_PLUS = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboardPlus");
    private final By BUTTON_MINUS = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboardMinus");
    private final By BUTTON_MULTIPLY = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboardMultiply");
    private final By BUTTON_DIVIDE = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboardDivide");
    private final By BUTTON_EQUALS = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboardEquals");
    private final By BUTTON_DOT = AppiumBy.id("com.monefy.app.lite:id/buttonKeyboardDot");
    private final By BUTTON_ACTION = AppiumBy.id("com.monefy.app.lite:id/keyboard_action_button");
    private final By NAVIGATE_UP = AppiumBy.accessibilityId("Navigate up");

    public TransactionEntryPage(AppiumDriver driver) {
        super(driver);
    }
    
    public TransactionEntryPage enterNumber(int number) {
        String numStr = String.valueOf(number);
        for (char digit : numStr.toCharArray()) {
            click(getNumberButton(digit));
        }
        return this;
    }
    
    private By getNumberButton(char digit) {
        switch (digit) {
            case '0':
                return BUTTON_0;
            case '1':
                return BUTTON_1;
            case '2':
                return BUTTON_2;
            case '3':
                return BUTTON_3;
            case '4':
                return BUTTON_4;
            case '5':
                return BUTTON_5;
            case '6':
                return BUTTON_6;
            case '7':
                return BUTTON_7;
            case '8':
                return BUTTON_8;
            case '9':
                return BUTTON_9;
            default:
                throw new IllegalArgumentException("Invalid digit: " + digit);
        }
    }
    
    public TransactionEntryPage clickPlus() {
        click(BUTTON_PLUS);
        return this;
    }
    
    public TransactionEntryPage clickMinus() {
        click(BUTTON_MINUS);
        return this;
    }
    
    public TransactionEntryPage clickMultiply() {
        click(BUTTON_MULTIPLY);
        return this;
    }
    
    public TransactionEntryPage clickDivide() {
        click(BUTTON_DIVIDE);
        return this;
    }
    
    public TransactionEntryPage clickEquals() {
        click(BUTTON_EQUALS);
        return this;
    }
    
    public TransactionEntryPage clickDot() {
        click(BUTTON_DOT);
        return this;
    }
    
    public TransactionEntryPage clickChooseCategoryButton() {
        click(BUTTON_ACTION);
        return this;
    }
    
    public TransactionEntryPage clickNavigateUp() {
        click(NAVIGATE_UP);
        return this;
    }
    
    public boolean isButtonDisplayed(By buttonLocator) {
        return isElementDisplayed(buttonLocator);
    }

    private By getCategoryLocator(String category) {
        return AppiumBy.androidUIAutomator("new UiSelector().text(\"" + category + "\")");
    }

    public void completeTransaction(int amount, String category) {
        enterNumber(amount);
        clickChooseCategoryButton();
        click(getCategoryLocator(category));
    }
}
