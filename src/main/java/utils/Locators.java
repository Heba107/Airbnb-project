package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Locators extends SeleniumBase {

    public By homePageSearch = By.xpath("//div[@role='search']/button[1]");
    public By countrySelection = By.id("bigsearch-query-location-input");
    public By checkIn = By.xpath("//div[@data-testid='structured-search-input-field-split-dates-0']");


    public By generateCheckInDate(int days) {
        LocalDate currentDate = LocalDate.now().plusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = currentDate.format(formatter);

        String output = String.format("calendar-day-%s", formattedDate);
        String xpathExpression = "//div[@data-testid='%s']";
        return By.xpath(String.format(xpathExpression, output));
    }

    public By generateCheckOutDate(int days) {
        LocalDate currentDatechekout = LocalDate.now().plusDays(10);
        DateTimeFormatter formatterchekout = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDatechekout = currentDatechekout.format(formatterchekout);

        String outputchekout = String.format("calendar-day-%s", formattedDatechekout);
        String xpathExpressionchekout = "//div[@data-testid='%s']";
        return By.xpath(String.format(xpathExpressionchekout, outputchekout));
    }

    public By selectguests = By.xpath("//div[@data-testid='structured-search-input-field-guests-button']");
    public By selectadult = By.xpath("//button[@data-testid='stepper-adults-increase-button']");
    public By selectchildren = By.xpath("//button[@data-testid='stepper-children-increase-button']");
    public By search = By.xpath("//button[@data-testid='structured-search-input-search-button']");
    public By actualdestination= By.xpath("//div[@data-testid='little-search']/button[1]/div");
    public By actualguest = By.xpath("//div[@data-testid='little-search']/button[3]");

    public By assertCheckDate(int days) {
        String month1 = LocalDate.now().getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        int dayOfMonth1 = LocalDate.now().getDayOfMonth();

        String month2 = LocalDate.now().plusDays(10).getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        int dayOfMonth2 = LocalDate.now().plusDays(10).getDayOfMonth();

        String output1 = String.format("%s %s – %s", month1, dayOfMonth1, dayOfMonth2);

        String output2 = String.format("%s %s – %s %s", month1, dayOfMonth1, month2, dayOfMonth2);

        String actual3 =driver.findElement(By.xpath("//div[@class='cs3bjhu dir dir-ltr']/button[2]/div")).getText();


       if (month1.equals(month2)) {
            Assert.assertEquals(actual3, output1);
        } else {
            Assert.assertEquals(actual3, output2);

        }
        return By.xpath(String.format(actual3, output1,output2));
    }
}
