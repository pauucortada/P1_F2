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
        adventurer.setBody(valorEstadistiques());
        adventurer.setMind(valorEstadistiques());
        adventurer.setSpirit(valorEstadistiques());

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

    public ArrayList<Integer> staistics(Character character) {
        ArrayList<Integer> stats = new ArrayList<>();
        stats.add(character.getBody());
        stats.add(character.getMind());
        stats.add(character.getSpirit());

        return stats;
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

    public int valorEstadistiques(){
        if (dausEstadistiques().get(2) == 2){
            return -1;
        } else if (dausEstadistiques().get(2) >= 3 && dausEstadistiques().get(2) <= 5) {
            return 0;
        } else if (dausEstadistiques().get(2) >= 6 && dausEstadistiques().get(2) <= 9) {
            return 1;
        } else if (dausEstadistiques().get(2) == 10 || dausEstadistiques().get(2) == 11) {
            return 2;
        } else {
            return 3;
        }
    }

    public ArrayList<Integer> dausEstadistiques() {
        ArrayList<Integer> statisticsNumbers = new ArrayList<>();
        Random random1 = new Random();
        int num1 = random1.nextInt(6) + 1;
        int num2 = random1.nextInt(6) + 1;
        int suma = num1 + num2;
        statisticsNumbers.add(num1);
        statisticsNumbers.add(num2);
        statisticsNumbers.add(suma);
        return statisticsNumbers;
    }

    public void deleteCharacter(String name, ArrayList<Character> characters) {
        int i = 0;

        while (!characters.get(i).getName().equals(name)){
            i++;
        }
        characters.remove(i);
        // Actualitzem JSON amb funció actualitzarDades(characters)
    }

    public int whichLevel(Character character) {
        int exp = character.getExperience();

        if (exp < 100){
            return 1;
        } else if (exp < 200) {
            return 2;
        } else if (exp < 300) {
            return 3;
        } else if (exp < 400) {
            return 4;
        } else if (exp < 500) {
            return 5;
        } else if (exp < 600) {
            return 6;
        } else if (exp < 700) {
            return 7;
        } else if (exp < 800) {
            return 8;
        } else if (exp < 900) {
            return 9;
        }
        return 10;
    }

    public ArrayList<Integer> calculateTotalHitPoints(ArrayList<Character> characters) {
        int i = 0, maxHitPoints;
        ArrayList<Integer> hitPoints = new ArrayList<>();
        while (characters.size() > i){
            maxHitPoints = (10 + characters.get(i).getBody()) * whichLevel(characters.get(i));
            hitPoints.add(maxHitPoints);
            i++;
        }
        return hitPoints;
    }
}
