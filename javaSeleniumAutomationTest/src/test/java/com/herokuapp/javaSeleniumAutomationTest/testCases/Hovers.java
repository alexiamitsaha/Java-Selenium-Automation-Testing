package com.herokuapp.javaSeleniumAutomationTest.testCases;

import com.herokuapp.javaSeleniumAutomationTest.basicJava.BaseClass;
import com.herokuapp.javaSeleniumAutomationTest.basicJava.Internet;
import com.herokuapp.javaSeleniumAutomationTest.pages.HoversPage;
import com.herokuapp.javaSeleniumAutomationTest.utilities.Data;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hovers extends BaseClass {
    @Test
    public void hovers() throws InterruptedException {
        Internet ti = new Internet(driver);
        HoversPage hp = new HoversPage(driver);
        ti.getHover().click();

        // Test Case 01 - HOME URL Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given "+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.MOUSE_HOVER_LINK);
        System.out.println("Link is valid");
        Thread.sleep(1000);

        // Test Case 02 Mouse Hover Validation : User01
        Actions actionOne = new Actions(driver);
        actionOne.moveToElement(hp.getImageOne()).perform();
        Thread.sleep(2000);

        String userNameOne = hp.getNameUserOne().getText();
        System.out.println( userNameOne );
        Thread.sleep(2000);

        String profileViewOne = hp.getViewProfileOne().getText();
        System.out.println( profileViewOne );
        System.out.println("User 1 is validate");

        // Test Case 03 Mouse Hover Validation : User02
        Actions actionTwo = new Actions(driver);
        actionTwo.moveToElement(hp.getImageTwo()).perform();
        Thread.sleep(2000);

        String userNameTwo = hp.getNameUserTwo().getText();
        System.out.println( userNameTwo );
        Thread.sleep(2000);

        String profileViewTwo = hp.getViewProfileTwo().getText();
        System.out.println( profileViewTwo );
        Thread.sleep(2000);
        System.out.println("User2 is validate ");

        // Test Case 04 Mouse Hover Validation : User03
        Actions actionThree = new Actions(driver);
        actionThree.moveToElement(hp.getImageThree()).perform();
        Thread.sleep(2000);

        String userNameThree = hp.getNameUserThree().getText();
        System.out.println( userNameThree );
        Thread.sleep(2000);

        String profileViewThree = hp.getViewProfileThree().getText();
        System.out.println( profileViewThree );
        Thread.sleep(2000);
        System.out.println(" User3 is validate");

        // Back to home URL
        driver.navigate().back();
        Thread.sleep(2000);

    }
}
