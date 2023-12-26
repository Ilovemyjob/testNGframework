package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameTest extends TestBase {
//    Go to https://the-internet.herokuapp.com/iframe
//    Verify the Bolded text contains “Editor”
//    Locate the text box
//    Delete the text in the text box
//    Type “This text box is inside the iframe”
//    Verify the text Elemental Selenium text is displayed on the page


        @Test
    public void iframeTest() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/iframe");



            WebElement Bolded = driver.findElement(By.xpath("//h3"));
            String boldedText =Bolded.getText();
            Assert.assertTrue(boldedText.contains("Editor"));

            //WE HAVE TO SWITCH IFRAME
         //   driver.switchTo().frame(0);
           // driver.switchTo().frame("mce_0_ifr");
            WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
            driver.switchTo().frame(iframeElement);

            Thread.sleep(1000);

            WebElement textBox = driver.findElement(By.xpath("//p"));
            Thread.sleep(1000);
            textBox.clear();
            textBox.sendKeys("This text box is inside the iframe");

            //Elementeal Selenium is out side of the Iframe .But currently our driver is inside the iframe.

            driver.switchTo().defaultContent();
            String elementText= driver.findElement(By.linkText("Elemental Selenium")).getText();
            Assert.assertTrue(elementText.equals("Elemental Selenium"));

        }
}
