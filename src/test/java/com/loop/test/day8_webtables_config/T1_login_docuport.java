package com.loop.test.day8_webtables_config;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class T1_login_docuport extends TestBase {

    @Test
    public void test_login_logout() throws InterruptedException {
        DocuportUtils.login(driver, DocuportConstants.CLIENT);
        DocuportUtils.logout(driver);

    //    Thread.sleep(3000);

        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        DocuportUtils.logout(driver);

        DocuportUtils.login(driver, DocuportConstants.SUPERVISOR);
        DocuportUtils.logout(driver);

        DocuportUtils.login(driver, DocuportConstants.EMPLOYEE);
        DocuportUtils.logout(driver);

    }
}
