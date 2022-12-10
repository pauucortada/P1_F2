package Business.Managers;

import Business.Entities.Adventure;
import Business.Entities.Fight;
import Business.Entities.Monster;

import java.util.ArrayList;

public class FightManager {

    public Fight createFight(ArrayList<Monster> monsters, int id){
        Fight fight = new Fight();
        fight.setId(id);
        fight.setMonsters(monsters);
        return fight;
    } // Invocar en controller y hacer lista de fights para pasarsela a createAdventure

    public int countMonsterName(Monster monster, ArrayList<Monster> monsters) {
        int i = 0, count = 0;
        while (monsters.size() > i){
            if (monsters.get(i).getName().equals(monster.getName())){
                count++;
            }
            i++;
        }
        return count;
    } //Mostrar numero de monstruos iguales



}
