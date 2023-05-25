package com.herokuapp.javaSeleniumAutomationTest.testCases;

import com.herokuapp.javaSeleniumAutomationTest.basicJava.BaseClass;
import com.herokuapp.javaSeleniumAutomationTest.basicJava.Internet;
import com.herokuapp.javaSeleniumAutomationTest.pages.Horizontal_Slider;
import com.herokuapp.javaSeleniumAutomationTest.utilities.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class HorizontalSlider extends BaseClass {
    @Test
    public void horizontalSlider() throws InterruptedException {
        Internet ti =new Internet(driver);
        Horizontal_Slider hs = new Horizontal_Slider(driver);
        ti.getHorizontalSlider().click();
        Thread.sleep(1000);

        //TestCase -01 Corresponding Page URL Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given "+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.HORIZONTAL_SLIDER_LINK);
        System.out.println("Link is valid");
        Thread.sleep(1000);

        //TestCase -02 Header Validation
        if(hs.getHeader1().isDisplayed()){
            String header = hs.getHeader1().getText();
            Assert.assertTrue(true,Data.HORIZONTAL_SLIDER_LINK);
            System.out.println("Head text is vaild");
        }else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

        //TestCase -03 Horizontal Slider Validation
        WebElement slider = driver.findElement(By.xpath("/html//div[@id='content']//input[@value='0']"));
        Actions move = new Actions(driver);
        Action action = move.dragAndDropBy(slider,20,0).build();
        action.perform();
        Thread.sleep(2000);

        //TestCase -04 Slider Value Validation
        String value = driver.findElement(By.xpath("/html//span[@id='range']")).getText();
        System.out.println("Dragged value" + value);
        String val = "3.5";
        Assert.assertEquals(value,val);
    }
}
