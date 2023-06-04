package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;
import utils.SeleniumBase;
import utils.WebActions;

public class Homepage {

    public void closeADsPopup(WebDriver driver) {
        SeleniumBase selenium = new SeleniumBase();
        By close = By.xpath("//span[@class='i9dqh6z dir dir-ltr']");
        selenium.seleniumWait(150, close);
        WebElement popUp = driver.findElement(close);
        popUp.click();
    }


    public void prepareSearchCriteria(String country, int startDayAfterCheckIn, int startDayAfterCheckOut) {
        WebActions webActions = new WebActions();
        Locators locators = new Locators();
        SeleniumBase selenium = new SeleniumBase();
        webActions.click(locators.homePageSearch);

        selenium.seleniumWait(30, locators.countrySelection);

        webActions.sendKeys(locators.countrySelection, country);
        webActions.click(locators.checkIn);
        webActions.click(locators.generateCheckInDate(startDayAfterCheckIn));
        webActions.click(locators.generateCheckOutDate(startDayAfterCheckOut));
        webActions.click(locators.selectGuests);

        selenium.seleniumWait(20, locators.selectAdult);

        webActions.click(locators.selectAdult);
        webActions.click(locators.selectAdult);
        webActions.click(locators.selectChildren);
        webActions.click(locators.search);

        selenium.seleniumWait(30, locators.maps);

    }

    public String assertionDestination() {
        Locators locators = new Locators();
        SeleniumBase selenium = new SeleniumBase();
        WebActions webActions = new WebActions();
        selenium.seleniumWait(20, locators.actualDestination);

        return webActions.getText(locators.actualDestination);
    }

    public String assertionGuests() {
        SeleniumBase selenium = new SeleniumBase();
        WebActions webActions = new WebActions();
        Locators locators = new Locators();
        selenium.seleniumWait(20, locators.actualGuest);

        return webActions.getText(locators.actualGuest);
    }

    public String assertionDates() {
        SeleniumBase selenium = new SeleniumBase();
        WebActions webActions = new WebActions();
        Locators locators = new Locators();
        selenium.seleniumWait(20, locators.actualDates);

        return webActions.getText(locators.actualDates);
    }


}
