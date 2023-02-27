package Business.Managers;

import Business.Entities.Monster;
import Persistance.JSONMonsters;

import java.util.ArrayList;
import java.util.Random;

public class MonsterManager {

    public ArrayList<Monster> listMonsters() {
        JSONMonsters jsonMonsters = new JSONMonsters();
        return jsonMonsters.getCharactersFromFile();
    }

    public boolean dataLoaded() {
        boolean isDataLoaded = false;
        if (listMonsters().size() == 0) {
            return isDataLoaded;
        }
        return !isDataLoaded;
    }

}
