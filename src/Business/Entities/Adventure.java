package Business.Entities;

import java.util.ArrayList;

/**
 * This is the entity class of the adventures, it contains all the constructors about to get and set
 * the attributes of an adventure
 */
public class Adventure {

    private String name;
    private int numFights;
    private ArrayList<Fight> fights;


    //Getters and Setters

    /**
     * Getter of the name of the adventure
     * @return: name of the adventure
     */
    public String getName() {
        return name;
    }

    /**
     * Getter of the number of fights of the adventure
     * @return: number of fights
     */
    public int getNumFights() {
        return numFights;
    }

    /**
     * Getter of the fights of the adventure
     * @return: ArrayList of fights of the adventure
     */
    public ArrayList<Fight> getFights() {
        return fights;
    }

    /**
     * Setter of the name of the adventure
     * @return: void
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter of the number of fights of the adventure
     * @return: void
     */
    public void setNumFights(int numFights) {
        this.numFights = numFights;
    }
    /**
     * Setter of the fights of the adventure
     * @return: void
     */
    public void setFights(ArrayList<Fight> fights) {
        this.fights = fights;
    }
}
