package config;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static Properties properties;
    private static final String CONFIG_FILE = "src/main/resources/config.properties";

    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(CONFIG_FILE);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        // Common capabilities
        capabilities.setCapability("platformName", getProperty("platform.name"));
        capabilities.setCapability("automationName", getProperty("automation.name"));
        capabilities.setCapability("deviceName", getProperty("device.name"));
        capabilities.setCapability("udid", getProperty("device.udid"));
        
        // App specific capabilities
        capabilities.setCapability("app", getProperty("app.path"));
        capabilities.setCapability("appPackage", getProperty("app.package"));
        capabilities.setCapability("appActivity", getProperty("app.activity"));
        
        // Additional capabilities
        capabilities.setCapability("noReset", Boolean.parseBoolean(getProperty("no.reset")));
        capabilities.setCapability("newCommandTimeout", Integer.parseInt(getProperty("command.timeout")));
        
        return capabilities;
    }
} 