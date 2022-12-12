package Business.Entities;

public class Character {

    private String name;
    private String namePlayer;
    private int experience;
    private int body;
    private int mind;
    private int spirit;
    private String clas;

    private String classe;

    public Character() {
    }

    public Character(String name, String namePlayer, int experience, int body, int mind, int spirit, String clas) {
        this.name = name;
        this.namePlayer = namePlayer;
        this.experience = experience;
        this.body = body;
        this.mind = mind;
        this.spirit = spirit;
        this.clas = clas;
    }

// Getters and Setters


    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getName() {
        return name;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public int getExperience() {
        return experience;
    }

    public int getBody() {
        return body;
    }

    public int getMind() {
        return mind;
    }

    public int getSpirit() {
        return spirit;
    }

    public String getClasse() {
        return classe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public void setMind(int mind) {
        this.mind = mind;
    }

    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}
