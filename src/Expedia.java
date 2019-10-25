import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Expedia implements FlightData {
    private WebDriver driver;
    private HashMap<String, Double> listOfCheapestFlights = new HashMap<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public Expedia(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void getFlightPage() {
        driver.get("https://www.expedia.com/");
    }

    @Override
    public void setFlightOptions() {
        // Currently set to roundtrip, nonstop, economy
        driver.findElement(By.id("tab-flight-tab-hp")).click();
/*
        // This code is ONLY unnecessary because the options are these by default when 'flights' is selected.
        // It appears to be necessary if using FireFox... this may cause some problems.
        driver.findElement(By.id("flight-advanced-options-hp-flight")).click();
        driver.findElement(By.id("advanced-flight-nonstop-label-hp-flight")).click();
        Select flightClass = new Select(driver.findElement(By.id("flight-advanced-preferred-class-hp-flight")));
        flightClass.selectByVisibleText("Economy/Coach");
*/
    }

    @Override
    public void setOrigin(String flyingFrom) {
        WebElement city = driver.findElement(
                By.xpath("//*[@id=\"flight-origin-hp-flight\"]"));
        city.click();
        city.sendKeys(flyingFrom);
    }

    @Override
    public void setDestination(String flyingTo) {
        WebElement city = driver.findElement(
                By.xpath("//*[@id=\"flight-destination-hp-flight\"]"));
        city.click();
        city.sendKeys(flyingTo);
    }

    @Override
    public void setDepartingDate(LocalDate departingDate) {
        String departingDateText = departingDate.format(formatter);
        WebElement departing = driver.findElement(By.id("flight-departing-hp-flight"));
        departing.click();
        departing.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        departing.sendKeys(departingDateText);
    }

    @Override
    public void setReturningDate(LocalDate returningDate) {
        String returningDateText = returningDate.format(formatter);
        WebElement returning = driver.findElement(By.id("flight-returning-hp-flight"));
        returning.click();
        returning.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        returning.sendKeys(returningDateText);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        returning.submit(); // This instead of getFlights(). Refer to getFlights() comment to see why.
    }

    @Override
    public void getFlights() {
        // This introduces a funny problem where Expedia at some point doesn't recognize 'Cancun' as a real place.
        WebElement search = driver.findElement(
                By.cssSelector("#gcw-flights-form-hp-flight > div.cols-nested.ab25184-submit > label > button"));
        search.click();
    }

    public HashMap<String, Double> getListOfCheapestFlights() {
        return listOfCheapestFlights;
    }

}
