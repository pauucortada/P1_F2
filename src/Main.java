import Business.Managers.AdventureManager;
import Business.Managers.CharacterManager;
import Presentation.Controllers.Controller;

import java.io.IOException;

/**
 * Main class of the program
 */
public class Main {
    public static void main(String[] args){
        Controller controller = new Controller();
        controller.loadDataSuccess();
        controller.mainMenu();

    }
}