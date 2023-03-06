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

    private CharacterManager characterManager = new CharacterManager();
    private AdventureManager adventureManager = new AdventureManager();
    private FightManager fightManager = new FightManager();
    private MonsterManager monsterManager = new MonsterManager();
    private UIManager uiManager = new UIManager();

    public Controller(CharacterManager characterManager, AdventureManager adventureManager, FightManager fightManager, MonsterManager monsterManager, UIManager uiManager) {
        this.characterManager = characterManager;
        this.adventureManager = adventureManager;
        this.fightManager = fightManager;
        this.monsterManager = monsterManager;
        this.uiManager = uiManager;
    }

    public Controller() {

    }

    public void loadDataSuccess() {
        uiManager.printLogo();
        uiManager.loadDataSuccessfully(monsterManager.dataLoaded());
    }

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        String option;

        while (true) {

            uiManager.printMainMenu();
            option = sc.nextLine();

            if (Objects.equals(option, "1")){
                createCharacter();

            } else if (Objects.equals(option, "2")) {
                listCharacters();

            } else if (Objects.equals(option, "3")) {
                createAdventure();

            } else if (Objects.equals(option, "4")) {
                startAdventure();

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
        ArrayList<Integer> dausResults = new ArrayList<>(characterManager.dausResult());
        int level;

        uiManager.printCreateCharacterName();
        name = sc.nextLine();
        if (!characterManager.isNameValid(name)){
            uiManager.printUserExist();
            return;
        } else {
            name  = name.toLowerCase();
            name = capitalizeString(name);
        }

        uiManager.printCreateCharacterPlayer(name);
        namePlayer = sc.nextLine();

        uiManager.printCreateCharacterLevel();
        strlevel = sc.nextLine();
        while (!characterManager.isLevelValid(strlevel)){
            uiManager.printLevelError();
            strlevel = sc.nextLine();
        }

        level = parseInt(strlevel);
        characterManager.createCharacter(name, namePlayer, level, dausResults);
        Character character = characterManager.nameToCharacter(name);

        uiManager.printCreateCharacterStatistics(level, dausResults, characterManager.stats(character), name);

    }

    public void listCharacters() {
        Scanner sc = new Scanner(System.in);
        String name, stroption, deleteName;
        int option;

        uiManager.printListCharactersMenu();
        name = sc.nextLine();
        try {
            uiManager.printListCharactersPlayer(characterManager.listChosenCharactersByName(name));
            stroption = sc.nextLine();

            if (characterManager.isOptionValid(stroption)){
                option = parseInt(stroption);
            } else {
                uiManager.printErrorMainMenu();
                return;
            }

            int listSize = characterManager.listChosenCharactersByName(name).size();
            if (option == 0) {
                uiManager.printExit();
            } else if (option < 0 || option > listSize) {
                uiManager.printErrorMainMenu();
            } else {
                uiManager.printCharacter(characterManager.listChosenCharactersByName(name).get(option - 1), characterManager.whichLevel(characterManager.listChosenCharactersByName(name).get(option - 1)));
                deleteName = sc.nextLine();
                if (deleteName.equals(characterManager.listChosenCharactersByName(name).get(option - 1).getName())){
                    characterManager.deleteCharacter(deleteName);
                    uiManager.printdeleteCharacter(deleteName);
                }

            }

        } catch (NullPointerException npe) {
            uiManager.printThereAreNoCharacters();
        } catch (NumberFormatException nfe) {
            uiManager.invalidOption();
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
        while (!adventureManager.checkAdventureName(name)) {
            uiManager.printAdventureNameError(name);
            uiManager.printCreateAdventureName();
            name = sc.nextLine();
        }


        try {
            uiManager.printCreateAdventureEncounters(name);
            numFights = sc.nextLine();
            uiManager.printStartAdventure(parseInt(numFights));

            while (parseInt(numFights) >= countFights) {
                uiManager.printAdventureFights(countFights, parseInt(numFights), monstersFightList);
                option = sc.nextLine();

                switch (option) {
                    case "3" -> {
                        fights.add(fightManager.createFight(monstersFightList, countFights));
                        countFights++;
                    }
                    case "2" -> {
                        int j = 0, size = monstersFightList.size(), counter = 0;
                        String nameM;


                        uiManager.printDeleteMonster();
                        monsterIndex = sc.nextLine();
                        while (!monsterManager.isValidOption(monsterIndex, monstersFightList.size())){
                            uiManager.printMonsterChosenError();
                            uiManager.printDeleteMonster();
                            monsterIndex = sc.nextLine();
                        }
                        nameMonster = monstersFightList.get(parseInt(monsterIndex) - 1).getName();

                        while (size > j) {
                            nameM = monstersFightList.get(j).getName();
                            if (nameM.equals(nameMonster)) {
                                monstersFightList.remove(j);
                                size = monstersFightList.size();
                                j--;
                                counter++;
                            }
                            j++;
                        }

                        uiManager.printDeletedMonster(nameMonster, monstersFightList, counter);
                    }
                    case "1" -> {
                        int j = 0;

                        uiManager.printAdventureAddMonster(monsters);
                        monsterIndex = sc.nextLine();

                        while (!monsterManager.isValidOption(monsterIndex, monsters.size())){
                            uiManager.printMonsterChosenError();
                            uiManager.printAdventureAddMonster(monsters);
                            monsterIndex = sc.nextLine();
                        }

                        nameMonster = monsters.get(parseInt(monsterIndex) - 1).getName();

                        uiManager.printMonsterToAdd(nameMonster);
                        monstersToAdd = sc.nextLine();
                        while (parseInt(monstersToAdd) > j) {
                            monstersFightList.add(monsters.get(parseInt(monsterIndex) - 1));
                            j++;
                        }
                    }
                    default -> uiManager.invalidOptionAdventure();
                }
            }
            adventureManager.createAdventure(name, parseInt(numFights), fights);

            uiManager.printAdventureCreated(name);

        } catch (NumberFormatException nfe) {
            uiManager.printNumberFormatError();
        }

    }

    public void startAdventure() {
        Scanner sc = new Scanner(System.in);
        String adventureIndex, adventureName;
        int numCharcaters;
        ArrayList<Adventure> adventures = adventureManager.listAdventures();
        ArrayList<Character> mainCharacters = characterManager.listCharacters();

        uiManager.printPlayAdventureMenu(adventures);
        adventureIndex = sc.nextLine();
        adventureName = adventures.get(parseInt(adventureIndex) - 1).getName();

        try {
            uiManager.printPlayAdventureNumCharacters(adventureName);
            numCharcaters = sc.nextInt();
            while (numCharcaters < 3 || numCharcaters > 5) {
                uiManager.printNumCharactersError();
                uiManager.printPlayAdventureNumCharacters(adventureName);
                numCharcaters = sc.nextInt();
            }
        } catch (NumberFormatException nfe) {
            uiManager.printNumCharactersError();
            uiManager.printPlayAdventureNumCharacters(adventureName);
            numCharcaters = sc.nextInt();
        }

        uiManager.printNumOfCharacters(numCharcaters);

    }

    public void exitMainMenu() {
        uiManager.printExit();
    }

    public String capitalizeString(String chain) {
        return toUpperCase(chain.charAt(0)) + chain.substring(1);
    }
}
