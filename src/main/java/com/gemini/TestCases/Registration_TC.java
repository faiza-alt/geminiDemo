package com.gemini.TestCases;

import com.gemini.Base.TestBase;
import com.gemini.Pages.RegistrationPage;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class Registration_TC extends TestBase {

    ////Positive Testing\\\\

    RegistrationPage registrationPage = new RegistrationPage(driver);

    //Verify Page Title
    @Test
    public void verifyPageTitle()  {
        String expTitle = "[Sandbox] Gemini - Institutional Client Registration";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expTitle, actualTitle);
    }

    //Verify Current URL
    @Test
    public void verifyPageURL(){
        String expectedURL = "https://exchange.sandbox.gemini.com/register/institution";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }


    //Verify Page LOGO
    @Test
    public void verifyPageLOGO() {
        boolean pageLogoDisplayed = registrationPage.isPageLogoDisplayed();
        Assert.assertTrue(pageLogoDisplayed);

    }

    //Verify Join an Existing Institutional Account link
    @Test
    public void verifyExistingAccountLink() throws InterruptedException {
        boolean existingAccountLinkDisplayed = registrationPage.isExistingAccountLinkDisplayed();
        Assert.assertTrue(existingAccountLinkDisplayed);
    }

    //verify Personal info link
    @Test
    public void personalInformationLink(){
        Assert.assertTrue(registrationPage.isPersonalInfoLinkDisplayed());
    }

    // Verify Registration with all valid data
    @Test
    public void validRegistrationTest(){
        //Enter Company Name
        registrationPage.enterCompanyName("Gemini");

        // Company Type
        registrationPage.selectCompanyType("Broker-Dealer");

        // select Business Country
        registrationPage.selectBusinessCountry("United States");
        registrationPage.selectState("VA");

        //Enter credentials
        registrationPage.enterCredentials("Faiza", "Ramzan", "faiza@gmail.com");

        //click on continue
        registrationPage.clickOnContinue();

        //Success Message Verification
        String ExpectedMsg = "Thanks for Registering!";
        Assert.assertEquals(registrationPage.getActualSuccessMessage(), ExpectedMsg);

    }


    ////Negative Testing\\\\

    //Verify by clicking on continue button without entering mandatory data
    @Test
    public void submitWithoutData() {
        //click on continue
        registrationPage.clickOnContinue();

        //Error Message should displayed
        WebElement errorMsg = driver.findElement(By.xpath("//div[@class='AlertBody']/ul"));
        Assert.assertTrue(errorMsg.isDisplayed());
    }

    // Registration without providing Company Name field
    @Test
    public void emptyCompanyNameTest() {
        //Enter Company Name
        registrationPage.enterCompanyName("");

        // Company Type
        registrationPage.selectCompanyType("Broker-Dealer");

        // select Business Country
        registrationPage.selectBusinessCountry("United States");
        registrationPage.selectState("VA");

        //Enter credentials
        registrationPage.enterCredentials("Faiza", "Ramzan", "faiza@gmail.com");

        //click on continue
        registrationPage.clickOnContinue();


        //Error Message Verification
        String expectedErrorMsg = "Legal Business Name is required.";
        WebElement act = driver.findElement(By.xpath("//li[text()='Legal Business Name is required.']"));
        String actualErrorMsg = act.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }


    @Test
    public void emptyCompanyType() {

        //Enter Company Name
        registrationPage.enterCompanyName("Gemini");

        // Empty Company Type
        registrationPage.selectCompanyType("");

        // select Business Country
        registrationPage.selectBusinessCountry("United States");
        registrationPage.selectState("VA");

        //Enter credentials
        registrationPage.enterCredentials("Faiza", "Ramzan", "faiza@gmail.com");

        //click on continue
        registrationPage.clickOnContinue();


        //Error Message Verification
        String expectedErrorMsg = "Company type is required.";
        WebElement act = driver.findElement(By.xpath("//li[text()='Company type is required.']"));
        String actualErrorMsg = act.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }


    @Test
    public void otherDescriptionBoxTest() {

        //Enter Company Name
        registrationPage.enterCompanyName("Gemini");

        // Company Type
        registrationPage.selectCompanyType("other");
        registrationPage.setOtherDescription("firm-organization");

        // select Business Country
        registrationPage.selectState("VA");

        //Enter credentials
        registrationPage.enterCredentials("Faiza", "Ramzan", "faiza@gmail.com");

        //click on continue
        registrationPage.clickOnContinue();

        //Success Message Verification
        String ExpectedMsg = "Thanks for Registering!";
        Assert.assertEquals(registrationPage.getActualSuccessMessage(), ExpectedMsg);
    }

    //verify country without state
    @Test
    public void businessCountryWithOutState() {
        //Enter Company Name
        registrationPage.enterCompanyName("Gemini");

        // Company Type
        registrationPage.selectCompanyType("Broker-Dealer");

        // select Business Country
        registrationPage.selectBusinessCountry("Albania");
        //Enter credentials
        registrationPage.enterCredentials("Faiza", "Ramzan", "faiza@gmail.com");

        //click on continue
        registrationPage.clickOnContinue();


        //Success Message Verification
        String ExpectedMsg = "Thanks for Registering!";
        Assert.assertEquals(registrationPage.getActualSuccessMessage(), ExpectedMsg);
    }

    //verify registration by country with state but empty State , error message should displayed
    @Test
    public void emptyBusinessState(){
        //Enter Company Name
        registrationPage.enterCompanyName("Gemini");

        // Company Type
        registrationPage.selectCompanyType("Broker-Dealer");

        // select Business Country
        registrationPage.selectBusinessCountry("United States");
        registrationPage.selectState("");

        //Enter credentials
        registrationPage.enterCredentials("Faiza", "Ramzan", "faiza@gmail.com");

        //click on continue
        registrationPage.clickOnContinue();


        //Error Message Verification
        String expectedErrorMsg = "Company state is required.";
        WebElement act = driver.findElement(By.xpath("//li[text()='Company state is required.']"));
        String actualErrorMsg = act.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }


    //verify by empty first Name , error message should displayed
    @Test
    public void emptyFirstName(){
        //Enter Company Name
        registrationPage.enterCompanyName("Gemini");

        // Company Type
        registrationPage.selectCompanyType("Broker-Dealer");

        // select Business Country
        registrationPage.selectBusinessCountry("United States");
        registrationPage.selectState("VA");

        //Enter credentials
        registrationPage.enterCredentials("", "Ramzan", "faiza@gmail.com");

        //click on continue
        registrationPage.clickOnContinue();


        //Error Message Verification
        String expectedErrorMsg = "First name is required.";
        WebElement act = driver.findElement(By.xpath("//li[text()='First name is required.']"));
        String actualErrorMsg = act.getText();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    //verify by empty Last Name , error message should displayed
    @Test
    public void emptyLastName() {
        //Enter Company Name
        registrationPage.enterCompanyName("Gemini");

        // Company Type
        registrationPage.selectCompanyType("Broker-Dealer");

        // select Business Country
        registrationPage.selectBusinessCountry("United States");
        registrationPage.selectState("VA");

        //Enter credentials
        registrationPage.enterCredentials("Faiza", "", "faiza@gmail.com");

        //click on continue
        registrationPage.clickOnContinue();


        //Error Message Verification
        String expectedErrorMsg = "Last name is required.";
        WebElement act = driver.findElement(By.xpath("//li[text()='Last name is required.']"));
        String actualErrorMsg = act.getText();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }


    //verify by empty email , error message should displayed
    @Test
    public void emptyEmail() {
        //Enter Company Name
        registrationPage.enterCompanyName("Gemini");

        // Company Type
        registrationPage.selectCompanyType("Broker-Dealer");

        // select Business Country
        registrationPage.selectBusinessCountry("United States");
        registrationPage.selectState("VA");

        //Enter credentials
        registrationPage.enterCredentials("Faiza", "Ramzan", "");

        //click on continue
        registrationPage.clickOnContinue();


        //Error Message Verification
        String expectedErrorMsg = "Please enter a valid email address.";
        WebElement act = driver.findElement(By.xpath("//li[text()='Please enter a valid email address.']"));
        String actualErrorMsg = act.getText();

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    //verify by invalid email , error message should displayed
    @Test
    public void InValidEmail() {
        //Enter Company Name
        registrationPage.enterCompanyName("Gemini");

        // Company Type
        registrationPage.selectCompanyType("Broker-Dealer");

        // select Business Country
        registrationPage.selectBusinessCountry("United States");
        registrationPage.selectState("VA");

        //Enter credentials
        registrationPage.enterCredentials("Faiza", "Ramzan", "faiza@com");

        //click on continue
        registrationPage.clickOnContinue();


        //Error Message Verification
        String expectedErrorMsg = "Please specify a valid email domain.";
        WebElement act = driver.findElement(By.xpath("//div[text()='Please specify a valid email domain.']"));
        String actualErrorMsg = act.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }


    //Verify Registration With filling optional field(middle name )
    //it should successfully register
    @Test
    public void registrationWithOptionalField(){
        //Enter Company Name
        registrationPage.enterCompanyName("Gemini");

        // Company Type
        registrationPage.selectCompanyType("Broker-Dealer");

        // select Business Country
        registrationPage.selectBusinessCountry("United States");
        registrationPage.selectState("VA");

        //Enter credentials
        registrationPage.enterCredentials("Faiza", "Ramzan", "faiza@gmail.com");

        // fill optional field (middle Name)
        registrationPage.middleName("Azo");


        //click on continue
        registrationPage.clickOnContinue();

        //Success Message Verification
        String ExpectedMsg = "Thanks for Registering!";
        Assert.assertEquals(registrationPage.getActualSuccessMessage(), ExpectedMsg);
    }

    //Verify Registration Without filling optional field(middle name )
    //it should successfully register
    @Test
    public void registrationWithOutOptionalField(){
        //Enter Company Name
        registrationPage.enterCompanyName("Gemini");

        // Company Type
        registrationPage.selectCompanyType("Broker-Dealer");

        // select Business Country
        registrationPage.selectBusinessCountry("United States");
        registrationPage.selectState("VA");

        //Enter credentials
        registrationPage.enterCredentials("Faiza", "Ramzan", "faiza@gmail.com");

        // fill optional field (middle Name)
        registrationPage.middleName("");


        //click on continue
        registrationPage.clickOnContinue();

        //Success Message Verification
        String ExpectedMsg = "Thanks for Registering!";
        Assert.assertEquals(registrationPage.getActualSuccessMessage(), ExpectedMsg);
    }
}
