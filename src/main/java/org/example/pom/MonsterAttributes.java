package org.example.pom;

import org.example.model.MonsterModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MonsterAttributes extends PomBase{

    @FindBy(css = "[data-testid='monster-name'] input")
    private WebElement name;
    @FindBy(css = "[data-testid='hp-value'] input")
    private WebElement hp;
    @FindBy(css = "[data-testid='attack-value'] input")
    private WebElement attack;
    @FindBy(css = "[data-testid='defense-value'] input")
    private WebElement defense;
    @FindBy(css = "[data-testid='speed-value'] input")
    private WebElement speed;

    @FindBy(css = "[data-testid='btn-create-monster']")
    private WebElement create;

    public MonsterAttributes(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void fillMonsterAttributes(MonsterModel monsterModel){
        typeWithWait(name, monsterModel.getName());
        typeWithWait(hp, monsterModel.getHp());
        typeWithWait(attack, monsterModel.getAttack());
        typeWithWait(defense, monsterModel.getDefense());
        typeWithWait(speed, monsterModel.getSpeed());
    }

    public void clickCreateMonster(){
        clickWithWait(create);
    }

}
