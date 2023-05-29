package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebActions extends SeleniumBase{

    public void click(By path){
        WebElement click = driver.findElement(path);
        click.click();

    }

    public void sendKeys(By path, String text){
        WebElement sendKey = driver.findElement(path);
        sendKey.sendKeys(text);

    }
    public String getText(By path){
        WebElement getText = driver.findElement(path);
       String test= getText.getText();
        return test;
    }

}
