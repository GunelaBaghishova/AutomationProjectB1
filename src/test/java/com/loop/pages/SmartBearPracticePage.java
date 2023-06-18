package com.loop.pages;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SmartBearPracticePage {
    public SmartBearPracticePage(){
PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//input[@type='text']")
    public WebElement username;
    @FindBy (xpath = "//input[@type='password']")
    public WebElement password;
    @FindBy (xpath = "//input[@type='submit']")
    public WebElement loginButton;
    @FindBy(xpath = "//a[.='Order']")
    public WebElement order;
    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productDropdown;
    @FindBy(xpath = "//input[contains(@id,'Quantity')]")
    public WebElement quantity;
    @FindBy(xpath = "//input[@value='Calculate']")
    public WebElement calculate;
    @FindBy(xpath = "//input[contains(@id,'Name')]")
    public WebElement customerName;
    @FindBy(xpath = "//input[contains(@id,'Box2')]")
    public WebElement street;
    @FindBy(xpath = "//input[contains(@id,'Box3')]")
    public WebElement city;
    @FindBy(xpath = "//input[contains(@id,'Box4')]")
    public WebElement state;
    @FindBy(xpath = "//input[contains(@id,'Box5')]")
    public WebElement zipCode;
    @FindBy(xpath = "//input[@value='Visa']")
    public WebElement cardRadioButton;
    @FindBy(xpath = "//input[contains(@id,'Box6')]")
    public WebElement cardNr;
    @FindBy(xpath = "//input[contains(@id,'Box1')]")
    public WebElement expireddate;
    @FindBy(xpath = "//div[@class='buttons_process']/a")
    public WebElement processButton;
    @FindBy(xpath = "//strong")
    public WebElement successMessage;
}
