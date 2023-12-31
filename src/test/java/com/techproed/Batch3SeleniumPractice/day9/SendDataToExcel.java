package com.techproed.Batch3SeleniumPractice.day9;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendDataToExcel {

    @Test
    public void Send() throws IOException {
        String path= "C:\\Users\\Administrator\\IdeaProjects\\testNGframework\\src\\test\\java\\resources\\medal table .xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("medal");
       // int lastrow = sheet.getLastRowNum();
        int lastCell = sheet.getRow(11).getLastCellNum();
        System.out.println(lastCell);

        List<String> infoAust = new ArrayList<>();
        for (int i = 1; i < lastCell; i++) {
            infoAust.add(sheet.getRow(11).getCell(i).toString());
        }
        System.out.println(infoAust);

        Sheet sheet2 = workbook.getSheet("Sheet1");
        sheet2.getRow(3).createCell(1).setCellValue("asfsaf");
//       Sheet sheet1 = workbook.getSheetAt(0);
//      //  Sheet sheet1 = workbook.getSheet("medal_table");
//        for (int i = 0; i < infoAust.size(); i++) {
//            sheet2.getRow(3).createCell(i).setCellValue(infoAust.get(i));
//        }

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }
}
