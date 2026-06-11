package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class ScreenshotUtils {

    public static String captureScreenshot(
            WebDriver driver,
            String testName)
    {
        String path=
                System.getProperty("user.dir")
                +"/screenshots/"
                +testName+".png";

        try {

            File src=
                    ((TakesScreenshot)driver)
                            .getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(src,new File(path));

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return path;
    }
}