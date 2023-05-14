package openbrowser;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Airbnb {
    @BeforeTest
    public void openbrowser() throws InterruptedException {
        locators openbrowser = new locators();
        openbrowser.open();

    }

    @Test(priority = 1)
    public void data() throws InterruptedException {
        locators setdata = new locators();
        setdata.data();
    }

    @Test(priority = 2)
    public void checkindate() throws InterruptedException {
        locators checkindate = new locators();
        checkindate.checkin();

    }

    @Test(priority = 3)
    public void checkout() throws InterruptedException {
        locators checkout = new locators();
        checkout.checkout();
    }

    @Test(priority = 4)
    public void guestsdata() throws InterruptedException {
        locators guestsdata = new locators();
        guestsdata.guests();

    }

    @Test(priority = 5)
    public void assertion() throws InterruptedException {
        locators checkassertion = new locators();
        checkassertion.assertion();
    }

}


