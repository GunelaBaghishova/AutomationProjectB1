package com.loop.test.day4_xpath_findElement.day4_home_tasks;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2_TestNG {

    /*

task 2
=============
1. go to docuport
2. sign as adviser
3. store left navigate items to (Home, Received docs, My uploads, Invitations etc) to the List
4. iterate and print out href values

optional step:
5. Validate that expected matching to actual

Home, Received docs, My uploads, Clients, Invitations, Users, Leads, Bookkeeping, 1099 form, Reconciliation

     */
    @Test
    public void docuportTest () throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //1. go to docuport app
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(DocuportConstants.DOCUPORT_URL);

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-14']"));
        userName.sendKeys(DocuportConstants.USERNAME_ADVISOR);

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys(DocuportConstants.PASSWORD_ADVISOR);

        WebElement loginButton = driver.findElement(By.xpath("//span[.=' Log in ']"));
        loginButton.click();


        //3. store left navigate items to (Home, Received docs, My uploads, Invitations etc) to the List
        List<WebElement> leftNavigateItems= driver.findElements(By.xpath("//a[contains(@class,'v-list-item')]"));
        List <String> expectedLeftNavigateItems = new ArrayList<>(Arrays.asList("Home", "Received docs", "My uploads", "Clients", "Invitations", "Users", "Leads", "Bookkeeping", "1099 form", "Reconciliation"));
        //4. iterate and print out href values
        for (WebElement leftNavigateItem : leftNavigateItems) {
            if(!leftNavigateItem.getText().equals(""))
                // System.out.println("Left navigate item "+leftNavigateItem.getText());
                System.out.println("href value of "+leftNavigateItem.getText() +" : "+ leftNavigateItem.getAttribute("href"));
        }

       // optional step:
       // 5. Validate that expected matching to actual

        String[] expected = {"Home", "Received docs", "My uploads", "Clients", "Invitations", "Users", "Leads", "Bookkeeping", "1099 Form", "Reconciliations"};

        List<WebElement> leftItems = driver.findElements(By.xpath("//a[contains(@class,'v-list-item')]"));

        String[] actual = new String[leftItems.size()];

        for (int i = 0 ; i< leftItems.size(); i++){
            actual[i] = leftItems.get(i).getText();

        }
        Assert.assertEquals(expected,actual);

        driver.quit();
    }
}
