package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {

    WebDriver driver;

    protected PageBase(WebDriver driver){
        this.driver = driver;
    }

    protected void waitUntilElementClickable(By locator, int time){
        try {
            new WebDriverWait(driver,time)
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    protected void waitUntilElementIsVisible(By locator, int time){
        try {
            new WebDriverWait(driver,time)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    protected void waitUntilElemAttrContainsText(By locator, String attribute, String value, int time){
        try {
            new WebDriverWait(driver,time)
                    .until(ExpectedConditions.attributeContains(locator,attribute,value));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void waitUntilElemContainsText(By locator, String value, int time){
        try {
            new WebDriverWait(driver,time)
                    .until(ExpectedConditions.textToBePresentInElementLocated(locator,value));
        } catch(Exception e){
            e.printStackTrace();
        }
    }


}
