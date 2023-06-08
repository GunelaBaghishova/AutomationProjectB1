package com.loop.test.day5_testNG_dropdown;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class T000_testNGWithSelenium {

    WebDriver driver;
    String actual;
    String expected;

@BeforeMethod
public void setUpMethod(){
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
@AfterMethod
public void tearDownMethod(){
    driver.close();
}
@Test
    public void googleTitle(){
      //  driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com/");
    System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
      expected = "Google";
       actual= driver.getTitle();
        Assert.assertEquals(expected,actual, "Ecpected Title "+expected+ "does not match "+actual);
}
@Test
    public void docuportTitle(){
//       driver= WebDriverFactory.getDriver("chrome");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://beta.docuport.app/");
    System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
       expected = "Docuport";
       actual= driver.getTitle();
      Assert.assertTrue(actual.contains(expected));


    }
}
