package Business.Entities;

import java.util.Random;

public class Warrior extends Adventurer{
    @Override
    public int attackDamage(Character character) {
        Random random1 = new Random();
        int num = random1.nextInt(10) + 1;
        return num + character.getBody();
    }

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
