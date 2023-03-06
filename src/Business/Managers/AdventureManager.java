package Business.Managers;

import Business.Entities.Adventure;
import Business.Entities.Fight;
import Persistance.JSONAdventures;

import java.util.ArrayList;

public class AdventureManager {

    private final ArrayList<Adventure> adventures;

    private FightManager fightManager;

    public AdventureManager() {
        adventures = new ArrayList<>();
    }


    public void createAdventure(String name, int numFights, ArrayList<Fight> fights) {
        Adventure adventure = new Adventure();
        JSONAdventures jsonAdventures = new JSONAdventures();

        adventure.setName(name);
        adventure.setNumFights(numFights);
        adventure.setFights(fights);
        adventures.add(adventure);
        jsonAdventures.savAdventuresToFile(adventures);
    }

    public boolean checkAdventureName(String name) {
        JSONAdventures jsonAdventures = new JSONAdventures();
        ArrayList<Adventure> adventures = jsonAdventures.getAdventuresFromFile();
        int i = 0;
        try {
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
        JSONAdventures jsonAdventures = new JSONAdventures();
        return jsonAdventures.getAdventuresFromFile();
    }



}
