package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homework2 {
    //    • Use Different Test Method for each Test Case
//• Go to https://www.amazon.com/
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


    }

    @Test
    public void selectByValue() {
        // • Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        //• Print the first selected option and assert if it equals “All Departments”
        WebElement all = driver.findElement(By.id("searchDropdownBox"));
        Select options = new Select(all);
        String first = options.getFirstSelectedOption().getText();
        System.out.println(first);

        Assert.assertEquals(first, "All Departments");
    }

    @Test
    public void index4() {

        WebElement all = driver.findElement(By.id("searchDropdownBox"));
        Select options = new Select(all);
//            • Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
//            (after you select you need to use get first selected option method)
        options.selectByIndex(4);
        WebElement actualIndex4 = driver.findElement(By.xpath("//*[@id='searchDropdownBox']/option[4]"));
        String expectedIndex4 = "Amazon Devices";
        Assert.assertEquals(actualIndex4, expectedIndex4);

    }

    @Test
    public void alldropdown() {

        WebElement all = driver.findElement(By.id("searchDropdownBox"));
        Select options = new Select(all);

//            • Print all of the dropdown options

        List<WebElement> allOption = options.getOptions();
        for (WebElement w :
                allOption) {
            System.out.println(w.getText() + " ,");
        }
    }
        @Test
        public void totalnumber() {

            WebElement all = driver.findElement(By.id("searchDropdownBox"));
            Select options = new Select(all);



            List<WebElement> allOption = options.getOptions();
            System.out.println(allOption.size());
        }

//• Print the the total number of options in the dropdown
    @Test
    public void Appliances() {

        WebElement all = driver.findElement(By.id("searchDropdownBox"));
        Select options = new Select(all);
        List<WebElement> allOption = options.getOptions();


//• Check if Appliances is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
        Assert.assertFalse(allOption.contains("Appliances"));

    }

    @Test
    public void Alphabetical() {
        //• BONUS: Check if the dropdown is in Alphabetical Order




    }

    @BeforeMethod
    public  void tierDown(){
        driver.close();
    }
    }
