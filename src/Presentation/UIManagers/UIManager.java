package Presentation.UIManagers;

import Business.Entities.Adventure;
import Business.Entities.Adventurer;
import Business.Entities.Character;
import Business.Entities.Monster;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class that shows all that is running in the program UI, it is in touch with the controllers, this class is about to
 * show all the data.
 */
public class UIManager {

    /**
     * This method shows the first logo
     */
    public void printLogo(){
        System.out.println("""
                 / __/(_)__ _   ___   / /___   / /   / __// _ \\ / _ \\ / ___/
                 _\\ \\ / //  ' \\ / _ \\ / // -_) / /__ _\\ \\ / , _// ___// (_ /
                /___//_//_/_/_// .__//_/ \\__/ /____//___//_/|_|/_/    \\___/
                /_/""");

        System.out.println("\nWelcome to Simple LSRPG.\n");
    }

    /**
     * This method says if the data entred has been loaded correctly
     * @param dataLoaded
     */
    public void loadDataSuccessfully(boolean dataLoaded){
        System.out.println("Loading data...");
        if (dataLoaded){
            System.out.println("Data was successfully loaded.\n");
        } else {
            System.out.println("Error: The monsters.json file can’t be accessed.\n");
        }
    }

    /**
     * This method prints the menu to choose the action you want to do
     */
    public void printMainMenu(){
        System.out.println("""
                \nThe tavern keeper looks at you and says:
                “Welcome adventurer! How can I help you?”
                """);
        System.out.print("""
                    1) Character creation
                    2) List characters
                    3) Create an adventure
                    4) Start an adventure
                    5) Exit
                \nYour answer:\040""");
    }

    /**
     * This method shows the menu
     */
    public void printMainMenuWoCharacters(){
        System.out.println("""
                The tavern keeper looks at you and says:
                “Welcome adventurer! How can I help you?”
                """);
        System.out.print("""
                    1) Character creation
                    2) List characters
                    3) Create an adventure
                    4) Start an adventure (disabled: create 3 characters first)
                    5) Exit
                \nYour answer:\040""");
    }

    /**
     * This method is about to enter the name of a character
     */
    public void printCreateCharacterName(){
        System.out.print("""
                Tavern keeper: “Oh, so you are new to this land.”
                “What’s your name?”
                -> Enter your name:\040""");
    }

    /**
     * This method will tell you that an user already exsits in the data base
     */
    public void printUserExist() {
        System.out.println("Sorry Lad, this username already exists!\n");
    }

    /**
     * This method wil ask you which character would you like to choose
     * @param name
     */
    public void printCreateCharacterPlayer(String name){
        System.out.print("Tavern keeper: “Hello " + name + ", be welcome.”\n" +
                "“And now, if I may break the fourth wall, who is your Player?” \n-> Enter the player’s name: ");
    }

    /**
     * This method will print the character level
     */
    public void printCreateCharacterLevel() {
        System.out.print("""
                Tavern keeper: “I see, I see...”
                “Now, are you an experienced adventurer?”
                -> Enter the character’s level [1..10]:\040""");
    }

    /**
     * This alert method is related when the option entred before is not correct
     */
    public void printLevelError() {
        System.out.print("This is not a valid option. Please, introduce a number from 1 to 10." +
                "\n-> Enter the character’s level [1..10]: ");
    }

