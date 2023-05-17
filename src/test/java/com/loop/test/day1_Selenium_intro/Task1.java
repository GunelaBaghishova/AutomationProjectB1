package com.loop.test.day1_Selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
 */
public class Task1 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        WebElement title = driver.findElement(By.linkText("Gmail"));
        title.click();

        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if ( actualTitle.contains(expectedTitle)){

            System.out.println("Actual title" + actualTitle+ " verified --> PASS");
        }else {
            System.err.println("Actual title" + actualTitle+ " is NOT verified --> FAIL");
        }

        driver.navigate().back();
        String expectedTitle1 = "Google";
        String actualTitle1 = driver.getTitle();

        if ( actualTitle1.equals(expectedTitle1)){
            System.out.println("Actual title" + actualTitle1+ " verified--> PASS");
        }else{
            System.out.println("Actual title is NOT verified --> FAIL");
        }
        driver.quit();







    }


}
