package Business.Entities;

public class Champion extends Warrior {

    @Override
    public int calculateMaxLifePoints(Character character, int level){
        return 900 + character.getBody() * level;
    }
}
