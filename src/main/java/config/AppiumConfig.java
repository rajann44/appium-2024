package config;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

/**
 * Configuration manager for Appium settings
 */
public class AppiumConfig {
    private static final Properties properties = new Properties();
    private static final String CONFIG_FILE = "config.properties";

    static {
        try (InputStream input = AppiumConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new RuntimeException("Unable to find " + CONFIG_FILE);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading " + CONFIG_FILE, e);
        }
    }

    private static String getRequiredProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalStateException("Required property '" + key + "' is missing");
        }
        return value;
    }

    /**
     * Server configuration group
     */
    public static class Server {
        public static String getUrl() {
            return getRequiredProperty("appium.server.url");
        }

        public static Duration getImplicitWait() {
            return Duration.ofSeconds(Long.parseLong(getRequiredProperty("appium.implicit.wait")));
        }
    }

    /**
     * Device configuration group
     */
    public static class Device {
        public static String getPlatformName() {
            return getRequiredProperty("platform.name");
        }

        public static String getName() {
            return getRequiredProperty("device.name");
        }

        public static String getPlatformVersion() {
            return getRequiredProperty("platform.version");
        }

        public static String getUdid() {
            return getRequiredProperty("device.udid");
        }

        public static String getAutomationName() {
            return getRequiredProperty("automation.name");
        }
    }

    /**
     * Application configuration group
     */
    public static class App {
        public static String getPackage() {
            return getRequiredProperty("app.package");
        }

        public static String getActivity() {
            return getRequiredProperty("app.activity");
        }

        public static boolean getNoReset() {
            return Boolean.parseBoolean(getRequiredProperty("app.no.reset"));
        }

        public static String getAutoGrantPermissions() {
            return getRequiredProperty("app.grant.permissions");
        }
    }
}