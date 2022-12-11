package Presentation.Controllers;

import Business.Managers.AdventureManager;
import Business.Managers.CharacterManager;
import Business.Managers.FightManager;
import Business.Managers.MonsterManager;
import Presentation.UIManagers.UIManager;

import java.util.Objects;
import java.util.Scanner;

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
        option = sc.next();

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

    }

    public void listCharacters() {

    }

    public void createAdventure() {

    }

    public void startAdventure() {

    }

    public void exitMainMenu() {
        uiManager.printExit();
    }
}
