package com.loop.test.day9_driver_faker_action.practice;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Task4_ScrollDown_ScrollUp {
    /*
    1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/
3. Scroll down to “Powered by LOOPCAMP”
4. Scroll using Actions class “moveTo(element)” method
     */
    @Test

    public void scrollDown(){
    Driver.getDriver().get(ConfigurationReader.getProperty("loop.practice"));

        WebElement poweredBy = Driver.getDriver().findElement(By.xpath("//div[@class='large-4 large-centered columns mb-5']"));
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(poweredBy).perform();

        // task 5

        WebElement loopAcademyPic = Driver.getDriver().findElement(By.xpath("//a[@href='index.html']"));
        loopAcademyPic.sendKeys(Keys.PAGE_UP);
    }

}
