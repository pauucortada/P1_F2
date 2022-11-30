package Business.Managers;

import Business.Entities.Adventurer;
import Business.Entities.Character;

import java.util.ArrayList;
import java.util.Random;

public class CharacterManager {

    public void createCharacter(String name, String namePlayer, int level) {
        Adventurer adventurer = new Adventurer();

        adventurer.setName(name);
        adventurer.setNamePlayer(namePlayer);
        adventurer.setExperience(levelExperience(level));
        adventurer.setBody(dausEstadistiques());
        adventurer.setMind(dausEstadistiques());
        adventurer.setSpirit(dausEstadistiques());
        adventurer.setClasse("Adventurer");

        Character character = adventurer;

        //Función crearPersonaje(character) en el JSON
    }

    public ArrayList <Character> listCharacters (String namePlayer) {
        ArrayList <Character> list = new ArrayList<>();

        if (namePlayer.equals("\n")){
            //Función que lee TODOS los personajes del JSON
            return list;
        } else {
            //Función que lee los personajes de un jugador
            return list;
        }
    }



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

    public void deleteCharacter(String name, ArrayList<Character> characters) {
        int i = 0;

        while (!characters.get(i).getName().equals(name)){
            i++;
        }
        characters.remove(i);
        // Actualitzem JSON amb funció actualitzarDades(characters)
    }

    
}
