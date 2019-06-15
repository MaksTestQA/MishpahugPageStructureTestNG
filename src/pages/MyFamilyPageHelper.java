package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyFamilyPageHelper extends PageBase {


    public MyFamilyPageHelper(WebDriver driver) {
        super(driver);
    }


    public void waitUntilPageIsLoaded() {

        waitUntilElementIsVisible(By.id("titleprofile"),20);
    }
}
