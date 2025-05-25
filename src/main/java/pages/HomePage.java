package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;
import java.util.List;
import org.openqa.selenium.WebElement;

/**
 * Page Object class representing the Home screen of the Monefy app
 */
public class HomePage extends BasePage {
    private final TransactionEntryPage transactionScreen;

    // Transaction action buttons
    private static final By EXPENSE_BUTTON = By.id("com.monefy.app.lite:id/expense_button_title");
    private static final By INCOME_BUTTON = By.id("com.monefy.app.lite:id/income_button_title");

    // Amount display elements
    private static final By EXPENSE_AMOUNT_TEXT = By.id("com.monefy.app.lite:id/expense_amount_text");
    private static final By INCOME_AMOUNT_TEXT = By.id("com.monefy.app.lite:id/income_amount_text");
    private static final By BALANCE_CONTAINER = By.id("com.monefy.app.lite:id/balance_container");
    private static final By BALANCE_TEXT_LIST = AppiumBy.androidUIAutomator(
        "new UiSelector().resourceId(\"com.monefy.app.lite:id/textViewWholeAmount\")"
    );

    // Settings related elements
    private static final By APP_SETTINGS_BUTTON = AppiumBy.accessibilityId("Settings");
    private static final By SETTINGS_BUTTON = AppiumBy.id("com.monefy.app.lite:id/settings_textview");
    private static final By BUDGET_MODE_CHECKBOX = AppiumBy.id("com.monefy.app.lite:id/is_budget_mode_checkbox");
    private static final By MONTHLY_BUDGET_AMOUNT_INPUT = AppiumBy.className("android.widget.EditText");
    private static final By MONTHLY_BUDGET_AMOUNT_OK_BUTTON = AppiumBy.id("android:id/button1");

    public HomePage(AndroidDriver driver) {
        super(driver);
        this.transactionScreen = new TransactionEntryPage(driver);
    }

    // Transaction Methods
    public void recordExpense(int amount, String category) {
        click(EXPENSE_BUTTON);
        transactionScreen.completeTransaction(amount, category);
    }

    public void recordIncome(int amount, String category) {
        click(INCOME_BUTTON);
        transactionScreen.completeTransaction(amount, category);
    }

    // Balance Methods
    public void toggleBalanceContainer() {
        click(BALANCE_CONTAINER);
    }

    public boolean validateBalanceText(int expectedText) {
        List<WebElement> elements = driver.findElements(BALANCE_TEXT_LIST);
        System.out.println("Number of balance elements found: " + elements.size());
        
        String expectedAmount = "$" + expectedText + ".00";
        return elements.stream()
            .map(WebElement::getText)
            .peek(text -> System.out.println("Actual text: " + text))
            .anyMatch(text -> text.equals(expectedAmount));
    }

    // Amount Validation Methods
    public boolean isExpenseAmountDisplayed(int amount) {
        String expectedText = "$" + amount;
        String actualText = getText(EXPENSE_AMOUNT_TEXT);
        return actualText.contains(expectedText);
    }

    public boolean isIncomeAmountDisplayed(int amount) {
        String expectedText = "$" + amount;
        String actualText = getText(INCOME_AMOUNT_TEXT);
        return actualText.contains(expectedText);
    }

    // Settings Methods
    public void toggleSettings() {
        click(APP_SETTINGS_BUTTON);
    }

    public void setBudgetMode(int amount) {
        toggleSettings();
        click(SETTINGS_BUTTON);
        click(BUDGET_MODE_CHECKBOX);
        type(MONTHLY_BUDGET_AMOUNT_INPUT, String.valueOf(amount));
        click(MONTHLY_BUDGET_AMOUNT_OK_BUTTON);
        toggleSettings();
    }
}
