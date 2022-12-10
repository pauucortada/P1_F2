package Persistance;

import Business.Entities.Monster;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


/*      FORMAT JSON MONSTERS
[
    {
        "name": "Orc",
        "challenge": "Minion",
        "experience": 3,
        "hitPoints": 9,
        "initiative": -1,
        "damageDice": "d6",
        "damageType": "Physical"
    },
    {
        "name": "Morgoth",
        "challenge": "Boss",
        "experience": 168,
        "hitPoints": 100,
        "initiative": 4,
        "damageDice": "d20",
        "damageType": "Psychical"
    }
]
*/

public class JSONMonsters {

    File jsonMonstersFile = new File("Files/JSONMonstersFile.json");

    public void saveMonstersToFile (ArrayList<Monster> monstersList) {
        try {
            FileWriter f = new FileWriter(jsonMonstersFile ,false);
            f.write(new Gson().toJson(monstersList));
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Monster> getMonstersFromFile () {
        ArrayList<Monster> monstersList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try {

            Object obj = jsonParser.parse(new FileReader(jsonMonstersFile));
            JSONArray monstersJSONList = (JSONArray) obj;

            Iterator<JSONObject> monstersListJSON_iterator = monstersJSONList.iterator();

            while (monstersListJSON_iterator.hasNext()){

                JSONObject object = monstersListJSON_iterator.next();
                Monster monster = new Monster();

                monster.setName(object.get("name").toString());
                monster.setChallenge(object.get("challenge").toString());
                monster.setExperience(Integer.parseInt(object.get("experience").toString()));
                monster.setExperience(Integer.parseInt(object.get("hitPoints").toString()));
                monster.setExperience(Integer.parseInt(object.get("initiative").toString()));
                monster.setChallenge(object.get("damageDice").toString());
                monster.setChallenge(object.get("Physical").toString());

                monstersList.add(monster);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return monstersList;
    }

    
}
