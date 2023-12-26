package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://google.com/");

    }


    @Test
    public void hardAssertTest() {
        //Assert if the gmail link text equals "gmail"
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        //Assert if the gmail link text equals "gmail"
        String actualGmailText = gmailLink.getText();
        String expectedGmailText = "Gmail";
        Assert.assertEquals(actualGmailText, expectedGmailText);

        //Assert ig the images link text is equal to Images
        WebElement imagesLink = driver.findElement(By.linkText("Bilder"));
        String expectedImages = "Images";
        String actualImages = imagesLink.getText();
        Assert.assertEquals(actualImages, expectedImages);

        //Assert if the sign in link text is equal to Sign in
        WebElement signInLink = driver.findElement(By.linkText("Anmelden"));
        String expectedSignIn = "Sign in";
        String actualSignIn = signInLink.getText();
        Assert.assertEquals(actualSignIn, expectedSignIn);


    }
    @Test
    public void hard(){
        WebElement link = driver.findElement(By.id(""));
        String actual = link.getText();
        String expected = "Gmail";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void softAssert(){
        //Assert if the gmail link text equals "gmail"
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        //Assert if the gmail link text equals "gmail"
        String actualGmailText = gmailLink.getText();
        String expectedGmailText = "Gmail";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualGmailText, expectedGmailText);

        //Assert ig the images link text is equal to Images
        WebElement imagesLink = driver.findElement(By.linkText("Bilder"));
        String expectedImages = "Images";
        String actualImages = imagesLink.getText();
        softAssert.assertEquals(actualImages, expectedImages);

        //Assert if the sign in link text is equal to Sign in
        WebElement signInLink = driver.findElement(By.linkText("Anmelden"));
        String expectedSignIn = "Sign in";
        String actualSignIn = signInLink.getText();
        softAssert.assertEquals(actualSignIn, expectedSignIn);

        softAssert.assertAll();
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}