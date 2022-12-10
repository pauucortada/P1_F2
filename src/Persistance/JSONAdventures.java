package Persistance;

import Business.Entities.Adventure;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.util.Iterator;


/*      FORMAT JSON ADVENTURES

[
    {
        "name": "AventureName",
        "combats": "4",
        "monsters": 2, // Minim 3 personatges
    },
]*/

public class JSONAdventures {

    File jsonAdventuresFile = new File("Files/JSONAdventuresFile.json");


    public void saveAdventuresToFile(ArrayList<Adventure> adventuresList) {
        try {
            FileWriter f = new FileWriter(jsonAdventuresFile ,false);
            f.write(new Gson().toJson(adventuresList));
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Adventure> getAdventuresFromFile (){

    }




}
