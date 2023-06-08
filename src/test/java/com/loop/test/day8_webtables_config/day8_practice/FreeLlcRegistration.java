package com.loop.test.day8_webtables_config.day8_practice;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FreeLlcRegistration extends TestBase {
   @Test
    public void test_registration_payment() throws InterruptedException {

       driver.get("https://app.docuport.app/company-formation/resident");
       WebElement labelRadioButton= driver.findElement(By.xpath("//label[.='LLC']"));
       labelRadioButton.click();
       WebElement radioButton = driver.findElement(By.xpath("//label[.='LLC']/../div/i/following-sibling::input"));
       System.out.println("radioButton.isSelected() = " + radioButton.isSelected());

       WebElement labelMaryland= driver.findElement(By.xpath("//label[.='Maryland']"));
       labelMaryland.click();
       WebElement marylandRadioButton = driver.findElement(By.xpath("//label[.='Maryland']/../div/i/following-sibling::input"));
       System.out.println("radioButton.isSelected() = " + marylandRadioButton.isSelected());

       WebElement inputCompanyName= driver.findElement(By.xpath("//label[text()='Legal Company Name  *']/following-sibling::input"));
       inputCompanyName.sendKeys("Loop");

       WebElement inputBDA= driver.findElement(By.xpath("//label[text()='DBA (Doing Business As)']/following-sibling::input"));
       inputBDA.sendKeys("Director");

       WebElement industryDropdown = driver.findElement(By.xpath("//label[.='Industry *']/following-sibling::input[1]"));
       industryDropdown.click();

       WebElement industryAccounting = driver.findElement(By.xpath("//div[text()='Accounting']"));
       industryAccounting.click();

       WebElement inputFirstName = driver.findElement(By.xpath("(//label[contains(text(),'First name *')]/following-sibling::input)[1]"));
       inputFirstName.sendKeys("Tom");

      WebElement inputLastName = driver.findElement(By.xpath("(//label[contains(text(),'Last name *')]/following-sibling::input)[1]"));
      inputLastName.sendKeys("Cruz");

      WebElement inputEmail = driver.findElement(By.xpath("(//label[contains(text(),'Email address *')]/following-sibling::input)[1]"));
      inputEmail.sendKeys("tomcruz@gmail.com");

      WebElement inputPhoneNumber = driver.findElement(By.xpath("(//label[contains(text(),'Phone number *')]/following-sibling::input)[1]"));
     inputPhoneNumber.sendKeys("4445554455");

     WebElement inputFax = driver.findElement(By.xpath("(//label[contains(text(),'Fax')]/following-sibling::input)[1]"));
      inputFax.sendKeys("4445554477");

      WebElement nextButton1 = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
      nextButton1.click();


      WebElement agentTypeRadioButton = driver.findElement(By.xpath("//label[contains(text(),'Individual')]/../div/i/following-sibling::input"));
      System.out.println("agentTypeRadioButton = " + agentTypeRadioButton.isSelected());


      WebElement agentFirstName = driver.findElement(By.xpath("(//label[contains(text(),'First name *')]/following-sibling::input)[2]"));
      agentFirstName.sendKeys("Robert");

      WebElement agentLastName = driver.findElement(By.xpath("(//label[contains(text(),'Last name *')]/following-sibling::input)[2]"));
      agentLastName.sendKeys("Smith");

      WebElement agentMiddleName = driver.findElement(By.xpath("(//label[contains(text(),'Middle name')]/following-sibling::input)[1]"));
      agentMiddleName.sendKeys("Rose");

      WebElement addressLane1 = driver.findElement(By.xpath("//label[contains(text(),'Address line 1 *')]/following-sibling::input"));
      addressLane1.sendKeys("77 Capstone lane");


      WebElement addressLane2 = driver.findElement(By.xpath("//label[contains(text(),'Address line 2')]/following-sibling::input"));
      addressLane2.sendKeys("76 Capstone lane");

      WebElement city = driver.findElement(By.xpath("//label[contains(text(),'City *')]/following-sibling::input"));
      city.sendKeys("Maryland");

      WebElement jurisdictionDropdown = driver.findElement(By.xpath("//label[contains(text(),'Jurisdiction *')]/following-sibling::input[1]"));
      jurisdictionDropdown.click();

      WebElement jurisdictionBaltimoreCity = driver.findElement(By.xpath("//div[text()='Baltimore City']"));
     jurisdictionBaltimoreCity.click();

     WebElement zipCode = driver.findElement(By.xpath("//label[contains(text(),'Zip code')]/following-sibling::input"));
     zipCode.sendKeys("00000");

     WebElement agentEmail = driver.findElement(By.xpath("(//label[contains(text(),'Email')]/following-sibling::input)[2]"));
     agentEmail.sendKeys("robertsmith@gmail.com");

      WebElement agentPhoneNumber = driver.findElement(By.xpath("(//label[contains(text(),'Phone')]/following-sibling::input)[2]"));
      agentPhoneNumber.sendKeys("4549876677");


      WebElement chooseAddressRadioButton = driver.findElement(By.xpath("//label[contains(text(),'Use Registered')]/../div/i/following-sibling::input"));
      System.out.println("chooseAddressRadioButton = " + chooseAddressRadioButton.isSelected());

      WebElement agentSubmitButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
      agentSubmitButton.click();


       WebElement managerManagedRadioButton = driver.findElement(By.xpath("//label[contains(text(),'Manager managed')]/../div/i/following-sibling::input"));
       System.out.println("managerManagedRadioButton = " + managerManagedRadioButton.isSelected());


      WebElement organizerFirstName =driver.findElement(By.xpath("(//label[contains(text(),'First name *')]/following-sibling::input)[3]"));
      organizerFirstName.sendKeys("James");

       WebElement organizerLastName =driver.findElement(By.xpath("(//label[contains(text(),'Last name *')]/following-sibling::input)[3]"));
       organizerLastName.sendKeys("Bond");


       WebElement organizerMiddleName =driver.findElement(By.xpath("(//label[contains(text(),'Middle name')]/following-sibling::input)[2]"));
       organizerMiddleName.sendKeys("007");

       WebElement shareOwnerShip = driver.findElement(By.xpath("//label[.='Share Ownership (%) *']/following-sibling::input"));
       shareOwnerShip.sendKeys("100");

       WebElement snnNumber = driver.findElement(By.xpath("//label[.='SSN of an Organizing Member *']/following-sibling::input"));
       snnNumber.sendKeys("555775555");

       WebElement lastFirstName = driver.findElement(By.xpath("(//label[.='First name *']/following-sibling::input)[4]"));
       lastFirstName.sendKeys("James");

       WebElement lastLastName = driver.findElement(By.xpath("(//label[.='Last name *']/following-sibling::input)[4]"));
       lastLastName.sendKeys("Bond");

       WebElement goToPaymentButton = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
       goToPaymentButton.click();


       /*
       driver.findElement(By.xpath("(//span[.=' Next '])[2]")).click();
Thread.sleep(1500);
driver.findElement(By.xpath("//label[.='Member managed']")).click();
driver.findElement(By.xpath("(//label[.='First name *']/following-sibling::input)[3]")).sendKeys("Ivanovich");
driver.findElement(By.xpath("(//label[.='Last name *']/following-sibling::input)[3]")).sendKeys("Ivanka");
driver.findElement(By.xpath("(//label[.='Middle name']/following-sibling::input)[2]")).sendKeys("Junior");
driver.findElement(By.xpath("//label[.='Share Ownership (%) *']/following-sibling::input")).sendKeys("99");
driver.findElement(By.xpath("//label[.='SSN of an Organizing Member *']/following-sibling::input")).sendKeys("555667788");
driver.findElement(By.xpath("(//label[.='First name *']/following-sibling::input)[4]")).sendKeys("Ivan");
driver.findElement(By.xpath("(//label[.='Last name *']/following-sibling::input)[4]")).sendKeys("Ivanovich");
driver.findElement(By.xpath("//span[.=' Go to payment ']")).click();

Thread.sleep(1500);
driver.switchTo().frame(0);
driver.findElement(By.xpath("//input[@placeholder='Card number']")).sendKeys("5432654376548769");
driver.switchTo().defaultContent();
driver.switchTo().frame(1);
driver.findElement(By.xpath("//input[@placeholder='MM/YY']")).sendKeys("0225");
driver.switchTo().defaultContent();
driver.switchTo().frame(2);
driver.findElement(By.xpath("//input[@placeholder='CVC']")).sendKeys("122");
driver.switchTo().defaultContent();
driver.findElement(By.xpath("//span[contains(text(),'Pay')]")).click();
String expectedMessage = "Your card number is invalid.";
System.out.println(driver.findElement(By.xpath("//span[@class='body-1']")).getText());

assertEquals(driver.findElement(By.xpath("//span[@class='body-1']")).getText(), expectedMessage);
        */


















}
}