    /**
     * This method prints a summary of the statitics of the character
     * @param level
     * @param dacesResults
     * @param stats
     * @param name
     */
    public void printCreateCharacterStatistics(int level, ArrayList<Integer> dacesResults, ArrayList<Integer> stats, String name) {
        System.out.println("Tavern keeper: “Oh, so you are level " + level + "!”\n" +
                "“Great, let me get a closer look at you...”\n" +
                "Generating your stats...\n" +
                "\nBody:   You rolled " + dacesResults.get (2) + " ("+ dacesResults.get (0) + " and " + dacesResults.get (1) + ").\n" +
                "Mind:   You rolled " + dacesResults.get (5) + " ("+ dacesResults.get (3) + " and " + dacesResults.get (4) + ").\n" +
                "Spirit: You rolled " + dacesResults.get (8) + " ("+ dacesResults.get (6) + " and " + dacesResults.get (7) + ").\n" +
                "\nYour stats are:\n" +
                "  - Body: " + stats.get(0) + "\n" +
                "  - Mind: " + stats.get(1) + "\n" +
                "  - Spirit: " + stats.get(2) + "\n" +
                "The new character " + name + " has been created.\n");
    }


    /**
     * This method ask which player you want to filter
     */
    public void printListCharactersMenu(){
        System.out.print("""
                Tavern keeper: “Lads! They want to see you!”
                “Who piques your interest?”
                -> Enter the name of the Player to filter:\040""");
    }

    /**
     * This method prints all the list of characters
     * @param characters
     */
    public void printListCharactersPlayer(ArrayList<Character> characters){
        int i = 0;
        System.out.println("You watch as some adventurers get up from their chairs and approach you.\n");
        if (characters.size() > 0){
            while (characters.size() > i){
                System.out.println(i + 1 + ". " + characters.get(i).getName());
                i++;
            }
            System.out.println("\n0. Back\n");
            System.out.print("Who would you like to meet [0.."+ i +"]: ");
        } else {
            printThereAreNoCharacters();
            System.out.print("Please, put 0 to go back: ");
        }

    }

    /**
     * This method prints when you leave
     */
    public void printExit() {
        System.out.println("\nTavern keeper: “Are you leaving already? See you soon, adventurer.”\n");
    }

    /**
     * This methos alarms that the option entred is not correct
     */
    public void printErrorMainMenu() {
        System.out.println("This is not an option, please, introduce a valid option.\n");
    }

    /**
     * This method prints the attributes of a character
     * @param character
     * @param level
     */
    public void printCharacter(Character character, int level) {

        System.out.println("\nTavern keeper: “Hey " + character.getName() + " get here; the boss wants to see you!”\n");
        System.out.println(
                "* Name: " + character.getName() + "\n" +
                "* Player: " + character.getNamePlayer() + "\n" +
                "* Class: " + "Adventurer" + "\n" +
                "* Level: " + level + "\n" +
                "* XP: " + character.getExperience() + "\n" +
                "* Body: " + character.getBody() + "\n" +
                "* Mind: " + character.getMind() + "\n" +
                "* Spirit: " + character.getSpirit() + "\n");
        System.out.print("[Enter name to delete, or press enter to cancel] \nDo you want to delete " + character.getName() + "? ");
    }

    /**
     * This methor prints when the list of characters is empty
     */
    public void printThereAreNoCharacters(){
        System.out.println("There are no characters to show, please, create one before listing.");
    }

    /**
     * This method prints when you want to delete a character
     * @param name
     */
    public void printdeleteCharacter(String name) {
        System.out.println("Tavern keeper: “I’m sorry kiddo, but you have to leave.”\n" +
                "Character " + name + " left the Guild.\n");
    }

    /**
     * This method prints a phrase when you want a new adventurer
     */
    public void printCreateAdventureName() {
        System.out.print("Tavern keeper: “Planning an adventure? Good luck with that!” \n-> Name your adventure: ");
    }

    /**
     * This method prints how many enconuters you want to add to a adventure
     * @param name
     */
    public void printCreateAdventureEncounters(String name) {
        System.out.print("Tavern keeper: “You plan to undertake " + name + ", really?”\n" +
                "“How long will that take?”\n" +
                "-> How many encounters do you want [1..4]: ");
    }

    /**
     * This method prints when there is an error in the name of the adventure
     * @param name
     */
    public void printAdventureNameError(String name) {
        System.out.println("Sorry, there is an adventure called: " + name + ". Please, choose another name.");
    }

