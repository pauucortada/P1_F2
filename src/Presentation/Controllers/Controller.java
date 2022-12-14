package Presentation.Controllers;

import Business.Entities.Adventure;
import Business.Entities.Character;
import Business.Entities.Fight;
import Business.Entities.Monster;
import Business.Managers.AdventureManager;
import Business.Managers.CharacterManager;
import Business.Managers.FightManager;
import Business.Managers.MonsterManager;
import Presentation.UIManagers.UIManager;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;
import static java.lang.Integer.parseInt;

public class Controller {

    private CharacterManager characterManager;
    private AdventureManager adventureManager;
    private FightManager fightManager;
    private MonsterManager monsterManager;
    private UIManager uiManager;

    public Controller(CharacterManager characterManager, AdventureManager adventureManager, FightManager fightManager, MonsterManager monsterManager, UIManager uiManager) {
        this.characterManager = characterManager;
        this.adventureManager = adventureManager;
        this.fightManager = fightManager;
        this.monsterManager = monsterManager;
        this.uiManager = uiManager;
    }

    public void loadDataSuccess() {
        uiManager.printLogo();
        if (monsterManager.dataLoaded()) {
            uiManager.loadDataSuccessfully(true);
        } else {
            uiManager.loadDataSuccessfully(false);
        }
    }

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        String option;

        uiManager.printMainMenu();
        option = sc.nextLine();

        while (true) {
            if (Objects.equals(option, "1")){
                createCharacter();
                break;
            } else if (Objects.equals(option, "2")) {
                listCharacters();
                break;
            } else if (Objects.equals(option, "3")) {
                createAdventure();
                break;
            } else if (Objects.equals(option, "4")) {
                startAdventure();
                break;
            } else if (Objects.equals(option, "5")) {
                exitMainMenu();
                break;
            } else {
                uiManager.printErrorMainMenu();
            }
        }

    }
    public void createCharacter() {
        Scanner sc = new Scanner(System.in);
        String name, namePlayer, strlevel;
        int level;

        uiManager.printCreateCharacterName();
        name = sc.nextLine();
        if (!characterManager.isNameValid(name)){
            return;
        } else {
            name = capitalizeString(name);
        }

        uiManager.printCreateCharacterPlayer(name);
        namePlayer = sc.nextLine();

        uiManager.printCreateCharacterLevel();
        strlevel = sc.nextLine();
        while (!characterManager.isLevelValid(strlevel)){
            uiManager.printLevelError();
        }

        level = parseInt(strlevel);
        characterManager.createCharacter(name, namePlayer, level);

        Character character = characterManager.nameToCharacter(name);
        uiManager.printCreateCharacterStatistics(level, characterManager.dausEstadistiques(), characterManager.staistics(character), name);

    }

    public void listCharacters() {
        Scanner sc = new Scanner(System.in);
        String name, stroption;
        int option;

        uiManager.printListCharactersMenu();
        name = sc.nextLine();
        uiManager.printListCharactersPlayer(characterManager.listCharacters(name));
        stroption = sc.nextLine();

        if (characterManager.isOptionValid(stroption)){
            option = parseInt(stroption);
        } else {
            uiManager.printErrorMainMenu();
            return;
        }

        int listSize = characterManager.listCharacters(name).size();
        if (option == 0) {
            uiManager.printExit();
        } else if (option < 0 || option > listSize) {
            uiManager.printErrorMainMenu();
        } else {
            uiManager.printCharacter(characterManager.listCharacters(name).get(option - 1), characterManager.whichLevel(characterManager.listCharacters(name).get(option - 1)));
        }

    }

    public void createAdventure() {
        Scanner sc = new Scanner(System.in);
        String name, numFights, option, nameMonster, monsterIndex, monstersToAdd;
        int countFights = 1, monstersToDel;
        ArrayList<Monster> monsters = monsterManager.listMonsters();
        ArrayList<Monster> monstersFightList = new ArrayList<>();
        ArrayList<Fight> fights = new ArrayList<>();

        uiManager.printCreateAdventureName();
        name = sc.nextLine();
        while (adventureManager.checkAdventureName(name)) {
            uiManager.printAdventureNameError(name);
            uiManager.printCreateAdventureName();
            name = sc.nextLine();
        }

        uiManager.printCreateAdventureEncounters(name);
        numFights = sc.nextLine();
        uiManager.printStartAdventure(parseInt(numFights));

        while (parseInt(numFights) >= countFights) {
            uiManager.printAdventureFights(countFights, parseInt(numFights), monsters);
            option = sc.nextLine();

            switch (option) {
                case "3" -> {
                    fights.add(fightManager.createFight(monstersFightList, countFights));
                    countFights++;
                }
                case "2" -> {
                    int j = 0;

                    uiManager.printDeleteMonster();
                    monsterIndex = sc.nextLine();
                    nameMonster = monstersFightList.get(parseInt(monsterIndex)).getName();
                    monstersToDel = fightManager.countMonsterName(nameMonster, monstersFightList);
                    while (monstersToDel > j) {
                        if (monstersFightList.get(j).getName().equals(nameMonster)) {
                            monstersFightList.remove(j);
                        }
                        j++;
                    }

                    uiManager.printDeletedMonster(nameMonster, monstersFightList);

                    break;
                }
                case "1" -> {
                    int j = 0;

                    uiManager.printAdventureAddMonster(monsters);
                    monsterIndex = sc.nextLine();
                    nameMonster = monsters.get(parseInt(monsterIndex) - 1).getName();

                    uiManager.printMonsterToAdd(nameMonster);
                    monstersToAdd = sc.nextLine();
                    while (parseInt(monstersToAdd) > j) {
                        monstersFightList.add(monsters.get(parseInt(monsterIndex) - 1));
                        j++;
                    }
                    break;
                }
                default -> uiManager.invalidOption();
            }
        }
        adventureManager.createAdventure(name, parseInt(numFights), fights);
    }

    public void startAdventure() {
        Scanner sc = new Scanner(System.in);
        String adventureIndex, adventureName, numCharcaters;
        ArrayList<Adventure> adventures = adventureManager.listAdventures();

        uiManager.printPlayAdventureMenu(adventures);
        adventureIndex = sc.nextLine();
        adventureName = adventures.get(parseInt(adventureIndex)).getName();

        uiManager.printPlayAdventureNumCharacters(adventureName);
        numCharcaters = sc.nextLine();
    }

    public void exitMainMenu() {
        uiManager.printExit();
    }

    public String capitalizeString(String chain) {
        return toUpperCase(chain.charAt(0)) + chain.substring(1);
    }
}
