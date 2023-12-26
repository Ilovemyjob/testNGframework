package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebTables extends TestBase {
    /*
    Create a class: WebTables
Create a method: login()
Log in  http://www.kaolapalace-qa-environment2.com/
//Click on Hotel Management
//Click on Hotel Rooms
     */

    //PRE CONDITION. THIS IS NOT A TEST CASE


    public void login() {
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainPageLoginButton = driver.findElement(By.linkText("Log in"));
        mainPageLoginButton.click();
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();
        //Click on Hotel Management
        WebElement hotelManagement = driver.findElement(By.linkText("Hotel Management"));
        hotelManagement.click();
        //Click on Hotel Rooms
        WebElement hotelRooms = driver.findElement(By.partialLinkText("Hotel Rooms"));
        hotelRooms.click();


    }
//    Create a test method: entireTable() and Find the size of the entire table body and print all of headers
//    Create a test method: printRows() and Print all of the rows and print the element s on the 4th row
//    Create a test method: printCells() and Find the total number of cells in the table body and print all of the cells
//    Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 5th column
//    Create a test method: printData(int row, int column); This method should print the given cell. Example: printData(2,3); should print 2nd row,3rd column

    @Test
    public void entireTable() throws InterruptedException {
        login();//

        Thread.sleep(5000);
        WebElement tBody = driver.findElement(By.xpath("//tbody"));
        //We can identify table body using tagName
        //   WebElement tBodyTag = driver.findElement(By.tagName("tbody")); =>same

        System.out.println(tBody.getText());


        // Find the size of the entire table body
        List<WebElement> tableData = driver.findElements(By.xpath("//td"));
        System.out.println(tableData.size());


//       for (WebElement eachData :
//              tableData) {
//           System.out.println(eachData.getText());
//       }

        List<WebElement> allHeaders = driver.findElements(By.xpath("//th"));
        for (WebElement eachHeaders :
                allHeaders) {
            System.out.println(eachHeaders.getText());
        }
        //        what is diffrence for each and tBody.getText()
        //Answer: In for each, i get each data one by one and print them one by one.
        //  tBody gives me one SINGLE element that has ALL OF THE DATA AS A WHOLE.

    }

//    Create a test method: printRows() and Print all of the rowsinthe Table body and print the element s on the 4th row

    @Test
    public void printRows() {
        login();//


        //and Print all of the rows in the TABLE BODY
        List<WebElement> allRows = driver.findElements(By.xpath("//table//tr"));
        for (WebElement eachRows :
                allRows) {
            System.out.println(eachRows.getText());


        }
        System.out.println("=================");
        //and print the elements on the 4th row
        WebElement forth = driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println(forth.getText());


    }

    //    Create a test method: printCells() and Find the total number of cells in the table body and print all of the cells=//td
    @Test
    public void printCells() {
        login();//


        //and Find the total number of cells in the table body and print all of the cells
        List<WebElement> allCells = driver.findElements(By.xpath("//tbody//td"));
        System.out.println(allCells.size());
        for (WebElement eachCells :
                allCells) {
            System.out.println(eachCells.getText());
        }

    }

    //    Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 5th column
    @Test
    public void printColumns() throws InterruptedException {
        login();//

        //and print Find the total number of columns
        List<WebElement> allcolumn = driver.findElements(By.xpath("//thead//th"));////tr[1]//td;//th;//thead//th

        System.out.println(allcolumn.size());

        //and Print the elements of the 5th column
        Thread.sleep(5000);

        List<WebElement> fifth = driver.findElements(By.xpath("//td[5]"));
        //    //tr//td[5]  => give me 5th elements on each row
        for (WebElement eachfifth :
                fifth) {
            System.out.println(eachfifth.getText());
        }


    }

    //Homework
/*
Create a test method: webTableHW
Test if the 6th column includes price of 1000
Test if the first table row has Orlando
Test if the  4th column has a Hotel name called Hilton
 */
    @Test
    public void webTableHW() {
        login();//

        List<WebElement> sixthColumn = driver.findElements(By.xpath("//td[6]"));
        //   System.out.println(sixthColumn);

        for (WebElement eachCoulumn :
                sixthColumn) {

            System.out.println(eachCoulumn.getText());


            Assert.assertFalse(eachCoulumn.getText().contains("1000"));

        }


        List<WebElement> firstRow = driver.findElements(By.xpath("//tbody//tr[1]"));
        for (WebElement eachRow :
                firstRow) {

            Assert.assertTrue(eachRow.getText().contains("Orlando"));
        }

        List<String> list = new ArrayList<>();
        List<WebElement> fourthColumn = driver.findElements(By.xpath("//td[4]"));
        for (WebElement eachCoulumn :
                fourthColumn) {
            list.add(eachCoulumn.getText());
            //  Assert.assertTrue(eachCoulumn.getText().contains("Hilton"));
        }
        Assert.assertTrue(list.contains("Hilton"));
        //  Assert.assertFalse(firstRow.contains("Hilton"));

//   Create a test method: printData(int row, int column); This method should print the given cell. Example: printData(2,3); should print 2nd row,3rd column

    }

    // printData(3,6); => print the data in row 3 column 6
//Create a test method: printData(int row, int column);
// This method should print the given cell. Example: printData(2,3);
// should print 2nd row,3rd column
    //This custom method will take a row, and a column number
    //and print the data on that row and column
    //This will not be a test method, but this will be a custom method
//    public void printData(int row, int column) {
//
////        String xPath="//tbody//tr[9]//td[5]";//NJ
////        String xPath2="//tbody//tr[2]//td[3]";//12746376
//        //Only the index numbers keep changing in the webtable xpath
//        String xPath = "//tbody//tr[" + row + "]//td[" + column + "]";
//        WebElement data = driver.findElement(By.xpath(xPath));
//        System.out.println(data);
//
//    }
//
//    @Test
//    public void printTestData() {
//        login();//
//
//        printData(2, 3);


//   Create a test method: printData(int row, int column);
//   This method should print the given cell.
//   Example: printData(2,3); should print 2nd row,3rd column
 //   }

        public void printData(int row,int column){
        String xPath2="//tbody//tr["+row+"]//td["+column+"]";
        WebElement data =driver.findElement(By.xpath(xPath2));
        System.out.println(data.getText());
    }

    @Test
    public void print(){
        login();
        printData(4,3);
    }

}