package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateHotelRoomReservation1 {


    public CreateHotelRoomReservation1(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//select)[1]")
    public WebElement selectUser;
    @FindBy(xpath = "(//select)[2]")
    public WebElement selectRoom;
    @FindBy(xpath = "(//input)[1]")
    public WebElement price;
    @FindBy(xpath = "//input[@name='DateStart']")
    public WebElement DateStart;
    @FindBy(xpath = "//input[@id = 'DateEnd']")
    public WebElement DateEnd;
    @FindBy(xpath = "//input[@id = 'AdultAmount']")
    public WebElement AdultAmount;
    @FindBy(xpath = "//input[@id = 'ChildrenAmount']")
    public WebElement ChildrenAmount;
    @FindBy(xpath = "//input[@id = 'ContactPhone']")
    public WebElement ContactPhone;
    @FindBy(xpath = "//input[@id='ContactNameSurname']")
    public WebElement ContactNameSurname;
    @FindBy(xpath = "//input[@id='ContactEmail']")
    public WebElement ContactEmail;
    @FindBy(xpath = "//input[@id='Notes']")
    public WebElement Notes;
    @FindBy(xpath = "//input[@id='Approved']")
    public WebElement Approved;
    @FindBy(xpath = "//input[@id='IsPaid']")
    public WebElement IsPaid;
    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement btnSubmit;


    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement popUp;
    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement ok;






}
