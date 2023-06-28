package Business.Entities;

import java.util.Random;

public class Mage extends Character {
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

    @Override
    public int calculateMaxLifePoints(Character character, int level){
        return (10 + character.getBody()) * level;
    }

    @Override
    public int attackDamage (Character character) {
        Random random1 = new Random();
        int num = random1.nextInt(4) + 1;
        return num + character.getMind();
    }

    public int arcaneMisile (Character character) {
        Random random1 = new Random();
        int num = random1.nextInt(6) + 1;
        return num + character.getMind();
    }
}
