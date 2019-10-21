package com.company;

import org.openqa.selenium.WebDriver;

public class Flight {

    //The goal here is to create a flight object that had the redundant information stored, I may have use "final" wrong
    private final String departingAirport = "Atlanta Hartsfield";
    private final String destination = "Cancun";
    private String departureDate;
    private String returnDate;

//default constructor for a flight object
    public Flight(String departureDate, String returnDate) {
        this.departureDate = departureDate;
        this.returnDate = returnDate;
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

    public Flight[] createFlights() {
        Flight[] flights = new Flight[60];
        //initialize all of the flights Departing in November
        flights[0] = new Flight("11/01/2019", "11/08/2019");
        flights[1] = new Flight("11/02/2019", "11/09/2019");
        flights[2] = new Flight("11/03/2019", "11/10/2019");
        flights[3] = new Flight("11/04/2019", "11/11/2019");
        flights[4] = new Flight("11/05/2019", "11/12/2019");
        flights[5] = new Flight("11/06/2019", "11/13/2019");
        flights[6] = new Flight("11/07/2019", "11/14/2019");
        flights[7] = new Flight("11/08/2019", "11/15/2019");
        flights[8] = new Flight("11/09/2019", "11/16/2019");
        flights[9] = new Flight("11/10/2019", "11/17/2019");
        flights[10] = new Flight("11/11/2019", "11/18/2019");
        flights[11] = new Flight("11/12/2019", "11/19/2019");
        flights[12] = new Flight("11/13/2019", "11/20/2019");
        flights[13] = new Flight("11/14/2019", "11/21/2019");
        flights[14] = new Flight("11/15/2019", "11/22/2019");
        flights[15] = new Flight("11/16/2019", "11/23/2019");
        flights[16] = new Flight("11/17/2019", "11/24/2019");
        flights[17] = new Flight("11/18/2019", "11/25/2019");
        flights[18] = new Flight("11/19/2019", "11/26/2019");
        flights[19] = new Flight("11/20/2019", "11/27/2019");
        flights[20] = new Flight("11/21/2019", "11/28/2019");
        flights[21] = new Flight("11/22/2019", "11/29/2019");
        flights[22] = new Flight("11/23/2019", "11/30/2019");
        flights[23] = new Flight("11/24/2019", "12/01/2019");
        flights[24] = new Flight("11/25/2019", "12/02/2019");
        flights[25] = new Flight("11/26/2019", "12/03/2019");
        flights[26] = new Flight("11/27/2019", "12/04/2019");
        flights[27] = new Flight("11/28/2019", "12/05/2019");
        flights[28] = new Flight("11/29/2019", "12/06/2019");
        flights[29] = new Flight("11/30/2019", "12/07/2019");
        //Initialize all flights departing in December
        flights[30] = new Flight("12/01/2019", "12/08/2019");
        flights[31] = new Flight("12/02/2019", "12/09/2019");
        flights[32] = new Flight("12/03/2019", "12/10/2019");
        flights[33] = new Flight("12/04/2019", "12/11/2019");
        flights[34] = new Flight("12/05/2019", "12/12/2019");
        flights[35] = new Flight("12/06/2019", "12/13/2019");
        flights[36] = new Flight("12/07/2019", "12/14/2019");
        flights[37] = new Flight("12/08/2019", "12/15/2019");
        flights[38] = new Flight("12/09/2019", "12/16/2019");
        flights[39] = new Flight("12/10/2019", "12/17/2019");
        flights[40] = new Flight("12/11/2019", "12/18/2019");
        flights[41] = new Flight("12/12/2019", "12/19/2019");
        flights[42] = new Flight("12/13/2019", "12/20/2019");
        flights[43] = new Flight("12/14/2019", "12/21/2019");
        flights[44] = new Flight("12/15/2019", "12/22/2019");
        flights[45] = new Flight("12/16/2019", "12/23/2019");
        flights[46] = new Flight("12/17/2019", "12/24/2019");
        flights[47] = new Flight("12/18/2019", "12/25/2019");
        flights[48] = new Flight("12/19/2019", "12/26/2019");
        flights[49] = new Flight("12/20/2019", "12/27/2019");
        flights[50] = new Flight("12/21/2019", "12/28/2019");
        flights[51] = new Flight("12/22/2019", "12/29/2019");
        flights[52] = new Flight("12/23/2019", "12/30/2019");
        flights[53] = new Flight("12/24/2019", "12/31/2019");
        flights[54] = new Flight("12/25/2019", "01/01/2019");
        flights[55] = new Flight("12/26/2019", "01/02/2019");
        flights[56] = new Flight("12/27/2019", "01/03/2019");
        flights[57] = new Flight("12/28/2019", "01/04/2019");
        flights[58] = new Flight("12/29/2019", "01/05/2019");
        flights[59] = new Flight("12/30/2019", "01/06/2019");
        flights[60] = new Flight("12/31/2019", "01/07/2019");


        return flights;
    }

}
