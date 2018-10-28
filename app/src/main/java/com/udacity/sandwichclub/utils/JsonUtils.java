package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sw = new Sandwich();

        List<String> aka =  new ArrayList<>();

        List<String> ingredientList =  new ArrayList<>();

        //Log.i("FROM SANDWICH", "Received JSON: " + json);

        try {
            JSONObject jsonBody = new JSONObject(json);


            JSONObject jsonObject =  jsonBody.getJSONObject("name");

            JSONArray akaArray =  jsonObject.getJSONArray("alsoKnownAs");

            sw.setMainName(jsonObject.getString("mainName"));

            for(int i = 0; i < akaArray.length();i++){

                aka.add(akaArray.getString(i));
            }
            sw.setAlsoKnownAs(aka);

            sw.setPlaceOfOrigin(jsonBody.getString("placeOfOrigin"));

            sw.setDescription(jsonBody.getString("description"));

            JSONArray ingredientsArray = jsonBody.getJSONArray("ingredients");

            for(int i = 0; i < ingredientsArray.length();i++){

               ingredientList.add(ingredientsArray.getString(i));
            }
            sw.setIngredients(ingredientList);
            sw.setImage(jsonBody.getString("image"));
        }
        catch (Exception ee) {
            Log.i("A", "Fail to parse JSON: " + ee.getMessage());
        }
        Log.i("FROM SANDWICH", "A look at the string: " + json);



        return sw;
    }
}
