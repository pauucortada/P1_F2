package Persistance.Cloud;

import Business.Entities.Monster;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CloudMonsters {

    private static final Type REVIEW_TYPE = new TypeToken<ArrayList<Monster>>() {}.getType();
    String url ="https://balandrau.salle.url.edu/dpoo/shared/monsters";

    public CloudMonsters(){
    }

    /**
     * In this method we get the Montser data from the json of monsters, we recive this data in
     * an ArrayList of Monsters
     * @return ArrayList
     */
    public ArrayList<Monster> getMonstersFromCloud () throws IOException {
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
