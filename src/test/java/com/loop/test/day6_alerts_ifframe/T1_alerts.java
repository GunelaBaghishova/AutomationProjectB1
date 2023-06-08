package com.loop.test.day6_alerts_ifframe;

import com.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class T1_alerts extends TestBase{
    @Test
    public void informationAlert() throws InterruptedException {
        /*
         Information alert practice
    1. Open browser
    2. Go to website: http://the-internet.herokuapp.com/javascript_alerts
    3. Click to “Click for JS Alert” button
    4. Click to OK button from the alert
    5. Validate “You successfully clicked an alert” text is displayed
         */

        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement  clickForJSAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        clickForJSAlert.click();
        Alert alert = driver.switchTo().alert();
//        // driver.switchTo().alert().accept();
//      Thread.sleep(3000);
       alert.accept();
       WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
       String actual = successMessageForInformationAlert.getText();
       String expected = "You successfully clicked an alert";
       assertEquals(expected,actual, "expected does not match the actual");
    }
    @Test
   public void confirmationAlert() throws InterruptedException {
        /*
          Confirmation alert practice
    1. Click to “Click for JS Confirm” button
    2. Click to OK button from the alert
    3. Verify “You clicked: Ok” text is displayed.
    4. Click to “Click for JS Confirm” button
    5. Click to Cancel button from the alert
    6. Validate “You clicked: Cancel” text is displayed.
         */
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickForJSConfirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
        clickForJSConfirm.click();//will click and accept
//        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement successMessageConfirmationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successMessageConfirmationAlert.getText();
        String expected = "You clicked: Ok";
        assertEquals(expected, actual, "expected does not match the actual");

        clickForJSConfirm.click();
        //Thread.sleep(3000);
        driver.switchTo().alert().dismiss();// will click cancel - will dismiss
        actual = successMessageConfirmationAlert.getText();
        expected = "You clicked: Cancel";
        Assert.assertEquals(actual, expected, "Actual does NOT match expected");
    }

        @Test
        public void promptAlert () {
       /*
         Prompt alert practice
    1. Click to “Click for JS Prompt” button
    2. Send "Loop Academy"
    3. Click Ok
    4. Validate "You entered: Loop Academy" text is displayed
        */

            driver.get("http://the-internet.herokuapp.com/javascript_alerts");
            WebElement clickJSPrompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
            clickJSPrompt.click();
           String text = "Loop Academy";
//       driver.switchTo().alert().sendKeys("Loop Academy");
//        driver.switchTo().alert().accept();
             Alert alert = driver.switchTo().alert();
             alert.sendKeys(text);
             alert.accept();

           WebElement successMessagePromptAlert = driver.findElement(By.xpath("//p[@id='result']"));
           String actual = successMessagePromptAlert.getText();
           String expected = "You entered: " + text;
           assertEquals(actual, expected, "actual does not match the expected");
        }

    }


