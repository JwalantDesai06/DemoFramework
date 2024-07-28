package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
    private static ExtentReports extentReports;
    private static ExtentHtmlReporter htmlReporter;

    public static ExtentReports getReporter() {
        if (extentReports == null) {
            htmlReporter = new ExtentHtmlReporter("target/extent-report.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);
        }
        return extentReports;
    }

    public static ExtentTest createTest(String testName) {
        return getReporter().createTest(testName);
    }

    public static void flush() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}