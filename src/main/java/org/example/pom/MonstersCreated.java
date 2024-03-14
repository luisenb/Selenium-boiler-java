package org.example.pom;

import org.example.model.MonsterModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MonstersCreated extends PomBase{

    @FindBy(css = "[data-testid='monster-card']")
    private WebElement firstCard;

    @FindBy(css = "[data-testid='monster-card'] [data-testid='card-monster-name']")
    private WebElement monsterName;

    @FindBy(css = "[data-testid='monster-card'] [data-testid='card-monster-hp']")
    private WebElement monsterHp;

    @FindBy(css = "[data-testid='monster-card'] [data-testid='card-monster-attack']")
    private WebElement monsterAttack;

    @FindBy(css = "[data-testid='monster-card'] [data-testid='card-monster-defense']")
    private WebElement monsterDefense;

    @FindBy(css = "[data-testid='monster-card'] [data-testid='card-monster-speed']")
    private WebElement monsterSpeed;

    @FindBy(css = "[data-testid='monster-card'] [data-testid='btn-delete']")
    private WebElement delete;

    public MonstersCreated(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void verifyAttributes(MonsterModel monsterModel){
            verifyTitle(monsterName, monsterModel.getName());
            verifyValue(monsterHp, monsterModel.getHp());
            verifyValue(monsterAttack, monsterModel.getAttack());
            verifyValue(monsterDefense, monsterModel.getDefense());
            verifyValue(monsterSpeed, monsterModel.getSpeed());
    }

    public void clickDelete(){
        clickWithWait(delete);
    }


}
