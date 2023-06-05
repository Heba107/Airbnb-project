package openbrowser;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import pom.Homepage;
import utils.Locators;
import utils.SeleniumBase;

public class Test {


    @BeforeTest
    public void init() {
        SeleniumBase seleniumBase = new SeleniumBase();
        //Homepage homepage = new Homepage();

        seleniumBase.seleniumConfig("https://www.airbnb.com/");
       // homepage.closeADsPopup(driver);
    }

    SoftAssert softAssert = new SoftAssert();

    @AfterClass
    public void finish() {
        softAssert.assertAll();
    }

    @org.testng.annotations.Test(priority = 1)
    public void searchForItaly() throws InterruptedException {
        Homepage homepage = new Homepage();
        Locators locators = new Locators();
        int startDay = 0;
        int endDay = 10;

        //select country
        String country = "Italy";
        homepage.prepareSearchCriteria(country, startDay, endDay);


        //assert to destination
        Assert.assertEquals(homepage.assertionDestination(), country);

        //assert to guests
        String expectedGuests = "3 guests";
        softAssert.assertTrue(homepage.assertionGuests().contains(expectedGuests));

        //assert to date
        softAssert.assertEquals(homepage.assertionDates(), locators.assertCheckDate(startDay, endDay));


    }

}
