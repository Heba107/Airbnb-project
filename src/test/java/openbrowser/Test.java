package openbrowser;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import pom.Homepage;
import utils.Locators;
import utils.SeleniumBase;

public class Test {


    @BeforeTest
    public void init() {
        SeleniumBase seleniumBase = new SeleniumBase();
        Homepage homepage = new Homepage();

        WebDriver driver = seleniumBase.seleniumConfig("https://www.airbnb.com/");
        homepage.closeADsPopup(driver);
    }

    SoftAssert softAssert = new SoftAssert();

    @org.testng.annotations.Test(priority = 1)
    public void searchForItaly() {
        Homepage homepage = new Homepage();
        Locators locators = new Locators();

        //select country
        String country = "Italy";
        homepage.prepareSearchCriteria(country, 0, 10);

        //select check in & out
        locators.generateCheckInDate(0);
        locators.generateCheckOutDate(10);

        //assert to destination
        String expectedDestination = "Italy";
        Assert.assertEquals(homepage.assertionDestination(), expectedDestination);

        //assert to guests
        String expectedGuests = "3 guests";
        softAssert.assertTrue(homepage.assertionGuests().contains(""), expectedGuests);

        //assert to date
        softAssert.assertEquals(homepage.assertionDates(), locators.assertCheckDate(0, 10));

        softAssert.assertAll();
    }

}
