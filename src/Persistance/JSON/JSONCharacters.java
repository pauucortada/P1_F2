package Persistance.JSON;

import Business.Entities.Character;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class is about the persistence of data for the characters
 */

public class JSONCharacters {

    File jsonCharactersFile = new File("Files/JSONCharactersFile.json");
    private static final Type REVIEW_TYPE = new TypeToken<ArrayList<Character>>() {}.getType();

    /**
     * We use this method to save the Characters data in a json, the parameter that recives
     * is an ArrayList of Characters
     * @param charactersList
     */
    public void savCharactersToFile(ArrayList<Character> charactersList) {
        Gson gson = new Gson();
        String json = gson.toJson(charactersList);
        try {
            FileWriter fileWriter = new FileWriter(jsonCharactersFile ,false);
            fileWriter.write(json); /// post to url
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returs an ArrayList of Characters of the json, we read the json in this method
     * @return ArrayList
     */
    public ArrayList<Character> getCharactersFromFile (){
        Gson gson = new Gson();

        try {

            JsonReader jsonReader = new JsonReader(new FileReader(jsonCharactersFile));
            return gson.fromJson(jsonReader, REVIEW_TYPE);

        } catch (IOException | NullPointerException e) {
            return new ArrayList<>();
        }
    }

}
