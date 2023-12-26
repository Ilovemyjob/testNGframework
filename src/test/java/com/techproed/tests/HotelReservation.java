package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelReservation extends TestBase {
    //HOMEWORK2: As user I should be able to create a room reservation
    //As tester, you decide your test data.
    //Use same manager id and password

    //Create a clickOnLogin method

//Click on Hotel Management
//Click on Room reservations
//Click on Add Room Reservation
//Enter All required fields
//To enter a price, we can send keys, OR we can use actions class to drag and drop
//Click Save
//Verify the message: RoomReservation was inserted successfully
//Click OK

    public void clickOnLogin(){
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainPageLoginButton = driver.findElement(By.linkText("Log in"));
        mainPageLoginButton.click();
    }

    @Test
    public void createRoomReservation() throws InterruptedException {

        clickOnLogin();
        driver.findElement(By.id("UserName")).sendKeys("manager2", Keys.TAB, "Man1ager2!", Keys.ENTER);
        driver.findElement(By.id("menuHotels")).click();
        driver.findElement(By.partialLinkText("Room reservations")).click();
        driver.findElement(By.className("hidden-480")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("IDUser")).sendKeys("manager2", Keys.TAB, "TEST123", Keys.TAB, "500",
                Keys.TAB, "10/01/2020", Keys.TAB, Keys.TAB, "11/01/2020", Keys.TAB, Keys.TAB, "2", Keys.TAB, "4",
                Keys.TAB, "Alex de Souza", Keys.TAB, "3479871212", Keys.TAB, "alexdesouza@gmail.com", Keys.TAB, "OK!");

        driver.findElement(By.id("Approved")).click();
        driver.findElement(By.id("IsPaid")).click();
        driver.findElement(By.id("btnSubmit")).click();

        Thread.sleep(2000);

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='bootbox-body']"));
        String successMessageText = successMessage.getText();
        Assert.assertEquals(successMessageText,"RoomReservation was inserted successfully");

        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    }
}




//    public void clickOnLogin(){
//
//        driver.get("http://www.kaolapalace-qa-environment2.com/");
//        WebElement mainPageLoginButton=driver.findElement(By.linkText("Log in"));
//        mainPageLoginButton.click();
//    }
//
//
//
//    @Test
//    public void roomReservation() throws InterruptedException {
//        clickOnLogin();
//
//        clickOnLogin();
//        driver.findElement(By.id("UserName")).sendKeys("manager2");
//        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
//        driver.findElement(By.id("btnSubmit")).click();
//        driver.findElement(By.linkText("Hotel Management")).click();
//Thread.sleep(3000);
//        WebElement reservations=driver.findElement(By.xpath("(//i[@class=\"icon-calendar\"])[4]"));
//        reservations.click();
//        Thread.sleep(2000);
//        WebElement addRoom=driver.findElement(By.xpath("//span[@class=\"hidden-480\"]"));
//        addRoom.click();
//        WebElement idUser = driver.findElement(By.id("IDUser"));
//        Select option1 = new Select(idUser);
//        option1.selectByIndex(1);
//        WebElement selectHotelRoom = driver.findElement(By.id("IDHotelRoom"));
//        Select option2 = new Select(selectHotelRoom);
//        option2.selectByIndex(1);
//        WebElement price = driver.findElement(By.id("Price"));
//        price.sendKeys("1000");
//Thread.sleep(2000);
//        driver.findElement(By.id("DateStart")).sendKeys("09/28/2020");
//        driver.findElement(By.id("dateEnd")).sendKeys("09/30/2020");
//        driver.findElement(By.id("AdultAmount")).sendKeys("2");
//        driver.findElement(By.id("ChildrenAmount")).sendKeys("2");
//        WebElement contactNameSurname = driver.findElement(By.id("ContactNameSurname"));
//        contactNameSurname.sendKeys("emrah");
//        WebElement contactPhone = driver.findElement(By.id("ContactPhone"));
//        contactPhone.sendKeys("1234567890");
//        WebElement contactEmail = driver.findElement(By.id("ContactEmail"));
//        contactEmail.sendKeys("a@gmail.com");
//        WebElement notes = driver.findElement(By.id("Notes"));
//        notes.sendKeys("super");
//
//  //      WebElement notes = driver.findElement(By.id("Approved"));
