package Persistance;

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


public class JSONCharacters {

    File jsonCharactersFile = new File("Files/JSONCharactersFile.json");
    private static final Type REVIEW_TYPE = new TypeToken<ArrayList<Character>>() {}.getType();

    public void savCharactersToFile(ArrayList<Character> charactersList) {
        Gson gson = new Gson();
        String json = gson.toJson(charactersList);
        try {
            FileWriter fileWriter = new FileWriter(jsonCharactersFile ,false);
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
