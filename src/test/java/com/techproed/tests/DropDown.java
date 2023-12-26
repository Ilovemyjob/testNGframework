package com.techproed.tests;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDown {

    //Create a class name : DropDown
     //Go to https://the-internet.herokuapp.com/dropdown
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
//    driver.manage().timeouts().implicitlyWait();
    driver.manage().window().maximize();
    Thread.sleep(1000);
    driver.get("https://the-internet.herokuapp.com/dropdown");

}
    //1.Select and Print Option 1 using index
    @Test
    public void dropdownTest(){
        //1-locate dropdown
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        //2-create select obj
        Select options =new Select(dropdownElement);
        //3-select option byindex ,byvalue,byvisibletext
        options.selectByIndex(1);


    }

    //2.Select and Print Option 2 by value
    @Test
    public void selectByValue() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdownElement);
        Thread.sleep(3000);
        options.selectByValue("2");
        Thread.sleep(3000);


    }

        //3.Select and Print Option 1 by visible text
        @Test
        public void selectOption1() {
            WebElement dropdownElement = driver.findElement(By.id("dropdown"));
            Select options = new Select(dropdownElement);
            options.selectByVisibleText("Option 1");
        }

    //4.Print all dropdown values
        //there are many ways
    @Test
    public void printAllValues() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdownElement);
        Thread.sleep(2000);
        //This gives all dropdown option
            // alotof element thts why we use list and we print
        List<WebElement> allOption =options.getOptions();// to get all data
            for (WebElement option:allOption) {
               System.out.println(option.getText());
    }

  //      5.Find the size of the dropdown,
// Print true if there are 4 elements in the dropdown.
// Print false otherwise.

    }
    @Test
    public void size() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdownElement);
        Thread.sleep(1000);
        int actualSize = options.getOptions().size();
        Assert.assertEquals(actualSize, 3,"EXPECTED IS NOT EQUAL TO ACTUAL");

    }


     @Test
    public void getFirstSelectedOptionTest() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdownElement);
        Thread.sleep(1000);
        String FirstSelectedOption=options.getFirstSelectedOption().getText();
         System.out.println("First Selected Option=>"+ FirstSelectedOption);

    }

    @AfterMethod
        public void tearDown(){
        driver.close();

        }





}