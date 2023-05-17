package com.loop.test.day3_home_task;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
task 1
=============
1. login to docuport application
2. logout from docuport application
3. Validate successful login
4. Validate successful logout
 */
public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app/");

        WebElement userName = driver.findElement(By.cssSelector("input[id='input-14']"));
        userName.sendKeys(DocuportConstants.USERNAME_CLIENT);

        WebElement password = driver.findElement(By.cssSelector("input[id='input-15']"));
        password.sendKeys(DocuportConstants.PASSWORD_CLIENT);

        WebElement login = driver.findElement(By.cssSelector("span[class='v-btn__content']"));
        login.click();

        WebElement uploadButton = driver.findElement(By.cssSelector("button[class='mt-2 ml-2 white--text v-btn v-btn--has-bg theme--light v-size--large'"));
       if(uploadButton.isDisplayed()){
               System.out.println("Upload button is displayed. Successful login --> PASS");
       }else{
             System.out.println("Upload button is NOT displayed. Login is NOT successful --> FAIL");
       }
       Thread.sleep(3000);

       WebElement bach1Group2 = driver.findElement(By.cssSelector("span[class='subtitle-2 text-none pl-2 pr-3 gray--text text--darken-3']"));
       bach1Group2.click();
       Thread.sleep(1000);

       WebElement logOut = driver.findElement(By.cssSelector("div[id='list-item-108']"));
       logOut.click();
       Thread.sleep(1000);

       WebElement loginHeader = driver.findElement(By.cssSelector("h1[class='text-h5 font-weight-medium mb-6']"));
       if(loginHeader.isDisplayed()){
             System.out.println("Login header is displayed. --> TEST PASS");
         }else{
             System.out.println("Login header is NOT displayed. --TEST FAIL");
         }
         driver.quit();















    }
}
