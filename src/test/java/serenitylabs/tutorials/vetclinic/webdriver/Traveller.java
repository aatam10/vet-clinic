package serenitylabs.tutorials.vetclinic.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.ArriveBefore;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.LeaveAfter;

/**
 * Created by aatchoud on 9/11/2016.
 */
public class Traveller {
    private final WebDriver driver;

    Traveller(WebDriver driver) {
        this.driver = driver;
    }



    public void planTrip() {
        driver.findElement(TripPlannerForm.SUBMIT_BUTTON).click();
    }


    private static final DecimalFormat TIME_UNIT_FORMAT = new DecimalFormat("##");
    public void theTrainShould(DeparturePreference departurePreference,
                                int hour,
                                int minute,
                                TravelDay travelDay) {
        driver.findElement(TripPlannerForm.departureButtonfor(departurePreference)).click();

        Select selectTimeDay = new Select(driver.findElement(TripPlannerForm.TRAVEL_DAY));
        selectTimeDay.selectByIndex(travelDay.getDaysInFuture());

        Select selectTimeHour = new Select(driver.findElement(TripPlannerForm.TIME_HOUR));
        selectTimeHour.selectByVisibleText(TIME_UNIT_FORMAT.format(hour));

        Select selectTimeMinute = new Select(driver.findElement(TripPlannerForm.TIME_MINUTE));
        selectTimeMinute.selectByVisibleText(TIME_UNIT_FORMAT.format(minute));
    }



    public void arrivalStationIs(String station) {
        driver.findElement(TripPlannerForm.TO_STATION).sendKeys(station);
    }


    public void depatureStationIs(String station) {
        driver.findElement(TripPlannerForm.FROM_STATION).sendKeys(station);
    }


    public TripPreferences displayedTripPreferences() {

        String fromStation = driver.findElement(TripSummaryView.ORIGIN).getAttribute("value");
        String toStation = driver.findElement(TripSummaryView.DESTINATION).getAttribute("value");
        String arriveOrDepart = new Select(driver.findElement(TripSummaryView.ARRIVE_DEPART)).getFirstSelectedOption().getText();
        String selectedHour = new Select(driver.findElement(TripSummaryView.HOUR)).getFirstSelectedOption().getText();
        String selectedMinute = new Select(driver.findElement(TripSummaryView.MINUTE)).getFirstSelectedOption().getText();
        String selectedDay = new Select(driver.findElement(TripSummaryView.DAY)).getFirstSelectedOption().getText();

        return TripPreferences.arrivingOrDeparting(arriveOrDepart)
                .from(fromStation)
                .to(toStation)
                .arrivingOn(selectedDay)
                .at(selectedHour,selectedMinute);

    }
}
