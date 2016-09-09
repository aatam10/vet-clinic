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

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
        driver.findElement(By.id("display_origin")).sendKeys("Town Hall");
        driver.findElement(By.id("display_destination")).sendKeys("Parramatta");
        driver.findElement(By.id("itdTripDateTimeArr")).click();

        Select selectTimeDay = new Select(driver.findElement(By.id("itdDate")));
        selectTimeDay.selectByIndex(1);

        Select selectTimeHour = new Select(driver.findElement(By.id("itdTimeHour")));
        selectTimeHour.selectByVisibleText("10");

        Select selectTimeMinute = new Select(driver.findElement(By.id("itdTimeMinute")));
        selectTimeMinute.selectByVisibleText("15");

        driver.findElement(By.id("btnTripPlannerSubmit")).click();

        List<WebElement> optionsForTrip = driver.findElements(By.className("journeyValue"));

        assertThat(optionsForTrip.size(), is(greaterThan(0)));

        String fromStation = driver.findElement(By.id("name_origin")).getAttribute("value");
        String toStation = driver.findElement(By.id("name_destination")).getAttribute("value");
        String arriveBeforePreference = new Select(driver.findElement(By.id("SelectArriveDepart"))).getFirstSelectedOption().getText();
        String selectedHour = new Select(driver.findElement(By.id("selectHour"))).getFirstSelectedOption().getText();
        String selectedMinute = new Select(driver.findElement(By.id("selectMinute"))).getFirstSelectedOption().getText();
        String selectedDay = new Select(driver.findElement(By.id("itdDateDayMonthYear"))).getFirstSelectedOption().getText();

        assertThat(fromStation,containsString("Town Hall"));
        assertThat(toStation,containsString("Parramatta"));
        assertThat(arriveBeforePreference, equalTo("arrive before"));
        assertThat(selectedHour, equalTo("10"));
        assertThat(selectedMinute, equalTo("15"));
        assertThat(selectedDay,containsString("Tomorrow"));
    }

    @After
    public void shutdown() {
      driver.quit();
    }
}
