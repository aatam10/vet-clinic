package serenitylabs.tutorials.vetclinic.webdriver;

import net.serenitybdd.core.annotations.findby.By;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WhenInteractingWithElementsAndForms {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://www.sydneytrains.info/");
    }

    @Test
    public void entering_a_field_value() {

        WebElement fromStation = driver.findElement(By.id("display_origin"));
        fromStation.sendKeys("Town Hall");
        String displayedValue = fromStation.getAttribute("value");
        assertThat(displayedValue, equalTo("Town Hall"));
    }


    @Test
        public void click_on_a_button() {

        driver.findElement(By.id("display_origin")).sendKeys("Town Hall");;
        driver.findElement(By.id("display_destination")).sendKeys("Parramatta");

        driver.findElement(By.id("btnTripPlannerSubmit")).click();

        String title = driver.findElement(By.tagName("H1")).getText();
        assertThat(title, is("Plan your trip"));
    }

    @Test
    public void click_on_a_checkbox() {

        WebElement rememberMeChkBox = driver.findElement(By.id("chkPlannerRemember"));

        rememberMeChkBox.click();

        Boolean rememberMeChoice = rememberMeChkBox.isSelected();
        assertThat(rememberMeChoice, is(true));
    }


    @Test
    public void click_on_a_radio_button() {

        WebElement arriveBefore = driver.findElement(By.id("itdTripDateTimeArr"));
        arriveBefore.click();

        String leaveOrArrivePreference = arriveBefore.getAttribute("value");

        assertThat(leaveOrArrivePreference, is("arr"));
    }


    @Test
    public void choose_a_dropdown_value() {
        // TODO: Click on 12pm
        //WebElement selectTimeHour = driver.findElement(By.id("itdTimeHour"));
        Select selectTimeHour = new Select(driver.findElement(By.id("itdTimeHour")));
        selectTimeHour.selectByValue("12");

        String selectedHour = selectTimeHour.getFirstSelectedOption().getText();

        assertThat(selectedHour, is("12"));
    }

    @After
    public void shutdown() {
        driver.quit();
    }
}
