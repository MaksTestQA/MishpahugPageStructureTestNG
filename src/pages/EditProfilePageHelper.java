package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfilePageHelper extends PageBase {


    public EditProfilePageHelper(WebDriver driver) {
        super(driver);
    }


    public void waitUntilPageIsLoaded() {
        waitUntilElemContainsText(By.xpath("//div[@class='centertext']"),"Edit profile! Please enter data in fields!",20);
    }

    public void selectFamilyStatus() {

        driver.findElement(By.id("typeuser2inprofile")).click();
        waitUntilElemAttrContainsText(By.id("typeuser2inprofile"),
                "class","active",5);
    }

    public void saveProfile() {

        waitUntilElementIsVisible(By.xpath("//i[@class='fa fa-check-square-o']"),10);
        driver.findElement(By.id("idbtnsaveprofile")).click();

    }

    public void selectGuestStatus() {

        driver.findElement(By.id("typeuser1inprofile")).click();
        waitUntilElemAttrContainsText(By.id("typeuser1inprofile"),"class","active",5);
    }

    public void selectGuestAndFamilyStatus(){

        driver.findElement(By.id("typeuser3inprofile")).click();
        waitUntilElemAttrContainsText(By.id("typeuser3inprofile"),"class","active",5);
    }



}
