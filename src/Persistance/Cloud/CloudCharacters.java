package Persistance.Cloud;

import Business.Entities.Character;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class CloudCharacters {

    String url = "https://balandrau.salle.url.edu/dpoo/S1-Project_30/characters";
    private static final Type REVIEW_TYPE = new TypeToken<ArrayList<Character>>() {}.getType();

    /**
     * We use this method to save the Characters data in a API, the parameter that recives
     * is an ArrayList of Characters
     * @param charactersList
     */
    public void savCharactersToFileCloud(ArrayList<Character> charactersList) throws IOException {
        Gson gson = new Gson();
        ApiHelper apiHelper = new ApiHelper();

        try {

            for (int i = 0; i < charactersList.size(); i++) {
                String body = gson.toJson(charactersList.get(i));
                apiHelper.postToUrl(url, body);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returs an ArrayList of Characters of the Cloud API, we read the json in this method
     * @return ArrayList
     */
    public ArrayList<Character> getCharactersFromFileCloud () throws IOException {
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
