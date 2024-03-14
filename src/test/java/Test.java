import org.example.core.CoreBase;
import org.example.model.MonsterModel;
import org.example.pom.ErrorMessage;
import org.example.pom.MonsterAttributes;
import org.example.pom.MonsterImages;
import org.example.pom.MonstersCreated;
import org.testng.annotations.DataProvider;

public class Test extends CoreBase {

    public void setAttributesMonster(String name, String hp, String attack, String defense, String speed){

        MonsterModel monsterModel = new MonsterModel();
        monsterModel.setHp(hp);
        monsterModel.setName(name);
        monsterModel.setSpeed(speed);
        monsterModel.setDefense(defense);
        monsterModel.setAttack(attack);

        MonsterAttributes monsterAttributes = new MonsterAttributes(getDriver(), getWait());
        monsterAttributes.fillMonsterAttributes(monsterModel);
        monsterAttributes.clickCreateMonster();

        MonstersCreated monstersCreated = new MonstersCreated(getDriver(), getWait());
        monstersCreated.verifyAttributes(monsterModel);
    }

    public void selectShark(){
        MonsterImages monsterImages = new MonsterImages(getDriver(), getWait());
        monsterImages.verifyTitle();
        monsterImages.clickShark();
    }


    @org.testng.annotations.Test(dataProvider = "monsterData", testName = "Create shark")
    public void test(String name, String hp, String attack, String defense, String speed){
        setAttributesMonster(name, hp, attack, defense, speed);
    }


    @org.testng.annotations.Test(dataProvider = "monsterData", testName = "Create monster with image")
    public void createWithImage(String name, String hp, String attack, String defense, String speed){
        selectShark();
        setAttributesMonster(name, hp, attack, defense, speed);
    }

    @org.testng.annotations.Test(dataProvider = "monsterDataInvalid", testName = "Create monster with invalid values")
    public void createSharkWithInvalidValues(String name, String hp, String attack, String defense, String speed){
        selectShark();
        MonsterModel monsterModel = new MonsterModel();
        monsterModel.setHp(hp);
        monsterModel.setName(name);
        monsterModel.setSpeed(speed);
        monsterModel.setDefense(defense);
        monsterModel.setAttack(attack);

        MonsterAttributes monsterAttributes = new MonsterAttributes(getDriver(), getWait());
        monsterAttributes.fillMonsterAttributes(monsterModel);
        monsterAttributes.clickCreateMonster();

        ErrorMessage errorMessage = new ErrorMessage(getDriver(), getWait());
        errorMessage.alertIsPresent();
    }

    @org.testng.annotations.Test(dataProvider = "monsterData", testName = "Create monster with image")
    public void deleteShark(String name, String hp, String attack, String defense, String speed){
        selectShark();
        setAttributesMonster(name, hp, attack, defense, speed);
        MonstersCreated monstersCreated = new MonstersCreated(getDriver(), getWait());
        monstersCreated.clickDelete();
    }

    @DataProvider(name = "monsterData")
    public Object[][] monsterData(){
        return new Object[][] {
                {"test", "1", "1", "1", "1"}
        };
    }

    @DataProvider(name = "monsterDataInvalid")
    public Object[][] invalidData(){
        return new Object[][] {
                {"test", "1", "0", "1", "1"}
        };
    }
}
