package com.loop.test.day9_driver_faker_action;
/*
 /*
    1- Open a chrome browser
    2- Go to: https://demo.guru99.com/test/drag_drop.html
    3- Drag “BANK” and drop into Account area under Debit Side
    4- Drag “5000” and drop into Amount area under Debit Side
    5- Drag “SALES” and drop into Account area under Credit Side
    6- Drag “5000” and drop into Amount area under Credit Side
    7- Validate “Perfect!” text displayed.
     */

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T5_drag_drop {

    @Test
    public void drag_drop_test() throws InterruptedException {
        /*
    1- Open a chrome browser
    2- Go to: https://demo.guru99.com/test/drag_drop.html
    3- Drag “BANK” and drop into Account area under Debit Side
    4- Drag “5000” and drop into Amount area under Debit Side
    5- Drag “SALES” and drop into Account area under Credit Side
    6- Drag “5000” and drop into Amount area under Credit Side
    7- Validate “Perfect!” text displayed.
     */

        Driver.getDriver().get(ConfigurationReader.getProperty("guru.draq"));
        WebElement bank = Driver.getDriver().findElement(By.partialLinkText("BANK"));
        WebElement debitAccount = Driver.getDriver().findElement(By.id("bank"));
        Actions action= new Actions(Driver.getDriver());
        action.dragAndDrop(bank,debitAccount).perform();
        WebElement fiveK = Driver.getDriver().findElement(By.xpath("//a[.=' 5000 ']"));
        WebElement debitAmount = Driver.getDriver().findElement(By.id("amt7"));
        action.dragAndDrop(fiveK,debitAmount).perform();
        WebElement sales = Driver.getDriver().findElement(By.xpath("//li[@id='credit1']"));
        WebElement creditAccaunt = Driver.getDriver().findElement(By.id("loan"));
        action.dragAndDrop(sales,creditAccaunt).perform();
        WebElement fiveK2 = Driver.getDriver().findElement(By.xpath("//a[.=' 5000 ']"));
        WebElement creditAmount = Driver.getDriver().findElement(By.id("amt8"));
        action.dragAndDrop(fiveK2,creditAmount).perform();
        WebElement confirmText = Driver.getDriver().findElement(By.xpath("//a[text()='Perfect!']"));
        Assert.assertTrue(confirmText.isDisplayed());




    }
}
