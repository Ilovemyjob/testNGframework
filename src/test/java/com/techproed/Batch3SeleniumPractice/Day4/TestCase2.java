package com.techproed.Batch3SeleniumPractice.Day4;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends TestBase {
    /*
    1.Go to http://webdriveruniversity.com/File-Upload/
2.Click the Choose file button
3.Create a text document in your desktop
4.Upload this document from your desktop
5.Click the Submit button
6.Verify the “Your file has now been uploaded!” is displayed
7.Accept the popup.
webdriveruniversity.com
File Upload
Free Online (Interaction) Training Platform. Enhance yours skills within Automation Testing (Selenium WebDriver), Complicated Tasks & Framework Design…
     */

    @Test
    public void testCase1() throws InterruptedException {


        driver.get("http://webdriveruniversity.com/File-Upload/");
        WebElement chooseFile = driver.findElement(By.id("myFile"));


        String pathOfFile="C:\\Users\\Administrator\\Desktop\\new.txt";

        chooseFile.sendKeys(pathOfFile);

        WebElement submit = driver.findElement(By.id("submit-button"));
        submit.click();

        String actualText=driver.switchTo().alert().getText();
        String expectedText ="Your file has now been uploaded!";
        Assert.assertEquals(actualText,expectedText);

        driver.switchTo().alert().accept();














    }





    }
