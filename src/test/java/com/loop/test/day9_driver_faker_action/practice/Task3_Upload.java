package com.loop.test.day9_driver_faker_action.practice;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task3_Upload {
    /*
    1. Go to https://loopcamp.vercel.app/upload.html
2. Find some small file from your computer, and get the path of it.
3. Upload the file.
4. Assert:
	-File uploaded text is displayed on the page

     */
    @Test
    public void upload(){
        Driver.getDriver().get(ConfigurationReader.getProperty("loop.upload"));
        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//div[@id='drag-drop-upload']"));
        String path = "/Users/gunelediyarova/Desktop/table.png";
        chooseFile.sendKeys(path);
        String actual =Driver.getDriver().findElement(By.id("file-upload")).getText();
        System.out.println(actual);
        String expected = "table";
        assertEquals(actual,expected, " does not match");


    }
}
