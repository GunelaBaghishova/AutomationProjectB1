package com.loop.test.day9_driver_faker_action.practice;

import com.github.javafaker.Faker;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class T6_registration_form {
    /*
    1. go to url:https://loopcamp.vercel.app
    2. fill the form
    3. use faker
     */
    @Test
    public void registration_form_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("loop.practice"));
        Driver.getDriver().findElement(By.xpath("//a[.='Registration Form']")).click();// clicking on  registration form
        Faker faker= new Faker();
        Driver.getDriver().findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());//first name
        Driver.getDriver().findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());//last name
        Driver.getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(faker.bothify("???###"));// username
        Driver.getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(faker.internet().emailAddress());// email
        Driver.getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(faker.internet().password());// password
        Driver.getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys(faker.numerify("571-###-####"));// phone
        Driver.getDriver().findElement(By.xpath("//input[@value='other']")).click();// gender

        SimpleDateFormat dob= new SimpleDateFormat("MM/dd/yyyy");
        Driver.getDriver().findElement(By.xpath("//input[@name='birthday']")).sendKeys(dob.format(faker.date().birthday()));//date of birth

        Select department = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));//department dropdown
        department.selectByValue("DE");

        Select jobTitle = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByVisibleText("SDET");
        Driver.getDriver().findElement(By.xpath("//input[@value='java']")).click();
        Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']")).click();
       String actual= Driver.getDriver().findElement(By.xpath("//div[text()='Thanks for signing up!']")).getText();
        String expected = "Thanks for signing up!";
        Assert.assertEquals(actual,expected);





    }
}
