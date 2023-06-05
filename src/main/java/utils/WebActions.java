package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebActions extends SeleniumBase{

    public void click(By path) throws InterruptedException {
        Thread.sleep(500);
        WebElement click = driver.findElement(path);
        click.click();

    }

    public void sendKeys(By path, String text) throws InterruptedException {
        Thread.sleep(500);
        WebElement sendKey = driver.findElement(path);
        sendKey.sendKeys(text);

    }
    public String getText(By path) throws InterruptedException {
        Thread.sleep(500);
        WebElement getText = driver.findElement(path);
       String test= getText.getText();
        return test;
    }

}
