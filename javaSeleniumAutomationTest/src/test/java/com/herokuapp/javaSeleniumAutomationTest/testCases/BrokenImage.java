package com.herokuapp.javaSeleniumAutomationTest.testCases;

import com.herokuapp.javaSeleniumAutomationTest.pages.Broken_Images;
import com.herokuapp.javaSeleniumAutomationTest.pages.Internet;
import com.herokuapp.javaSeleniumAutomationTest.utilities.Data;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

public class BrokenImage extends BaseClass{
    private Object RestAssured;

    @Test
    public void brokenImage(){

        Internet ti = new Internet(driver);
        Broken_Images bi = new Broken_Images (driver);

        ti.getBrokenImage().click();
        sleepTest(500);


        //TestCase-1 URL Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given "+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.BROKEN_IMAGE_LINK);
        System.out.println("Link is valid");
        sleepTest(500);


        //TestCase-2 : Header Validation
        if(bi. getHeader1().isDisplayed()){
            String header =bi.getHeader1().getText() ;
            Assert.assertEquals(header, Data.BROKEN_IMAGE_HEADER);
            System.out.println("Header Text is valid");

        }
        else{
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        sleepTest(3000);


        // TestCase-3 : Broken Image Validation Including (Http response , Broken Image Link)
        List<WebElement> elementList = driver.findElements(By.tagName("img"));
        for (int i = 0; i < elementList.size(); i++){

//            Response response = RestAssured.given().contentType("application/json").get(elementList.get(i).getAttribute("src"));
            Response response = io.restassured.RestAssured.given().contentType("application/json").get(elementList.get(i).getAttribute("src"));
            System.out.println("HTTP Response Is: " + response.getStatusCode());

            if ( elementList.get(i).getAttribute("naturalWidth").equals("0")){
                System.out.println( elementList.get(i).getAttribute("src") + " Is Broken." );
            }

            else{
                System.out.println( elementList.get(i).getAttribute("src") + " Is Not Broken." );
            }
        }

        driver.navigate().to(Data.BASE_URL);
        sleepTest(500);
        driver.close();
        driver.quit();


    }
}
