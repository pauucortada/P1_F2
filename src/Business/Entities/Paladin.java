package Business.Entities;

public class Paladin extends Cleric {

    @Override
    public int calculateMaxLifePoints(Character character, int level){
        return (10 + character.getBody()) * level;
    }

}