    /**
     * This method shows that an adventurer has been created
     * @param name
     */
    public void printAdventureCreated (String name) {
        System.out.println("Your adventure " + name + "has been created, good luck.\n");
    }

    /**
     * This method prints the number of combats
     * @param numCmbt
     */
    public void printStartAdventure(int numCmbt) {
        System.out.println("Tavern keeper: “"+ numCmbt + " encounters? That is too much for me...”\n");
    }

    /**
     * This method is shown when has been a problem with there is not a number
     */
    public void printNumberFormatError(){
        System.out.print("This is not even a number!");
    }

    /**
     * This method prints the fights of an adventure
     * @param i
     * @param numCmbt
     * @param monsters
     */
    public void printAdventureFights(int i, int numCmbt, ArrayList<Monster> monsters) {
        int j = 0, k = 0;
        String nameAux;

        System.out.println("* Encounter "+ i +" / " + numCmbt + "\n" +
                "* Monsters in encounter\n");
        if (monsters.size() == 0) {
            System.out.println("# Empty");
        } else {
            while (monsters.size() > j) {
                nameAux = monsters.get(j).getName();
                if (j == 0){
                    System.out.println(k + 1 + ". " + monsters.get(j).getName() + " (x" + counterNameInList(monsters.get(j).getName(), monsters) + ")");
                    k++;
                } else {
                    if (!nameAux.equals(monsters.get(j - 1).getName())){
                        System.out.println(k + 1 + ". " + monsters.get(j).getName() + " (x" + counterNameInList(monsters.get(j).getName(), monsters) + ")");
                        k++;
                    }
                }
                j++;

            }
        }

        System.out.print("""
                \n1. Add monster
                2. Remove monster
                3. Continue
                -> Enter an option [1..3]:\040""");
    }

    /**
     * This method counts the number of monsters in the list
     * @param name
     * @param monsters
     * @return
     */
    public int counterNameInList(String name, ArrayList<Monster> monsters) {
        int i = 0, counter = 0;

        while (monsters.size() > i) {
            if (Objects.equals(monsters.get(i).getName(), name)) {
                counter++;
            }
            i++;
        }
        return counter;
    }

    /**
     * This method shows when you want to add a monster
     * @param monsters
     */
    public void printAdventureAddMonster(ArrayList<Monster> monsters) {
        int i = 0;
        while (monsters.size() > i) {
            System.out.println(i + 1 + ". " + monsters.get(i).getName() + " (" + monsters.get(i).getChallenge() + ")");
            i++;
        }
        System.out.print("\n" +
                "-> Choose a monster to add [1.." + monsters.size() + "]: ");
    }

    /**
     * This method ask the total monsters that you want to add
     * @param name
     */
    public void printMonsterToAdd(String name) {
        System.out.print("-> How many " + name + "(s) do you want to add: ");
    }

    /**
     * This method asks which montser you want to delete of the list
     */
    public void printDeleteMonster() {
        System.out.print("-> Which monster do you want to delete: ");
    }

    /**
     * This method is shown when the entred is not correct
     */
    public void printMonsterChosenError() {
        System.out.println("This is not a valid option.\n");
    }

    /**
     * This method is shown when you have deleted a monster of the list
     * @param name
     * @param monsters
     * @param counter
     */
    public void printDeletedMonster(String name, ArrayList<Monster> monsters, int counter) {
        System.out.println(counter + " " + name + " were removed from the encounter.");
    }

    /**
     * This method shows that an option writed is not correct
     */
    public void invalidOptionAdventure() {
        System.out.println("This is not a valid option, please, choose a number between 1 and 3.");
    }

    /**
     * This method shows that an option entred is not correct
     */
    public void invalidOption() {
        System.out.println("This is not a valid option.");
    }


