package Business.Managers;

import Business.Entities.Adventurer;
import Business.Entities.Character;
import Persistance.JSONCharacters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

import static java.lang.Character.getName;
import static java.lang.Character.toUpperCase;
import static java.lang.Integer.parseInt;

public class CharacterManager {

    public void createCharacter(String name, String namePlayer, int level, ArrayList<Integer> daus) {
        Adventurer adventurer = new Adventurer();
        JSONCharacters jsonCharacters = new JSONCharacters();
        ArrayList<Integer> valors = valorEstadistiques(daus);
        ArrayList<Character> characters = jsonCharacters.getCharactersFromFile();

        adventurer.setName(name);
        adventurer.setNamePlayer(namePlayer);
        adventurer.setExperience(levelExperience(level));
        adventurer.setBody(valors.get(0));
        adventurer.setMind(valors.get(1));
        adventurer.setSpirit(valors.get(2));
        adventurer.setTypeAttack("Sword Slash");

        try {
            characters.add(adventurer);
            jsonCharacters.savCharactersToFile(characters);
        } catch (NullPointerException npe) {
            ArrayList<Character> characterArrayList = new ArrayList<>();
            characterArrayList.add(adventurer);
            jsonCharacters.savCharactersToFile(characterArrayList);
        }


    }

    public ArrayList <Character> listCharacters(){
        JSONCharacters jsonCharacters = new JSONCharacters();
        return jsonCharacters.getCharactersFromFile();
    }

    public ArrayList <Character> listChosenCharactersByName(String namePlayer) {
        ArrayList<Character> characters = listCharacters();
        ArrayList<Character> charactersFiltered = new ArrayList<>();
        int i = 0;

        if (namePlayer.equals("")){
            return characters;
        } else {
            String name = namePlayer.toLowerCase();
            while (characters.size() > i) {
                if (characters.get(i).getNamePlayer().toLowerCase().equals(name)) {
                    charactersFiltered.add(characters.get(i));
                }
                i++;
            }
            return charactersFiltered;
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

    public ArrayList<Integer> stats (Character character){
        ArrayList<Integer> stats = new ArrayList<>();
        stats.add(character.getBody());
        stats.add(character.getMind());
        stats.add(character.getSpirit());
        return stats;
    }

    public ArrayList<Integer> valorEstadistiques(ArrayList<Integer> daus){
        ArrayList<Integer> valors = new ArrayList<>();
        int i = 2;

        while (i <= 8){
            if (i == 2 || i == 5 || i == 8){
                if (daus.get(i) == 2){
                    valors.add(-1);
                } else if (daus.get(i) >= 3 && daus.get(i) <= 5) {
                    valors.add(0);
                } else if (daus.get(i) >= 6 && daus.get(i) <= 9) {
                    valors.add(1);
                } else if (daus.get(i) == 10 || daus.get(i) == 11) {
                    valors.add(2);
                } else {
                    valors.add(3);
                }
            }
            i++;
        }

        return valors;
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

    public ArrayList<Integer> dausResult(){
        ArrayList<Integer> daus = new ArrayList<>();
        daus.addAll(dausEstadistiques());
        daus.addAll(dausEstadistiques());
        daus.addAll(dausEstadistiques());
        return daus;
    }

    public void deleteCharacter(String name) {
        int i = 0;
        String nameC;
        JSONCharacters jsonCharacters = new JSONCharacters();
        ArrayList<Character> characters = jsonCharacters.getCharactersFromFile();

        while (characters.size() > i) {
            nameC = characters.get(i).getName();
            if (nameC.equals(name)){
                characters.remove(i);
                jsonCharacters.savCharactersToFile(characters);
            }
            i++;
        }

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

    public boolean isNameValid(String chain) {
        JSONCharacters jsonCharacters = new JSONCharacters();
        ArrayList<Character> characters = jsonCharacters.getCharactersFromFile();
        int i = 0;
        String name = chain.toLowerCase();


        if ((!name.matches("[a-z]*")) && (!Pattern.matches(".*[éèàùúíìáäëïüóòöâãåąæāêęėēîįīôõøœōûūšđñçćčń].*", name))){
            return false;
        }

        try {
            while (characters.size() > i){
                if (characters.get(i).getName().toLowerCase().equals(name)){
                    return false;
                }
                i++;
            }
        } catch (NullPointerException npe) {
            return true;
        }

        return true;
    }

    public boolean isLevelValid(String strlevel) {
        int level;
        if (!strlevel.matches("[0-9]*")){
            return false;
        }
        level = parseInt(strlevel);
        return level >= 1 && level <= 10;
    }

    public boolean isOptionValid(String strOption) {

        try {
            return strOption.matches("[0-9]*") || strOption.equals("\n");
        } catch (NumberFormatException nfe) {
            return false;
        }

    }

    public String capitalizeString(String chain) {
        return toUpperCase(chain.charAt(0)) + chain.substring(1);
    }

    public Character nameToCharacter(String name) {
        JSONCharacters jsonCharacters = new JSONCharacters();
        ArrayList<Character> characters = jsonCharacters.getCharactersFromFile();

        int i = 0;

        while (characters.size() > i) {
            if (characters.get(i).getName().equals(name)){
                return characters.get(i);
            }
            i++;
        }
        return null;
    }

}
