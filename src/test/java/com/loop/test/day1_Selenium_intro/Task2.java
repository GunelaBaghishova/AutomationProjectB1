package com.loop.test.day1_Selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com");

        WebElement searchBox = driver.findElement(By.name("search_query"));
        String textToSearch = "wooden spoon";
        searchBox.sendKeys(textToSearch+ Keys.ENTER);

        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){

            System.out.println("Actual title "+ actualTitle+ " verified --> PASS");
        }else {
            System.out.println("Actual title "+ actualTitle+ " is NOT verified --> FAIL");

        }
        driver.quit();
    }
}
