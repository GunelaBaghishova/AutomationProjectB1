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
public class T3_webTables extends TestBase {
    @Test
    public void test_web_tables_client(){
        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        WebElement users = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        users.click();
        String actual = DocuportWebTablesUtils.returnAnyField(driver,DocuportConstants.CLIENTEMAIL, DocuportConstants.FULL_NAME);
        String expected = DocuportConstants.CLIENTFULLNAME;
        System.out.println("actual = " + actual);
        assertEquals(actual,expected);

        String actualUseName = DocuportWebTablesUtils.returnAnyField(driver, DocuportConstants.CLIENTEMAIL,DocuportConstants.USERNAME);
        String expectedUserName = DocuportConstants.CLIENTUSERNAME;
        System.out.println("actualUseName = " + actualUseName);
        Assert.assertEquals(actualUseName,expectedUserName);

        String actualPhoneNumber= DocuportWebTablesUtils.returnAnyField(driver,DocuportConstants.CLIENTEMAIL,DocuportConstants.PHONE_NUMBER);
        String expectedPhoneNumber =DocuportConstants.CLIENTPHONENUMBER;
        System.out.println("actualPhoneNumber = " + actualPhoneNumber);
        assertEquals(actualPhoneNumber, expectedPhoneNumber);

        String actualRole= DocuportWebTablesUtils.returnAnyField(driver,DocuportConstants.CLIENTEMAIL,DocuportConstants.ROLE);
        String expectedRole =DocuportConstants.CLIENTROLE;
        System.out.println("expectedRole = " + expectedRole);
        assertEquals(actualRole,expectedRole);

        String actualAdvisor= DocuportWebTablesUtils.returnAnyField(driver,DocuportConstants.CLIENTEMAIL,DocuportConstants.ADVISOR);
        String expectedAdvisor = DocuportConstants.ADVISORFORCLIENT;
        System.out.println("actualAdvisor = " + actualAdvisor);
        assertEquals(actualAdvisor,expectedAdvisor);
    }

}
