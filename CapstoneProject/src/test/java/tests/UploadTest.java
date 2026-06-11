package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import factory.DriverFactory;
import pages.UploadPage;

public class UploadTest extends BaseTest {

    @Test
    public void verifyFileUpload()
    {
        UploadPage upload =
                new UploadPage(
                        DriverFactory.getDriver());

        upload.uploadFile();
    }
}