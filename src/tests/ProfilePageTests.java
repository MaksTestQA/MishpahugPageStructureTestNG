package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class ProfilePageTests extends TestsBase {

    private HomePageHelper homePage;
    private LoginPageHelper loginPage;
    private HomePageAuthHelper homePageAuth;
    private ProfilePageHelper profilePage;
    private EditProfilePageHelper editProfilePage;

  @BeforeMethod
    public void initTest(){
      homePage = new HomePageHelper(driver);
      loginPage = new LoginPageHelper(driver);
      homePageAuth = new HomePageAuthHelper(driver);
      profilePage = new ProfilePageHelper(driver);
      editProfilePage = new EditProfilePageHelper(driver);

  }

  @Test
    public void profileTitleTest(){
      homePage.waitUntilPageIsLoaded();
      homePage.openLoginPage();
      loginPage.waitUntilPageIsLoaded();
      loginPage.enterLoginPassword(LOGIN,PASSWORD);
      homePageAuth.waitUntilPageIsLoaded();
      homePageAuth.goToProfile();
      profilePage.waitUntilPageIsLoaded();
      Assert.assertTrue(profilePage.checkingTitle());

  }
    @Test
    public  void profileUserGuestTest(){
      homePage.waitUntilPageIsLoaded();
      homePage.openLoginPage();
      loginPage.waitUntilPageIsLoaded();
      loginPage.enterLoginPassword(LOGIN,PASSWORD);
      homePageAuth.waitUntilPageIsLoaded();
      homePageAuth.goToProfile();
      profilePage.waitUntilPageIsLoaded();
        if(!profilePage.checkProfileStatus(guestStatus)){
        profilePage.goToEditProfilePage();
        editProfilePage.selectGuestStatus();
        editProfilePage.saveProfile();
        profilePage.waitUntilPageIsLoaded();
      }
    profilePage.goToHomePageAuth();
    homePageAuth.waitUntilPageIsLoaded();
    System.out.println("User Status - "+guestStatus+" Add buttun is hidden - " + !homePageAuth.checkButtonAddEventIsDisplayed());
    Assert.assertFalse(homePageAuth.checkButtonAddEventIsDisplayed());
    }

    @Test
  public void profileUserFamilyTest(){
    homePage.waitUntilPageIsLoaded();
    homePage.openLoginPage();
    loginPage.enterLoginPassword(LOGIN,PASSWORD);
    homePageAuth.waitUntilPageIsLoaded();
    homePageAuth.goToProfile();
    profilePage.waitUntilPageIsLoaded();
    if(!profilePage.checkProfileStatus(familyStatus)) {
      profilePage.goToEditProfilePage();
      editProfilePage.selectFamilyStatus();
      editProfilePage.saveProfile();
      profilePage.waitUntilPageIsLoaded();
    }
      profilePage.goToHomePageAuth();
      homePageAuth.waitUntilPageIsLoaded();
      System.out.println("User status - " + familyStatus + " Add buttun is displayed - " + homePageAuth.checkButtonAddEventIsDisplayed());
      Assert.assertTrue(homePageAuth.checkButtonAddEventIsDisplayed());
  }

    @Test
  public void profileUserFamilyAndGuestTest(){
   // homePage.waitUntilPageIsLoaded();
    homePage.waitUntilPageIsLoadedJS();
    homePage.openLoginPage();
    loginPage.enterLoginPassword(LOGIN,PASSWORD);
    homePageAuth.waitUntilPageIsLoaded();
    homePageAuth.goToProfile();
    profilePage.waitUntilPageIsLoaded();
    if(!profilePage.checkProfileStatus(guestAndFamilyStatus)){
      profilePage.goToEditProfilePage();
      editProfilePage.waitUntilPageIsLoaded();
      editProfilePage.selectGuestAndFamilyStatus();
      editProfilePage.saveProfile();
      profilePage.waitUntilPageIsLoaded();
      }
      profilePage.goToHomePageAuth();
      homePageAuth.waitUntilPageIsLoaded();
      System.out.println("User status - " + familyStatus + " Add buttun is displayed - " + homePageAuth.checkButtonAddEventIsDisplayed());
    homePageAuth.checkButtonAddEventIsDisplayed();

    }

}
