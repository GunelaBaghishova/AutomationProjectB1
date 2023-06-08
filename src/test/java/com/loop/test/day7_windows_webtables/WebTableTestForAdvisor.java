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

public class WebTableTestForAdvisor extends TestBase {

    @Test
    public void test_web_tables_advisor1() {
        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        WebElement users = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        users.click();
        String actual = DocuportWebTablesUtils.returnAnyField(driver, DocuportConstants.ADVISOREMAIL, DocuportConstants.FULL_NAME);
        String expected = DocuportConstants.ADVISORFULLNAME;
        System.out.println("actual = " + actual);
        assertEquals(actual, expected);

        String actualUseName = DocuportWebTablesUtils.returnAnyField(driver, DocuportConstants.ADVISOREMAIL, DocuportConstants.USERNAME);
        String expectedUserName = DocuportConstants.ADVISORURERNAME;
        System.out.println("actualUseName = " + actualUseName);
        Assert.assertEquals(actualUseName, expectedUserName);

        String actualPhoneNumber = DocuportWebTablesUtils.returnAnyField(driver, DocuportConstants.ADVISOREMAIL, DocuportConstants.PHONE_NUMBER);
        String expectedPhoneNumber = DocuportConstants.ADVISORPHONENUMBER;
        System.out.println("actualPhoneNumber = " + actualPhoneNumber);
        assertEquals(actualPhoneNumber, expectedPhoneNumber);

        String actualRole = DocuportWebTablesUtils.returnAnyField(driver, DocuportConstants.ADVISOREMAIL, DocuportConstants.ROLE);
        String expectedRole = DocuportConstants.ADVISORROLE;
        System.out.println("expectedRole = " + expectedRole);
        assertEquals(actualRole, expectedRole);

    }


}
