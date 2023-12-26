package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWaitTest extends TestBase {
    /*
    Create a class:ExplicitWaitTest. Create a method: explicitWait
Go to https://the-internet.herokuapp.com/dynamic_controls
Click on remove button
And verify the message is equal to “It's gone!”
Then click on Add button
And verify the message is equal to “It's back!”
     */
// implicit waie driver explicit wait expectedcondition in site
    @Test
    public void explicitWait(){



        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement addButton=driver.findElement(By.xpath("//button[@type='button']"));
        addButton.click();

//Expected condition is to wait for the its gone element
        WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
 //       WebElement message= driver.findElement(By.id("message"));


        String messageText = message.getText();
        Assert.assertEquals(messageText,"It's gone!");

        WebElement removeButton =driver.findElement(By.xpath("//button[@type='button']"));
        addButton.click();


        WebElement message2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
    //    WebElement message2= driver.findElement(By.id("message"));
        String message2Text = message2.getText();
        Assert.assertEquals(message2Text,"It's back!");







    }




}
