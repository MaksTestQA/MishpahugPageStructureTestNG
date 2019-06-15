package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageAuthHelper extends PageBase {


    public HomePageAuthHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementClickable(By.id("profile"),20);
    }



    public boolean profileButtonTitleContainsText(String login) {
        WebElement profileButton = driver.findElement(By.id("profile"));
        return profileButton.getAttribute("title").contains(login);

    }

    public void goToProfile() {

        waitUntilPageIsLoaded();
        WebElement profileButton = driver.findElement(By.id("profile"));
        profileButton.click();

    }

    public void goToMyFamilyPage() {
        waitUntilPageIsLoaded();
        //waitUntilElementIsVisible(By.id("titleprofile"),10);
        driver.findElement(By.id("family")).click();
    }

    public boolean checkButtonAddEventIsDisplayed() {
        waitUntilPageIsLoaded();
        return driver.findElement(By.id("idbtnaddevent")).isDisplayed();
    }




}








