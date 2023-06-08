package com.loop.test.day9_driver_faker_action;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_upload {

      /*
    1. Go to “http://demo.guru99.com/test/upload”
    2. Upload file into Choose File
    3. Click terms of service check box
    4. Click Submit File button
    5. Validate expected message appeared. Expected: “1 file has been successfully uploaded.
   */
    @Test

    public void upload_file() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("guru.url"));
        WebElement chooseFile = Driver.getDriver().findElement(By.id("uploadfile_0"));
        String path = "/Users/gunelediyarova/Desktop/table.png";
        chooseFile.sendKeys(path);
        WebElement checkBox = Driver.getDriver().findElement(By.id("terms"));
        checkBox.click();
        WebElement submitButton = Driver.getDriver().findElement(By.id("submitbutton"));
        submitButton.click();
        WebElement successMassage = Driver.getDriver().findElement(By.id("res"));
        String expected="1 file\nhas been successfully uploaded.";
        Assert.assertEquals(successMassage.getText(), expected);
      //  Driver.closeDriver();

    }
}
