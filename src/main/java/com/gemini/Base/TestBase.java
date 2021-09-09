package com.gemini.Base;

import com.gemini.Pages.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;


    //Launch the browser and navigate to the registration page
    @Parameters({ "browser" })
    @BeforeMethod
    public void setUp(String browser) throws InterruptedException {

        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            String URL = "https://exchange.sandbox.gemini.com/signin?redirect=56164ca5f83d11575cdb4138df6532b3a4045a24-1630945223697-%2F";
            driver.get(URL);
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
            RegistrationPage rg = new RegistrationPage(driver);
            rg.navigateToRegistrationPage();
        }



            if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                String URL = "https://exchange.sandbox.gemini.com/signin?redirect=56164ca5f83d11575cdb4138df6532b3a4045a24-1630945223697-%2F";
                driver.get(URL);
                driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
                RegistrationPage rg = new RegistrationPage(driver);
                rg.navigateToRegistrationPage();

            }else {

                System.out.println("Enter one of these browsers  1)Firefox  2) Chrome" );
            }


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
