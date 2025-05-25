package tests;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import utils.DriverManager;
import utils.TestListeners;

@Listeners(TestListeners.class)
public class BaseTest {
    protected AndroidDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Just get the existing driver instance without resetting
        driver = DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
} 