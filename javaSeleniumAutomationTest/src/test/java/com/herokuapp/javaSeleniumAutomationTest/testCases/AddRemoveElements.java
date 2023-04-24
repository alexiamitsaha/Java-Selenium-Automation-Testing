package com.herokuapp.javaSeleniumAutomationTest.testCases;

import com.herokuapp.javaSeleniumAutomationTest.pages.Add_Remove_Elements;
import com.herokuapp.javaSeleniumAutomationTest.pages.Internet;
import com.herokuapp.javaSeleniumAutomationTest.utilities.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveElements extends BaseClass {
    @Test
    public  void  addRemoveElements ()  {

        Internet ti = new Internet(driver);
        Add_Remove_Elements are =new Add_Remove_Elements(driver);

        //TestCase-1 HOME URL Validation
        String baseLink = driver.getCurrentUrl();
        System.out.println("Given "+baseLink);
        Assert.assertEquals(baseLink, Data.BASE_URL);
        System.out.println("Home URL is valid");
        sleepTest(500);

        //TestCase-2 Header Validation
        sleepTest(500);
        if (ti.getAddRemoveElements().isDisplayed())
        {
            String addRemoveElementsText =ti.getAddRemoveElements().getText();
            Assert.assertTrue(true, addRemoveElementsText);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        ti.getAddRemoveElements().click();


        //TestCase-3 Corresponding Page URL Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given "+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.ADD_REMOVE_ELEMENTS_LINK);
        System.out.println("Link is validate");
        sleepTest(500);

        //TestCase-4 Header Validation
        sleepTest(500);
        if (are.getaddRemoveElementsHeader().isDisplayed())
        {
            String addRmvHeader= are.getaddRemoveElementsHeader().getText();
            Assert.assertTrue(true,addRmvHeader);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(500);
        are.getaddElement().click();
        sleepTest(500);
        are.getaddElement().click();
        sleepTest(500);
        are.getdelete1().click();
        sleepTest(500);
        are.getdelete2().click();
        sleepTest(500);
        driver.navigate().back();
        sleepTest(500);



    }
}
