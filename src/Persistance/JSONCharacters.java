package Persistance;

import Business.Entities.Character;
import Business.Entities.Monster;
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

/*      FORMAT JSON CHARACTERS
[
    {
        "name": "Amrod",
        "player": "SonsOfFeanor",
        "xp": 229,
        "body": 2,
        "mind": 0,
        "spirit": 0,
        "class": "Adventurer"

    },
    {
        "name": "Caranthir",
        "player": "SonsOfFeanor",
        "xp": 306,
        "body": 2,
        "mind": 0,
        "spirit": 1,
        "class": "Adventurer"
    }
]
 */

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

            Iterator<JSONObject> characterListJSON_iterator = characterJSONList.iterator();

            while (characterListJSON_iterator.hasNext()){


                JSONObject object = characterListJSON_iterator.next();
                Character character = new Character();

                character.setName(object.get("name").toString());
                character.setNamePlayer(object.get("player").toString());
                character.setExperience(Integer.parseInt(object.get("xp").toString()));
                character.setBody(Integer.parseInt(object.get("body").toString()));
                character.setMind(Integer.parseInt(object.get("mind").toString()));
                character.setSpirit(Integer.parseInt(object.get("spirit").toString()));
                character.setClasse(object.get("class").toString());

                characterList.add(character);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return characterList;
    }
}
