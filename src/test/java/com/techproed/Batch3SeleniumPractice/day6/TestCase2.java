package com.techproed.Batch3SeleniumPractice.day6;

import com.techproed.pages.DemogaWebTables;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class TestCase2 extends TestBase {
    /*
    1.Go to ” https://demoqa.com/webtables”
2.Print Department from the headers
3.Print  the department name of Alden
     */
    @Test
    public void demoga(){

        driver.get("https://demoqa.com/webtables");

   //     DemogaWebTables demogaWebTables =new DemogaWebTables(driver);
             DemogaWebTables demogaWebTables =new DemogaWebTables();

        String Textdepartment=demogaWebTables.department.getText();
        String TextdepartmentOfAlden=demogaWebTables.departmentOfAlden.getText();

        System.out.println(Textdepartment);//sonuna .sout yaz sonra enter
        System.out.println(TextdepartmentOfAlden);

         // xpath can go back with  /..
        //div[@class='rt-tbody']//div[text()='Alden']/..

        System.out.println(demogaWebTables.DepName("Kierra",3));

    }
}
