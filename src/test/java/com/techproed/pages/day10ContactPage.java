package com.techproed.pages;

import com.techproed.pages.ContactPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class day10ContactPage {
/*
1.First get the datas from dataContact.xlsx then use them to fill
2.Log in the twiliaerp.com/
3.Click the Contacts
4.Click the create button
5.Enter any name the individual
6.And click create button the bottom
7.Then enter contact name, phone and email
8.And click Save & Close button
9.Then click the save button top of the left side
 */

    @Test
    public void saveContact() throws InterruptedException {
        ExcelUtil excelUtil = new ExcelUtil("src/test/java/resources/dataContact.xlsx", "data");
        List<Map<String, String>> data = excelUtil.getDataList();
        System.out.println(data);

        ContactPage contactPage = new ContactPage();
        Driver.getDriver().get(ConfigReader.getProperty("twiliaerp_link"));
        String user = ConfigReader.getProperty("username_for_erp");
        String password = ConfigReader.getProperty("password_for_erp");
        contactPage.login(user, password);

        int lastRow = excelUtil.rowCount() - 1;
        for (int i = 0; i < lastRow; i++) {
            Thread.sleep(3000);

            contactPage.contacts.click();
            Thread.sleep(2000);
            contactPage.createButton.click();
            contactPage.inputName.sendKeys(data.get(i).get("FirstName"));
            contactPage.createbutton2.click();
            String fullName = data.get(i).get("FirstName") + " " + data.get(i).get("LastName");
            contactPage.contactName.sendKeys(fullName);
            contactPage.email.sendKeys(data.get(i).get("Email"));
            contactPage.phone.sendKeys(data.get(i).get("Phone"));
            contactPage.save_close.click();
            contactPage.save.click();
            Thread.sleep(5000);
            Driver.closeDriver();
        }
        //2.way
        for (Map<String, String> data2 : data) {
            Thread.sleep(5000);
            contactPage.contacts.click();
            Thread.sleep(3000);
            contactPage.createButton.click();
            contactPage.inputName.sendKeys(data2.get("FirstName"));
            contactPage.createbutton2.click();
            String fullName = data2.get("FirstName") + " " + data2.get("LastName");
            contactPage.contactName.sendKeys(fullName);
            contactPage.email.sendKeys(data2.get("Email"));
            contactPage.phone.sendKeys(data2.get("Phone"));
            contactPage.save_close.click();
            contactPage.save.click();
            Thread.sleep(5000);
        }
        // Driver.closeDriver();
    }


}
