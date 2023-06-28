package Business.Entities;

import java.util.Random;

/**
 * Class related to the entity of an Adventurer that is a type of Character
 */

public class Adventurer extends Character {


    @Override
    public int calculateMaxLifePoints(Character character, int level){
        if (level == 1) {
            return 0;
        } else if (level == 2) {
            return 100;
        } else{
            return 200;
        }
    }

    @Override
    public int attackDamage (Character character) {
        Random random1 = new Random();
        int num = random1.nextInt(6) + 1;
        return num + character.getBody();
    }


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


    @Override
    public String getPreparationType(Character character){
        return ("");
    }

}
