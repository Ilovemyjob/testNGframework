package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {
    /*
    Create a class:FileDownload
downloadTest()
In the downloadTest() method, do the following test:
Go to https://the-internet.herokuapp.com/download
Download logo.png file
Then verify if the file downloaded successfully
     */
    @Test
    public void downloadTest() throws InterruptedException {

    driver.get("https://the-internet.herokuapp.com/download");

        WebElement flower = driver.findElement(By.linkText("FLOWER.JPG"));
        flower.click();
        Thread.sleep(3000);


        // parantezin icine yapistir kolay oluyor
        //WE can find user folder using System.getProperty(); to make more dynamic
        String userFolder = System.getProperty("user.home");
        System.out.println(userFolder);
        String pathOfFile = userFolder+"\\Downloads\\FLOWER.JPG\\";

        //   String pathOfFile ="C:\\Users\\Administrator\\Downloads\\FLOWER.JPG";
        boolean isDownLoaded = Files.exists(Paths.get(pathOfFile));
        Assert.assertTrue(isDownLoaded);







    }
}
