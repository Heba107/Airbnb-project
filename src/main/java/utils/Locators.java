package utils;

import org.openqa.selenium.By;

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
        LocalDate currentDateCheckOut = LocalDate.now().plusDays(days);
        DateTimeFormatter formatterCheckOut = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDateCheckout = currentDateCheckOut.format(formatterCheckOut);

        String outputCheckOut = String.format("calendar-day-%s", formattedDateCheckout);
        String xpathExpressionCheckout = "//div[@data-testid='%s']";
        return By.xpath(String.format(xpathExpressionCheckout, outputCheckOut));
    }

    public By selectGuests = By.xpath("//div[@data-testid='structured-search-input-field-guests-button']");
    public By selectAdult = By.xpath("//button[@data-testid='stepper-adults-increase-button']");
    public By selectChildren = By.xpath("//button[@data-testid='stepper-children-increase-button']");
    public By search = By.xpath("//button[@data-testid='structured-search-input-search-button']");
    public By actualDestination = By.xpath("//div[@data-testid='little-search']/button[1]/div");
    public By actualGuest = By.xpath("//div[@data-testid='little-search']/button[3]");
    public By actualDates = By.xpath("//div[@class='cs3bjhu dir dir-ltr']/button[2]/div");
    public By maps = By.xpath("//div[@aria-roledescription='map']");

    public String assertCheckDate(int daysCheckIn, int daysCheckOut) {
        String month1 = LocalDate.now().plusDays(daysCheckIn).getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        int dayOfMonth1 = LocalDate.now().plusDays(daysCheckIn).getDayOfMonth();

        String month2 = LocalDate.now().plusDays(daysCheckOut).getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        int dayOfMonth2 = LocalDate.now().plusDays(daysCheckOut).getDayOfMonth();


        String output;
        if (month1.equals(month2)) {
            output = String.format("%s %s – %s", month1, dayOfMonth1, dayOfMonth2);
        } else {
            output = String.format("%s %s – %s %s", month1, dayOfMonth1, month2, dayOfMonth2);

        }
        return output;
    }
}
