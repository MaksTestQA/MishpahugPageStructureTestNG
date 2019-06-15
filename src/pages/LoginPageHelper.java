package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPageHelper extends PageBase{
    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public void  waitUntilPageIsLoaded(){
        waitUntilElementClickable(By.id("signinrequest"),20);
    }


    public void enterLoginPassword(String login, String password) {

        WebElement loginField = driver.findElement(By.id("logininput"));
        loginField.click();
        loginField.sendKeys(login);
        WebElement passwordField = driver.findElement(By.id("passwordinput"));
        passwordField.click();
        passwordField.sendKeys(password);
        WebElement signInButton = driver.findElement(By.id("signinrequest"));
        signInButton.click();


    }



    public boolean wrongMessageIsDisplayed() {
        waitUntilElemContainsText(By.id("wrongloginorpassword"),"Wrong Authorization!",30);
        WebElement wrongAuthText = driver.findElement(By.id("wrongloginorpassword"));
        System.out.println("Wrong Authorization text: " + wrongAuthText.getText().contains("Wrong Authorization!"));
        return wrongAuthText.getText().contains("Wrong Authorization!");
    }

    public void closeLoginWindows() {
        WebElement closeLogin = driver.findElement(By.id("closedsignin"));
        closeLogin.click();
    }

}
