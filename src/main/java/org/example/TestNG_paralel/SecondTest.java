package org.example.TestNG_paralel;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondTest {

    private Driver driver;


    @BeforeMethod
    public void before(){
        driver = new Driver();

    }

    @Test
    public void test2() throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            driver.findElement("//*[@id=\"step_12\"]/div[1]/div[3]/button[1]").click();
            driver.findElement("//*[@id=\"modalProducts\"]/div/div/div[1]/button/span").click();
            driver.findElement("//*[@id=\"step_5\"]/div[1]/div[3]/button[1]").click();
            driver.findElement("//*[@id=\"modalProducts\"]/div/div/div[1]/button/span").click();
            driver.findElement("//*[@id=\"step_18\"]/div[1]/div[3]/button[1]").click();
            driver.findElement("//*[@id=\"modalProducts\"]/div/div/div[1]/button/span").click();

        }
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }



}
