package com.loop.test.day6_alerts_ifframe.practice_tasks;

import com.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTask1 extends TestBase {
    @Test
    public void demoqaAlertTest() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        //2. click - click button to see alert
        WebElement clickButtonToSeeAlert = driver.findElement(By.xpath("//button[@id='alertButton'] "));
        clickButtonToSeeAlert.click();
        //3. handle alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //4. click - On button click, alert will appear after 5 seconds
        WebElement clickAlertAppearAfter5Sec = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        clickAlertAppearAfter5Sec.click();
        Thread.sleep(6000);
        //5. handle alert
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        //6. click - On button click, confirm box will appear
        WebElement confirmationAlert1 = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        confirmationAlert1.click();
        driver.switchTo().alert().accept();
       //7. click ok and validate - You selected Ok
        WebElement confirmResult = driver.findElement(By.xpath("//div[@class='col-md-6']/span/following-sibling::span[text()='Ok' and 'You selected  ']"));
         String actual = confirmResult.getText();
         String expected = "You selected Ok";
        Assert.assertEquals(actual,expected);
        // 8. after that do it again this time cancel and validate - You selected Cancel
        WebElement confirmationAlert2 = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        confirmationAlert2.click();
        driver.switchTo().alert().dismiss();
        WebElement dismissResult = driver.findElement(By.xpath("//div[@class='col-md-6']/span/following-sibling::span[text()='Cancel' and 'You selected  ']"));
        actual = confirmResult.getText();
        expected = "You selected Cancel";
        Assert.assertEquals(actual,expected);

        //9. click - On button click, prompt box will appear
        WebElement promptAlert = driver.findElement(By.xpath("//button[@id='promtButton']"));
        promptAlert.click();
        String text = "Loop Academy";
        //10. enter "Loop Academy" and validate You entered Loop Academy
        driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        WebElement promBox = driver.findElement(By.xpath("//div[@class='col-md-6']/span/following-sibling::span[text()='You entered ' and 'Loop Academy']"));
        Assert.assertEquals(promBox.getText(),"You entered "+text);
    }
}

