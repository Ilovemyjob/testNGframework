package com.techproed.Batch3SeleniumPractice.day6;

import com.techproed.pages.ZeroBankLogin;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.apache.poi.hssf.record.chart.DatRecord;
import org.testng.annotations.Test;


public class TestCase1 extends TestBase {

/*
Go to http://zero.webappsecurity.com/
 2. Write a useful method which is named login() under the
    practicePage
3. Call the login method from TestCase1 class.
 */

@Test
    public void zero(){

 //   driver.get("http://zero.webappsecurity.com/");
    driver.get(ConfigReader.getProperty("zeroLink"));

  //  ZeroBankLogin zeroBankLogin = new ZeroBankLogin(driver);
      ZeroBankLogin zeroBankLogin = new ZeroBankLogin();

//
//    zeroBankLogin.zeroBankSignin.click();
//
//    zeroBankLogin.zeroBankLogin.sendKeys("abc");
//
//    zeroBankLogin.zeroBankPass.sendKeys("123");
//
//    zeroBankLogin.zeroBankSignin2.click();


    zeroBankLogin.zeroLogin();



}
}
