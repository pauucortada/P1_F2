package Persistance.Cloud;

import Business.Entities.Adventure;
import Business.Entities.Character;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CloudAdventures {

    String url = "https://balandrau.salle.url.edu/dpoo/S1-Project_30/characters";
    private static final Type REVIEW_TYPE = new TypeToken<ArrayList<Character>>() {}.getType();

    public void savAdventuresToFileCloud(ArrayList<Adventure> adventureList) throws IOException {
            Gson gson = new Gson();
            ApiHelper apiHelper = new ApiHelper();

            try {

                for (int i = 0; i < adventureList.size(); i++) {
                    String body = gson.toJson(adventureList.get(i));
                    apiHelper.postToUrl(url, body);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    /**
     * Method that gets the adventures of the json
     * @return
     */
    public ArrayList<Adventure> getAdventuresFromFileCloud () throws IOException {
        Gson gson = new Gson();
        ApiHelper apiHelper = new ApiHelper();

        try {

            JsonReader jsonReader = new JsonReader(new FileReader(apiHelper.getFromUrl(url)));
            return gson.fromJson(jsonReader, REVIEW_TYPE);

        } catch (IOException | NullPointerException e) {
            return new ArrayList<>();
        }

    }
}
