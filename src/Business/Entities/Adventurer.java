package Business.Entities;

import java.util.Random;

/**
 * Class related to the entity of an Adventurer that is a type of Character
 */

public class Adventurer extends Character {

    /**
     * Method that calculate the max life points of a character
     * @param character: character to calculate
     * @param level: level to calculate
     * @return: points
     */
    @Override
    public int calculateMaxLifePoints(Character character, int level){
        if (level == 1) {
            return 0;
        } else if (level == 2) {
            return 100;
        } else if (level == 3) {
            return 200;
        } else if (level == 4) {
            return 300;
        } else if (level == 5) {
            return 400;
        } else if (level == 6) {
            return 500;
        } else if (level == 7) {
            return 600;
        } else if (level == 8) {
            return 700;
        } else if (level == 9) {
            return 800;
        } else {
            return 900;
        }
    }

    /**
     * Method that returns the total amount of damage
     * @param character: character that attacks
     * @return: total damage
     */
    @Override
    public int attackDamage (Character character) {
        Random random1 = new Random();
        int num = random1.nextInt(6) + 1;
        return num + character.getBody();
    }

    /**
     * This method is about when a character has to evolve
     * @param character: character to evolve
     * @return: character or warrior if it has evolved or not
     */
    @Override
    public Character evolve(Character character){
        Warrior warrior;
        if (character instanceof Adventurer adventurer) {
            warrior = (Warrior) adventurer;
            setClasse("Warrior");
            return warrior;
        } else {
            return character;
        }
    }

    /**
     * Method that gets the preparation time of a character
     * @param character: character
     * @return: preparation time
     */
    @Override
    public String getPreparationType(Character character){
        return ("");
    }

}
