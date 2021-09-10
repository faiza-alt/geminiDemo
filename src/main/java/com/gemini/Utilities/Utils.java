package com.gemini.Utilities;

import com.gemini.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.gemini.Base.TestBase.driver;

public class Utils extends TestBase {

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    // all custom methods we can use in our classes for reusability of codes
    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickByJavascript(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click()", element);
    }

    public void waitUntilElemClickable(WebElement elem) {
        //  Create the object of WebDriverWait class
        WebDriverWait wait = new WebDriverWait(driver, 20);
        // Wait till the element is not clickable
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elem));
    }

    public void waitUntilElemVisible(WebElement elem) {
        //  Create the object of WebDriverWait class
        WebDriverWait wait = new WebDriverWait(driver, 20);
        // Wait till the element is not visible
        WebElement element = wait.until(ExpectedConditions.visibilityOf(elem));
    }

}
