package com.nlnd.pokemonsearch.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nlnd.pokemonsearch.R;
import com.nlnd.pokemonsearch.models.Pokemon;

import java.util.List;

public class SearchResultListAdapter extends ArrayAdapter<Pokemon> {
    List<Pokemon> pokemons;
    Activity context;
    int resourceId;
    public SearchResultListAdapter(@NonNull Context context, int resource, @NonNull List<Pokemon> objects) {
        super(context, resource, objects);
        this.context = (Activity) context;
        this.pokemons = objects;
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View listItem = layoutInflater.inflate(this.resourceId, null, true);

        ImageView image = listItem.findViewById(R.id.list_item_image);
        TextView name = listItem.findViewById(R.id.list_item_name);
        LinearLayout container = listItem.findViewById(R.id.list_item_container);

        name.setText(pokemons.get(position).getName());

        return  listItem;
    }
}
