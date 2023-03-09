package Persistance;

import Business.Entities.Character;
import Business.Entities.Monster;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class saves and takes the Monster's data from the json
 */
public class JSONMonsters {

    File jsonMonstersFile = new File("Files/JSONMonstersFile.json");
    private static final Type REVIEW_TYPE = new TypeToken<ArrayList<Monster>>() {}.getType();

    /*public void saveMonstersFile(ArrayList<Monster> monstersList) {
        try {
            FileWriter f = new FileWriter(jsonMonstersFile,false);
            f.write(new Gson().toJson(monstersList));
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * In this method we get the Montser data from the json of monsters, we recive this data in
     * an ArrayList of Monsters
     * @return ArrayList
     */
    public ArrayList<Monster> getMonstersFromFile (){
        Gson gson = new Gson();

        try {
            JsonReader jsonReader = new JsonReader(new FileReader(jsonMonstersFile));
            return gson.fromJson(jsonReader, REVIEW_TYPE);

        } catch (IOException | NullPointerException e) {
            return new ArrayList<>();
        }
    }

}
