package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports createInstance(){
        String reportDirectory = System.getProperty("user.dir") + "/reports/";
        String reportFilePath = reportDirectory + getReportName();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportFilePath);
        htmlReporter.viewConfigurer().viewOrder().as(new ViewName[]{
        ViewName.DASHBOARD,ViewName.TEST,ViewName.EXCEPTION,ViewName.CATEGORY,ViewName.LOG,ViewName.DEVICE});
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Test Case Result");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.setSystemInfo("Test Run By:","Rajan Chaudhary");
        extent.attachReporter(htmlReporter);

        return extent;
    }

    public static String getReportName(){
        String fileName = "report.html";
        return fileName;
    }

}