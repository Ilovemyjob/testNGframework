package com.techproed.Batch3SeleniumPractice.Day4;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase3 extends TestBase {
/*
1.Go to http://webdriveruniversity.com/IFrame
2.Click the Our Products button
3.Click Cameras product
4.Print the message from popup
5.Click the close button
 */ @Test
public void testCase1() throws InterruptedException {



        driver.get("http://webdriveruniversity.com/IFrame");
        WebElement iframe = driver.findElement(By.id("frame"));
        driver.switchTo().frame(iframe);
        WebElement products = driver.findElement(By.linkText("Our Products"));
        //we did try but there is another frame we shuld change ifreme

        products.click();
        WebElement camera = driver.findElement(By.id("camera-img"));
        camera.click();
        Thread.sleep(2000);
        WebElement popUp = driver.findElement(By.className("modal-title"));
       String popUPText = popUp.getText();
        System.out.println(popUp.getText());

        WebElement close = driver.findElement(By.xpath("//button[2]"));
        close.click();






    }
    }
