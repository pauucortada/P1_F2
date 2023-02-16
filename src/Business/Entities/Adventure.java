package Business.Entities;

import java.util.ArrayList;

public class Adventure {

    private String name;
    private int numFights;
    private ArrayList<Fight> fights;


    //Getters and Setters

    public String getName() {
        return name;
    }

    public int getNumFights() {
        return numFights;
    }

    public ArrayList<Fight> getFights() {
        return fights;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumFights(int numFights) {
        this.numFights = numFights;
    }

    public void setFights(ArrayList<Fight> fights) {
        this.fights = fights;
    }
}
