package Business.Entities;

import java.util.Random;

/**
 * Class entity of a Mage, it contains all the getters, setters of a Mage with his
 * related attributes
 */
public class Mage extends Character {
    private String typeAttack2;
    private int shield;

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
     * Getter of the shield of a mage
     * @return: shield
     */
    public int getShield() {
        return shield;
    }

    /**
     * Setter of the shield of a mage
     * @param shield
     */
    public void setShield(int shield) {
        this.shield = shield;
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
        return num + character.getMind();
    }

    /**
     * Method that returns a random to arcaneMisile
     * @param character: character
     * @return: random
     */
    public int arcaneMisile (Character character) {
        Random random1 = new Random();
        int num = random1.nextInt(6) + 1;
        return num + character.getMind();
    }

    /**
     * Calculates the shield of a mage
     * @param level: level of the mage
     * @return: total shield
     */
    public int calculateShield(int level) {
        Random random1 = new Random();
        int num = (random1.nextInt() + getMind()) * level;
        setShield(num);
        return num;
    }
}
