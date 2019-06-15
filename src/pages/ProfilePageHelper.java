package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static tests.TestsBase.LOGIN;

public class ProfilePageHelper extends PageBase {
    public ProfilePageHelper(WebDriver driver) {
        super(driver);
    }


    public boolean checkingTitle() {
        waitUntilElemContainsText(By.id("titleprofile"),LOGIN,30);
        WebElement titleProfile = driver.findElement(By.id("titleprofile"));
        return titleProfile.getText().contains(LOGIN);
    }

    public void waitUntilPageIsLoaded() {
           waitUntilElementIsVisible(By.id("titleprofile"),30);
    }

    public boolean checkProfileStatus(String status) {

        waitUntilElemContainsText(By.id("titleprofile"),"maks",30);
        return driver.findElement(By.id("statusinmishpahuginprofile")).getText().equals(status);
    }


    public void goToEditProfilePage() {

        waitUntilElementIsVisible(By.xpath("//div[@id='titleprofile']"),10);
        driver.findElement(By.id("idbtneditprofile")).click();

    }

    public void goToHomePageAuth() {

        driver.findElement(By.id("ihome")).click();
    }


}
