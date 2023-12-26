package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class isExistClass extends TestBase {

    /*
    package com.techproed.tests;
import org.testng.annotations.Test;
public class IsExistClass {
    @Test
    public void isExist(){
    }
}
     */
    @Test
    public void isExist() {
//We will use JAVA to check if a file exist or not .

        //Check if the Flower image is existing on your desktop
        //Find the path of the image
        String pathOfFile="C:\\Users\\Administrator\\Desktop\\FLOWER. IMG.jpg";
        //shortcut shift and rightclick to get path
        //We will use JAVA to check if a file exist or not.

       boolean isExist= Files.exists(Paths.get(pathOfFile));
        //Assert if the path exist

        Assert.assertTrue(isExist);

    }

}
