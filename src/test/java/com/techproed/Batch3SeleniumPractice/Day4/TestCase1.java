package com.techproed.Batch3SeleniumPractice.Day4;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase1 extends TestBase {
//    Go to http://zero.webappsecurity.com/
//            2. Click Sign in button
// 3. Enter login ( “username”)
// 4. Enter wrong password (“password”)
// 5. Click Sign in button
//6. Go to Pay Bills page
//7. Click Purchase Foreign Currency

//8. Select Eurozone from currency drop dawn menu
//9. Verify the Euro zone is selected
//10. Verify the List Options is following {Select One, Australia (dollar), Canada (dollar),Switzerland (franc),China (yuan),Denmark (krone),Eurozone (euro),Great Britain (pound),Hong Kong (dollar),Japan (yen),Mexico (peso),Norway (krone),New Zealand (dollar),Sweden (krona),Singapore (dollar),Thailand (baht)}


    @Test
    public void testCase1() throws InterruptedException {

        driver.get("http://zero.webappsecurity.com/");


        WebElement signIn = driver.findElement(By.id("signin_button"));
        signIn.click();
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.id("user_login"));
        userName.sendKeys("username");
        WebElement password = driver.findElement(By.xpath("//input[@name='user_password']"));
        password.sendKeys("password" );
        Thread.sleep(1000);
        WebElement singINButton = driver.findElement(By.xpath("//input[@name='submit']"));
        singINButton.click();
        WebElement payBills = driver.findElement(By.id("pay_bills_tab"));
        payBills.click();

        WebElement foreignBox = driver.findElement(By.linkText("Purchase Foreign Currency"));
        foreignBox.click();

        WebElement selectBox = driver.findElement(By.id("pc_currency"));
        Select select = new Select(selectBox);
        select.selectByVisibleText("Eurozone (euro)");

     //   Assert.assertTrue(select.getFirstSelectedOption().isDisplayed());
        // with this way show selected or not but we dont know which one is selected
        String selected = select.getFirstSelectedOption().getText();
        String actual="Eurozone (euro)";
        Assert.assertEquals(actual,selected);

        List<String> expectedText = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)",
                "Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)",
                "Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)",
                "Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)");

        List<WebElement> webElements = select.getOptions();
        List<String> actualText = new ArrayList<String>();
        for (WebElement each :
                webElements) {
            actualText.add(each.getText());
        }

        Assert.assertEquals(actualText,expectedText);

    }















}
