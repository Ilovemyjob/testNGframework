package com.techproed.Batch3SeleniumPractice.day9;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetDatafromExel {

    @Test
    public void read() throws IOException {
        String pathOfTable= "C:\\Users\\Administrator\\IdeaProjects\\testNGframework\\src\\test\\java\\resources\\medal table .xlsx";
        FileInputStream fileInputStream = new FileInputStream(pathOfTable);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

       // Sheet sheet = workbook.getSheetAt(0);
        //2. way to go tot table
        Sheet sheet = workbook.getSheet("medal");
        Row row = sheet.getRow(6);
        Cell cell = row.getCell(1);
        System.out.println(cell);

        System.out.println("=");
        System.out.println(row.getCell(2));

        Row row2 = sheet.getRow(8);
        Cell cell2 = row2.getCell(1);
        System.out.println(cell2);
        System.out.println("===");


        for (int i = 2; i <sheet.getLastRowNum() ; i++) {
            System.out.println(sheet.getRow(i).getCell(1));
        }

        System.out.println("===");
        List<String> country1=new ArrayList<>();
        for(int i=1;i<=sheet.getLastRowNum();i++){
            String country=sheet.getRow(i).getCell(1).toString();
            country1.add(country);
        }
        System.out.println(country1);






    }
}
