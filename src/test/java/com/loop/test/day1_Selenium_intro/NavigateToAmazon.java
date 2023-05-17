package com.loop.test.day1_Selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToAmazon {

    public static void main(String[] args) throws InterruptedException {

        // setting up the web driver
        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();



        driver.manage().window().maximize();
//


        driver.navigate().to("https://www.amazon.com/");

        driver.manage().window().maximize();

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();
        driver.quit();



    }
}






