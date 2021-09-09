package com.gemini.Pages;
import com.gemini.Base.TestBase;
import com.gemini.Utilities.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class RegistrationPage extends TestBase {

       WebDriver driver;
    //  Page Factory / Object Repository

    @FindBy(xpath = "//a[@href='https://gemini.com/']/img")
    WebElement GeminiLogo_Locator;

    @FindBy(xpath = "//p/a[text()='Join an existing institutional account?']")
    WebElement existingAccount_Locator;

    @FindBy(name ="company.legalName")
    WebElement companyName;

    @FindBy(xpath ="//div[@class='css-9a2vyg e5i1odf0']/label/div[2]/div/div/div[2]/div/input[contains(@id,'companyType')]")
    WebElement companyTypeBox;

    @FindBy(name ="company.companyTypeDetail")
    WebElement otherDescription;

    @FindBy(xpath ="//div[@class='css-13wozid e5i1odf0']/label/div[2]/div/div/div[2]/div/input")
    WebElement state;

    @FindBy(name ="personal.legalName.firstName")
    WebElement FName;

    @FindBy(name ="personal.legalName.lastName")
    WebElement LName;

    @FindBy(name ="personal.email")
    WebElement email;

    @FindBy(name = "personal.legalName.middleName")
    WebElement midName;

    @FindBy(xpath = "//button[@data-testid='InstitutionSubmit']")
    WebElement submitBtn;

    @FindBy(xpath = "//div/h3[text()='Thanks for Registering!']")
    WebElement successMsg;

    @FindBy(xpath = "(//div[@class='css-9a2vyg e5i1odf0']/label/div)[6]/div/div/div[2]/div/input")
    WebElement BusinessCountry;

    @FindBy(linkText = "Why am I providing personal information?")
    WebElement personalInfoLink;

    @FindBy(xpath ="//div[@class='Content FreeWidth']")
    WebElement infoTextBox;

    @FindBy(xpath ="//div/a[text()='OK']")
    WebElement popUp;

    @FindBy(linkText = "Create new account")
    WebElement create_new_account;

    @FindBy(linkText = "Create a business account")
    WebElement createNewBusinessAccount;


    //Constructor to initialize the WebDriver
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

      Utils ut = new Utils(driver);


    //Registration page methods\\

    public void navigateToRegistrationPage() throws InterruptedException {
        //Verify The page
        String expectedPageTitle = "[Sandbox] Gemini - Sign In";
        Assert.assertTrue(driver.getTitle().contains(expectedPageTitle), "Test Failed");

        //Click on "Create an account" link
        create_new_account.click();
        Assert.assertEquals(driver.getTitle(),"[Sandbox] Gemini - Register");

        //Click On popUp
         popUp.click();

        //scroll the page to view the "Create a business account" link and Click on it
        ut.scrollIntoView(createNewBusinessAccount);
        Thread.sleep(3000);
        createNewBusinessAccount.click();
    }
    public boolean isPageLogoDisplayed() {
        return GeminiLogo_Locator.isDisplayed();
    }

    public boolean isExistingAccountLinkDisplayed() {
        return existingAccount_Locator.isDisplayed();
    }

    //Company Name
    public void enterCompanyName(String companyLegalName) {
        companyName.sendKeys(companyLegalName);
    }

    // Company Type
    public void selectCompanyType(String companyType) {
        companyTypeBox.sendKeys(companyType);
        companyTypeBox.sendKeys(Keys.ENTER);

    }

    //Add other description for company type
    public void setOtherDescription(String addOtherDescription) {
        otherDescription.sendKeys(addOtherDescription);
    }

    //Select state
    public void selectState(String State) {
        state.sendKeys(State);
        state.sendKeys(Keys.ENTER);
    }

    //Enter credentials
    public void enterCredentials(String firstName, String lastName, String Email) {
        FName.sendKeys(firstName);
       LName.sendKeys(lastName);
       email.sendKeys(Email);

    }

    //click on continue Btn
    public void clickOnContinue() {
        ut.scrollIntoView(submitBtn);
     ut.clickByJavascript(submitBtn);
    }

    //Success Message Verification
    public String getActualSuccessMessage() {
        return successMsg.getText();
    }

    //Select Business Country
    public void selectBusinessCountry(String country) {
        BusinessCountry.sendKeys(country);
        BusinessCountry.sendKeys(Keys.ENTER);

    }

    public void middleName(String middleName) { midName.sendKeys(middleName);
    }

    public boolean isPersonalInfoLinkDisplayed() {
        return personalInfoLink.isDisplayed();
    }

}
