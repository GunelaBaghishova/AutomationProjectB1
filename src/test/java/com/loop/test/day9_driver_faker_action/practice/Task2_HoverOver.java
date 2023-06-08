package com.loop.test.day9_driver_faker_action.practice;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2_HoverOver {


/*
1. Go to https://loopcamp.vercel.app/hovers.html
2. Hover over to first image
3. Assert:
	a. “name: user1” is displayed
	b. “view profile” is displayed
4. Hover over to second image
5. Assert:
	a. “name: user2” is displayed
	b. “view profile” is displayed
6. Hover over to third image
7. Confirm:
	a. “name: user3” is displayed
	b. “view profile” is displayed
 */
    @Test
    public void hover_over(){

        Driver.getDriver().get(ConfigurationReader.getProperty("loop.hover"));
        Actions action = new Actions(Driver.getDriver());

        action.moveToElement(Driver.getDriver().findElement(By.xpath("//div[@class='figure'][1]"))).perform();
        String actual=Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']")).getText();
        String expected = "name: user1";
        Assert.assertEquals(actual,expected);
        String actual1=Driver.getDriver().findElement(By.xpath("(//a[.='View profile'])[1]")).getText();
        String expected1 = "View profile";
        Assert.assertEquals(actual,expected);
        System.out.println("=====================================================");
        action.moveToElement(Driver.getDriver().findElement(By.xpath("//div[@class='figure'][2]"))).perform();
        String actualImg2=Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']")).getText();
        String expectedImg2 = "name: user2";
        Assert.assertEquals(actual,expected);
        String actual2=Driver.getDriver().findElement(By.xpath("(//a[.='View profile'])[2]")).getText();
        String expected2 = "View profile";
        Assert.assertEquals(actual,expected);
        System.out.println("=========================================");
        action.moveToElement(Driver.getDriver().findElement(By.xpath("//div[@class='figure'][3]"))).perform();
        String actualImg3=Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']")).getText();
        String expectedImg3 = "name: user3";
        Assert.assertEquals(actual,expected);
        String actual3=Driver.getDriver().findElement(By.xpath("(//a[.='View profile'])[3]")).getText();
        String expected3 = "View profile";
        Assert.assertEquals(actual,expected);

    }
}
