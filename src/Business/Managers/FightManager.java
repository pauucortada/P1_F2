package Business.Managers;

import Business.Entities.Adventure;
import Business.Entities.Fight;
import Business.Entities.Monster;

import java.util.ArrayList;

/**
 * In this class we manage all related with the fights
 */
public class FightManager {

    /**
     * This next method is related to the new creation of a new fight
     * @param monsters: List of monsters of the fight
     * @param id: id of the fight
     * @return: new fight
     */
    public Fight createFight(ArrayList<Monster> monsters, int id){
        Fight fight = new Fight();
        fight.setId(id);
        fight.setMonsters(monsters);
        return fight;
    }

}
