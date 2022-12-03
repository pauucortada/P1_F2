package Business.Entities;

import java.util.ArrayList;

public class Fight {
    private int id;
    private ArrayList<Monster> monsters;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }
}
