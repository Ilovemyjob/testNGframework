package com.techproed.Batch3SeleniumPractice.day10;

import com.techproed.pages.ContactPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class getDataFromExel {

    @Test
    public void Test() throws IOException, InterruptedException {

        String path = ".\\src\\test\\java\\resources\\dataContact.xlsx";
//        Open the file/workbook
       // FileInputStream fileInputStream=new FileInputStream(path);
      //  Workbook workbook= WorkbookFactory.create(fileInputStream);
//        Open the first worksheet
      //  Sheet sheet=workbook.getSheetAt(0);

      //  System.out.println(sheet.getRow(1).getCell(1).toString());

        ExcelUtil excelUtil = new ExcelUtil(path,"data");
        System.out.println(excelUtil.getDataList());
        List<Map<String,String>> data =excelUtil.getDataList();

        Driver.getDriver().get(ConfigReader.getProperty("twiliaerp_link"));
        String user = ConfigReader.getProperty("username_for_erp");
        String pass = ConfigReader.getProperty("password_for_erp");
        ContactPage contactPage = new ContactPage();
        contactPage.login(user,pass);
        Thread.sleep(2000);
        contactPage.contacts.click();
        contactPage.createButton.click();
        contactPage.inputName.sendKeys(data.get(1).get("Firstname"));


//        System.out.println(data.get(0).get("FirstName"));
//        System.out.println(data.get(1).get("Phone"));
//        System.out.println(data.get(0).get("LastName"));









    }
}
