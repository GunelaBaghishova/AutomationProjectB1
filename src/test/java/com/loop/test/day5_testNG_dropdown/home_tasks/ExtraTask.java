package com.loop.test.day5_testNG_dropdown.home_tasks;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExtraTask {
    /*
1. go to https://app.docuport.app/company-formation/resident
2. What type of business do you want to start? - choose corporation
3. Validate that corporation has been selected
4. Formation State - choose Virginia
5. Validate Virginia is selected
6. Validate order summer as below:

State registration fee $100
Payment processing $6
Service fee $150
Total $256

7. Formation State - choose Maryland
8. Validate Maryland is selected
9. Validate order summer as below:

State registration fee $170
Payment processing $10.20
Service fee $150
Total $330.20
     */
    WebDriver driver;
    @BeforeMethod
    public  void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://app.docuport.app/company-formation/resident");
    }

    @AfterMethod
    public void tearDownMethod () {
            // driver.close();
        }
    @Test
    public void testDocuportRadioButton() {
        //2. What type of business do you want to start? - choose corporation
        WebElement corporationRadioButton = driver.findElement(By.xpath("//label[.='Corporation']/../div/i/following-sibling::input/.."));
        corporationRadioButton.click();
        //3. Validate that corporation has been selected
        WebElement radioButtonSelected = driver.findElement(By.xpath("//label[.='Corporation']/../div/i/following-sibling::input"));
        Assert.assertTrue(radioButtonSelected.isSelected(), "Radio button is NOT selected");
        //4. Formation State - choose Virginia
//
//        // 4. Formation State - choose Virginia
//        WebElement radioButtonVirginia = driver.findElement(By.xpath("//label[contains(text(),'Virginia')]"));
//        radioButtonVirginia.click();
//        // 5. Validate Virginia is selected
//        WebElement radioButtonVSelected = driver.findElement(By.xpath("//label[.='Virginia']/../div/i/following-sibling::input"));
//        Assert.assertTrue(radioButtonSelected.isSelected(), "Radio button Virginia is NOT selected");
    }

        @Test
         public void testVirginiaRegistrationFee(){

    // 4. Formation State - choose Virginia
    WebElement radioButtonVirginia = driver.findElement(By.xpath("//label[contains(text(),'Virginia')]"));
        radioButtonVirginia.click();
    // 5. Validate Virginia is selected
    WebElement radioButtonVSelected = driver.findElement(By.xpath("//label[.='Virginia']/../div/i/following-sibling::input"));
        Assert.assertTrue(radioButtonVSelected.isSelected(), "Radio button Virginia is NOT selected");

        WebElement stateRegistrationFee = driver.findElement(By.xpath("//p[contains(text(),' State registration fee ')]/following-sibling::p"));
     Assert.assertEquals(stateRegistrationFee.getText(),"$100");


        WebElement paymentProcessing = driver.findElement(By.xpath("//p[contains(text(),' Payment processing ')]/following-sibling::p"));
        Assert.assertEquals(paymentProcessing.getText(),"$6");

//
            WebElement serviceFee = driver.findElement(By.xpath("//p[contains(text(),' Service fee ')]/following-sibling::p"));
            Assert.assertEquals(serviceFee.getText(), "$150");
            WebElement total = driver.findElement(By.xpath("//div[@class='company-formation__summary-list--item']/div/div/following-sibling::div/p"));
            Assert.assertEquals(total.getText(), "$256");
        }


@Test
        public void testFormationStateMariland(){

    // 4. Formation State - choose Virginia
    WebElement radioButtonVirginia = driver.findElement(By.xpath("//label[contains(text(),'Maryland')]"));
        radioButtonVirginia.click();
    // 5. Validate Virginia is selected
    WebElement radioButtonVSelected = driver.findElement(By.xpath("//label[.='Maryland']/../div/i/following-sibling::input"));
        Assert.assertTrue(radioButtonVSelected.isSelected(), "Radio button Maryland is NOT selected");

        WebElement stateRegistrationFee = driver.findElement(By.xpath("//p[contains(text(),' State registration fee ')]/following-sibling::p"));
     Assert.assertEquals(stateRegistrationFee.getText(),"$170");


        WebElement paymentProcessing = driver.findElement(By.xpath("//p[contains(text(),' Payment processing ')]/following-sibling::p"));
        Assert.assertEquals(paymentProcessing.getText(),"$10.20");

//
            WebElement serviceFee = driver.findElement(By.xpath("//p[contains(text(),' Service fee ')]/following-sibling::p"));
            Assert.assertEquals(serviceFee.getText(), "$150");
            WebElement total = driver.findElement(By.xpath("//div[@class='company-formation__summary-list--item']/div/div/following-sibling::div/p"));
            Assert.assertEquals(total.getText(), "$330.20");
        }

    }









