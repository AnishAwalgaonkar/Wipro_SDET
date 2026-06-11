package utilities;

import java.io.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getInstance() {

        if(extent == null) {
        	File reportDir = new File("reports");

            if(!reportDir.exists()) {
                reportDir.mkdirs();
            }

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("reports/ExtentReport.html");

            spark.config().setReportName("GUI Automation Report");
            spark.config().setDocumentTitle("Automation Results");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Anish");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}