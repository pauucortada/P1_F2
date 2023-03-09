package Business.Managers;

import Business.Entities.Monster;
import Persistance.JSONMonsters;

import java.util.ArrayList;

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
    public ArrayList<Monster> listMonsters() {
        JSONMonsters jsonMonsters = new JSONMonsters();
        return jsonMonsters.getMonstersFromFile();
    }

    /**
     * This method returns if the data has been loaded correctly
     * @return: boolean
     */
    public boolean dataLoaded() {
        boolean isDataLoaded = false;
        if (listMonsters().size() == 0) {
            return isDataLoaded;
        }
        return !isDataLoaded;
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

}
