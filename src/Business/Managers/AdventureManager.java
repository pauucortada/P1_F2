package Business.Managers;

import Business.Entities.Adventure;
import Business.Entities.Fight;

import java.util.ArrayList;

public class AdventureManager {

    private FightManager fightManager;
    public void createAdventure(String name, int numFights, ArrayList<Fight> fights) {
        Adventure adventure = new Adventure();
        adventure.setName(name);
        adventure.setNumFights(numFights);
        adventure.setFights(fights);

        // Guardar a DAO
    }

    public boolean checkAdventureName(String name) {
        ArrayList<Adventure> adventures = null; //= funcio que llegeixi aventures
        try {
            int i = 0;
            while (adventures.size() > i){
                if (adventures.get(i).getName().equals(name)){
                    return false;
                }
                i++;
            }
            return true;
        } catch (NullPointerException npe) {
            return true;
        }
    }

    public ArrayList<Adventure> listAdventures(){
        ArrayList<Adventure> adventures = new ArrayList<Adventure>(); //Funcion JSON que lee las aventuras
        return adventures;
    }



}
