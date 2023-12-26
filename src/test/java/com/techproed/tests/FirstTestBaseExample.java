package com.techproed.tests;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FirstTestBaseExample extends TestBase {
// This test case will call the setUp and tearDown methods in the TestBase bec. we extends TestBase
    @Test
    public  void test1(){

                driver.get("https://www.google.com/");
    }
}
