package Presentation.Controllers;

import Business.Entities.Character;
import Business.Managers.AdventureManager;
import Business.Managers.CharacterManager;
import Business.Managers.FightManager;
import Business.Managers.MonsterManager;
import Presentation.UIManagers.UIManager;

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
        String name;

        uiManager.printCreateAdventureName();
        name = sc.nextLine();

    }

    public void startAdventure() {

    }

    public void exitMainMenu() {
        uiManager.printExit();
    }

    public String capitalizeString(String chain) {
        return toUpperCase(chain.charAt(0)) + chain.substring(1);
    }
}
