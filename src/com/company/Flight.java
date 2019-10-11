package com.company;

import org.openqa.selenium.WebDriver;

public class Flight {

    //The goal here is to create a flight object that had the redundant information stored, I may have use "final" wrong
    private final String departingAirport = "Atlanta Hartsfield";
    private final String destination = "Cancun";
    private String departureDate;
    private String returnDate;
    private WebDriver driver;

//default constructor for a flight object
    public Flight(String departureDate, String returnDate, WebDriver driver) {
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.driver = driver;
    }

    public String getDepartingAirport() {
        return departingAirport;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

}
