package com.techproed.Batch3SeleniumPractice.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Homework {
    //  Go to “https://facebook.com”
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
        Thread.sleep(2000);
    }
    @Test
    public void get(){
        // 2. Click create new account button
        WebElement newAccount = driver.findElement(By.id("u_0_2"));
        newAccount.click();
        // 3. Enter a name firstName input box
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("emrah");
        // 4. Enter a surname surName input box
        WebElement surname = driver.findElement(By.name("lastname"));
        surname.sendKeys("alp");
        // 5. Enter an email into email input box
        WebElement email = driver.findElement(By.name("reg_email__"));
        email.sendKeys("emrah@gmail.com");
        //6. Re-enter the same email into email input box
        WebElement reemail = driver.findElement(By.name("reg_email_confirmation__"));
        reemail.sendKeys("emrah@gmail.com");

        //7. Enter a new password
        WebElement password = driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("123456789");
        //8. Select a day
        WebElement dayBox = driver.findElement(By.name("birthday_month"));
        Select day = new Select(dayBox);
        day.selectByIndex(1);
        //9. Select a moth
        WebElement monthBox = driver.findElement(By.name("birthday_day"));
        Select month = new Select(monthBox);
        month.selectByValue("1");
        //10. Select a year
        WebElement yearBox = driver.findElement(By.name("birthday_year"));
       Select year = new Select(yearBox);
       year.selectByVisibleText("2020");
        //11. Select a gender
        WebElement genderBox = driver.findElement(By.id("u_2_5"));
        genderBox.click();
        //12. Verify the gender is selected and verify the other gender is not selected.
        WebElement genderBox2 = driver.findElement(By.id("u_2_4"));
        WebElement genderBox3 = driver.findElement(By.id("u_2_6"));


        Assert.assertTrue(genderBox.isSelected());
        Assert.assertFalse(genderBox2.isSelected());
        Assert.assertFalse(genderBox3.isSelected());


    }





















}
