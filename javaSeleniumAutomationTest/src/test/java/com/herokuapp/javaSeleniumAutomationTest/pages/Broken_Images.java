package com.herokuapp.javaSeleniumAutomationTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Broken_Images extends BasePage {
    public Broken_Images(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@id='content']//h3[.='Broken Images']")
    public WebElement header1;
    public WebElement getHeader1() {

        return header1;
    }
}
