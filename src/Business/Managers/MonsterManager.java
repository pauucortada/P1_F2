package Business.Managers;

import Business.Entities.Monster;

import java.util.ArrayList;
import java.util.Random;

public class MonsterManager {

    public ArrayList<Monster> listMonsters() {
        ArrayList<Monster> monsters = new ArrayList<>();
        //Funció de llegir monstres del JSON
        return monsters;
    }

    public boolean dataLoaded() {
        boolean isDataLoaded = false;
        if (listMonsters().size() == 0) {
            return isDataLoaded;
        }
        return !isDataLoaded;
    }

}
