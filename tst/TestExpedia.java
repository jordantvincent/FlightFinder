import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.ArrayList;


public class TestExpedia {
    private static WebDriver driver;
    private Expedia expedia = new Expedia(driver);
    private static LocalDate date = LocalDate.of(2020, 8, 7);
    private String departingFrom = "Atlanta Hartsfield";
    private ArrayList<String> listOfDestinations = new ArrayList<>() {
        {
            add("Cancun");
            add("Las Vegas");
            add("Denver");
            add("Rome");
            add("Milan");
            add("Paris");
            add("Madrid");
            add("Amsterdam");
            add("Singapore");
        }
    };

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-single-click-autofill");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testExpediaFlightPrices() {
        for (String destination : listOfDestinations
        ) {
            drawDestination(destination);
            while (date.getMonth().getValue() <= 8) {
                if (date.getMonth().getValue() == 8 && date.plusDays(6).getDayOfMonth() <= 15) {
                    flyExpedia(destination);
                } else if (date.getMonth().getValue() == 8) {
                    break;
                } else {
                    flyExpedia(destination);
                }
            }
            resetDate();
        }

    }

    private void flyExpedia(String destination) {
        expedia.getFlightPage();
        expedia.setFlightOptions();
        expedia.setOrigin(departingFrom);
        expedia.setDestination(destination);
        expedia.setDepartingDate(date);
        expedia.setReturningDate(date.plusDays(6));
        double price = getPrice();
        System.out.printf("Departure: " + date+ " | Return: " + date.plusDays(6) + " | Price: %.2f\n", price);
        expedia.getListOfCheapestFlights().put(destination +
                " " + date.toString() +
                " " + date.plusDays(6).toString(), price);
        date = date.plusDays(1);
        Assert.assertTrue(price > 0);

    }

    private double getPrice() {
        WebElement cheapest = null;
        try {
            cheapest = (new WebDriverWait(driver, 30))
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.cssSelector("a[data-omniture-rfrr*=\".Cheapest\"]")));
        } catch (TimeoutException ex) {
            cheapest = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.cssSelector("a[data-omniture-rfrr*=\".BestValue\"]")));
        }

        return Double.parseDouble(cheapest.getAttribute("data-exact-price"));
    }

    private void resetDate() {
        date = LocalDate.of(2020, 8, 7);
    }

    private void drawDestination(String destination) {
        for (int i = 0; i < 3; i++) {
            if (i == 0 || i == 2) {
                for (int j = 0; j < 58; j++) {
                    System.out.print("=");
                }
            }
            else {
                System.out.print("|");
                for (int j = 0; j < ((58-destination.length())/2) - 1; j++) {
                    System.out.print(" ");
                }
                System.out.print(destination);
                for (int j = 0; j < ((58-destination.length())/2) - 1; j++) {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
