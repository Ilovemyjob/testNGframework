package com.techproed.excelautomation;

import com.techproed.pages.DataTablesPage;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import com.techproed.utilities.ReusableMethods;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ExcelAutomation {


    ExcelUtil excelUtil;
    List<Map<String, String>> testData;
    DataTablesPage dtPage = new DataTablesPage();

    @Test
    public void excelAutomation() {
        //get excel
        excelUtil = new ExcelUtil("./src/test/java/resources/exceldata.xlsx", "data");
        //get map of list
        testData = excelUtil.getDataList();
//       System.out.println(testData);
        for (Map<String, String> appData : testData) {
           System.out.println(appData.get("lastname"));
//            System.out.println(appData);
//            System.out.println(appData.get("position"));//We will use this logic to get the value of each column
            Driver.getDriver().get("https://editor.datatables.net/");
//
            dtPage.newButton.click();
            dtPage.firstName.sendKeys(appData.get("firstname"));
            dtPage.lastName.sendKeys(appData.get("lastname"));
            dtPage.position.sendKeys(appData.get("position"));
            dtPage.office.sendKeys(appData.get("office"));
            dtPage.extension.sendKeys(appData.get("extension"));
            dtPage.startDate.sendKeys(appData.get("startdate"));
            // to not get error data sent different if we not use
            dtPage.day.click();
            dtPage.salary.sendKeys(appData.get("salary"));
            dtPage.createButton.click();
            dtPage.searchBox.sendKeys(appData.get("firstname"));
            ReusableMethods.waitFor(1);
//
//                Assert.assertTrue(dtPage.nameField.getText().contains(appData.get("firstname")));
        }


    }


}
