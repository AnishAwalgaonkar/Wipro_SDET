package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import factory.DriverFactory;
import pages.FormSectionPage;

public class FormTest extends BaseTest {

    @Test
    public void verifyFormSubmission()
    {
        FormSectionPage form =
                new FormSectionPage(
                        DriverFactory.getDriver());

        form.fillForm();
    }
}