package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageHelper extends PageBase {


    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementClickable(By.id("idsignin"),20);
    }

    public void waitUntilPageIsLoadedJS(){

        WebDriverWait wait = new WebDriverWait(driver , 30);
        wait.until((ExpectedCondition<Boolean>) driver -> {
            System.out.println("Current windows State - " + String.valueOf(((JavascriptExecutor)driver).executeScript("return document.readyState")));
            return String.valueOf(((JavascriptExecutor)driver).executeScript("return document.readyState")).equals("complete");
        });
    }

    public void openLoginPage() {

        driver.findElement(By.id("idsignin")).click();
    }

    public boolean homeIconIsDisplayed() {
        WebElement homeIcon = driver.findElements(By.className("navi-item")).get(0);
        return homeIcon.isDisplayed();

    }

    public boolean loginIconIsDisplayed() {
        WebElement loginIcon = driver.findElements(By.className("navi-item")).get(1);
        return loginIcon.isDisplayed();
    }

    public boolean registrationIconIsDisplayed() {
        WebElement registrationIcon = driver.findElements(By.className("navi-item")).get(2);
        return registrationIcon.isDisplayed();
    }

    public boolean homeAuthIconIsHidden() {
        WebElement homeAuthIcon = driver.findElement(By.id("ihome"));
        return !homeAuthIcon.isDisplayed();
    }

    public boolean profileIconIsHidded() {
        WebElement profileIcon = driver.findElement(By.id("profile"));
        return !profileIcon.isDisplayed();

    }





}
