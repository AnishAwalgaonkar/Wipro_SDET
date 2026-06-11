package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver,
                                           String fileName)
                                           throws IOException {

        TakesScreenshot ts =
                (TakesScreenshot) driver;

        File source =
                ts.getScreenshotAs(OutputType.FILE);

        String path =
                "screenshots/" + fileName + ".png";

        File destination = new File(path);

        FileUtils.copyFile(source, destination);

        return path;
    }
}