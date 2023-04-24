package com.herokuapp.javaSeleniumAutomationTest.testCases;

import com.herokuapp.javaSeleniumAutomationTest.pages.AbTesting;
import com.herokuapp.javaSeleniumAutomationTest.pages.Internet;
import com.herokuapp.javaSeleniumAutomationTest.utilities.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ABTesting extends BaseClass {
    @Test
    public  void  aBTesting() {
        Internet ti = new Internet(driver);
        AbTesting at  = new AbTesting(driver);

        //TestCase-1 HOME URL Validation
        String baseLink = driver.getCurrentUrl();
        System.out.println("Given "+baseLink);
        Assert.assertEquals(baseLink, Data.BASE_URL);
        System.out.println("Home URL is validate");
        sleepTest(500);

        //TestCase-2 Header Validation
        if (ti.getAbTesting().isDisplayed())
        {
            String abTesting= ti.getAbTesting().getText();
            Assert.assertEquals(Data.AB_TESTING,abTesting);
        }

        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        ti.abTesting.click();
        sleepTest(500);

        //TestCase-3 Corresponding Page URL Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given "+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.AB_Test_LINK);
        System.out.println("Link is validate");
        sleepTest(500);

        //TestCase-4 Paragraph Validation
        if (at.getabTestingVariation1().isDisplayed())
        {
            String header1= at.getabTestingVariation1().getText();
            Assert.assertEquals(Data.AB_TEST_VARIATION1,header1);
        } else if (at.getAbTestControl().isDisplayed()){
            String header2= at.abTestControl.getText();
            Assert.assertEquals(Data.AB_TEST_Control,header2);
        } else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

        sleepTest(500);
        driver.navigate().back();
        sleepTest(500);

        driver.close();
        driver.quit();

    }
}
