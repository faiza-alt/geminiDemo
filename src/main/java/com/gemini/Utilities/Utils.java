package com.gemini.Utilities;

import com.gemini.Base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.gemini.Base.TestBase.driver;
public class Utils extends TestBase {

    public Utils(WebDriver driver){
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

}
