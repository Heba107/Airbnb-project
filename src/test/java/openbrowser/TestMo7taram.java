package openbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.Homepage;

import utils.Locators;
import utils.SeleniumBase;
import utils.WebActions;

public class TestMo7taram {


    @BeforeTest
    public void init() throws InterruptedException {
        SeleniumBase seleniumBase = new SeleniumBase();
        Homepage homepage = new Homepage();

        WebDriver driver = seleniumBase.seleniumConfig("https://www.airbnb.com/");
        homepage.closeADsPopup(driver);
    }

    @Test(priority = 1)
    public void searchForItaly() throws InterruptedException {
        Homepage homepage = new Homepage();
        Locators locators=new Locators();

        String country = "Italy";
        homepage.prepareSearchCriteria(country,0);
        //assert to destination
        String expectedDestination="Italy";
        String actualdestination=homepage.assertiondestination();
        Assert.assertEquals(homepage.assertiondestination(),expectedDestination);
        //assert to guests
        String expectedGuests="3 guests";
        String actualguests=homepage.assertionguests();
        Assert.assertTrue(homepage.assertionguests().contains(""),expectedGuests);
        //assert to date
        locators.assertCheckDate(0);
    }

}
