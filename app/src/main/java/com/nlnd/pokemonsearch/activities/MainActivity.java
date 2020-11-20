package com.nlnd.pokemonsearch.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.nlnd.pokemonsearch.R;
import com.nlnd.pokemonsearch.Utils.Network;

import com.nlnd.pokemonsearch.adapters.SearchResultListAdapter;
import com.nlnd.pokemonsearch.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ProgressBar progressBar;
    Activity activity;
    Network network;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        network = new Network(this);

        listView = findViewById(R.id.search_result_list_view);

        progressBar = findViewById(R.id.loading);
        progressBar.setVisibility(View.GONE);

        EditText searchStringInput = findViewById(R.id.search_string);
        searchStringInput.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                startSearch(v.getText().toString());
                return true;
            }
            return  false;
        });
    }

    private void startSearch(String searchString) {
        progressBar.setVisibility(View.VISIBLE);
        listView.setAdapter(null);;
        List<Pokemon> pokemons = new ArrayList<>();

        SearchResultListAdapter searchResultArrayAdapter = new SearchResultListAdapter(activity,
                R.layout.search_result_list_item, pokemons);
        listView.setAdapter(searchResultArrayAdapter);
        network.searchList(searchString, urls -> {
            for (String url: urls) {
                network.fetchPokemon(url, pokemon -> {
                    pokemons.add(pokemon);
                    searchResultArrayAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                });
            }
        });
    }
}