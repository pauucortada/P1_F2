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
    URL url = new URL("https://balandrau.salle.url.edu/dpoo/shared/monsters");

    public CloudMonsters() throws MalformedURLException, IOException {
    }

    /**
     * In this method we get the Montser data from the json of monsters, we recive this data in
     * an ArrayList of Monsters
     * @return ArrayList
     */
    public ArrayList<Monster> getMonstersFromCloud () {
        Gson gson = new Gson();

        try {

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }
                reader.close();


                try {
                    JsonReader jsonReader = new JsonReader(new FileReader(String.valueOf(url)));
                    return gson.fromJson(String.valueOf(response), REVIEW_TYPE);

                } catch (NullPointerException e) {
                    return new ArrayList<>();
                }

            } else {
                // Manejar el error de la solicitud
                System.out.println("Error number: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
