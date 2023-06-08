package com.loop.test.day8_webtables_config;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.PizzaOrderWebTableUtils;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T0_pizza_order extends TestBase {
      /*
    1. go to https://loopcamp.vercel.app/web-tables.html
    2. create a method to test given field for a given name
     */

    @BeforeMethod
    public void setUpMethod(){
        driver.get("https://loopcamp.vercel.app/web-tables.html");
    }
    @Test
    public void test_pizza_type(){
   String actual = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Alexandra Gray","pizza type");
    String expected= "Thin Crust";
        System.out.println("actual = " + actual);
    assertEquals(actual,expected);

    }
    @Test
    public void test_Amount(){
        String actual = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "John Doe","Amount");
        String expected= "3";
        System.out.println("actual = " + actual);
        assertEquals(actual,expected);
    }@Test
    public void test_date(){
        String actual = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Stewart Dawidson","");
        String expected= "1";
        System.out.println("actual = " + actual);
        assertEquals(actual,expected);
    }
    @Test
    public void test_street(){
        String actual = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Bart Fisher","Street");
        String expected= "35, Rock st.";
        System.out.println("actual = " + actual);
        assertEquals(actual,expected);

    }

    @Test
    public void test_city(){
        String actual = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Ned Stark","City");
        String expected= "Newcastle";
        System.out.println("actual = " + actual);
        assertEquals(actual,expected);
    }
    @Test
    public void test_state(){
        String actual = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Bob Martin","State");
        String expected= "US";
        System.out.println("actual = " + actual);
        assertEquals(actual,expected);

    }

    @Test
    public void test_zip(){
        String actual = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Samuel Jackson","Zip");
        String expected= "53665";
        System.out.println("actual = " + actual);
        assertEquals(actual,expected);

    }

    @Test
    public void test_card(){
        String actual = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "Robert Baratheon","Card");
        String expected= "MasterCard";
        System.out.println("actual = " + actual);
        assertEquals(actual,expected);

    }

    @Test
    public void test_card_number(){
        String actual = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "John Doe","Amount");
        String expected= "3";
        System.out.println("actual = " + actual);
        assertEquals(actual,expected);
    }

    @Test
    public void test_exp(){
        String actual = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, "John Doe","Amount");
        String expected= "3";
        System.out.println("actual = " + actual);
        assertEquals(actual,expected);
    }


    }





