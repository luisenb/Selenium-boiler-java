package org.example.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PomBase {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();


    public PomBase(WebDriver driver, WebDriverWait wait){
        this.driver.set(driver);
        this.wait.set(wait);
        PageFactory.initElements(driver, this);
    }

    public void clickWithWait(WebElement webElement){
        wait.get().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public void typeWithWait(WebElement webElement, String text){
        wait.get().until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
    }

    public void verifyTitle(WebElement webElement, String expectedText){
        String actualText = webElement.getText().trim();
        Assert.assertEquals(actualText, expectedText,
                "Title verification fialed. Expected: " + expectedText + ", Actual: " + actualText);
    }

    public void verifyValue(WebElement webElement, String expectedValue){
        //aria-valuenow
        String value = webElement.getAttribute("aria-valuenow");
        Assert.assertEquals(value, expectedValue,
                "Attribute doesn't match with the expected value: "
                        + expectedValue + ", actual value: " + value);
    }

    public void isPresent(WebElement webElement){
        wait.get().until(ExpectedConditions.visibilityOf(webElement));
    }
}
