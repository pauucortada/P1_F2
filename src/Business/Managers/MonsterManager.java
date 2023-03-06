package Business.Managers;

import Business.Entities.Monster;
import Persistance.JSONMonsters;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class MonsterManager {

    public ArrayList<Monster> listMonsters() {
        JSONMonsters jsonMonsters = new JSONMonsters();
        return jsonMonsters.getMonstersFromFile();
    }

    public boolean dataLoaded() {
        boolean isDataLoaded = false;
        if (listMonsters().size() == 0) {
            return isDataLoaded;
        }
        return !isDataLoaded;
    }

    public boolean isValidOption(String option, int size) {
        int validOption;
        if (!option.matches("[0-9]*")){
            return false;
        }
        validOption = parseInt(option);
        return validOption >= 1 && validOption <= size;
    }

}
