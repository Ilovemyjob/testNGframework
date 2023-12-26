package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateHotelRoom {
    WebDriver driver;

    public CreateHotelRoom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(id="IDHotel")
    public WebElement createHotelId;

    @FindBy(id="Code")
    public WebElement createCode;

    @FindBy(id="Name")
    public WebElement createName;

    @FindBy(id="Location")
    public WebElement createLocation;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement createDescription;

    @FindBy(xpath = "//li[@data-id='700']")
    public WebElement createSource;

    @FindBy(id="Price")
    public WebElement createTarget;

    @FindBy(id="IDGroupRoomType")
    public WebElement createRoomType;

    @FindBy(id="MaxAdultCount")
    public WebElement createMaxAdultCount;

    @FindBy(id="MaxChildCount")
    public WebElement createMaxChildCount;

    @FindBy(id="IsAvailable")
    public WebElement createIsAvailable;

    @FindBy(id="btnSubmit")
    public WebElement createbtnSubmit;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement createSuccessMessage;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement createOkButton;

    @FindBy(xpath = "(//a/i[@class='icon-calendar'])[3]")
    public WebElement createHotelAdminRoom;





}