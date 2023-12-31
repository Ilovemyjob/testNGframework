package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class KaolaLoginPage {

   // WebDriver driver;
    public KaolaLoginPage(){
      //  this.driver=driver;
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="UserName")
    public WebElement kaolaUsername;
    @FindBy(id="Password")
    public WebElement kaolaPass;
    @FindBy(id="btnSubmit")
    public WebElement kaolaLoginButton;

}
