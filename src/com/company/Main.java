package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    private static WebDriver driver;

    public static void main(String[] args) {
    //CHROME DRIVER SETUP

    //Each of us will have a different file path so just comment out the other one while you work
        System.setProperty("webdriver.chrome.driver","C:\\Users\\theli\\Desktop\\chromedriver.exe"); // Jordan's File Path
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Desktop\\chromedriver.exe"); // Ethan's File Path

        driver = new ChromeDriver();

        driver.get("http://www.google.com");
    }

}
