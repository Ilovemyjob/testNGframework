package com.techproed.tests;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceLogin extends TestBase {


    @Test
    public void logInTest() throws InterruptedException {

        driver.get("https://www.facebook.com/");
        //Create FaceLoginPage object
        FaceLoginPage faceLoginPage=new FaceLoginPage(driver);
        faceLoginPage.username.sendKeys("abc");
        faceLoginPage.password.sendKeys("123");
        Thread.sleep(3000);

        faceLoginPage.login.click();

       // WebElement message = driver.findElement(By.xpath("//div[@class='_9ay7']"));
     //   message.getText();
        //        Assert.assertEquals(message.getText(),"The email or phone number you've entered doesn't match any account. Sign up for an account.");

        Thread.sleep(3000);

        String actualErrorMessage=faceLoginPage.errorMessage.getText();
        String expectedErrorMessage="The email or phone number you’ve entered doesn’t match any account. Sign up for an account.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);










    }






}
