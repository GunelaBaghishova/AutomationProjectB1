package com.loop.test.day4_xpath_findElement;
/*
  /*
    1. Open Chrome browser
    2. Go to docuport
    3. Click on forgot password
    4. validate URL contains: reset-password
    5. validate - Enter the email address associated with your account
    6. enter forgotpasswordg1@gmail.com to email box
    7. validate cancel button is displayed
    8. validate send button is displayed
    9. click send button
    10. validate - We've sent you an email with a link to reset your password. Please check your email
     */


import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TOO_xpath_getText_staleElement {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://beta.docuport.app/");
        driver.manage().window().maximize();

        WebElement forgetPassword = driver.findElement(By.xpath("//a[.='Forgot password?']"));
        forgetPassword.click();

        String actualUrlForResetPassword = driver.getCurrentUrl();

        if(actualUrlForResetPassword.contains(DocuportConstants.RESET_PASSWORD_URL)){
            System.out.println("TEST PASS: => Actual url: " + actualUrlForResetPassword + " contains expected url: " + DocuportConstants.RESET_PASSWORD_URL);
        } else {
            System.out.println("TEST FAIL: => Actual url: " + actualUrlForResetPassword + " does not contain expected url: " + DocuportConstants.RESET_PASSWORD_URL);
        }

        WebElement validateMessage = driver.findElement(By.xpath("//div[@class='v-messages__message']"));
        String actualValidateMessage = validateMessage.getText();

        if (actualValidateMessage.contains(DocuportConstants.RESET_PASSWORD_MESSAGE)) {
            System.out.println("TEST PASS: ==> Actual validate message: \"" + actualValidateMessage + "\" contains expected message \"" + DocuportConstants.RESET_PASSWORD_MESSAGE);
        } else {
            System.out.println("TEST FAIL ==> Actual validate message: \"" + actualValidateMessage + "\" doesnt contains expected message \"" + DocuportConstants.RESET_PASSWORD_MESSAGE);

        }

        WebElement emailInputBox = driver.findElement(By.xpath("//input[@type='email']"));
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);


        // 7. validate cancel button is displayed
        WebElement cancelButton = driver.findElement(By.xpath("//span[.=' Cancel ']"));
        WebElement sendButton = driver.findElement(By.xpath("//span[.=' Send ']"));

        if (sendButton.isDisplayed()){
            System.out.println("Test Pass = Cancel button is displayed");
        } else {
            System.err.println("Test Failed = Cancel button is NOT displayed");
        }

        if (sendButton.isDisplayed()){
            System.out.println("Test Pass = Send button is displayed");
        } else {
            System.err.println("Test Failed = Send button is NOT displayed");
        }
        // 9. click send button
        sendButton.click();

        Thread.sleep(3000);

        // 10. validate - We've sent you an email with a link to reset your password. Please check your email
        WebElement successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));

        Thread.sleep(3000);


        try{
            System.out.println(successMessage.getText() + " we successfully got the message");
        } catch (StaleElementReferenceException e){
            System.out.println("Element is not accessible anymore");
            e.printStackTrace();
        }
}
}
