package com.loop.test.day8_webtables_config.day8_practice;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.PizzaOrderWebTableUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class pizza_order extends TestBase {

    @Test
    public void pizza()  {
        driver.get("https://loopcamp.vercel.app/web-tables.html");

        String expectedCardNumber = "321456789012";
        String expectedExpDate = "01/23";
        String expectedCard = "VISA";
        String expectedZip = "22043";
        String expectedState = "Italy";
        String expectedCity = "New York, NY";
        String expectedStreet = "13, Owl st.";
        String expectedPizzaType = "Hawaiian";
        String expectedAmount = "2";
        String expectedDate = "05/12/2021";

        Assert.assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Alexandra Gray", "Card Number"), expectedCardNumber);
        Assert.assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "John Doe", "Exp"), expectedExpDate);
        Assert.assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Stewart Dawidson", "Card"), expectedCard);
        Assert.assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Bart Fisher", "Zip"), expectedZip);
        Assert.assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Ned Stark", "State"), expectedState);
        Assert.assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Bob Martin", "City"), expectedCity);
        Assert.assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Samuel Jackson", "Street"), expectedStreet);
        Assert.assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Robert Baratheon", "Pizza Type"), expectedPizzaType);
        Assert.assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Bob Martin", "Amount"), expectedAmount);
        Assert.assertEquals(PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Ned Stark", "Date"), expectedDate);


    }
}
