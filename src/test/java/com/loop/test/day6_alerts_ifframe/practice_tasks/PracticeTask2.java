package com.loop.test.day6_alerts_ifframe.practice_tasks;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTask2 extends TestBase {
    /*
1. go to https://demoqa.com/nestedframes
2. Validate "Child Iframe" text
3. Validate "Parent Iframe" text
4. Validate the "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame."
 */@Test
    public  void iframePracticeTest (){
         driver.get("https://demoqa.com/nestedframes");
         //2. Validate "Child Iframe" text
         driver.switchTo().frame("frame1");
         driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));
        WebElement childIframe = driver.findElement(By.xpath("//p[text()='Child Iframe']"));
        String actual = childIframe.getText();
        String expected = "Child Iframe";
        Assert.assertEquals(actual, expected);
//3. Validate "Parent Iframe" text
        driver.switchTo().parentFrame();
        WebElement parentIframe = driver.findElement(By.xpath("//body[contains(text(),'Parent frame')]"));
        actual= parentIframe.getText();
        expected= "Parent frame";
        Assert.assertEquals(actual,expected);

        driver.switchTo().defaultContent();
        WebElement headerText = driver.findElement(By.xpath("//div[contains(text(),'Sample Nested Iframe page')]"));
        actual = headerText.getText();
        expected = "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.";
        Assert.assertEquals(actual,expected);
    }
}
