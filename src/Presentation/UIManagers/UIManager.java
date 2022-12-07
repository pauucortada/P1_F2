package Presentation.UIManagers;

import Presentation.Controllers.Controller;

import java.util.ArrayList;

public class UIManager {

    public void printLogo(){
        System.out.println(" / __/(_)__ _   ___   / /___   / /   / __// _ \\ / _ \\ / ___/\n" +
                " _\\ \\ / //  ' \\ / _ \\ / // -_) / /__ _\\ \\ / , _// ___// (_ /\n" +
                "/___//_//_/_/_// .__//_/ \\__/ /____//___//_/|_|/_/    \\___/\n" +
                "/_/");

        System.out.println("\nWelcome to Simple LSRPG.\n");
    }

    public void loadDataSuccessfully(boolean dataLoaded){
        System.out.println("Loading data...");
        if (dataLoaded){
            System.out.println("Data was successfully loaded.\n");
        } else {
            System.out.println("Error: The monsters.json file can’t be accessed.\n");
        }
    }

    public void printMainMenu(){
        System.out.println("""
                The tavern keeper looks at you and says:
                “Welcome adventurer! How can I help you?”
                """);
        System.out.println("""
                    1) Character creation
                    2) List characters
                    3) Create an adventure
                    4) Start an adventure
                    5) Exit
                Your answer:""");
    }

    public void printCreateAdventureName(){
        System.out.println("""
                Tavern keeper: “Oh, so you are new to this land.”
                “What’s your name?”
                -> Enter your name:""");
    }

    public void printCreateAdventurePlayer(String name){
        System.out.println("Tavern keeper: “Hello " + name + ", be welcome.”\n" +
                "“And now, if I may break the fourth wall, who is your Player?” -> Enter the player’s name:");
    }

    public void printCreateAdventureLevel() {
        System.out.println("""
                Tavern keeper: “I see, I see...”
                “Now, are you an experienced adventurer?”
                -> Enter the character’s level [1..10]:""");
    }

    public void printCreateAdventureStatistics(int level, ArrayList<Integer> dacesResults, ArrayList<Integer> stats, String name) {
        System.out.println("Tavern keeper: “Oh, so you are level " + level + "!”\n" +
                "“Great, let me get a closer look at you...”\n" +
                "Generating your stats...\n" +
                "Body:   You rolled " + dacesResults.get (2) + " ("+ dacesResults.get (0) + " and " + dacesResults.get (1) + ").\n" +
                "Mind:   You rolled " + dacesResults.get (5) + " ("+ dacesResults.get (3) + " and " + dacesResults.get (4) + ").\n" +
                "Spirit: You rolled " + dacesResults.get (8) + " ("+ dacesResults.get (6) + " and " + dacesResults.get (7) + ").\n" +
                "Your stats are:\n" +
                "  - Body: " + stats.get(0) + "\n" +
                "  - Mind: " + stats.get(1) + "\n" +
                "  - Spirit: " + stats.get(2) + "\n" +
                "The new character " + name + " has been created.");
    }


    public void printListCharactersMenu(){
        System.out.println("""
                Tavern keeper: “Lads! They want to see you!”
                “Who piques your interest?”
                -> Enter the name of the Player to filter:""");
    }

    public void printListCharactersPlayer(ArrayList<String> characters){
        int i = 0;
        System.out.println("You watch as some adventurers get up from their chairs and approach you.\n");
        while (characters.size() > i){
            System.out.println(i + 1 + ". " + characters.get(i));
            i++;
        }
        System.out.println("\n0. Back\n");
        System.out.println("Who would you like to meet [0.."+ i+1 +"]: ");
    }

    public void printExit() {
        System.out.println("\nTavern keeper: “Are you leaving already? See you soon, adventurer.”\n");
    }




}
