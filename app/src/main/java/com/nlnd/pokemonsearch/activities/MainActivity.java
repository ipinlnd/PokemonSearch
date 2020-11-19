package com.nlnd.pokemonsearch.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.nlnd.pokemonsearch.R;
import com.nlnd.pokemonsearch.Utils.JsonToPokemon;
import com.nlnd.pokemonsearch.adapters.SearchResultListAdapter;
import com.nlnd.pokemonsearch.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ProgressBar progressBar;
    Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        listView = findViewById(R.id.search_result_list_view);

        progressBar = findViewById(R.id.loading);
        progressBar.setVisibility(View.GONE);

        EditText searchStringInput = findViewById(R.id.search_string);
        searchStringInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    startSearch(v.getText().toString());
                    return true;
                }
                return  false;
            }
        });
    }

    private void startSearch(String searchString) {
        progressBar.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://pokeapi.co/api/v2/pokemon/" + searchString;
        listView.setAdapter(null);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                Pokemon pokemon = new JsonToPokemon().translate(response);
                List<Pokemon> pokemons = new ArrayList<>();
                pokemons.add(pokemon);
                progressBar.setVisibility(View.GONE);

                SearchResultListAdapter searchResultArrayAdapter = new SearchResultListAdapter(activity,
                        R.layout.search_result_list_item, pokemons);
                listView.setAdapter(searchResultArrayAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
                progressBar.setVisibility(View.GONE);
            }
        });
        queue.add(request);
    }
}