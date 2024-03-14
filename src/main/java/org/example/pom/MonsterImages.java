package org.example.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MonsterImages extends PomBase{

    @FindBy(css = "[data-testid='monster-list-title']")
    private WebElement title;

    @FindBy(css = "[data-testid='monster-list-section']")
    private WebElement section;

    @FindBy(css = "[data-testid='monster-2']")
    private WebElement shark;


    public MonsterImages(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }


    public void verifyTitle(){
        verifyTitle(title, "Select your monster's image");
    }

    public void clickShark(){
        clickWithWait(shark);
    }
}
