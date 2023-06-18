package com.loop.test.day11_utils_practice.practice;

import com.github.javafaker.Faker;
import com.loop.pages.SmartBearPracticePage;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

/*
task1
1. Open browser
2. Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click on Login button
6. Click on Order
7. Select familyAlbum from product, set quantity to 2
8. Click to “Calculate” button
9. Fill address Info with JavaFaker
• Generate: name, street, city, state, zip code
10.Click on “visa” radio button
11.Generate card number using JavaFaker
12.Click on “Process”
13.Verify success message “New order has been successfully added.”
 */
public class day12_task {
    SmartBearPracticePage smartBearPracticePage;
    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get(ConfigurationReader.getProperty("smartbear.url"));
        smartBearPracticePage = new SmartBearPracticePage();
    }
    @Test
    public void test2(){
        smartBearPracticePage.username.sendKeys("Tester");
        smartBearPracticePage.password.sendKeys("test");
        smartBearPracticePage.loginButton.click();
        smartBearPracticePage.order.click();
        Select select= new Select(smartBearPracticePage.productDropdown);
        select.selectByVisibleText("FamilyAlbum");
        smartBearPracticePage.quantity.sendKeys("2");
        smartBearPracticePage.calculate.click();
        Faker faker = new Faker();
        smartBearPracticePage.customerName.sendKeys(faker.name().firstName());
        smartBearPracticePage.street.sendKeys(faker.address().streetAddress());
        smartBearPracticePage.city.sendKeys(faker.address().cityName());
        smartBearPracticePage.state.sendKeys(faker.address().state());
        smartBearPracticePage.zipCode.sendKeys(faker.address().zipCode().replace("-",""));
        smartBearPracticePage.cardRadioButton.click();
        smartBearPracticePage.cardNr.sendKeys(faker.finance().creditCard().replace("-",""));
        SimpleDateFormat dateYear = new SimpleDateFormat("MM/yyyy");
        smartBearPracticePage.expireddate.sendKeys(dateYear.format(faker.date().birthday()));
        smartBearPracticePage.processButton.click();
        Assert.assertEquals(smartBearPracticePage.successMessage.getText(),"New order has been successfully added.", "Texts are not matching");
    }
}
