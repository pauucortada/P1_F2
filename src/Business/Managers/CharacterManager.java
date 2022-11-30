package Business.Managers;

import Business.Entities.Character;

import java.util.ArrayList;
import java.util.Random;

public class CharacterManager {

    public void createCharacter(String name, String namePlayer, int level) {
        Character character = new Character();

        character.setName(name);
        character.setNamePlayer(namePlayer);
        character.setExperience(levelExperience(level));
        character.setBody(dausEstadistiques());
        character.setMind(dausEstadistiques());
        character.setSpirit(dausEstadistiques());
        character.setClasse("Adventurer");

        //Función crearPersonaje en el JSON
    }

    /*public ArrayList <Character> listCharacters (String nameCharacter) {
        ArrayList <Character> list =new ArrayList<>();
        //Función que lee los personajes del JSON

        if (nameCharacter.equals("\n")){
            return list;
        } else {
            int i = 0;
            while (list.get(i).equals())
        }
    }*/

    public int levelExperience(int level) {
        if (level == 1) {
            return 0;
        } else if (level == 2) {
            return 100;
        } else if (level == 3) {
            return 200;
        } else if (level == 4) {
            return 300;
        } else if (level == 5) {
            return 400;
        } else if (level == 6) {
            return 500;
        } else if (level == 7) {
            return 600;
        } else if (level == 8) {
            return 700;
        } else if (level == 9) {
            return 800;
        } else {
            return 900;
        }
    }

    public int dausEstadistiques() {
        Random random1 = new Random();
        int num1 = random1.nextInt(6) + 1;
        int num2 = random1.nextInt(6) + 1;
        return num1 + num2;
    }




}
