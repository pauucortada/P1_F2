package Business.Entities;

import java.util.Random;

/**
 * Class related to the entity of an Adventurer that is a type of Character
 */

public class Adventurer extends Character {
    @Override
    public int attackDamage (Character character) {
        Random random1 = new Random();
        int num = random1.nextInt(6) + 1;
        return num + character.getBody();
    }

}
