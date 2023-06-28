package Business.Entities;

/**
 * Class entity of a Paladin, it contains all the getters, setters of a Paladin with his
 * related attributes
 */
public class Paladin extends Cleric {

    /**
     * Method that calculate the max life points of a character
     * @param character: character to calculate
     * @param level: level to calculate
     * @return: points
     */
    @Override
    public int calculateMaxLifePoints(Character character, int level){
        return (10 + character.getBody()) * level;
    }

}
