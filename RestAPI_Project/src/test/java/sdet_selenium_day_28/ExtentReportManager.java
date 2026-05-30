package sdet_selenium_day_28;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir")
                    + "/test-output/ExtentReport.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName("API Automation Report");
            sparkReporter.config().setDocumentTitle("Rest Assured Test Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Tester", "Anish");
            extent.setSystemInfo("Project", "DummyJSON API Testing");
        }

        return extent;
    }
}