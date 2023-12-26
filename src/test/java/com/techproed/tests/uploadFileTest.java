package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class uploadFileTest extends TestBase {
    @Test
    public void contextClickMethod() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        //locate teh element of choosefile

        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        //We need to send the path of the image
        //Each of your path will be different
        //Find your own path
        //Windows Example: C:\\Users\\USE YOUR OWN COMPUTER NAME\\Desktop\\FLOWER. IMG.jpg"
        String pathOfFile="C:\\Users\\Administrator\\Desktop\\FLOWER. IMG.jpg";
        //We will send this pathOfTheFile to the chooseFile button

        Thread.sleep(1000);

        chooseFile.sendKeys(pathOfFile);
        Thread.sleep(1000);
        //Click on upload button

        WebElement upLoad = driver.findElement(By.id("file-submit"));
        upLoad.click();

        WebElement fileUploedadText = driver.findElement(By.xpath("//h3"));
        String actualText = fileUploedadText.getText();
        String expectedText = "File Uploaded!";
        Assert.assertEquals(actualText,expectedText);


    }
    }
