package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestsBase {


    public static final String LOGIN = "maks";
    public static final String PASSWORD = "vfrcbv87";
    private static final String URL = "https://mishpahug.co.il/";
    protected static  String familyStatus = "Family";
    protected static  String guestStatus = "Guest";
    protected static  String guestAndFamilyStatus = "Guest and Family";

    WebDriver driver;

    @BeforeMethod
    public void startApplication() throws InterruptedException {

        driver = new ChromeDriver();
        //driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get(URL);
        Thread.sleep(2000);
        driver.findElement(By.id("closedIntro")).click();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }





}
