package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * TC03 – File Upload
 * Creates temporary dummy files at runtime, then sends their absolute
 * paths to the file-input elements (no browser dialog needed).
 */
public class TC03_FileUploadTest extends BaseTest {

    private String singlePath;
    private String multiPath1;
    private String multiPath2;

    @BeforeClass(alwaysRun = true)
    @Override
    public void setUp() {
        super.setUp();                 // driver + home page
        singlePath = createFile("testdata/single_upload.txt", "Single file upload test content");
        multiPath1 = createFile("testdata/multi_upload_1.txt", "Multi upload file 1");
        multiPath2 = createFile("testdata/multi_upload_2.txt", "Multi upload file 2");
    }

    // ── helpers ──────────────────────────────────────────────

    private String createFile(String relativePath, String content) {
        File f = new File(relativePath);
        f.getParentFile().mkdirs();
        try (FileWriter fw = new FileWriter(f)) {
            fw.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Could not create test file: " + relativePath, e);
        }
        return f.getAbsolutePath();
    }

    // ── tests ────────────────────────────────────────────────

    @Test(priority = 1, description = "Upload a single file via single-file input")
    public void testSingleFileUpload() {
        homePage.uploadSingleFile(singlePath);
        log().info("Sent file path to single-file input: " + singlePath);

        // Chrome places C:\fakepath\<filename> in the value attribute – non-empty is enough
        String val = driver.findElement(
            org.openqa.selenium.By.xpath("//input[@type='file'][1]"))
            .getAttribute("value");
        Assert.assertFalse(val == null || val.isEmpty(),
            "Single file input should reflect the uploaded file");
        log().pass("Single file upload successful. Input value: " + val);
    }

    @Test(priority = 2, description = "Upload a file via multiple-file input")
    public void testMultipleFileUpload() {
        // sendKeys one path at a time – most reliable cross-OS approach
        driver.findElement(org.openqa.selenium.By.xpath("//input[@type='file'][2]"))
              .sendKeys(multiPath1);
        log().info("Sent first file to multi-file input: " + multiPath1);

        String val = driver.findElement(
            org.openqa.selenium.By.xpath("//input[@type='file'][2]"))
            .getAttribute("value");
        Assert.assertFalse(val == null || val.isEmpty(),
            "Multiple file input should reflect the uploaded file");
        log().pass("Multiple file upload successful. Input value: " + val);
    }
}