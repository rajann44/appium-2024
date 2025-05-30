package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URI;
import config.AppiumConfig;
import java.io.File;

public class DriverManager {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    private static void initializeDriver() {
        try {
            var capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", AppiumConfig.Device.getPlatformName());
            capabilities.setCapability("appium:automationName", AppiumConfig.Device.getAutomationName());
            capabilities.setCapability("appium:app", new File("src/main/resources/app.apk").getAbsolutePath());
            capabilities.setCapability("appium:noReset", AppiumConfig.App.getNoReset());
            capabilities.setCapability("appium:autoGrantPermissions", AppiumConfig.App.getAutoGrantPermissions());
            capabilities.setCapability("appium:appActivity", AppiumConfig.App.getActivity());
            capabilities.setCapability("appium:appPackage", AppiumConfig.App.getPackage());

            driver = new AndroidDriver(URI.create(AppiumConfig.Server.getUrl()).toURL(), capabilities);
            driver.manage().timeouts().implicitlyWait(AppiumConfig.Server.getImplicitWait());
        } catch (Exception e) {
            System.err.println("Failed to initialize driver: " + e.getMessage());
            throw new RuntimeException("Failed to initialize driver", e);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
} 