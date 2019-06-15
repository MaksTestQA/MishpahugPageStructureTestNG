package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageAuthHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;

public class LoginPageTests extends TestsBase {

    private HomePageHelper homePage;
    private LoginPageHelper loginPage;
    private HomePageAuthHelper homePageAuth;

    @BeforeMethod
    public void initTests(){

        homePage = new HomePageHelper(driver);
        loginPage = new LoginPageHelper(driver);
        homePageAuth = new HomePageAuthHelper(driver);

    }

    @Test
    public void loginPositive() {
        homePage.waitUntilPageIsLoaded();
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLoginPassword(LOGIN, PASSWORD);
        homePageAuth.waitUntilPageIsLoaded();
        Assert.assertTrue(homePageAuth.profileButtonTitleContainsText(LOGIN));
    }

    @Test
    public void loginNegative() {
        homePage.waitUntilPageIsLoaded();
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLoginPassword("jjjj","syuyb87677");
       // Assert.assertTrue(loginPage.wrongMessageIsDisplayed());
        loginPage.closeLoginWindows();
        homePage.waitUntilPageIsLoaded();
        int counter = 0;
        if(homePage.homeIconIsDisplayed())counter++;
        if(homePage.loginIconIsDisplayed())counter++;
        if(homePage.registrationIconIsDisplayed())counter++;
        if(homePage.homeAuthIconIsHidden())counter++;
        if(homePage.profileIconIsHidded())counter++;

        Assert.assertEquals(counter,5);

    }

}
