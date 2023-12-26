package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KaolaDefaultPage {
    WebDriver driver;// cucumberde bu yok

    public KaolaDefaultPage(WebDriver driver){//ici cucumberde yok
        this.driver=driver;//cucumberde yok
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Hotel Management")
    public WebElement hotelManagement;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRooms;



}
