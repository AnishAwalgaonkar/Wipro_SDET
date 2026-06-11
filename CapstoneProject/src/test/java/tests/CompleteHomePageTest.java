package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import factory.DriverFactory;

import pages.*;

public class CompleteHomePageTest
        extends BaseTest {

    @Test
    public void automateEntirePage()
    {
        FormSectionPage form=
                new FormSectionPage(
                        DriverFactory.getDriver());

        DatePickerPage date=
                new DatePickerPage(
                        DriverFactory.getDriver());

        UploadPage upload=
                new UploadPage(
                        DriverFactory.getDriver());

        AlertPage alert=
                new AlertPage(
                        DriverFactory.getDriver());

        ActionsPage action=
                new ActionsPage(
                        DriverFactory.getDriver());

        TablePage table=
                new TablePage(
                        DriverFactory.getDriver());

        form.fillForm();

        date.selectDate();

        upload.uploadFile();

        alert.handleAlert();

        action.dragAndDrop();

        action.adjustSliderRange();

        System.out.println(
                "Rows = "
                + table.getRowCount());
    }
}