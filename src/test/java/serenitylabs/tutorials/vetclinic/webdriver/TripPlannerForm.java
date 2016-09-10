package serenitylabs.tutorials.vetclinic.webdriver;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.ArriveBefore;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.LeaveAfter;

/**
 * Created by aatchoud on 9/11/2016.
 */
public class TripPlannerForm {

    static final Map<DeparturePreference,By> DEPARTURE_RADIO_BUTTONS = new HashMap<>();
    public static final By TRAVEL_DAY = By.id("itdDate");
    public static final By TIME_HOUR = By.id("itdTimeHour");
    public static final By TIME_MINUTE = By.id("itdTimeMinute");
    public static final By TO_STATION = By.id("display_destination");
    public static final By FROM_STATION = By.id("display_origin");

    static {
        DEPARTURE_RADIO_BUTTONS.put(ArriveBefore,By.id("itdTripDateTimeArr"));
        DEPARTURE_RADIO_BUTTONS.put(LeaveAfter,By.id("itdTripDateTimeDep"));
    }

    public static final By SUBMIT_BUTTON = By.id("btnTripPlannerSubmit");

    public static By departureButtonfor(DeparturePreference departurePreference) {
        return DEPARTURE_RADIO_BUTTONS.get(departurePreference);
    }

}
