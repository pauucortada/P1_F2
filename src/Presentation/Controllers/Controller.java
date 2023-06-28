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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;
import static java.lang.Integer.parseInt;

/**
 * This class is the one that manages all the program and implements the funcitons that are needed
 */
public class Controller {

    private CharacterManager characterManager = new CharacterManager();
    private AdventureManager adventureManager = new AdventureManager();
    private FightManager fightManager = new FightManager();
    private MonsterManager monsterManager = new MonsterManager();
    private UIManager uiManager = new UIManager();
    private int option;

    public Controller(CharacterManager characterManager, AdventureManager adventureManager, FightManager fightManager, MonsterManager monsterManager, UIManager uiManager) {
        this.characterManager = characterManager;
        this.adventureManager = adventureManager;
        this.fightManager = fightManager;
        this.monsterManager = monsterManager;
        this.uiManager = uiManager;
    }

    public Controller() {

    }

    /**
     * Method that checks if the data loaded is success
     */
    public void loadDataSuccess() throws IOException {
        uiManager.printLogo();
        uiManager.printAskData();
        Scanner sc = new Scanner(System.in);
        String option = null;
        option = sc.nextLine();

        if (Objects.equals(option, "1")){
            uiManager.loadDataSuccessfully(monsterManager.dataLoaded(1));
            this.option = 1;
        }else if (Objects.equals(option, "2")){
            uiManager.loadDataSuccessfully(monsterManager.dataLoaded(2));
            this.option = 2;

        }
    }


    /**
     * Method that checks which option of the menu is choosen
     */
    public void mainMenu() throws IOException {
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

    /**
     * Method related to create a new Character
     */
    public void createCharacter() {
        Scanner sc = new Scanner(System.in);
        String name, namePlayer, strlevel, typeOfCharacter;
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
        uiManager.printLevel(level);

        uiManager.printWhichTypeOfCharacter();
        typeOfCharacter = sc.nextLine();
        while (!characterManager.isTypeCorrect(typeOfCharacter)){
            uiManager.printTypeError();
            typeOfCharacter = sc.nextLine();
        }

        switch (typeOfCharacter) {
            case "Adventurer":
                if (level <= 3) {
                    characterManager.createAdventurer(name, namePlayer, level, dausResults);
                } else if (level > 3 && level <= 7) {
                    characterManager.createWarrior(name, namePlayer, level, dausResults);
                } else {
                    characterManager.createChampion(name, namePlayer, level, dausResults);
                }

                break;
            case "Cleric":
                if (level >= 5) {
                    characterManager.createPaladin(name, namePlayer, level, dausResults);
                } else {
                    characterManager.createCleric(name, namePlayer, level, dausResults);
                }
                break;
            case "Mage":
                characterManager.createMage(name, namePlayer, level, dausResults);
                break;
            default:
                uiManager.printError();
                break;
        }

        Character character = characterManager.nameToCharacter(name);
        uiManager.printCreateCharacterStatistics(dausResults, characterManager.stats(character), name);
        uiManager.printFinishType(character);



    }

    /**
     * Method choosed to list all the characters created before
     */
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

    /**
     * Method that is choosen when the user wants to create a new adventure
     */
    public void createAdventure() throws IOException {
        Scanner sc = new Scanner(System.in);
        String name, numFights, option, nameMonster, monsterIndex, monstersToAdd;
        int countFights = 1;
        ArrayList<Monster> monsters = monsterManager.listMonsters(this.option);
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

    /**
     * This method is the one that starts a new adventure when the user wants to play one
     */
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

        for (int l = 0; l < chosenCharacters.size(); l++) {
            chosenCharacters.get(l).setTotalPoints(totalPoints.get(l));
            chosenCharacters.get(l).setActualPoints(totalPoints.get(l));
        }
        uiManager.printPlayAdventureEnd(adventureName);

        // PREPARATION STAGE
        ArrayList<Monster> monsters = adventures.get(parseInt(adventureIndex) - 1).getFights().get(j).getMonsters();
        int numId = adventures.get(parseInt(adventureIndex) - 1).getFights().get(j).getId();
        uiManager.printIncreaseSpirit(monsters, numId, chosenCharacters);
        while (chosenCharacters.size() > z){
            int spirit = chosenCharacters.get(z).getSpirit() + 1;
            chosenCharacters.get(z).setSpirit(spirit);
            z++;
        }

        // COMBAT STAGE
        uiManager.printMonstersInitiative(monsters);
        boolean attacking;
        while (j < adventures.get(parseInt(adventureIndex) - 1).getNumFights()){
            uiManager.printCombatStageIntroduction(j + 1, chosenCharacters, actualPoints, totalPoints);

            while (adventureManager.howManyAttacks() > k) {
                Monster monster = monsterManager.whichMonster(monsters, monsters.size());
                Character character = characterManager.whichCharacter(chosenCharacters, chosenCharacters.size());
                int damage = characterManager.attackDamage(character);

                if (damage != 0){
                    if (monsterManager.isMonsterAttacking() > 1){
                        attacking = true;
                        character.setActualPoints(character.getActualPoints() - (damage + monsterManager.isMonsterAttacking()));
                    } else {
                        attacking = false;
                    }
                } else {
                    attacking = false;
                }


                //System.out.println("Damage : " + damage + "Attacking: " + monsterManager.isMonsterAttacking()) ;
                if (character.getActualPoints() <= 0){
                    character.setActualPoints(0);
                }

                uiManager.printAttacks(monster, character, damage,
                        attacking, // aqui ara es retorna un bool el qual et diu si ataca o no, abans retornava random de 0 al 10
                        characterManager.isHitting(),
                        characterManager.isCriticalDamage(damage)
                );
                k++;
            }

            uiManager.printEndOfRound(j + 1);
            j++;
            if (!characterManager.areCharactersAlive(chosenCharacters)){
                uiManager.printAllEnemiesDefeated();
            }
        }


        // SHORT STAGE
        uiManager.printShortStageTitle();
        for (Character chosenCharacter : chosenCharacters) {
            int bandage = characterManager.bandageTime();

            int curation = bandage + chosenCharacter.getMind();
            int auxExperience = chosenCharacter.getExperience();
            int actualExperience = curation + chosenCharacter.getActualPoints();
            chosenCharacter.setActualPoints(actualExperience);

            uiManager.printShortStageGainPoints(chosenCharacter, bandage, characterManager.levelHasChanged(auxExperience, actualExperience), characterManager.getLevel(chosenCharacter.getActualPoints()));
        }
        uiManager.printShortStageEnd(adventureName);

    }

    /**
     * Method that is used when the user wants to get out
     */
    public void exitMainMenu() {
        uiManager.printExit();
    }

    /**
     * Mehtod that puts the first letter of each word capital
     * @param chain
     * @return
     * @throws StringIndexOutOfBoundsException
     */
    public String capitalizeString(String chain) throws StringIndexOutOfBoundsException {
        return toUpperCase(chain.charAt(0)) + chain.substring(1);
    }
}
