package com.loop.test.day5_testNG_dropdown.home_tasks;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task2 {
    /*
1. go to https://www.etsy.com/
2. search for rings
3. validate that Estimated Arrival shows any time
3. click Estimated Arrival dropdown
4. click Select custom date
5. choose may 30 from dropdown
6. validate Estimated Arrival shows may 30
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.etsy.com/");
        WebElement mapleLeaf = driver.findElement(By.xpath("(//span[@class='inline-svg locale-icon-svg wt-display-block wt-position-relative'])[1]"));
        mapleLeaf.click();
        Select regionDropdown = new Select(driver.findElement(By.xpath("//select[@id='locale-overlay-select-region_code']")));
        regionDropdown.selectByVisibleText("United States");
        Select currencyDropdown = new Select(driver.findElement(By.xpath("//select[@id='locale-overlay-select-currency_code']")));
        currencyDropdown.selectByVisibleText("$ United States Dollar (USD)");
        WebElement saveButton =driver.findElement(By.xpath("//button[@id='locale-overlay-save']"));
        saveButton.click();
    }
    @AfterMethod
    public void tearDownMethod(){
        //  driver.close();
    }
    @Test
    public void etsyDropdown(){
        //2. search for rings
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        searchInput.click();
        searchInput.sendKeys("rings"+Keys.ENTER);
        //3. validate that Estimated Arrival shows any time
        WebElement estimateArrivalDropdown= driver.findElement(By.xpath("//span[@class='wt-menu__trigger__label']/span[contains(text(),'Estimated Arrival')]"));
        Assert.assertEquals(estimateArrivalDropdown.getText(),"Estimated Arrival Any time");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //3. click Estimated Arrival dropdown
        estimateArrivalDropdown.click();
        //4. click Select custom date
        WebElement buttonCustomDate = driver.findElement(By.xpath("//div[@data-custom-edd-container-tf='true']/div/label"));
        buttonCustomDate.isSelected();
        WebElement selectdatedropdoem= driver.findElement(By.xpath("(//select[@aria-label='Select custom date'])[1]"));
        selectdatedropdoem.click();
        //5. choose may 30 from dropdown
        Select deliveryDateDropdown =new Select(driver.findElement(By.xpath("//select[@id='edd_select_tf']")));
        deliveryDateDropdown.selectByVisibleText("By 30 May");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //6. validate Estimated Arrival shows may 30
        Assert.assertEquals(estimateArrivalDropdown.getText(),"Estimated Arrival By 30 May");

    }
}


