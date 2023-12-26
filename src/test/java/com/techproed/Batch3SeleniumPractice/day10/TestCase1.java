package com.techproed.Batch3SeleniumPractice.day10;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

public class TestCase1 {
    /*
    1.Go to https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table
2.Go down to medal table
3.Print all the table on the console
     */


    @Test
    public void teble(){

        Driver.getDriver().get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");


        List<WebElement> table =Driver.getDriver().findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']"));
        List<WebElement> table2 =Driver.getDriver().findElements(By.xpath("(//table)[11]//tr"));

        for (WebElement tabledata : table) {
            System.out.println(tabledata.getText());
        }
        System.out.println("====");
        for (WebElement tabledata : table2) {
            System.out.println(tabledata.getText());
        }

        System.out.println("===========");
        System.out.println(table2.get(2).getText());









    }







}
