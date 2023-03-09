package Business.Managers;

import Business.Entities.Adventure;
import Business.Entities.Fight;
import Persistance.JSONAdventures;

import java.util.ArrayList;

/**
 * This class is related about Adventures, it manages all of it, you can create,
 * list or check the adventures you have
 */
public class AdventureManager {

    private FightManager fightManager;

    /**
     * This method is about to create a new adventure to the list
     * @param name: nme of the adventure
     * @param numFights: number of fights of the adventure
     * @param fights; arrayList of fights where you need to add the next adventure
     */
    public void createAdventure(String name, int numFights, ArrayList<Fight> fights) {
        Adventure adventure = new Adventure();
        JSONAdventures jsonAdventures = new JSONAdventures();
        ArrayList<Adventure> adventures = jsonAdventures.getAdventuresFromFile();

        adventure.setName(name);
        adventure.setNumFights(numFights);
        adventure.setFights(fights);
        adventures.add(adventure);
        jsonAdventures.savAdventuresToFile(adventures);
    }

    /**
     * This method can tell you if there is already an adventure with an specific name
     * @param name: name of the adventure
     * @return
     */
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

    /**
     * This method lists the adventure to the related persistance of the adventures
     * @return:
     */
    public ArrayList<Adventure> listAdventures(){
        JSONAdventures jsonAdventures = new JSONAdventures();
        return jsonAdventures.getAdventuresFromFile();
    }



}
