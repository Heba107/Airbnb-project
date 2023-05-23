package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Locators;
import utils.WebActions;

import java.util.stream.Stream;

public class Homepage {

    public void closeADsPopup(WebDriver driver) throws InterruptedException {
        Thread.sleep(10000);
        WebElement close = driver.findElement(By.xpath("//span[@class='i9dqh6z dir dir-ltr']"));

        close.click();
    }

    public void prepareSearchCriteria(String country, int startDayAfterchekIn) throws InterruptedException {
        WebActions webActions = new WebActions();
        Locators locators = new Locators();

        webActions.click(locators.homePageSearch);

        Thread.sleep(2000);
        webActions.sendKeys(locators.countrySelection, country);
        webActions.click(locators.checkIn);
        webActions.click(locators.generateCheckInDate(startDayAfterchekIn));
        webActions.click(locators.generateCheckOutDate(startDayAfterchekIn));
        webActions.click(locators.selectguests);
        Thread.sleep(2000);

        webActions.click(locators.selectadult);
        webActions.click(locators.selectadult);
        webActions.click(locators.selectchildren);
        webActions.click(locators.search);
        Thread.sleep(4000);

       // webActions.getText(locators.assertCheckDate(startDayAfterchekIn));
    }
    public String assertiondestination() throws InterruptedException {
        Thread.sleep(3000);

        WebActions webActions = new WebActions();
        Locators locators = new Locators();
        String actualdestination= webActions.getText(locators.actualdestination);
        return actualdestination;
    }

    public String assertionguests() throws InterruptedException {
        Thread.sleep(2000);

        WebActions webActions = new WebActions();
        Locators locators = new Locators();
        String actualguests= webActions.getText(locators.actualguest);
        return actualguests;
    }


}
