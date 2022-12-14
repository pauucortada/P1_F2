package Persistance;

import Business.Entities.Adventure;
import Business.Entities.Fight;
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

    public ArrayList<Fight> getAdventuresFromFile (){

        ArrayList<Fight> adventuresList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try {

            Object obj = jsonParser.parse(new FileReader(jsonAdventuresFile));
            JSONArray adventuresJSONList = (JSONArray) obj;

            Iterator<JSONObject> adventuresListJSON_iterator = adventuresJSONList.iterator();

            while (adventuresListJSON_iterator.hasNext()){

                JSONObject object = adventuresListJSON_iterator.next();
                Fight fight = new Fight();

                fight.setId(Integer.parseInt(object.get("id").toString()));
                // TODO: AGAFAR ARRAYLIST DE MONSTRES DE CADA FIGHT


                adventuresList.add(fight);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return adventuresList;
    }




}
