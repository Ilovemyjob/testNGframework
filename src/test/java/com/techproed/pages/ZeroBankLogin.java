package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZeroBankLogin {  // 2. way =extends TestBase  delete under webdriver


    WebDriver driver;

    public ZeroBankLogin() {
     //   this.driver = driver;
        PageFactory.initElements(Driver.getDriver(), this);


    }

    @FindBy(id = "signin_button")
    public WebElement zeroBankSignin;

    @FindBy(id = "user_login")
    public WebElement zeroBankLogin;

    @FindBy(id = "user_password")
    public WebElement zeroBankPass;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    public WebElement zeroBankSignin2;



    public void zeroLogin() {

        zeroBankSignin.click();

        zeroBankLogin.sendKeys("username");

        zeroBankPass.sendKeys("password");
        zeroBankSignin2.click();

    }
}