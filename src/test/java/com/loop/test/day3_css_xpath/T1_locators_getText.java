package com.loop.test.day3_css_xpath;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {

    public static void main(String[] args) {


//        WebDriverManager.chromedriver().setup();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app/");

        WebElement userName = driver.findElement(By.id("input-14"));
        userName.sendKeys(DocuportConstants.USERNAME_CLIENT);
        userName.clear();

//        WebElement password = driver.findElement(By.tagName("input"));
//        password.clear();
//        password.sendKeys("password");

        WebElement loginButton  = driver.findElement(By.className("v-btn__content"));
        loginButton.click();


        WebElement errorMessageForEmptyPassword = driver.findElement(By.className("v-messages__message"));
        String actualErrorMessage = errorMessageForEmptyPassword.getText();

        if(actualErrorMessage.equals(DocuportConstants.ERROR_MASSAGE_FOR_EMPTY_PASSWORD)){

            System.out.println("Expected error message : "+ DocuportConstants.ERROR_MASSAGE_FOR_EMPTY_PASSWORD +  actualErrorMessage+", matches actual error message. TEST PASS ");
        }else{
            System.out.println("Expected error message : "+ DocuportConstants.ERROR_MASSAGE_FOR_EMPTY_PASSWORD  +actualErrorMessage);
            System.err.println("TEST FSAIL");
        }

        driver.quit();



    }
}