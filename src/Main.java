import Business.Managers.AdventureManager;
import Business.Managers.CharacterManager;
import Presentation.Controllers.Controller;

/**
 * Main class of the program
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.loadDataSuccess();
        controller.mainMenu();

    }
}