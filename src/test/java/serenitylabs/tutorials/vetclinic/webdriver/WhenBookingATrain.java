package serenitylabs.tutorials.vetclinic.webdriver;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.ArriveBefore;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.LeaveAfter;
import static serenitylabs.tutorials.vetclinic.webdriver.TravelDay.Tomorrow;

public class WhenBookingATrain {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://www.sydneytrains.info/");
    }

    @Test
    public void should_be_able_to_plan_a_trip() {

        Traveller traveller = new Traveller(driver);

        traveller.depatureStationIs("Town Hall");
        traveller.arrivalStationIs("Parramatta");
        traveller.theTrainShould(ArriveBefore,10,15,Tomorrow);
        traveller.planTrip();


        List<WebElement> optionsForTrip = driver.findElements(By.className("journeyValue"));
        assertThat(optionsForTrip.size(), is(greaterThan(0)));

        TripPreferences displayedTripPreferences = traveller.displayedTripPreferences();

        TripPreferences expectedTripPreferences
                            = TripPreferences
                            .arrivingOrDeparting("arrive before")
                            .from("Town Hall Station, Sydney")
                            .to("Parramatta Station, Parramatta")
                            .arrivingOn("Tomorrow")
                            .at("10","15");
        assertThat(displayedTripPreferences,equalTo(expectedTripPreferences));

    }









    @After
    public void shutdown() {
      driver.quit();
    }
}
