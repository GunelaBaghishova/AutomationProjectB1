package com.loop.test.day4_xpath_findElement.day4_home_tasks;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task1 {
    /*
    task 1
=============
1. go to docuport app
2. validate that Home, Received docs, My uploads, Invitations are displayed
3. press three lines
4. Home, Received docs, My uploads, Invitations will disappear
5. Validate the buttons are not displayed
     */
@Test
    public void TestTask1() throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //1. go to docuport app
        driver.get("https://beta.docuport.app/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-14']"));
        userName.sendKeys(DocuportConstants.USERNAME_CLIENT);

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys(DocuportConstants.PASSWORD_CLIENT);

        WebElement login = driver.findElement(By.xpath("//span[.=' Log in ']"));
        login.click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    List<WebElement> leftNavigateItems = driver.findElements(By.xpath("//span[@class='body-1']"));
//2. validate that Home, Received docs, My uploads, Invitations are displayed
        for (WebElement leftNavigateItem : leftNavigateItems) {
            if (leftNavigateItem.isDisplayed()){
                System.out.println("Left navigate items \""+leftNavigateItem.getText()+"\" is displayed --> TEST PASSED");
            }else{
                System.out.println("Left navigate items \"" +leftNavigateItem.getText()+ "\" is displayed  --> TEST FAILED");
            }
        }
        System.out.println("===================AFTER CLICKING TREE LINES=======================");

 //   3. press three lines
        WebElement threeLinesButton = driver.findElement(By.xpath("//button[contains(@class,'v-app-bar__nav-icon v-btn v-btn--icon v-btn--round theme--light v-size--default')]"));
        threeLinesButton.click();
  //  4. Home, Received docs, My uploads, Invitations will disappear
Thread.sleep(3000);
//5. Validate the buttons are not displayed
        for (WebElement leftNavigateItem : leftNavigateItems) {
            if (!leftNavigateItem.isDisplayed()){
                System.out.println("Left navigate item  \""+leftNavigateItem.getText()+"\" is NOT displayed --> TEST PASSED");
            }else{
                System.out.println("Left navigate item \""+leftNavigateItem.getText()+"\" is  displayed --> TEST FAILED");
            }
        }
driver.quit();

    }
}
