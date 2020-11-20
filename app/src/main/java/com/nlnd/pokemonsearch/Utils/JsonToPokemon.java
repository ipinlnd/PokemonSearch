package com.nlnd.pokemonsearch.Utils;

import com.nlnd.pokemonsearch.models.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonToPokemon {

    public List<String> getUrlList(String json, String searchString) {
        try {
            List<String> urls = new ArrayList<>();
            JSONObject object = new JSONObject(json);
            JSONArray result = object.getJSONArray("results");
            for (int i = 0; i < result.length(); i++) {
                String name = result.getJSONObject(i).getString("name");
                if (name.startsWith(searchString)) {
                    urls.add(result.getJSONObject(i).getString("url"));
                }
            }
            return urls;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Pokemon translate(String json) {
        Pokemon pokemon = new Pokemon();
        try {
            JSONObject object = new JSONObject(json);
            pokemon.setName(object.getString("name"));
            pokemon.setWeight(object.getInt("weight"));
            pokemon.setOrder(object.getInt("order"));
            pokemon.setLocation_area_encounters(object.getString("location_area_encounters"));
            pokemon.setIs_default(object.getBoolean("is_default"));
            pokemon.setId(object.getInt("id"));
            pokemon.setHeight(object.getInt("height"));
            pokemon.setBase_experience(object.getInt("base_experience"));
            pokemon.setSprite(object.getJSONObject("sprites").getJSONObject("other").getJSONObject("official-artwork").getString("front_default"));
            pokemon.setSpecies(object.getJSONObject("species").getString("name"));
            JSONArray abilities = object.getJSONArray("abilities");
            List<String> temp_abilities = new ArrayList<>();
            for (int i = 0; i < abilities.length(); i++) {
                temp_abilities.add(abilities.getJSONObject(i).getJSONObject("ability").getString("name"));
            }
            pokemon.setAbilities(temp_abilities);
            return pokemon;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
