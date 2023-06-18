package com.loop.test.day11_utils_practice.practice;

import com.loop.pages.SmartBearPracticePage;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
/*
task1
1. Open browser
2. Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page
 */
public class day11_task {
    SmartBearPracticePage smartBearPracticePage;
    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get(ConfigurationReader.getProperty("smartbear.url"));
         smartBearPracticePage= new SmartBearPracticePage();
    }
    @Test
    public void task1(){
        smartBearPracticePage.username.sendKeys("Tester");
        smartBearPracticePage.password.sendKeys("test");
        smartBearPracticePage.loginButton.click();
        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));
        System.out.println("Count of all the links is "+ links.size());
        for (WebElement link : links) {
            System.out.println(link.getText());
            
        }

    }
}
