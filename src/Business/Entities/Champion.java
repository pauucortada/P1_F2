package Business.Entities;

/**
 * Class entity of a Champion, it contains all the getters, setters of a Champion with his
 * related attributes
 */
public class Champion extends Warrior {

    /**
     * Method that calculate the max life points of a character
     * @param character: character to calculate
     * @param level: level to calculate
     * @return: points
     */
    @Override
    public int calculateMaxLifePoints(Character character, int level){
        return 900 + character.getBody() * level;
    }
}
