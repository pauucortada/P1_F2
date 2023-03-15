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
        ArrayList<Character> characters = characterManager.listCharacters();
        String option;

        while (true) {
            try {
                if (characters.size() < 3) {
                    uiManager.printMainMenuWoCharacters();
                } else {
                    uiManager.printMainMenu();
                }
            } catch (NullPointerException npe) {
                uiManager.printMainMenuWoCharacters();
            }


            option = sc.nextLine();

            if (Objects.equals(option, "1")){
                createCharacter();

            } else if (Objects.equals(option, "2")) {
                listCharacters();

            } else if (Objects.equals(option, "3")) {
                createAdventure();

            } else if (Objects.equals(option, "4")) {
                try {
                    if (characters.size() < 3) {
                        uiManager.invalidOption();
                    } else {
                        startAdventure();
                    }
                } catch (NullPointerException npe) {
                    uiManager.invalidOption();
                }


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
            uiManager.invalidOption();
            return;
        } else {
            name  = name.toLowerCase();
            try {
                name = capitalizeString(name);
            } catch (StringIndexOutOfBoundsException sioobe) {
                uiManager.invalidOption();
                return;
            }

        }


        uiManager.printCreateCharacterPlayer(name);
        namePlayer = sc.nextLine();

        if (namePlayer.equals("")){
            uiManager.invalidOption();
            return;
        }

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
        int countFights = 1;
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
                        if (countFights > parseInt(numFights)){
                            adventureManager.createAdventure(name, parseInt(numFights), fights);
                        } else {
                            monstersFightList.clear();
                        }
                    }
                    case "2" -> {
                        int j = 0, size = monstersFightList.size(), counter = 0;
                        String nameM;


                        uiManager.printDeleteMonster();
                        monsterIndex = sc.nextLine();
                        while (monsterManager.isValidOption(monsterIndex, monstersFightList.size())){
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

                        while (monsterManager.isValidOption(monsterIndex, monsters.size())){
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

            uiManager.printAdventureCreated(name);

        } catch (NumberFormatException nfe) {
            uiManager.printNumberFormatError();
        }

    }

    public void startAdventure() {
        Scanner sc = new Scanner(System.in);
        String adventureIndex, adventureName, characterIndex;
        int numCharcaters, i = 0, j = 0, k = 0, z = 0;
        ArrayList<Adventure> adventures = adventureManager.listAdventures();
        ArrayList<Character> mainCharacters = characterManager.listCharacters();
        ArrayList<Character> chosenCharacters = new ArrayList<>();

        uiManager.printPlayAdventureMenu(adventures);
        adventureIndex = sc.nextLine();
        try {
            while (parseInt(adventureIndex) > adventures.size()){
                uiManager.printAdventuresError();
                adventureIndex = sc.nextLine();
            }
        } catch (NumberFormatException | IndexOutOfBoundsException nfe){
            uiManager.invalidOption();
            return;
        }
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

        while (i < numCharcaters){
            uiManager.printPlayAdventureChooseCharacters(mainCharacters, chosenCharacters, numCharcaters, (i + 1));
            characterIndex = sc.next();
            try {
                if (parseInt(characterIndex) <= mainCharacters.size()) {
                    chosenCharacters.add(mainCharacters.get(parseInt(characterIndex) - 1));
                    i++;
                } else {
                    uiManager.invalidOption();
                }

            } catch (NumberFormatException | IndexOutOfBoundsException nfe) {
                uiManager.invalidOption();
            }

        }


        ArrayList<Integer> totalPoints = new ArrayList<>(characterManager.calculateTotalHitPoints(chosenCharacters));
        ArrayList<Integer> actualPoints = new ArrayList<>(characterManager.calculateTotalHitPoints(chosenCharacters));

        uiManager.printPlayAdventureEnd(adventureName);

        while (j < adventures.get(parseInt(adventureIndex) - 1).getNumFights()){
            ArrayList<Monster> monsters = adventures.get(parseInt(adventureIndex) - 1).getFights().get(j).getMonsters();
            int numId = adventures.get(parseInt(adventureIndex) - 1).getFights().get(j).getId();
            uiManager.printIncreaseSpirit(monsters, numId, chosenCharacters);
            while (chosenCharacters.size() > z){
                int spirit = chosenCharacters.get(z).getSpirit() + 1;
                chosenCharacters.get(z).setSpirit(spirit);
                z++;
            }
            uiManager.printMonstersInitiative(monsters);
            uiManager.printCombatStageIntroduction(numId, chosenCharacters, actualPoints, totalPoints);

            while (adventureManager.howManyAttacks() > k) {
                Monster monster = monsterManager.whichMonster(monsters, monsters.size());
                Character character = characterManager.whichCharacter(chosenCharacters, chosenCharacters.size());
                int damage = characterManager.attackDamage(character);
                uiManager.printAttacks(
                        monster,
                        character,
                        damage,
                        isMonsterAttacking(monsterManager.isMonsterAttacking()),
                        characterManager.isHitting(),
                        characterManager.isCriticalDamage(damage)
                );
                k++;
            }


            j++;
        }
    }

    public boolean isMonsterAttacking(int num){
        return num < 2;
    }

    public void exitMainMenu() {
        uiManager.printExit();
    }

    public String capitalizeString(String chain) throws StringIndexOutOfBoundsException {
        return toUpperCase(chain.charAt(0)) + chain.substring(1);
    }
}
