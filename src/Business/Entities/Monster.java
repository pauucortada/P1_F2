package Business.Entities;

/**
 * Class entity of a Monter, it contains all the getters, setters of a Monster with his
 * related attributes
 */
public class Monster {

    private String name;
    private String challenge;
    private int experience;
    private int hitPoints;
    private int initiative;
    private String damageDice;
    private String damageType;

    /**
     * Retrieves the name of the object.
     * @return The name of the object.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the challenge of the object.
     * @return The challenge of the object.
     */
    public String getChallenge() {
        return challenge;
    }

    /**
     * Retrieves the initiative of the object.
     * @return The initiative of the object.
     */
    public int getInitiative() {
        return initiative;
    }

    /**
     * Retrieves the damage type of the object.
     * @return The damage type of the object.
     */
    public String getDamageType() {
        return damageType;
    }

}
