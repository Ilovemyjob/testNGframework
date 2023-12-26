package com.techproed.Batch3SeleniumPractice.Day5;

import com.techproed.utilities.TestBase;
import com.techproed.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 extends TestBaseCross {
    /*
    1.Go to ” https://demoqa.com/dynamic-properties”
2.Verify the Visible After 5 Seconds button is displayed

     */

    @Test
    public void TestCase2() throws InterruptedException {

        driver.get("https://demoqa.com/dynamic-properties");

  //      Thread.sleep(6000);

        WebDriverWait wait = new WebDriverWait(driver,10);


        WebElement visible = driver.findElement(By.id("visibleAfter"));
        wait.until(ExpectedConditions.visibilityOf(visible));//visibilityof after locating;visibilityOfLocated while Locating

        Assert.assertTrue(visible.isEnabled());


    }
}
