package com.nlnd.pokemonsearch.Utils;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.nlnd.pokemonsearch.models.Pokemon;

import java.util.List;

public class Network {
    final String LIST_URL = "https://pokeapi.co/api/v2/pokemon/";
    Activity context;
    String cachedFullList;

    public Network(Activity context) {
        this.context = context;
        cachedFullList = "";
    }

    public void searchList(String searchString, ListCallback callback) {
        if (cachedFullList.length() > 0 ) {
            List<String> urls = new JsonToPokemon().getUrlList(cachedFullList, searchString);
            callback.onSuccess(urls);
        } else {
            RequestQueue queue = Volley.newRequestQueue(context);
            StringRequest request = new StringRequest(Request.Method.GET, LIST_URL + "?limit=2000", response -> {
                cachedFullList = response;
                List<String> urls = new JsonToPokemon().getUrlList(response, searchString);
                callback.onSuccess(urls);
            }, error -> System.out.println(error.getMessage()));
            queue.add(request);
        }
    }

    public void fetchPokemon(String url, PokemonFetchCallback callback) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
            Pokemon pokemon = new JsonToPokemon().translate(response);
            callback.onSuccess(pokemon);
        }, error -> System.out.println(error.getMessage()));
        queue.add(request);
    }

}
