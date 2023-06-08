package com.loop.test.day4_xpath_findElement.day4_home_tasks;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/*
1. go to docuport app
2. validate that Home, Received docs, My uploads, Invitations are displayed
3. press three lines
4. Home, Received docs, My uploads, Invitations will disappear
5. Validate the buttons are not displayed
 */
public class TaskTest1 {
    @Test
    public void Test_Task_One() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //1. go to docuport app

        driver.get(DocuportConstants.DOCUPORT_URL);
        WebElement findByUserName = driver.findElement(By.xpath("//input[@id='input-14']"));
        findByUserName.sendKeys(DocuportConstants.USERNAME_CLIENT);

        WebElement findByPassword = driver.findElement(By.xpath("//input[@id='input-15']"));

        findByPassword.sendKeys(DocuportConstants.PASSWORD_CLIENT);

        WebElement findLogin = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
        findLogin.click();

        //(wait  up to 30 sec until the buttons are displayed)
        WebDriverFactory.visible(driver,30,"//*[@class='body-1']");
        List<WebElement> leftItems = driver.findElements(By.xpath("//*[@class='body-1']"));
        String[] arr = new String[4];
        int index =0;
        for (WebElement each:leftItems) {
            System.out.println(((each.isDisplayed()) ? "TEST PASSED ==> \"" + each.getText() + "\" is displayed" : "TEST FAILED ==> \"" + each.getText() + "\" is NOT displayed"));
            arr[index] = each.getText();
            index++;

        }

        WebElement threeLines  = driver.findElement(By.xpath("//i[@class='v-icon notranslate mdi mdi-menu theme--light']"));
        threeLines.click();
        //(wait  up to 30 sec until the buttons are disappeared)
        Thread.sleep(3000);

        System.out.println("--------after clicking three lines-------");
        index = 0;
        for (WebElement each :leftItems) {
            System.out.println(((each.isDisplayed())?"TEST FAILED ==> \""+ arr[index]+ "\" is displayed":"TEST PASSED ==> \""+ arr[index]+ "\" is NOT displayed"));
            index++;
        }


    }
}
