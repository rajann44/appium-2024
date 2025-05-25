package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WelcomeScreen;
import pages.HomePage;

public class WelcomeScreenTest extends BaseTest {
    private WelcomeScreen welcomeScreen;
    private HomePage homePage;
    private static final int REQUIRED_CLICKS = 3;

    @BeforeMethod
    public void initializePages() {
        welcomeScreen = new WelcomeScreen(driver);
        homePage = new HomePage(driver);
        navigateThroughWelcomeScreens();
    }

    private void navigateThroughWelcomeScreens() {
        for (int i = 0; i < REQUIRED_CLICKS; i++) {
            welcomeScreen.clickGetStarted();
        }
        welcomeScreen.clickClose();
    }

    @Test(priority = 1, description = "Verify expense recording functionality")
    public void shouldRecordExpenseSuccessfully() {
        int expenseAmount = 100;
        homePage.recordExpense(expenseAmount, "Bills");
        Assert.assertTrue(homePage.isExpenseAmountDisplayed(expenseAmount), "Expense amount should be displayed");
        homePage.toggleBalanceContainer();
        Assert.assertTrue(homePage.validateBalanceText(expenseAmount), "Balance should be displayed");
    }

    @Test(priority = 2, description = "Verify income recording functionality")
    public void shouldRecordIncomeSuccessfully() {
        int incomeAmount = 100;
        homePage.recordIncome(incomeAmount, "Deposits");
        Assert.assertTrue(homePage.isIncomeAmountDisplayed(incomeAmount), "Income amount should be displayed");
        homePage.toggleBalanceContainer();
        Assert.assertTrue(homePage.validateBalanceText(incomeAmount), "Balance should be displayed");
    }

    @Test(priority = 3, description = "Verify budget mode")
    public void shouldEnterBudgetMode() {
        int budgetAmount = 150;
        homePage.setBudgetMode(budgetAmount);
        Assert.assertTrue(homePage.isIncomeAmountDisplayed(budgetAmount), "Budget amount should be displayed");
    }
} 