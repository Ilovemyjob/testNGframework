package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {

    @Test
    public void logIn(){

        System.out.println("Log in TEST");
    }
    @Test
    public void homePage(){
        System.out.println("Home Page Test");
        Assert.assertEquals(3,4);
    }
    //i wanna searchTest to be dependent on homePage.
    //i wanna searchTest skipped if homePage fail
    @Test(dependsOnMethods ="homePage" )
    public void searchTest(){
        System.out.println("Search Test");

    }
    @Test
    public void verifyTheResult(){
        System.out.println("Result Test");

    }




}
