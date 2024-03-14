package org.example.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorMessage extends PomBase{

    @FindBy(css = "[data-testid='alert-required-fields']")
    private WebElement alert;

    public ErrorMessage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void alertIsPresent(){
        isPresent(alert);
    }
}