    /**
     * This method below shows the name adventures of the lists and let you choose one of them
     * @param adventures
     */
    public void printPlayAdventureMenu(ArrayList<Adventure> adventures) {
        int i = 0;
        System.out.println("""
                Tavern keeper: “So, you are looking to go on an adventure?”
                “Where do you fancy going?”
                Available adventures:""");
        while (adventures.size() > i) {
            System.out.println("\t"+ (i + 1)  + ". " + adventures.get(i).getName());
            i++;
        }
        System.out.print("\n" +
                "-> Choose an adventure: ");
    }

    /**
     * This method is shown when an adventure writted does not exist
     */
    public void printAdventuresError() {
        System.out.print("This adventure does not exist, please, introduce a valid number: ");
    }

    /**
     * This method prints a question of how many characters doy you want to add
     * @param name
     */
    public void printPlayAdventureNumCharacters(String name) {
        System.out.print("Tavern keeper: “" + name + "”\n" +
                "“And how many people shall join you?”\n" +
                "-> Choose a number of characters [3..5]: ");
    }

    /**
     * This method prints an error when the a value entred is incorrect
     */
    public void printNumCharactersError() {
        System.out.println("This is not a number between 3 and 5, please, introduce a correct value.");
    }

    /**
     * In this method the total number of characters are printed
     * @param numCharacters
     */
    public void printNumOfCharacters(int numCharacters) {
        System.out.println("Tavern keeper: “Great, " + numCharacters + " it is.”\n" +
                "“Who among these lads shall join you?”");
    }

    /**
     * This method let you choose the character
     * @param totalCharacters
     * @param chosenCharacters
     * @param numCharacters
     * @param i
     */
    public void printPlayAdventureChooseCharacters(ArrayList<Character> totalCharacters, ArrayList<Character> chosenCharacters, int numCharacters, int i) {
        int j = 0;
        System.out.println("\n" +
                "------------------------------\n" +
                "Your party (" + i + " / " + numCharacters + "):\n");
        while (chosenCharacters.size() > j) {
            System.out.print(j + 1 + ". ");
            System.out.println(chosenCharacters.get(j).getName());
            j++;
        }

        j = 0;
        if (!(chosenCharacters.size() == numCharacters)) {
            while ((numCharacters - chosenCharacters.size()) > j) {
                System.out.println(j + 1 + ". Empty");
                j++;
            }
        }
        System.out.println("""
                ------------------------------
                Available characters:
                """);
        j = 0;
        while (totalCharacters.size() > j) {
            System.out.println(j + 1 + ". " + totalCharacters.get(j).getName());
            j++;
        }
        System.out.print("\n-> Choose character " + i + " in your party: ");
    }

    /**
     * The method below shis an end of an adventure
     * @param name
     */
    public void printPlayAdventureEnd (String name){
        System.out.println("Tavern keeper: “Great, good luck on your adventure lads!\n" +
                "The ”" + name + "” will start soon...");
    }

    /**
     * This method prints the starting encountrer and the starting of a fight
     * @param monsters
     * @param numEncounter
     * @param characters
     */
    public void printIncreaseSpirit(ArrayList<Monster> monsters, int numEncounter, ArrayList<Character> characters) {
        int j = 0;
        System.out.println("---------------------\n" +
                "Starting Encounter " + numEncounter + ":\n");
        while (monsters.size() > j) {
            System.out.println("\t- " + counterNameInList(monsters.get(j).getName(), monsters) +
                    "x " + monsters.get(j).getName());
            j++;
        }
        System.out.println("""
                ---------------------

                -------------------------
                *** Preparation stage ***
                -------------------------""");
        j = 0;
        while (characters.size() > j) {
            System.out.println(characters.get(j).getName() + " uses Self-Motivated. Their Spirit increases in +1.");
            j++;
        }
    }

