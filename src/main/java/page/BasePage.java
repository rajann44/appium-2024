package page;

import com.aventstack.extentreports.ExtentTest;

public class BasePage {
    protected static ExtentTest logger;

    public static void setLogger(ExtentTest extentTest) {
        logger = extentTest;
    }
} 