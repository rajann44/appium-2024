package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URI;
import config.AppiumConfig;

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
            capabilities.setCapability("appium:deviceName", AppiumConfig.Device.getName());
            capabilities.setCapability("appium:platformVersion", AppiumConfig.Device.getPlatformVersion());
            capabilities.setCapability("appium:udid", AppiumConfig.Device.getUdid());
            capabilities.setCapability("appium:automationName", AppiumConfig.Device.getAutomationName());
            capabilities.setCapability("appium:appPackage", AppiumConfig.App.getPackage());
            capabilities.setCapability("appium:appActivity", AppiumConfig.App.getActivity());
            capabilities.setCapability("appium:noReset", AppiumConfig.App.getNoReset());
            capabilities.setCapability("appium:autoGrantPermissions", AppiumConfig.App.getAutoGrantPermissions());
            
            // Grant notification permission
            capabilities.setCapability("appium:autoGrantPermissions", true);

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