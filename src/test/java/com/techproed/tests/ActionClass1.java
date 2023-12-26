package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionClass1 extends TestBase {
//    Create a class: ActionsClass1
//    Create a test method : contextClickMethod() and test the following scenario:
//    Given user is on the https://the-internet.herokuapp.com/context_menu
//    When use Right clicks on the box
//    Then verify the alert message is “You selected a context menu”
//    Then accept the alert

    @Test
    public void contextClickMethod() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");
//after that we control driver
        Actions actions =new Actions(driver);
        WebElement box=driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();
        Thread.sleep(1000);

       String actualMessage =driver.switchTo().alert().getText();
       String expectedMesssage = "You selected a context menu";

        Assert.assertEquals(actualMessage,expectedMesssage);
        driver.switchTo().alert().accept();




    }






}
