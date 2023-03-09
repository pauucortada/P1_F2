package Business.Entities;

import java.util.ArrayList;

/**
 * Class related with the fight, it contains all the attributes of a fight
 */
public class Fight {
    private int id;
    private ArrayList<Monster> monsters;

    // Getters and Setters

    /**
     * Getter of the id of a fight
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Getter of the ArrayList of Monsters of a fight
     * @return: ArrayList of Monsters
     */
    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    /**
     * Setter of the id of the fight
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter of the ArrayList of the monsters
     * @param monsters
     */
    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }
}
