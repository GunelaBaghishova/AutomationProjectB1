package com.loop.test.utilities;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.InputMismatchException;

public class DocuportUtils {
    /**
     * login to the docuport application
     * @param driver which initialized  in test base
     * @param role , comes from DocuportConstants
     */
    public static void login(WebDriver driver, String role) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//label[.='Username or email']//following-sibling::input"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        switch (role.toLowerCase()){
            case "client":
                username.sendKeys(ConfigurationReader.getProperty("client"));
                password.sendKeys(ConfigurationReader.getProperty("password"));
                break;
            case "supervisor":
                username.sendKeys(ConfigurationReader.getProperty("supervisor"));
                password.sendKeys(ConfigurationReader.getProperty("password"));
                break;
            case "advisor":
                username.sendKeys(ConfigurationReader.getProperty("advisor"));
                password.sendKeys(ConfigurationReader.getProperty("password"));
                break;
            case "employee":
                username.sendKeys(ConfigurationReader.getProperty("employee"));
                password.sendKeys(ConfigurationReader.getProperty("password"));
                break;
            default: throw new InputMismatchException("There is not suc a role: " + role);
        }
        loginButton.click();
    }

    /**
     * logsout from the application
     * @param driver
     * @author GunelB.
     */
    public static void logout(WebDriver driver){

        WebElement userIcon = Driver.getDriver().findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        WebElement logOut = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();

    }


    }

