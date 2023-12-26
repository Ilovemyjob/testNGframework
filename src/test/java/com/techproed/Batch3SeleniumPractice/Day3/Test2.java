package com.techproed.Batch3SeleniumPractice.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Test2 {

//    Go to “http://webdriveruniversity.com/Popup-Alerts/index.html”
//            2. Click CLICK ME of JavaScript Alert
// 3. Get the pop up text
// 4. Verify the Message is “I am an alert box!“
//            5. Accept the pop up
WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }
    @Test
    public void alert1() throws InterruptedException {
        WebElement clickMe1 = driver.findElement(By.id("button1"));
        clickMe1.click();

        //   Alert alert = driver.switchTo().alert(); => shortcut toi use alert
        String actualText = driver.switchTo().alert().getText();

        String expectedText = "I am an alert box!";

        Assert.assertEquals(actualText, expectedText);

        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }
    @Test (dependsOnMethods = "alert1")
    public void alert2() throws InterruptedException {

//        1. Go to “http://webdriveruniversity.com/Popup-Alerts/index.html”
//        2. Click CLICK ME of JavaScript Confirm Box
//        3. Get the pop up text
//        4. Verify the Message is “Press a button“ (the message is worng but I
//        want to complete my test case)
//        5. Dismiss the pop up
//        6. Verify the “You pressed Cancel!” is displayed
//        7. Use the dependsOnMethods accorting to alert1

        WebElement clickMe1 = driver.findElement(By.id("button4"));
        clickMe1.click();

        SoftAssert softAssert = new SoftAssert();

    //shortcut    Alert popUp = driver.switchTo().alert();
        String actualText = driver.switchTo().alert().getText();
        String expectedText = "Press a button";


        softAssert.assertEquals(expectedText,actualText);
        driver.switchTo().alert().dismiss();



        WebElement displayText = driver.findElement(By.id("confirm-alert-text"));

     //   softAssert.assertEquals(displayText.getText(),"You pressed Cancel!");
        //we can use Assert also

        softAssert.assertTrue(displayText.isDisplayed());





        softAssert.assertAll();
    }
}
