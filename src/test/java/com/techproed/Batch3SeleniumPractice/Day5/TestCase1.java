package com.techproed.Batch3SeleniumPractice.Day5;

import com.techproed.utilities.TestBase;
import com.techproed.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.Set;

public class TestCase1 extends TestBaseCross {
    /*
    1.Go to http://webdriveruniversity.com/
2.Go down to Login Portal
3.Click the Login Portal
4.Go to second windows
5.Fill the username and password
6.Click the login button
7.Print the popup text
8.Accept the popup
     */

    @Test
    public void test() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/");

        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement logIn =driver.findElement(By.id("login-portal"));
        logIn.click();


        Set<String> allWindows = driver.getWindowHandles();
        String fistWindow = driver.getWindowHandle();

        for (String eachWindow :
                allWindows) {
            if(!eachWindow.equals(fistWindow)){
                driver.switchTo().window(eachWindow);
            }
        }
        WebElement username = driver.findElement(By.id("text"));
        Thread.sleep(2000);
        username.sendKeys("username");
        WebElement password = driver.findElement(By.id("password"));
        Thread.sleep(2000);
        password.sendKeys("password");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Thread.sleep(3000);
        loginButton.click();
        Thread.sleep(3000);
        String allertText = driver.switchTo().alert().getText();
        System.out.println(allertText);
        driver.switchTo().alert().accept();






    }
}
