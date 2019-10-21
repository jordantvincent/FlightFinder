package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    private static WebDriver driver;

    public static void main(String[] args) {

    //CHROME DRIVER SETUP

    //Each of us will have a different file path so just comment out the other one while you work
        System.setProperty("webdriver.chrome.driver","C:\\Users\\theli\\Desktop\\chromedriver.exe"); // Jordan's File Path
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Desktop\\chromedriver.exe"); // Ethan's File Path

        driver = new ChromeDriver();

        driver.get("https://www.expedia.com/Flights");



        WebElement departureLocation = driver.findElement(By.id("flight-origin-flp"));
        departureLocation.sendKeys("Atlanta Hartsfield");

        WebElement destinationLocation = driver.findElement(By.id("flight-destination-flp"));
        destinationLocation.sendKeys(" Cancun");

        WebElement departingDate = driver.findElement(By.id("flight-departing-flp"));
        departingDate.sendKeys("10/12/2019");

        //I am having trouble with getting the text deleted in this field in order to submit a new date
        WebElement returnDate = driver.findElement(By.id("flight-returning-flp"));
        returnDate.clear();


    }


}
