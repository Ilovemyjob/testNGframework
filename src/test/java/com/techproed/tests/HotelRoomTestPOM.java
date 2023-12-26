package com.techproed.tests;

import com.techproed.pages.*;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelRoomTestPOM extends TestBase {

    public void kaolaLogin() {
        driver.get(ConfigReader.getProperty("url"));
        // driver.get("http://www.kaolapalace-qa-environment2.com/");
        KaolaMainPage kaolaMainPage = new KaolaMainPage();
        kaolaMainPage.kaolaMainLoginButton.click();

        KaolaLoginPage kaolaLoginPage = new KaolaLoginPage();
        kaolaLoginPage.kaolaUsername.sendKeys(ConfigReader.getProperty("username"));
        kaolaLoginPage.kaolaPass.sendKeys(ConfigReader.getProperty("password"));
        kaolaLoginPage.kaolaLoginButton.click();

    }
    @Test
    public void hotelRoomTest() throws InterruptedException {
        kaolaLogin();
        KaolaDefaultPage kaolaDefaultPage=new KaolaDefaultPage(driver);
        kaolaDefaultPage.hotelManagement.click();
        kaolaDefaultPage.hotelRooms.click();
        Thread.sleep(5000);

        HotelRoomsPage hotelRoomsPage=new HotelRoomsPage(driver);
        hotelRoomsPage.addHotelRoomButton.click();
        //REST IS HOMEWORK

        CreateHotelRoom createHotelRoom = new CreateHotelRoom(driver);
        Select options = new Select(createHotelRoom.createHotelId);
        options.selectByIndex(1);

        createHotelRoom.createCode.sendKeys("12345");
        createHotelRoom.createName.sendKeys("aPages Object Model Hotel");
        createHotelRoom.createLocation.sendKeys("in Mars");
        createHotelRoom.createDescription.sendKeys("I like that");


        Actions actions = new Actions(driver);
        actions.dragAndDrop(createHotelRoom.createSource,createHotelRoom.createTarget).perform();


        Select options2 = new Select(createHotelRoom.createRoomType);
        options2.selectByVisibleText("Studio");

        createHotelRoom.createMaxAdultCount.sendKeys("5");
        createHotelRoom.createMaxChildCount.sendKeys("6");
        createHotelRoom.createIsAvailable.click();
        createHotelRoom.createbtnSubmit.click();

        Thread.sleep(2000);
        createHotelRoom.createOkButton.click();

        String ActualMessage = createHotelRoom.createSuccessMessage.getText();
        String ExpectedMessage = "HotelRoom was inserted successfully";

        createHotelRoom.createOkButton.click();

        createHotelRoom.createHotelAdminRoom.click();







    }

}
