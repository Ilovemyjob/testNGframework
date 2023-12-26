package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemogaWebTables {


    WebDriver driver;

    public DemogaWebTables() {
     //   this.driver = driver;
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "(//div[@class='rt-resizable-header-content'])[6]")
                      //2.way div[@class='rt-thead -header']/div/div[6]
    public WebElement department;

    @FindBy(xpath = "(//div[@class='rt-td'])[6]")
    public WebElement departmentOfAlden;





    public String DepName(String name, int colNum){
        WebElement depName1 =driver.findElement(By.xpath("//div[@class='rt-tbody']//div[text()='"+name+"']/../div["+colNum+"]"));
        return depName1.getText();
    }



}