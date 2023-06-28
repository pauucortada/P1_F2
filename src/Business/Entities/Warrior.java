package Business.Entities;

import java.util.Random;

/**
 * Class entity of a Warrior, it contains all the getters, setters of a Warrior with his
 * related attributes
 */
public class Warrior extends Adventurer{

    /**
     * Method that calculate the max life points of a character
     * @param character: character to calculate
     * @param level: level to calculate
     * @return: points
     */
    @Override
    public int calculateMaxLifePoints(Character character, int level){
        if (level == 4) {
            return 300;
        } else if (level == 5) {
            return 400;
        } else if (level == 6) {
            return 500;
        } else {
            return 600;
        }
    }

    /**
     * Method that returns the total amount of damage
     * @param character: character that attacks
     * @return: total damage
     */
    @Override
    public int attackDamage(Character character) {
        Random random1 = new Random();
        int num = random1.nextInt(10) + 1;
        return num + character.getBody();
    }

    /**
     * This method is about when a character has to evolve
     * @param character: character to evolve
     * @return: character or warrior if it has evolved or not
     */
    @Override
    public Character evolve(Character character){
        Champion champion;
        if (character instanceof Warrior warrior) {
            champion = (Champion) warrior;
            setClasse("Champion");
            return champion;
        } else {
            return character;
        }
    }
}
