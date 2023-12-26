package com.techproed.Batch3SeleniumPractice.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestCase3 {



    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @Test
    public void dropDown() throws InterruptedException {


        driver.get("http://zero.webappsecurity.com/");
        WebElement singIn = driver.findElement(By.id("signin_button"));
        singIn.click();
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.id("user_login"));
        userName.sendKeys("username");
        WebElement password = driver.findElement(By.xpath("//input[@name='user_password']"));
        password.sendKeys("password" );
        Thread.sleep(1000);
        WebElement singINButton = driver.findElement(By.xpath("//input[@name='submit']"));
        singINButton.click();

        Thread.sleep(1000);
       WebElement activity = driver.findElement(By.id("account_activity_tab"));
       activity.click();

        //1. Go to http://zero.webappsecurity.com/
//            2. Click Sign in button
// 3. Enter login ( “username”)
// 4. Enter wrong password (“password”)
// 5. Click Sign in button
//6. Go to Account Activity page
//7.Select Brokerage from account drop down menu

//8.Verify in the account dropdown menu Brokerage is selected
//9.Verify the drop down menu is following { Savings, Checking, Savings, Loan, Credit Card, Brokerage}

        WebElement dropDown = driver.findElement(By.id("aa_accountId"));

        Select options = new Select(dropDown);
        options.selectByVisibleText("Brokerage");
        Assert.assertTrue(options.getFirstSelectedOption().isDisplayed());



      //  String arr[] = {"Savings", "Checking", "Savings", "Loan", "Credit Card", "Brokerage"};


        Assert.assertTrue(options.getFirstSelectedOption().isDisplayed());
        //we are getting chosen option




        List<String> expectedList = Arrays.asList("Savings", "Checking", "Savings", "Loan", "Credit Card", "Brokerage");//kendi list yapti

        List<WebElement> webList = options.getOptions();//dropdowndakini list icine atti
        List<String> actualList = new ArrayList<String>();//bos list yapti
        for (WebElement each : webList) {//tek tek icine atti
            actualList.add(each.getText());
        }

        System.out.println("actualList = " + actualList);

        Assert.assertEquals(actualList,expectedList);//kendi listesi ve actual listi karsilastirdi

        //Assert.assertEquals(webList,expectedList);


    }
    @AfterMethod
   public void tearDown(){
    //    driver.quit();
    }
}
