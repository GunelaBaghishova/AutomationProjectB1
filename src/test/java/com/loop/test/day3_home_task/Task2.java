package com.loop.test.day3_home_task;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
task 2
=============
1. navigate to docuport application
2. validate placeholders for user name and password
3. without sending username and password click login button
4. validate username and password error messages
 */
public class Task2 {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");

//        Thread.sleep(1000);

        WebElement userNamePlaceHolder = driver.findElement(By.cssSelector("label[for=\"input-14\"]"));
        String  actualUserNamePlaceHolder = userNamePlaceHolder.getText();
        // System.out.println(userNamePlaceHolder.getText());
       String expectedUserNamePlaceHolder="Username or email";
       if(actualUserNamePlaceHolder.contains(expectedUserNamePlaceHolder)){
           System.out.println("Actual username placeholder text: \""+actualUserNamePlaceHolder+"\" matches expected username placeholder text: \""+expectedUserNamePlaceHolder+ "\"-->TEST PASSED");
       }else{
           System.out.println("Actual username placeholder text: "+actualUserNamePlaceHolder+" DOES NOT match expected  username placeholder text: "+expectedUserNamePlaceHolder+ "-->TEST FAIL");
       }

       WebElement passwordPlaceHolder = driver.findElement(By.cssSelector("label[for='input-15']"));
        String  actualPasswordPlaceHolder = passwordPlaceHolder.getText();
        String expectedPasswordPlaceHolder="Password";

        if(actualPasswordPlaceHolder.contains(expectedPasswordPlaceHolder)){
            System.out.println("Actual password placeholder text:  \""+actualPasswordPlaceHolder+"\"  matches expected  password placeholder text: \""+expectedPasswordPlaceHolder+"\" -->TEST PASSED");
        }else{
            System.out.println("Actual password placeholder text: "+"\""+actualPasswordPlaceHolder+"\"  DOES NOT match expected  password placeholder text: "+"\""+expectedPasswordPlaceHolder+"\" -->TEST FAIL");
        }


        WebElement loginButton = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        loginButton.click();

      String actualUserNameErrMsg =  driver.findElement(By.cssSelector("div[class=\"v-messages__wrapper\"]")).getText();
      String expectedUserNameErrMsg = "Please enter your username or email address";
        System.out.println(actualUserNameErrMsg.equals(expectedUserNameErrMsg)?"Actual username error message \""+ actualUserNameErrMsg+"\" MATCHES expected username error message \""+expectedUserNameErrMsg+"\" TEST PASSED":"Actual username error message \""+ actualUserNameErrMsg+"\" DOES NOT match expected username error message \""+expectedUserNameErrMsg+"\" TEST FAILED");


     String actualPasswordErrorMsg = driver.findElement(By.cssSelector("div[class=\"v-messages theme--light error--text\"]>div>div")).getText();







    }



}
