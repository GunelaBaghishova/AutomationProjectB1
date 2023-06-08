package com.loop.test.day7_windows_webtables;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.DocuportWebTablesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WebTableTestForSupervisor extends TestBase {
     @Test
    public void test_web_tables_supervisor(){
        DocuportUtils.login(driver, DocuportConstants.SUPERVISOR);
        WebElement users = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        users.click();
        String actual = DocuportWebTablesUtils.returnAnyField(driver,DocuportConstants.SUPERVISOREMAIL, DocuportConstants.FULL_NAME);
        String expected = DocuportConstants.SUPERVISORFULLNAME;
        System.out.println("actual = " + actual);
        assertEquals(actual,expected);

        String actualUseName = DocuportWebTablesUtils.returnAnyField(driver, DocuportConstants.SUPERVISOREMAIL,DocuportConstants.USERNAME);
        String expectedUserName = DocuportConstants.SUPRTVISORUSERNAME;
        System.out.println("actualUseName = " + actualUseName);
        Assert.assertEquals(actualUseName,expectedUserName);

        String actualPhoneNumber= DocuportWebTablesUtils.returnAnyField(driver,DocuportConstants.SUPERVISOREMAIL,DocuportConstants.PHONE_NUMBER);
        String expectedPhoneNumber =DocuportConstants.SUPERVISORPHONENUMBER;
        System.out.println("actualPhoneNumber = " + actualPhoneNumber);
        assertEquals(actualPhoneNumber, expectedPhoneNumber);

        String actualRole= DocuportWebTablesUtils.returnAnyField(driver,DocuportConstants.SUPERVISOREMAIL,DocuportConstants.ROLE);
        String expectedRole =DocuportConstants.SUPERVISORROLE;
        System.out.println("expectedRole = " + expectedRole);
        assertEquals(actualRole,expectedRole);

        String actualAdvisor= DocuportWebTablesUtils.returnAnyField(driver,DocuportConstants.SUPERVISOREMAIL,DocuportConstants.ADVISOR);
        String expectedAdvisor =DocuportConstants.ADVISORFORSUPERVISOR;
        System.out.println("actualAdvisor = " + actualAdvisor);
        assertEquals(actualRole,expectedRole);
    }

}


