package Persistance;

import Business.Entities.Adventure;
import Business.Entities.Character;
import Business.Entities.Fight;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
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

    private static final Type REVIEW_TYPE = new TypeToken<ArrayList<Adventure>>() {}.getType();

    public void savAdventuresToFile(ArrayList<Adventure> adventureList) {
        Gson gson = new Gson();
        String json = gson.toJson(adventureList);
        try {
            FileWriter fileWriter = new FileWriter(jsonAdventuresFile ,false);
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Adventure> getAdventuresFromFile (){
        Gson gson = new Gson();

        try {

            JsonReader jsonReader = new JsonReader(new FileReader(jsonAdventuresFile));
            return gson.fromJson(jsonReader, REVIEW_TYPE);

        } catch (IOException | NullPointerException e) {
            return new ArrayList<>();
        }
    }

    /*public void saveAdventuresToFile(ArrayList<Adventure> adventuresList) {
        try {
            FileWriter f = new FileWriter(jsonAdventuresFile, false);
            f.write(new Gson().toJson(adventuresList));
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Adventure> getAdventuresFromFile() {

        ArrayList<Adventure> adventuresList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try {

            Object obj = jsonParser.parse(new FileReader(jsonAdventuresFile));
            JSONArray adventuresJSONList = (JSONArray) obj;

            for (JSONObject object : (Iterable<JSONObject>) adventuresJSONList) {

                // TODO: AGAFAR ARRAYLIST DE MONSTRES DE CADA FIGHT
                Gson g = new Gson();
                JsonReader reader = new JsonReader(new FileReader(jsonAdventuresFile));
                Adventure adventure = g.fromJson(reader, Adventure.class);
                adventuresList.add(adventure);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return adventuresList;
    }
}

    public ArrayList<Fight> getAdventuresFromFile (){

        ArrayList<Fight> adventuresList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try {

            Object obj = jsonParser.parse(new FileReader(jsonAdventuresFile));
            JSONArray adventuresJSONList = (JSONArray) obj;

            for (JSONObject object : (Iterable<JSONObject>) adventuresJSONList) {

                Fight fight = new Fight();

                fight.setId(Integer.parseInt(object.get("id").toString()));

                // TODO: AGAFAR ARRAYLIST DE MONSTRES DE CADA FIGHT
                Gson g = new Gson();
                JsonReader reader = new JsonReader(new FileReader(jsonAdventuresFile));
                fight = g.fromJson(reader, Fight.class);
                adventuresList.add(fight);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return adventuresList;
    }*/
}