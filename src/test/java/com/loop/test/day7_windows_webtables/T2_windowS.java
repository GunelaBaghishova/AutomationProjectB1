package com.loop.test.day7_windows_webtables;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class T2_windowS extends TestBase {
     /*
    1. Go to : https://www.amazon.com
    2. Copy paste the lines from below into your class
    3. Create a logic to switch to the tab where Etsy.com is open
    4. Assert: Title contains “Etsy”
    Lines to be pasted:
    ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
    ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
    ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
    These lines will simply open new tabs using something called JavascriptExecutor
    and get those pages. We will learn JavascriptExecutor later as well.

     */

    @Test
    public void test_window_handles() {

        driver.get("https://www.amazon.com");
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            System.out.println("each window handle: "+each);
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains("etsy")){
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("etsy"));

//        BrowserUtils.switchToWindow(driver,"Facebook");
    }
    }
