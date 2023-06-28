package Business.Managers;

import Business.Entities.Monster;
import Persistance.Cloud.CloudMonsters;
import Persistance.JSON.JSONMonsters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import static java.lang.Integer.parseInt;

/**
 * This class manages all related with the monsters, you can make different actions it also contacts
 * with the persistance.
 */
public class MonsterManager {

    /**
     * This method is the one that talks with the persistance json
     * @return: ArrayList of monsters from the persistance
     */
    public ArrayList<Monster> listMonsters(int option) throws IOException {

        if (option == 1) {
            JSONMonsters jsonMonsters = new JSONMonsters();
            return jsonMonsters.getMonstersFromFile();

        } else if(option == 2) {
            CloudMonsters cloudMonsters = new CloudMonsters();
            return cloudMonsters.getMonstersFromCloud();
        }
        return null;
    }

    /**
     * This method returns if the data has been loaded correctly
     * @return: boolean
     */
    public boolean dataLoaded(int option) throws IOException {
        return listMonsters(option).size() == 0;
    }


    /**
     * This method very similar to the one before says if the option is correct
     * @param option: option to select
     * @param size: size of matches
     * @return: boolean
     */
    public boolean isValidOption(String option, int size) {
        int validOption;
        if (!option.matches("[0-9]*")){
            return true;
        }
        validOption = parseInt(option);
        return validOption < 1 || validOption > size;
    }

    /**
     * Returns the attack of the nonster
     * @return: int
     */
    public int isMonsterAttacking() {
        Random random1 = new Random();
        return random1.nextInt(10) + 1;
    }

    /**
     * Returns a random monster of the list
     * @param monsters: arraylist of monsters
     * @param size: size of the arraylist
     * @return: monster choosen
     */
    public Monster whichMonster(ArrayList<Monster> monsters, int size){
        Random random1 = new Random();
        int num = random1.nextInt(size);
        return monsters.get(num);
    }



}
