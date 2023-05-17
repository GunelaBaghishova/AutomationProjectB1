package com.loop.test.day3_home_task;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
1. go to http://the-internet.herokuapp.com/forgot_password
2. locate 5 elements, forgot password, email, email input, retrieve password, powered selenium
3. use css
4. verify those elements are displayed

 */
public class Task0 {


    public static void main(String[] args) {


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        driver.get("http://the-internet.herokuapp.com/forgot_password");

        WebElement forgetPassword = driver.findElement(By.cssSelector("div[class='example']"));
        if(forgetPassword.isDisplayed()){
            System.out.println("Forget password is displayed - TEST PASS");
        }else{
            System.out.println("Forget password is NOT displayed - TEST FAIL ");
        }


        WebElement email = driver.findElement(By.cssSelector("label[for='email']"));
        if(email.isDisplayed()){
            System.out.println("Email is displayed - TEST PASS");
        }else{
            System.out.println("Email is NOT displayed - TEST FAIL ");
        }

        WebElement emailInput = driver.findElement(By.cssSelector("input[type= 'text']"));
        if(email.isDisplayed()){
            System.out.println("Email input is displayed - TEST PASS");
        }else{
            System.out.println("Email  input is NOT displayed - TEST FAIL ");
        }

        WebElement retrievePassword = driver.findElement(By.cssSelector("button[id='form_submit']"));
        if(email.isDisplayed()){
            System.out.println("Retrieve passwordis displayed - TEST PASS");
        }else{
            System.out.println("Retrieve password  input is NOT displayed - TEST FAIL ");
        }

        WebElement poweredSelenium = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        if(email.isDisplayed()){
            System.out.println("Powered selenium displayed - TEST PASS");
        }else{
            System.out.println("Powered selenium  input is NOT displayed - TEST FAIL ");
        }
        driver.quit();
    }



    }

