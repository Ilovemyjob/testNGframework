package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleExample extends TestBase {
//    Create a new Class Tests package: WindowHandleExample
//    Given user is on the https://the-internet.herokuapp.com/windows
//    Then user verifies the text : “Opening a new window”
//    Then user verifies the title of the page is “The Internet”
//    When user clicks on the “Click Here” button

//    Then user verifies the new window title is “New Window”
//    Then user verifies the text:  “New Window”
//    When user goes back to the previous window and then verifies the title : “The Internet”

    @Test
    public void newWindowTest(){


//    Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        //    Then user verifies the text : “Opening a new window”

        String newWindowText = driver.findElement(By.xpath("//div[@class='example']//h3")).getText();
        String expectedNewWindowText = "Opening a new window";
        Assert.assertEquals(newWindowText,expectedNewWindowText);
        //    Then user verifies the title of the page is “The Internet”

        String expectedTitle="The Internet";
        String actualTitle = driver.getTitle();
        //Check if the expectedTitle equals the actual Title. If they are not equal then print Title is incorrect

        Assert.assertEquals(actualTitle,expectedTitle,"Title is incorrect");
        //WE ARE GETTING THE FIRST WINDOW HANDLE DO WHEN WE NEED TO SWITCH BACK TO THIS WINDOW WE CAN DO IT

        //    When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();


        String defaultWindow = driver.getWindowHandle();

        System.out.println(defaultWindow);
        //    Then user verifies the new window title is “New Window”
        //THE NEW WINDOW OPENS IN A NEW TAB. THIS MEANS WE HAVE TO SWITCH TO THE NEW WINDOW!!!!
        ///WE WILL GET ALL OPEN WINDOW HANDLES AND PUT THEM IN A SET.

        Set<String> allWindows=driver.getWindowHandles();
        //Using for each loop ,we can switch to new window
        for (String eachWindows :
                allWindows) {
            if (!eachWindows.equals(defaultWindow)) {
                driver.switchTo().window(eachWindows);
            }
            }

        String actualNewPageTitle =driver.getTitle();
        String expectedNewPageTitle="New Window";
        Assert.assertEquals(actualNewPageTitle,expectedNewPageTitle,"New ");
        //Using for each loop, we can switch to teh new window.

    String actualSecondWindowText = driver.findElement(By.xpath("//h3")).getText();
    String expectedSecondWindowText="New Window";
        Assert.assertEquals(actualSecondWindowText,expectedSecondWindowText,"New ");

        //    When user goes back to the previous window and then verifies the title : “The Internet”

        driver.switchTo().window(defaultWindow);
        Assert.assertEquals(actualSecondWindowText,expectedSecondWindowText);


    }

}
