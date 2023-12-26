package com.techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //This class will Read Data From configiration.properties file

    //create a properties instance.Data type =Properties,instanse name = properties

    private static Properties properties;
    static {  //staticblock=run first
    //path of the configuration.properties file
    String path = "configuration.properties";

    FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream(path);
            //loading the file
            properties=new Properties();
            properties.load(fileInputStream);
            //closing the file
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    //Create a method to READ
    //This method will get the KEY and return the VALUE
    public static String getProperty(String key){
        return properties.getProperty(key);

    }
    //TESTING IF OUR LOGIC WORKS
//    public static void main(String[] args) {
//        System.out.println(properties.getProperty("url"));
 //   }


}
