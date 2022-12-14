package Persistance;

import Business.Entities.Character;
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


public class JSONCharacters {

    File jsonCharactersFile = new File("Files/JSONCharactersFile.json");

    public void savCharactersToFile(ArrayList<Character> charactersList) {
        try {
            FileWriter f = new FileWriter(jsonCharactersFile ,false);
            f.write(new Gson().toJson(charactersList));
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Character> getCharactersFromFile (){
        ArrayList<Character> characterList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try {

            Object obj = jsonParser.parse(new FileReader(jsonCharactersFile));
            JSONArray characterJSONList = (JSONArray) obj;

            for (JSONObject object : (Iterable<JSONObject>) characterJSONList) {
                Character character = new Character();

                character.setName(object.get("name").toString());
                character.setNamePlayer(object.get("player").toString());
                character.setExperience(Integer.parseInt(object.get("xp").toString()));
                character.setBody(Integer.parseInt(object.get("body").toString()));
                character.setMind(Integer.parseInt(object.get("mind").toString()));
                character.setSpirit(Integer.parseInt(object.get("spirit").toString()));
                character.setClas(object.get("class").toString());

                characterList.add(character);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return characterList;
    }
}
