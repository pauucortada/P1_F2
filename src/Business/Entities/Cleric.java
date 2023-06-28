package Business.Entities;

import java.util.Random;

/**
 * Class entity of a Cleric, it contains all the getters, setters of a Cleric with his
 * related attributes
 */
public class Cleric extends Character {

    private String typeAttack2;

    /**
     * Getter of the type of attack of the adventurer
     * @return: type of attack of the adventurer
     */
    public String getTypeAttack2() {
        return typeAttack2;
    }

    /**
     * Setter of the type of attack of the adventurer
     * @param typeAttack: type of attack of the adventurer
     */
    public void setTypeAttack2(String typeAttack) {
        this.typeAttack2 = typeAttack;
    }

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

    /**
     * Method that returns the total amount of damage
     * @param character: character that attacks
     * @return: total damage
     */
    @Override
    public int attackDamage (Character character) {
        Random random1 = new Random();
        int num = random1.nextInt(4) + 1;
        return num + character.getSpirit();
    }

    public int attackHealing(Cleric cleric) {
        Random random1 = new Random();
        int num = random1.nextInt(10) + 1;
        return num + cleric.getMind();
    }

    /**
     * This method is about when a character has to evolve
     * @param character: character to evolve
     * @return: character or warrior if it has evolved or not
     */
    @Override
    public Character evolve(Character character){
        Paladin paladin;
        if (character instanceof Cleric cleric) {
            paladin = (Paladin) cleric;
            setClasse("Paladin");
            return paladin;
        } else {
            return character;
        }
    }
}