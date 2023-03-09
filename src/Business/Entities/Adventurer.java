package Business.Entities;

/**
 * Class related to the entity of an Adventurer that is a type of Character
 */
public class Adventurer extends Character {
    private String typeAttack;

    /**
     * Getter of the type of attack of the adventurer
     * @return: type of attack of the adventurer
     */
    public String getTypeAttack() {
        return typeAttack;
    }

    /**
     * Setter of the type of attack of the adventurer
     * @param typeAttack: type of attack of the adventurer
     */
    public void setTypeAttack(String typeAttack) {
        this.typeAttack = typeAttack;
    }
}
