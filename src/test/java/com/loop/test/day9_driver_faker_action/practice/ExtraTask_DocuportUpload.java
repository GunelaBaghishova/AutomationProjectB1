package com.loop.test.day9_driver_faker_action.practice;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExtraTask_DocuportUpload {
    @Test
    public void DocuportUpload() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        DocuportUtils.login(Driver.getDriver(), "employee");
        WebElement myUploads= Driver.getDriver().findElement(By.xpath("//h2[contains(text(),'My')]"));
        myUploads.click();

        WebElement uploadDocumentButton = Driver.getDriver().findElement(By.xpath("//button[@class='mt-2 ml-2 white--text v-btn v-btn--has-bg theme--light v-size--large']"));
        uploadDocumentButton.click();

        WebElement uploadFile = Driver.getDriver().findElement(By.xpath("//input[@type='file']"));
        String path = "/Users/gunelediyarova/Desktop/image.png";
        uploadFile.sendKeys(path);

        WebElement clientDropdown = Driver.getDriver().findElement(By.xpath("//label[contains(.,'Client')]/.."));
        clientDropdown.click();
        WebElement newClient = Driver.getDriver().findElement(By.xpath("//div[text()='amazon']/.."));
        newClient.click();

        WebElement serviceDropdown = Driver.getDriver().findElement(By.xpath("//label[contains(.,'Service')]/.."));
        serviceDropdown.click();
        Thread.sleep(3000);
        WebElement selectService = Driver.getDriver().findElement(By.xpath("//div[text()='Bookkeeping']/.."));
        selectService.click();

        WebElement docType = Driver.getDriver().findElement(By.xpath("//span[text()=' IRS/State Letter ']"));
        docType.click();
        WebElement quarter = Driver.getDriver().findElement(By.xpath("//span[text()=' Q4 ']"));
        quarter.click();

        WebElement description  = Driver.getDriver().findElement(By.id("input-148"));
        description.sendKeys("image");

        WebElement checkBox = Driver.getDriver().findElement(By.xpath("//label[text()='Upload on behalf of client']/.."));
        checkBox.click();
        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        String actualSuccessMsg = Driver.getDriver().findElement(By.xpath("//div[@class='docu-notifications']")).getText();
        String expected="Document(s) have been uploaded successfully";
        assertEquals(actualSuccessMsg,expected,actualSuccessMsg+" DOES NOT MATCH"+ expected );







    }
}
