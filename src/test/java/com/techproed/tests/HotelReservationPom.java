package com.techproed.tests;


import com.techproed.pages.*;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HotelReservationPom {

    public void kaolaLogin() {
        Driver.getDriver().get(ConfigReader.getProperty("kaola_url"));
        // driver.get("http://www.kaolapalace-qa-environment2.com/");
        KaolaMainPage1 kaolaMainPage1 = new KaolaMainPage1();
        kaolaMainPage1.kaolaMainLoginButton.click();

        KaolaLoginPage1 kaolaLoginPage1 = new KaolaLoginPage1();
        kaolaLoginPage1.kaolaUsername.sendKeys(ConfigReader.getProperty("username"));
        kaolaLoginPage1.kaolaPass.sendKeys(ConfigReader.getProperty("password"));
        kaolaLoginPage1.kaolaLoginButton.click();

    }
        @Test
        public void reservationTest() throws InterruptedException {
            kaolaLogin();

            // We Deleted because we use p.o.m.
//            Driver.getDriver().get("http://www.kaolapalace-qa-environment2.com/");
//            WebElement loginButton = Driver.getDriver().findElement(By.xpath("(//a[@class='nav-link'])[7]"));
//            loginButton.click();
//            WebElement userName = Driver.getDriver().findElement(By.xpath("(//input)[1]"));
//            userName.sendKeys("manager2");
//            WebElement password = Driver.getDriver().findElement(By.xpath("(//input)[3]"));
//            password.sendKeys("Man1ager2!");
//            WebElement clickOnLogin = Driver.getDriver().findElement(By.xpath("(//input)[4]"));
//            clickOnLogin.click();


            KaolaDefaultPage1 kaolaDefaultPage1 =new KaolaDefaultPage1();
            kaolaDefaultPage1.hotelManagement.click();
            kaolaDefaultPage1.roomReservation.click();

           // Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          Thread.sleep(3000);
            HotelRoomsPage1 hotelRoomsPage1 = new HotelRoomsPage1();
            hotelRoomsPage1.Add_Room_Reservation.click();

            CreateHotelRoomReservation1 createHotelRoomReservation1 = new CreateHotelRoomReservation1();
            Select selectSelectUser = new Select(createHotelRoomReservation1.selectUser);
            selectSelectUser.selectByIndex(1);

            Select selectSelectRoom = new Select(createHotelRoomReservation1.selectRoom);
            selectSelectRoom.selectByVisibleText("King Room");
            createHotelRoomReservation1.price.sendKeys("600");
            ReusableMethods.waitFor(1);
           createHotelRoomReservation1.DateStart.sendKeys("11/26/2020");
            ReusableMethods.waitFor(1);
            createHotelRoomReservation1.DateEnd.sendKeys("11/28/2020");

            createHotelRoomReservation1.AdultAmount.sendKeys("2");
            createHotelRoomReservation1.ChildrenAmount.sendKeys("2");
            ReusableMethods.waitFor(1);
            createHotelRoomReservation1.ContactPhone.sendKeys("0491255544");
            createHotelRoomReservation1.ContactNameSurname.sendKeys("Emrah");
            createHotelRoomReservation1.ContactEmail.sendKeys("ggg@gmail.com");
            createHotelRoomReservation1.Notes.sendKeys("okey");
            createHotelRoomReservation1.IsPaid.click();
            createHotelRoomReservation1.Approved.click();
            createHotelRoomReservation1.btnSubmit.click();


          WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
     //      WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bootbox-body']")));
//
         wait.until(ExpectedConditions.visibilityOf(createHotelRoomReservation1.popUp));

       //     boolean isTrue=wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),"RoomReservation was inserted successfully"));

          //  boolean isTrue=ReusableMethods.waitForText(By.xpath("//div[@class='bootbox-body']"),"RoomReservation was inserted successfully",10);
        //   Assert.assertTrue(isTrue);

            String message = createHotelRoomReservation1.popUp.getText();
//            String message = Driver.getDriver().findElement(By.xpath("//div[@class='bootbox-body']")).getText();
//            System.out.println(message);
            Assert.assertEquals(message, "RoomReservation was inserted successfully");

           // createHotelRoomReservation1.ok.click();
        }
    }

