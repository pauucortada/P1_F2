package Business.Managers;

import Business.Entities.*;
import Business.Entities.Character;
import Persistance.Cloud.CloudCharacters;
import Persistance.JSON.JSONCharacters;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

/**
 * This class manages all stuff related with characters logic
 */
public class CharacterManager {

    /**
     * This method is about to create a new adventurer
     * @param name: name of the adventurer
     * @param namePlayer: player's name of the adventurer
     * @param level: level of the adventurer
     * @param daus: random number for adventurer
     */
    public void createAdventurer(String name, String namePlayer, int level, ArrayList<Integer> daus) {
        Adventurer adventurer = new Adventurer();
        JSONCharacters jsonCharacters = new JSONCharacters();
        ArrayList<Integer> valors = valorEstadistiques(daus);
        ArrayList<Character> characters = jsonCharacters.getCharactersFromFile();

        adventurer.setName(name);
        adventurer.setNamePlayer(namePlayer);
        adventurer.setBody(valors.get(0));
        adventurer.setMind(valors.get(1));
        adventurer.setSpirit(valors.get(2));
        adventurer.setExperience(adventurer.calculateMaxLifePoints(adventurer, level));
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

    /**
     * This method is about to create a new warrior
     * @param name: name of the warrior
     * @param namePlayer: player's name of the warrior
     * @param level: level of the warrior
     * @param daus: random number for warrior
     */
    public void createWarrior(String name, String namePlayer, int level, ArrayList<Integer> daus) {
        Warrior warrior = new Warrior();
        JSONCharacters jsonCharacters = new JSONCharacters();
        ArrayList<Integer> valors = valorEstadistiques(daus);
        ArrayList<Character> characters = jsonCharacters.getCharactersFromFile();

        warrior.setName(name);
        warrior.setNamePlayer(namePlayer);
        warrior.setBody(valors.get(0));
        warrior.setMind(valors.get(1));
        warrior.setSpirit(valors.get(2));
        warrior.setExperience(warrior.calculateMaxLifePoints(warrior, level));
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

    /**
     * This method is about to create a new champion
     * @param name: name of the champion
     * @param namePlayer: player's name of the champion
     * @param level: level of the champion
     * @param daus: random number for champion
     */
    public void createChampion(String name, String namePlayer, int level, ArrayList<Integer> daus) {
        Champion champion = new Champion();
        JSONCharacters jsonCharacters = new JSONCharacters();
        ArrayList<Integer> valors = valorEstadistiques(daus);
        ArrayList<Character> characters = jsonCharacters.getCharactersFromFile();

        champion.setName(name);
        champion.setNamePlayer(namePlayer);
        champion.setBody(valors.get(0));
        champion.setMind(valors.get(1));
        champion.setSpirit(valors.get(2));
        champion.setExperience(champion.calculateMaxLifePoints(champion, level));
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

    /**
     * This method is about to create a new cleric
     * @param name: name of the cleric
     * @param namePlayer: player's name of the cleric
     * @param level: level of the cleric
     * @param daus: random number for cleric
     */
    public void createCleric(String name, String namePlayer, int level, ArrayList<Integer> daus, int option) throws IOException {
        Cleric cleric = new Cleric();
        JSONCharacters jsonCharacters = new JSONCharacters();
        CloudCharacters cloudCharacters = new CloudCharacters();

        ArrayList<Integer> valors = valorEstadistiques(daus);
        ArrayList<Character> characters = jsonCharacters.getCharactersFromFile();

        cleric.setName(name);
        cleric.setNamePlayer(namePlayer);
        cleric.setBody(valors.get(0));
        cleric.setMind(valors.get(1));
        cleric.setSpirit(valors.get(2));
        cleric.setExperience(cleric.calculateMaxLifePoints(cleric, level));
        cleric.setTypeAttack("Not on my watch");
        cleric.setTypeAttack2("Prayer of healing");
        cleric.setClasse("Cleric");

        if (option == 1){
            try {
                characters.add(cleric);
                jsonCharacters.savCharactersToFile(characters);
            } catch (NullPointerException npe) {
                ArrayList<Character> characterArrayList = new ArrayList<>();
                characterArrayList.add(cleric);
                jsonCharacters.savCharactersToFile(characterArrayList);
            }
        }else if (option == 2){
            try {
                characters.add(cleric);
                cloudCharacters.savCharactersToFileCloud(characters);
            } catch (NullPointerException npe) {
                ArrayList<Character> characterArrayList = new ArrayList<>();
                characterArrayList.add(cleric);
                cloudCharacters.savCharactersToFileCloud(characterArrayList);
            }
        }

    }

    /**
     * This method is about to create a new paladin
     * @param name: name of the paladin
     * @param namePlayer: player's name of the paladin
     * @param level: level of the paladin
     * @param daus: random number for paladin
     *
     */
    public void createPaladin(String name, String namePlayer, int level, ArrayList<Integer> daus, int option) throws IOException {
        Paladin paladin = new Paladin();
        JSONCharacters jsonCharacters = new JSONCharacters();
        CloudCharacters cloudCharacters = new CloudCharacters();
        ArrayList<Integer> valors = valorEstadistiques(daus);
        ArrayList<Character> characters = jsonCharacters.getCharactersFromFile();

        paladin.setName(name);
        paladin.setNamePlayer(namePlayer);
        paladin.setBody(valors.get(0));
        paladin.setMind(valors.get(1));
        paladin.setSpirit(valors.get(2));
        paladin.setExperience(paladin.calculateMaxLifePoints(paladin, level));
        paladin.setTypeAttack("Not on my watch");
        paladin.setTypeAttack2("Prayer of mass healing");
        paladin.setClasse("Paladin");

        if (option == 1){
            try {
                characters.add(paladin);
                jsonCharacters.savCharactersToFile(characters);
            } catch (NullPointerException npe) {
                ArrayList<Character> characterArrayList = new ArrayList<>();
                characterArrayList.add(paladin);
                jsonCharacters.savCharactersToFile(characterArrayList);
            }
        }else if (option == 2){
            try {
                characters.add(paladin);
                cloudCharacters.savCharactersToFileCloud(characters);
            } catch (NullPointerException | IOException npe) {
                ArrayList<Character> characterArrayList = new ArrayList<>();
                characterArrayList.add(paladin);
                cloudCharacters.savCharactersToFileCloud(characterArrayList);
            }
        }

    }
    /**
     * This method is about to create a new mage
     * @param name: name of the mage
     * @param namePlayer: player's name of the mage
     * @param level: level of the mage
     * @param daus: random number for mage
     *
     */
    public void createMage(String name, String namePlayer, int level, ArrayList<Integer> daus, int option) throws IOException {
        Mage mage = new Mage();
        JSONCharacters jsonCharacters = new JSONCharacters();
        CloudCharacters cloudCharacters = new CloudCharacters();
        ArrayList<Integer> valors = valorEstadistiques(daus);
        ArrayList<Character> characters = jsonCharacters.getCharactersFromFile();

        mage.setName(name);
        mage.setNamePlayer(namePlayer);
        mage.setBody(valors.get(0));
        mage.setMind(valors.get(1));
        mage.setSpirit(valors.get(2));
        mage.setExperience(mage.calculateMaxLifePoints(mage, level));
        mage.setTypeAttack("Fireball");
        mage.setTypeAttack2("Arcane missile");
        mage.setClasse("Mage");

        if (option == 1){
            try {
                characters.add(mage);
                jsonCharacters.savCharactersToFile(characters);
            } catch (NullPointerException npe) {
                ArrayList<Character> characterArrayList = new ArrayList<>();
                characterArrayList.add(mage);
                jsonCharacters.savCharactersToFile(characterArrayList);
            }
        }else if (option == 2){
            try {
                characters.add(mage);
                cloudCharacters.savCharactersToFileCloud(characters);
            } catch (NullPointerException | IOException npe) {
                ArrayList<Character> characterArrayList = new ArrayList<>();
                characterArrayList.add(mage);
                cloudCharacters.savCharactersToFileCloud(characterArrayList);
            }
        }

    }
    
    public String evolveCharacter(Character character, int level){
        if (character instanceof Adventurer adventurer && level > 3){
            adventurer.evolve(character);
        } else if (character instanceof Warrior warrior && level > 7) {
            warrior.evolve(character);
        } else if (character instanceof Cleric cleric && level > 4) {
            cleric.evolve(character);
        }
        return character.getClasse();
    }



    /**
     * This method returns the json of the characters in a list
     * @param option: if its from json or API
     * @return: list of characters
     */
    public ArrayList <Character> listCharacters(int option) throws IOException {
        CloudCharacters cloudCharacters = new CloudCharacters();
        JSONCharacters jsonCharacters = new JSONCharacters();
        if (option == 1){
            return jsonCharacters.getCharactersFromFile();
        }else{
            return cloudCharacters.getCharactersFromFileCloud();
        }
    }
    /**
     * THis class is the one that choose the character to play
     * @param namePlayer: name of the player
     * @param option: if its from cloud or json
     * @return
     */
    public ArrayList <Character> listChosenCharactersByName(String namePlayer, int option) throws IOException {
        ArrayList<Character> characters = listCharacters(option);
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


    public ArrayList<Integer> stats (Character character){
        ArrayList<Integer> stats = new ArrayList<>();
        stats.add(character.getBody());
        stats.add(character.getMind());
        stats.add(character.getSpirit());
        return stats;
    }

    /**
     * This method looks the random of statistics
     * @param daus
     * @return: random number
     */
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

    /**
     * This method returns a random of statistics
     * @return
     */
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

    /**
     * This method returns the result of "daus"
     * @return
     */
    public ArrayList<Integer> dausResult(){
        ArrayList<Integer> daus = new ArrayList<>();
        daus.addAll(dausEstadistiques());
        daus.addAll(dausEstadistiques());
        daus.addAll(dausEstadistiques());
        return daus;
    }

    /**
     * This method is about to implement when a character wants to be deleted
     * @param name
     */
    public void deleteCharacter(String name, int option) throws IOException {
        int i = 0;
        String nameC;
        ArrayList<Character> characters= new ArrayList<>();
        JSONCharacters jsonCharacters = new JSONCharacters();
        CloudCharacters cloudCharacters = new CloudCharacters();

        if (option == 1) {
            characters = jsonCharacters.getCharactersFromFile();
        }else if (option == 2){
            characters = cloudCharacters.getCharactersFromFileCloud();
        }
        while (characters.size() > i) {
            nameC = characters.get(i).getName();
            if (nameC.equals(name)){
                characters.remove(i);
                if(option == 1) {
                    jsonCharacters.savCharactersToFile(characters);
                }else{
                    cloudCharacters.savCharactersToFileCloud(characters);
                }
            }
            i++;
        }

    }

    /**
     * Return the level of a characeter depending the experience
     * @param character: character to look the level
     * @return: level of the character
     */
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

    /**
     * This method calculates the total hitpoints of the character
     * @param characters
     * @return
     */
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

    /**
     * This method checks if the name of a character is correct
     * @param chain: name
     * @return: 1 if is correct, 0 if not
     */
    public boolean isNameValid(String chain, int option) throws IOException {
        JSONCharacters jsonCharacters = new JSONCharacters();
        CloudCharacters cloudCharacters = new CloudCharacters();
        ArrayList<Character> characters;

        if (option == 1) {
            characters = jsonCharacters.getCharactersFromFile();
        } else {
            characters = cloudCharacters.getCharactersFromFileCloud();
        }


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

    /**
     * This method checks if the level of a character is correct
     * @param strlevel: level
     * @return: 1 if is correct, 0 if not
     */
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

    /**
     * This method checks if the option is correct
     * @param strOption: option
     * @return: 1 if is correct, 0 if not
     */
    public boolean isOptionValid(String strOption) {

        try {
            return strOption.matches("[0-9]*") || strOption.equals("\n");
        } catch (NumberFormatException nfe) {
            return false;
        }

    }

    /**
     * This method checks the character list and gets the one that is choosen
     * @param name: name of the one to choose
     * @return: character choosen
     */
    public Character nameToCharacter(String name, int option) throws IOException {
        JSONCharacters jsonCharacters = new JSONCharacters();
        CloudCharacters cloudCharacters = new CloudCharacters();
        ArrayList<Character> characters;

        if (option == 1){
            characters = jsonCharacters.getCharactersFromFile();
        } else {
            characters = cloudCharacters.getCharactersFromFileCloud();
        }

        int i = 0;

        while (characters.size() > i) {
            if (characters.get(i).getName().equals(name)){
                return characters.get(i);
            }
            i++;
        }
        return null;
    }

    /**
     * This method returns the randonm of damage
     * @param character
     * @return
     */
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

    /**
     * Returns the random of a character to hit
     * @return
     */
    public boolean isHitting(){
        Random random1 = new Random();
        int num = random1.nextInt(15) + 1;
        return num <= 7;
    }

    /**
     * This method checks if a level of a character has changed
     * @param auxExp
     * @param actualExp
     * @return
     */
    public boolean levelHasChanged(int auxExp, int actualExp) {
        if (actualExp < 100){
            return false;
        }else {
            int previousLevel = (auxExp / 100) + 1;
            int currentLevel = (actualExp / 100) + 1;
            return previousLevel != currentLevel;
        }
    }

    /**
     * Calculates the level based on the experience points.
     * @param experience The experience points.
     * @return The calculated level.
     */
    public int getLevel(int experience) {
        return (experience / 100) + 1;
    }

    /**
     * This method looks if the type of the character is correct
     * @param typeOfCharacter: type of the character
     * @return
     */
    public boolean isTypeCorrect(String typeOfCharacter) {
        return typeOfCharacter.equals("Adventurer") || typeOfCharacter.equals("Cleric") || typeOfCharacter.equals("Mage");
    }

    /**
     * Generates a random time value for bandage application.
     * @return The random time value.
     */
    public int bandageTime(){
        Random random1 = new Random();
        return random1.nextInt(8) + 1;
    }

    /**
     * Determines if a damage roll is critical based on the roll value.
     * @param num The damage roll value.
     * @return true if the damage is critical, false otherwise.
     */
    public boolean isCriticalDamage(int num){
        return num >= 10;
    }

    /**
     * Selects a random character from the provided list.
     * @param characters The list of characters.
     * @param size       The size of the list.
     * @return The randomly selected character.
     */
    public Character whichCharacter(ArrayList<Character> characters, int size){
        Random random1 = new Random();
        int num = random1.nextInt(size);
        return characters.get(num);
    }

    /**
     * Checks if any characters in the provided list are alive.
     * @param characers The list of characters.
     * @return true if any characters are alive, false otherwise.
     */
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
