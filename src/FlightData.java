import java.time.LocalDate;

public interface FlightData {
    void getFlightPage();
    void setFlightOptions();
    void setOrigin(String flyingFrom);
    void setDestination(String flyingTo);
    void setDepartingDate(LocalDate departingDate);
    void setReturningDate(LocalDate returningDate);
    void getFlights();
}
