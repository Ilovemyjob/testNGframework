package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.security.Key;

public class ActionClass3 extends TestBase {
//    Create a class: ActionClass3
//    Create test method : keysUpDown()
//    Go to google
//    Send iPhone X prices => convert small letter capital vice versa.
//    Highlight the search box by double clicking


    @Test
    public void contextClickMethod() throws InterruptedException {
        driver.get("https://www.google.de/");

        WebElement searchBox = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);


        actions.
                keyDown(searchBox, Keys.SHIFT).
                sendKeys("iPhone X prices").
                keyUp(searchBox,Keys.SHIFT).
                sendKeys(" in Germany").
                perform();
        Thread.sleep(8000);









    }
}
