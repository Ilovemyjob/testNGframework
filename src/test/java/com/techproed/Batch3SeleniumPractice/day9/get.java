package com.techproed.Batch3SeleniumPractice.day9;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class get{
    @Test
    public void Test() throws IOException {

        String pathOfTable= "C:\\Users\\Administrator\\IdeaProjects\\testNGframework\\src\\test\\java\\resources\\medal table .xlsx";

        FileInputStream fileInputStream = new FileInputStream(pathOfTable);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("medal");
        Row row =sheet.getRow(2);
      //  System.out.println(row);
        Cell cell = row.getCell(1);
        System.out.println(cell);

        for (int i = 0; i <sheet.getLastRowNum() ; i++) {
            System.out.println(sheet.getRow(i).getCell(1));

        }

        List<String> list = new ArrayList<>();
        for (int i = 2; i < sheet.getLastRowNum(); i++) {
            String country = sheet.getRow(i).getCell(1).toString();
            list.add(country);
        }
        System.out.println(list);
        System.out.println("-----------");

        List<String>  listall   = new ArrayList<>();
        for (int i = 2; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j<sheet.getRow(i).getLastCellNum() ; j++) {
               String all= sheet.getRow(i).getCell(j).toString();
                listall.add(all);
            }
        }
        System.out.println(listall);













    }
}
