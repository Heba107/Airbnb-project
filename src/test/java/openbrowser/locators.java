package openbrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;


public class locators {
    static WebDriver driver;

    public void open() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.airbnb.com/");
        Thread.sleep(10000);
        WebElement close = driver.findElement(By.xpath("//span[@class='i9dqh6z dir dir-ltr']"));
        close.click();
    }

    public void data() throws InterruptedException {
        WebElement Country = driver.findElement(By.xpath("//div[@role='search']/button[1]"));
        Thread.sleep(2000);
        Country.click();

        WebElement destination = driver.findElement(By.id("bigsearch-query-location-input"));
        Thread.sleep(2000);
        destination.sendKeys("italy");

        WebElement checkin = driver.findElement(By.xpath("//div[@data-testid='structured-search-input-field-split-dates-0']"));
        checkin.click();

    }

    public void guests() throws InterruptedException {
        WebElement guest = driver.findElement(By.xpath("//div[@data-testid='structured-search-input-field-guests-button']"));
        guest.click();

        WebElement adult = driver.findElement(By.xpath("//button[@data-testid='stepper-adults-increase-button']"));
        adult.click();
        adult.click();

        WebElement children = driver.findElement(By.xpath("//button[@data-testid='stepper-children-increase-button']"));
        children.click();

        WebElement search = driver.findElement(By.xpath("//button[@data-testid='structured-search-input-search-button']"));
        search.click();
    }

    public void assertion() throws InterruptedException {
        By xpath = By.xpath("//div[@data-testid='little-search']/button[1]/div");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(xpath));

        Thread.sleep(2000);

        String expected1 = "Italy";
        String actual1 = driver.findElement(By.xpath("//div[@data-testid='little-search']/button[1]/div")).getText();
        Assert.assertTrue(actual1.contains(expected1));

        String expected2 = "3 guests";
        String actual2 = driver.findElement(By.xpath("//div[@data-testid='little-search']/button[3]")).getText();
        Assert.assertTrue(actual2.contains(expected2));


        String month1 = LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int dayOfMonth1 = LocalDate.now().getDayOfMonth();

        String month2 = LocalDate.now().plusDays(10).getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int dayOfMonth2 = LocalDate.now().plusDays(10).getDayOfMonth();

        String output1 = String.format("%s %s – %s", month1, dayOfMonth1, dayOfMonth2);

        String output2 = String.format("%s %s – %s %s", month1, dayOfMonth1, month2, dayOfMonth2);

        String actual3 = driver.findElement(By.xpath("//div[@class='cs3bjhu dir dir-ltr']/button[2]/div")).getText();
//div[@class='cs3bjhu dir dir-ltr']/button[2]/div


        if (month1.equals(month2)) {
            Assert.assertEquals(actual3, output1);
        } else {
            Assert.assertEquals(actual3, output2);

        }

    }

    public void checkin() throws InterruptedException {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = currentDate.format(formatter);

        String output = String.format("calendar-day-%s", formattedDate);
        String xpathExpression = "//div[@data-testid='%s']";
        String formattedXpath = String.format(xpathExpression, output);

        WebElement checkin = driver.findElement(By.xpath(formattedXpath));
        Thread.sleep(2000);
        checkin.click();
    }

    public void checkout() throws InterruptedException {
        LocalDate currentDate = LocalDate.now().plusDays(10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = currentDate.format(formatter);

        String output = String.format("calendar-day-%s", formattedDate);
        String xpathExpression = "//div[@data-testid='%s']";
        String formattedXpath = String.format(xpathExpression, output);

        WebElement checkin = driver.findElement(By.xpath(formattedXpath));
        Thread.sleep(2000);
        checkin.click();
    }

}








