package com.techproed.Batch3SeleniumPractice.Day5;

import com.techproed.utilities.TestBase;
import com.techproed.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TestCase2 extends TestBaseCross {
    /*
    1.Go to ”https://www.mediawiki.org/wiki/Download”
2.Click Download MediaWiki 1.34.2
3.Verify the file is downloaded
     */

    @Test
    public void TestCase2()  throws InterruptedException  {

        driver.get("https://www.mediawiki.org/wiki/Download");

      WebElement username = driver.findElement(By.xpath("(//a[@class=\"extiw\"])[1]"));
      username.click();

      Thread.sleep(5000);
     String userfolder = System.getProperty("user.home");
     String download = userfolder+"\\Downloads\\mediawiki-1.35.0.tar.gz";

     boolean isDownload = Files.exists(Paths.get(download));

        Assert.assertTrue(isDownload);





    }
}
