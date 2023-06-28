package Business.Entities;

/**
 * Class entity of a Champion, it contains all the getters, setters of a Champion with his
 * related attributes
 */
public class Champion extends Warrior {


    @Override
    public int calculateMaxLifePoints(Character character, int level){
        return 900 + character.getBody() * level;
    }
}
