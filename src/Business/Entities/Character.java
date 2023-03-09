package Business.Entities;

/**
 * Class related with the entity of a Character, it contains all the attributes of the entity and
 * the corresponded getters and setters with the constructors
 */
public class Character {

    private String name;
    private String namePlayer;
    private int experience;
    private int body;
    private int mind;
    private int spirit;

    private String classe;

    /**
     * void contructor of a character
     */
    public Character() {
    }

    /**
     * contrusctor of a Character
     * @param name: name of the character (string)
     * @param namePlayer:  name player of the character (string)
     * @param experience: experience of the character (int)
     * @param body: body of the character (int)
     * @param mind: mind of the character (int)
     * @param spirit: spirit o the character (int)
     * @param clas: class type of the character (string)
     */
    public Character(String name, String namePlayer, int experience, int body, int mind, int spirit, String clas) {
        this.name = name;
        this.namePlayer = namePlayer;
        this.experience = experience;
        this.body = body;
        this.mind = mind;
        this.spirit = spirit;
        this.classe = clas;
    }

// Getters and Setters

    /**
     * Getter of the name of the character
     * @return: name of the character
     */

    public String getName() {
        return name;
    }
    /**
     * Getter of the name player of the character
     * @return: name player of the character
     */
    public String getNamePlayer() {
        return namePlayer;
    }

    /**
     * Getter of the experience of the character
     * @return: experience of the character
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Getter of the body of the character
     * @return: body of the character
     */
    public int getBody() {
        return body;
    }

    /**
     * Getter of the mind of the character
     * @return: mind of the character
     */
    public int getMind() {
        return mind;
    }

    /**
     * Getter of the spirit of the character
     * @return: spirit of the character
     */
    public int getSpirit() {
        return spirit;
    }

    /**
     * Getter of the class type of the character
     * @return: class type of the character
     */
    public String getClasse() {
        return classe;
    }

    /**
     * Setter of the name of the character
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter of the mame player
     * @param namePlayer
     */
    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    /**
     * Setter of the experience
     * @param experience
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * Setter of the body of the character
     */
    public void setBody(int body) {
        this.body = body;
    }

    /**
     * Setter of the mind of the character
     * @param mind
     */
    public void setMind(int mind) {
        this.mind = mind;
    }

    /**
     * Setter of the spirit
     * @param spirit
     */
    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }

    /**
     * Setter of the class type
     * @param classe
     */
    public void setClasse(String classe) {
        this.classe = classe;
    }
}
