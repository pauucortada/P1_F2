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
    } // Invocar en controller y hacer lista de fights para pasarsela a createAdventure

    /**
     * This method counts the number of monsters of the game
     * @param monster
     * @param monsters
     * @return
     */
    public int countMonsterName(String monster, ArrayList<Monster> monsters) {
        int i = 0, count = 0;
        while (monsters.size() > i){
            if (monsters.get(i).getName().equals(monster)){
                count++;
            }
            i++;
        }
        return count;
    } //Mostrar numero de monstruos iguales



}
