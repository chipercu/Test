package org.example.TestNG_paralel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static final String url = "https://configurator.bitrixdemo.ru/configurators/pc/";
    public static WebDriver driver;


    public Driver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/WebDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("Open browser, url = " + url);

    }

    public void quit(){
        driver.quit();
    }

    public WebElement findElement(String xpath) throws InterruptedException {
        Thread.sleep(100);
        return driver.findElement(By.xpath(xpath));
    }



}
