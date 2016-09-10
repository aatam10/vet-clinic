package serenitylabs.tutorials.vetclinic.webdriver;

import net.serenitybdd.core.annotations.findby.By;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.openqa.selenium.By.id;

public class WhenLocatingElements {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://todomvc.com/examples/dojo");
    }

    @Test
    public void finding_the_new_todo_field_by_id() {

        WebElement todoField = driver.findElement(By.id("new-todo"));

        assertThat(todoField.getAttribute("placeholder"), equalTo("What needs to be done?"));
    }

    @Test
    public void finding_the_quote_by_tag() {
        WebElement quote = driver.findElement(By.tagName("blockquote"));

        assertThat(quote.getText(), containsString("Dojo saves you time"));
    }


    @Test
    public void finding_the_source_link_by_link_text() {
        WebElement completedButton = driver.findElement(By.linkText("Source"));

        assertThat(completedButton.getText(), equalTo("Source"));

    }


    @Test
    public void finding_the_new_todo_field_by_css() {
        WebElement todoField = driver.findElement(By.cssSelector("#new-todo"));

        assertThat(todoField.getAttribute("placeholder"), equalTo("What needs to be done?"));
    }

    @Test
    public void finding_the_new_todo_field_by_class() {
        WebElement quote = driver.findElement(By.className("quote"));

        assertThat(quote.getText(), containsString("Dojo saves you time"));
    }

    @Test
    public void finding_the_quote_by_css() {
        WebElement quote = driver.findElement(By.cssSelector(".quote"));

        assertThat(quote.getText(), containsString("Dojo saves you time"));
    }

    @Test
    public void finding_the_new_todo_field_by_xpath() {
        WebElement todoField = driver.findElement(By.xpath("//input[@id='new-todo']"));

        assertThat(todoField.getAttribute("placeholder"), equalTo("What needs to be done?"));
    }


    @Test
    public void finding_the_todo_entries_by_css() {
        addTodo("Buy some milk");
        addTodo("Walk the dog");
        addTodo("Feed the cat");

        List<WebElement> todoItems = driver.findElements(By.cssSelector("#todo-list li"));

        assertThat(todoItems.size(), equalTo(3));
    }

    private void addTodo(String item) {
        WebElement todoInputField = driver.findElement(By.cssSelector("#new-todo"));
        todoInputField.sendKeys(item);
        todoInputField.sendKeys(Keys.RETURN);
    }

    @After
    public void shutdown() {
        driver.quit();
    }
}
