package com.techproed.Batch3SeleniumPractice.Day4;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase4 extends TestBase {
//    1.Go to http://webdriveruniversity.com/Actions
//            2.Hover over the Me First
//3.Click Link 1
//            4.Print the popup message
//5.Accept the popup
//6.Click and hold
//7.Get the text click and hold
//8.Double click to the double click me
    @Test
    public void testCase1() throws InterruptedException {

        driver.get("http://webdriveruniversity.com/Actions");
        WebElement hoverOver = driver.findElement(By.xpath("(//button[@class=\"dropbtn\"])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOver).perform();

        WebElement account =driver.findElement(By.linkText("Link 1"));
        account.click();

       String text= driver.switchTo().alert().getText();
        System.out.println(text);
       driver.switchTo().alert().accept();

        WebElement clickandHold =driver.findElement(By.id("click-box"));


        //clickandHold.click();
        actions.clickAndHold(clickandHold).perform();


       

        System.out.println("clickAndHold.getText() = " + clickandHold.getText());

        WebElement doubleClick = driver.findElement(By.id("double-click"));

        actions.doubleClick(doubleClick).perform();




    }




}
