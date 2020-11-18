package com.nlnd.pokemonsearch.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.nlnd.pokemonsearch.R;
import com.nlnd.pokemonsearch.adapters.SearchResultListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.search_result_list_view);
        List pokemons = new ArrayList();
        SearchResultListAdapter searchResultArrayAdapter = new SearchResultListAdapter(this, R.layout.search_result_list_item, pokemons);

        ProgressBar progressBar = findViewById(R.id.loading);
        progressBar.setVisibility(View.GONE);

    }


}