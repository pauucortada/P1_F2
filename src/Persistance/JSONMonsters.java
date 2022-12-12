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

public class JSONMonsters {

    File jsonMonstersFile = new File("Files/JSONMonstersFile.json");

    public void saveMonstersFile(ArrayList<Monster> monstersList) {
        try {
            FileWriter f = new FileWriter(jsonMonstersFile,false);
            f.write(new Gson().toJson(monstersList));
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Monster> getCharactersFromFile (){
        ArrayList<Monster> monstersList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try {

            Object obj = jsonParser.parse(new FileReader(jsonMonstersFile));
            JSONArray monstersJSONList = (JSONArray) obj;

            Iterator<JSONObject> monstersListJSON_iterator = monstersJSONList.iterator();

            while (monstersJSONList.iterator().hasNext()){

                JSONObject object = monstersListJSON_iterator.next();
                Monster monster = new Monster();

                monster.setName(object.get("name").toString());
                monster.setChallenge(object.get("challenge").toString());
                monster.setExperience(Integer.parseInt(object.get("experience").toString()));
                monster.setHitPoints(Integer.parseInt(object.get("hitPoints").toString()));
                monster.setInitiative(Integer.parseInt(object.get("initiative").toString()));
                monster.setDamageDice(object.get("damageDice").toString());
                monster.setDamageType(object.get("damageType").toString());

                monstersList.add(monster);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return monstersList;
    }

}
