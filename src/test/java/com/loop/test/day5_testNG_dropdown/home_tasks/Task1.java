package com.loop.test.day5_testNG_dropdown.home_tasks;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
public class Task1 {
    /*
1. go to http://the-internet.herokuapp.com/dropdown
2. validate "Please select an option" is selected by default
3. Choose option 1 and validate that it is selected
4. Choose option 2 and validate that it is selected
5. Validate dropdown name is "Dropdown List"
 */
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        //1. go to http://the-internet.herokuapp.com/dropdown
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://the-internet.herokuapp.com/dropdown");
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
    @Test
    public void dropdown () {
        //2. validate "Please select an option" is selected by default
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Please select an option", dropdown.getFirstSelectedOption().getText() + "does NOT match expected" + "Please select an option");
        //3. Choose option 1 and validate that it is selected
        dropdown.selectByVisibleText("Option 1");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1",dropdown.getFirstSelectedOption().getText() + " does NOT match expected Option 1");
        // 4. Choose option 2 and validate that it is selected
        dropdown.selectByIndex(2);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2",dropdown.getFirstSelectedOption().getText() + " does NOT match expected Option 2");
        //5. Validate dropdown name is "Dropdown List"
        String actualDropdownName = driver.findElement(By.xpath("//div/h3[text()='Dropdown List']")).getText();
        Assert.assertEquals(actualDropdownName,"Dropdown List",actualDropdownName+" Does NOT match Dropdown List" );
    }

}
