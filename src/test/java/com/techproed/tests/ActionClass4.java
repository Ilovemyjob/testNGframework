package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClass4 extends TestBase {

    /*
    Create a class: ActionClass4
Create test method : scrollUpDown()
Go to amazon
Scroll the page down
Scroll the page up
     */
    @Test
    public void contextClickMethod() throws InterruptedException {
        //        Go to amazon

        driver.get("https://www.amazon.com/");

        Actions actions = new Actions(driver);



        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //ARROW_DOWN moved the page down, but it moves less than PAGE_DOWN
        Thread.sleep(1000);
        //        Scroll the page down

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        //        Scroll the page up

        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();

       //ARROW_UP will also move the page up but a little bit up.

        //actions.sendKeys(Keys.BREAK).perform();
        //When do we move the page up or page down in testing?
        //Some pages are long. When we need to take a screenshot of an element that is at the buttom of the page,
        //we have to move the page down.









    }

}
