package Business.Managers;

import Business.Entities.Adventure;
import Business.Entities.Fight;
import Persistance.Cloud.CloudAdventures;
import Persistance.JSON.JSONAdventures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class is related about Adventures, it manages all of it, you can create,
 * list or check the adventures you have
 */
public class AdventureManager {

    /**
     * This method is about to create a new adventure to the list
     * @param name: nme of the adventure
     * @param numFights: number of fights of the adventure
     * @param fights; arrayList of fights where you need to add the next adventure
     */
    public void createAdventure(String name, int numFights, ArrayList<Fight> fights, int option) throws IOException {
        Adventure adventure = new Adventure();
        JSONAdventures jsonAdventures = new JSONAdventures();
        CloudAdventures cloudAdventures = new CloudAdventures();
        ArrayList<Adventure> adventures = jsonAdventures.getAdventuresFromFile();

        adventure.setName(name);
        adventure.setNumFights(numFights);
        adventure.setFights(fights);

        if (option == 1){
            try {
                adventures.add(adventure);
                jsonAdventures.savAdventuresToFile(adventures);
            } catch (NullPointerException npe) {
                ArrayList<Adventure> adventures1 = new ArrayList<>();
                adventures1.add(adventure);
                jsonAdventures.savAdventuresToFile(adventures1);
            }

        }else if (option == 2){
            try {
                adventures.add(adventure);
                cloudAdventures.savAdventuresToFileCloud(adventures);
            } catch (NullPointerException | IOException npe) {
                ArrayList<Adventure> adventures1 = new ArrayList<>();
                adventures1.add(adventure);
                cloudAdventures.savAdventuresToFileCloud(adventures1);
            }
        }
    }

    /**
     * This method can tell you if there is already an adventure with an specific name
     * @param name: name of the adventure
     * @return
     */
    public boolean checkAdventureName(String name, int option) throws IOException {
        JSONAdventures jsonAdventures = new JSONAdventures();
        CloudAdventures cloudAdventures = new CloudAdventures();
        ArrayList<Adventure> adventures = new ArrayList<>();

        if (option == 1) {
            adventures = jsonAdventures.getAdventuresFromFile();
        }else if (option == 2){
            adventures = cloudAdventures.getAdventuresFromFileCloud();
        }

        int i = 0;
        try {
            while (adventures.size() > i){
                if (adventures.get(i).getName().equals(name)){
                    return false;
                }
                i++;
            }
            return !name.equals("");
        } catch (NullPointerException npe) {
            return true;
        }

    }

    /**
     * This method lists the adventure to the related persistance of the adventures
     * @return:
     */
    public ArrayList<Adventure> listAdventures(int option) throws IOException {
        JSONAdventures jsonAdventures = new JSONAdventures();
        CloudAdventures cloudAdventures = new CloudAdventures();

        if (option == 1){
            return jsonAdventures.getAdventuresFromFile();
        }else{
            return cloudAdventures.getAdventuresFromFileCloud();
        }
    }

    public int howManyAttacks() {
        Random random1 = new Random();
        return random1.nextInt(15) + 1;
    }



}