    /**
     * This method prints the monster initiative
     * @param monsters
     */
    public void printMonstersInitiative(ArrayList<Monster> monsters) {
        int i = 0;
        System.out.println("\nRolling initiative...");
        while (monsters.size() > i) {
            System.out.println("\n- " + monsters.get(i).getInitiative() + "\t" + monsters.get(i).getName());
            i++;
        }
        System.out.println("""

                --------------------
                *** Combat stage ***
                --------------------
                """);
    }

    /**
     * this method prints the stage introduction of the combat
     * @param round
     * @param characters
     * @param actualPoints
     * @param totalPoints
     */
    public void printCombatStageIntroduction(int round, ArrayList<Character> characters, ArrayList<Integer> actualPoints, ArrayList<Integer> totalPoints) {
        int i = 0;
        System.out.println("Round" + round + ":");
        System.out.println("Party:");
        while (characters.size() > i) {
            System.out.println("\t-" + characters.get(i).getName() + "\t\t" +
                    actualPoints.get(i) + " / " + totalPoints.get(i) + " hit points");
            i++;
        }
    }

    /**
     * This method prints an attack
     * @param monster
     * @param character
     * @param damage
     * @param isMonsterAttacking
     * @param isHitting
     * @param criticalDamage
     */
    public void printAttacks(Monster monster, Character character, int damage, boolean isMonsterAttacking, boolean isHitting, boolean criticalDamage) {
        if (isMonsterAttacking) {
            System.out.println(monster.getName() + " attacks " + character.getName() + ".\n");
            if (isHitting) {
                System.out.println("Hits and deals " + damage + " " + monster.getDamageType() + ".");
            } else if (criticalDamage) {
                System.out.println("Critical hit and deals " + damage + " " + monster.getDamageType() + ".");
            } else {
                System.out.println("Fails and deals 0 " + monster.getDamageType() + ".");
            }
        } else {
            if (character instanceof Adventurer) {
                System.out.println(character.getName() + " attacks " + monster.getName() + " with " + ((Adventurer) character).getTypeAttack() + "\n");
                if (isHitting) {
                    System.out.println("Hits and deals " + damage + " physical damage.");
                } else if (criticalDamage) {
                    System.out.println("Critical hit and deals " + damage + " physical damage.");
                } else {
                    System.out.println("Fails and deals 0 physical damage.");
                }

            } else {
                System.out.println("Something went wrong");
            }

        }
    }

    /**
     * This method prints when a monster has died
     * @param monster
     */
    public void printMonsterDied (Monster monster) {
        System.out.println(monster.getName() + "dies.");
    }

    /**
     * This method prints all the enemies defeated in the fights
     * @param monsters
     */
    public void printAllEnemiesDefeated(ArrayList<Monster> monsters) {
        System.out.println("All enemies are defeated.");
    }

    /**
     * This method prints the characters to sleep
     * @param character
     */
    public void printCharacterToSleep(Character character) {
        System.out.println(character.getName() + " falls unconscious.");
    }

    /**
     * This method is shown when a round has ended
     * @param round
     */
    public void printEndOfRound(int round) {
        System.out.println("End of round " + round + ".");
    }

    /**
     * The method below prints the short stage title
     */
    public void printShortStageTitle (){
        System.out.println("""

                ------------------------
                *** Short rest stage ***
                ------------------------""");
    }

    /**
     * The method below prints when a character has won points and surpasses a level
     * @param character
     * @param experience
     * @param levelUp
     * @param level
     */
    public void printShortStageGainPoints(Character character, int experience, boolean levelUp, int level) {
        System.out.print(character.getName() + " gains " + experience + " xp.");

        if (levelUp) {
            System.out.println(" " + character.getName() + " levels up. They are now lvl " + level + "!");
        } else {
            System.out.println();
        }
    }

    /**
     * This method is shown when points has been hitted to the encounter.
     * @param character
     * @param pointsHealed
     */
    public void printShortStageHealPoints(Character character, int pointsHealed) {
        System.out.println(character.getName() + " uses Bandage time. Heals " + pointsHealed + " hit points.");
    }

}
