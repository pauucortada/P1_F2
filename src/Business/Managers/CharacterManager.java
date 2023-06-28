package Business.Managers;

import Business.Entities.*;
import Business.Entities.Character;
import Persistance.JSON.JSONCharacters;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class CharacterManager {

    public void createAdventurer(String name, String namePlayer, int level, ArrayList<Integer> daus) {
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
        adventurer.setClasse("Adventurer");

        try {
            characters.add(adventurer);
            jsonCharacters.savCharactersToFile(characters);
        } catch (NullPointerException npe) {
            ArrayList<Character> characterArrayList = new ArrayList<>();
            characterArrayList.add(adventurer);
            jsonCharacters.savCharactersToFile(characterArrayList);
        }
    }

    public void createWarrior(String name, String namePlayer, int level, ArrayList<Integer> daus) {
        Warrior warrior = new Warrior();
        JSONCharacters jsonCharacters = new JSONCharacters();
        ArrayList<Integer> valors = valorEstadistiques(daus);
        ArrayList<Character> characters = jsonCharacters.getCharactersFromFile();

        warrior.setName(name);
        warrior.setNamePlayer(namePlayer);
        warrior.setExperience(levelExperience(level));
        warrior.setBody(valors.get(0));
        warrior.setMind(valors.get(1));
        warrior.setSpirit(valors.get(2));
        warrior.setTypeAttack("Improved Sword Slash");
        warrior.setClasse("Warrior");

        try {
            characters.add(warrior);
            jsonCharacters.savCharactersToFile(characters);
        } catch (NullPointerException npe) {
            ArrayList<Character> characterArrayList = new ArrayList<>();
            characterArrayList.add(warrior);
            jsonCharacters.savCharactersToFile(characterArrayList);
        }
    }

    public void createChampion(String name, String namePlayer, int level, ArrayList<Integer> daus) {
        Champion champion = new Champion();
        JSONCharacters jsonCharacters = new JSONCharacters();
        ArrayList<Integer> valors = valorEstadistiques(daus);
        ArrayList<Character> characters = jsonCharacters.getCharactersFromFile();

        champion.setName(name);
        champion.setNamePlayer(namePlayer);
        champion.setExperience(levelExperience(level));
        champion.setBody(valors.get(0));
        champion.setMind(valors.get(1));
        champion.setSpirit(valors.get(2));
        champion.setTypeAttack("Improved Sword Slash");
        champion.setClasse("Champion");

        try {
            characters.add(champion);
            jsonCharacters.savCharactersToFile(characters);
        } catch (NullPointerException npe) {
            ArrayList<Character> characterArrayList = new ArrayList<>();
            characterArrayList.add(champion);
            jsonCharacters.savCharactersToFile(characterArrayList);
        }
    }

    public void createCleric(String name, String namePlayer, int level, ArrayList<Integer> daus) {
        Cleric cleric = new Cleric();
        JSONCharacters jsonCharacters = new JSONCharacters();
        ArrayList<Integer> valors = valorEstadistiques(daus);
        ArrayList<Character> characters = jsonCharacters.getCharactersFromFile();

        cleric.setName(name);
        cleric.setNamePlayer(namePlayer);
        cleric.setExperience(levelExperience(level));
        cleric.setBody(valors.get(0));
        cleric.setMind(valors.get(1));
        cleric.setSpirit(valors.get(2));
        cleric.setTypeAttack("Not on my watch");
        cleric.setTypeAttack2("Prayer of healing");
        cleric.setClasse("Cleric");

        try {
            characters.add(cleric);
            jsonCharacters.savCharactersToFile(characters);
        } catch (NullPointerException npe) {
            ArrayList<Character> characterArrayList = new ArrayList<>();
            characterArrayList.add(cleric);
            jsonCharacters.savCharactersToFile(characterArrayList);
        }
    }

    public void createPaladin(String name, String namePlayer, int level, ArrayList<Integer> daus) {
        Paladin paladin = new Paladin();
        JSONCharacters jsonCharacters = new JSONCharacters();
        ArrayList<Integer> valors = valorEstadistiques(daus);
        ArrayList<Character> characters = jsonCharacters.getCharactersFromFile();

        paladin.setName(name);
        paladin.setNamePlayer(namePlayer);
        paladin.setExperience(levelExperience(level));
        paladin.setBody(valors.get(0));
        paladin.setMind(valors.get(1));
        paladin.setSpirit(valors.get(2));
        paladin.setTypeAttack("Not on my watch");
        paladin.setTypeAttack2("Prayer of mass healing");
        paladin.setClasse("Paladin");

        try {
            characters.add(paladin);
            jsonCharacters.savCharactersToFile(characters);
        } catch (NullPointerException npe) {
            ArrayList<Character> characterArrayList = new ArrayList<>();
            characterArrayList.add(paladin);
            jsonCharacters.savCharactersToFile(characterArrayList);
        }
    }

    public void createMage(String name, String namePlayer, int level, ArrayList<Integer> daus) {
        Mage mage = new Mage();
        JSONCharacters jsonCharacters = new JSONCharacters();
        ArrayList<Integer> valors = valorEstadistiques(daus);
        ArrayList<Character> characters = jsonCharacters.getCharactersFromFile();

        mage.setName(name);
        mage.setNamePlayer(namePlayer);
        mage.setExperience(levelExperience(level));
        mage.setBody(valors.get(0));
        mage.setMind(valors.get(1));
        mage.setSpirit(valors.get(2));
        mage.setTypeAttack("Fireball");
        mage.setTypeAttack2("Arcane missile");
        mage.setClasse("Mage");

        try {
            characters.add(mage);
            jsonCharacters.savCharactersToFile(characters);
        } catch (NullPointerException npe) {
            ArrayList<Character> characterArrayList = new ArrayList<>();
            characterArrayList.add(mage);
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
        try {
            int level;
            if (!strlevel.matches("[0-9]*")){
                return false;
            }
            level = parseInt(strlevel);
            return level >= 1 && level <= 10;
        } catch (NumberFormatException nfe) {
            return false;
        }

    }

    public boolean isOptionValid(String strOption) {

        try {
            return strOption.matches("[0-9]*") || strOption.equals("\n");
        } catch (NumberFormatException nfe) {
            return false;
        }

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

    public int attackDamage (Character character) {
        if (character instanceof Adventurer adventurer){
            return adventurer.attackDamage(character);
        } else if (character instanceof Cleric cleric) {
            return cleric.attackDamage(character);
        } else if (character instanceof Mage mage){
            return mage.attackDamage(character);
        } else {
            return 0;
        }
    }

    public int arcaneMisile(Character character){
        if (character instanceof Mage mage){
            return mage.arcaneMisile(character);
        } else {
            return 0;
        }
    }

    public boolean isHitting(){
        Random random1 = new Random();
        int num = random1.nextInt(15) + 1;
        return num <= 7;
    }

    public boolean levelHasChanged(int auxExp, int actualExp) {
        if (actualExp < 100){
            return false;
        }else {
            int previousLevel = (auxExp / 100) + 1;
            int currentLevel = (actualExp / 100) + 1;
            return previousLevel != currentLevel;
        }
    }

    public int getLevel(int experience) {
        return (experience / 100) + 1;
    }

    public boolean isTypeCorrect(String typeOfCharacter) {
        return typeOfCharacter.equals("Adventurer") || typeOfCharacter.equals("Cleric") || typeOfCharacter.equals("Mage");
    }

    public int bandageTime(){
        Random random1 = new Random();
        return random1.nextInt(8) + 1;
    }

    public boolean isCriticalDamage(int num){
        return num >= 10;
    }

    public Character whichCharacter(ArrayList<Character> characters, int size){
        Random random1 = new Random();
        int num = random1.nextInt(size);
        return characters.get(num);
    }

    public boolean areCharactersAlive(ArrayList<Character> characers){
        boolean alive = false;

        for (Character characer : characers) {
            if (!(characer.getActualPoints() <= 0)) {
                alive = true;
                break;
            }
        }
        return alive;
    }
}
