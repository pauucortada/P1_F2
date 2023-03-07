import Business.Managers.AdventureManager;
import Business.Managers.CharacterManager;
import Presentation.Controllers.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.loadDataSuccess();
        controller.mainMenu();
        // System.out.println("Hello wor1ld!");

    }
}