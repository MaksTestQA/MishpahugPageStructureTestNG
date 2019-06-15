package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class FamilyPageTests extends TestsBase{


    private HomePageHelper homePage;
    private LoginPageHelper loginPage;
    private HomePageAuthHelper homePageAuth;
    private ProfilePageHelper profilePage;
    private EditProfilePageHelper editProfilePage;
    private MyFamilyPageHelper myFamilyPage;

    @BeforeMethod
    public void initTests(){

        homePage = new HomePageHelper(driver);
        loginPage = new LoginPageHelper(driver);
        homePageAuth = new HomePageAuthHelper(driver);
        profilePage = new ProfilePageHelper(driver);
        editProfilePage = new EditProfilePageHelper(driver);
        myFamilyPage = new MyFamilyPageHelper(driver);
    }



    @Test
    public void profileFamilyInfoTest(){

        homePage.waitUntilPageIsLoaded();
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.enterLoginPassword(LOGIN,PASSWORD);
        homePageAuth.waitUntilPageIsLoaded();
        homePageAuth.goToProfile();
        profilePage.waitUntilPageIsLoaded();
        String confessionProfile = driver.findElement(By.id("fieldobjconfession")).getText();
        String languageProfile = driver.findElement(By.id("fieldobjlanguages")).getText();
        String foodsProfile = driver.findElement(By.id("fieldobjfoodPreferences")).getText();


        if(!profilePage.checkProfileStatus(familyStatus)) {

            profilePage.goToEditProfilePage();
            editProfilePage.waitUntilPageIsLoaded();
            editProfilePage.selectFamilyStatus();
            editProfilePage.saveProfile();
            profilePage.waitUntilPageIsLoaded();
            System.out.println("Family status - "+profilePage.checkProfileStatus(familyStatus));
        }

            profilePage.goToHomePageAuth();
            homePageAuth.waitUntilPageIsLoaded();
            homePageAuth.goToMyFamilyPage();
            myFamilyPage.waitUntilPageIsLoaded();

        String confessionMyFamily = driver.findElement(By.id("fieldobjconfession")).getText();
        String languageMyFamily = driver.findElement(By.id("fieldobjlanguages")).getText();
        String foodsMyFamily = driver.findElement(By.id("fieldobjfoodPreferences")).getText();

        int counter = 0;
        if(confessionProfile.equals(confessionMyFamily))  counter++;
        System.out.println("Confessions are the same - "+confessionProfile.equals(confessionMyFamily));

        if(languageProfile.equals(languageMyFamily))   counter++;
            System.out.println("Languages are the same - "+languageProfile.equals(languageMyFamily));

        if(foodsProfile.equals(foodsMyFamily))counter++;
            System.out.println("foods preferences are the same - "+foodsProfile.equals(foodsMyFamily));

        Assert.assertEquals(counter, 3);

    }





}
