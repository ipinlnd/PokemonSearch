package com.nlnd.pokemonsearch.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nlnd.pokemonsearch.R;
import com.nlnd.pokemonsearch.models.Pokemon;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    Pokemon pokemon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        pokemon = getIntent().getExtras().getParcelable("pokemon");
        setView();
    }

    private void setView() {
        TextView name = findViewById(R.id.details_name);
        TextView weight = findViewById(R.id.details_weight);
        TextView height = findViewById(R.id.details_height);
        TextView baseExperience = findViewById(R.id.details_base_experience);
        TextView order = findViewById(R.id.details_order);
        TextView species = findViewById(R.id.details_species);
        TextView abilities = findViewById(R.id.details_abilities);
        ImageView image = findViewById(R.id.details_image);

        Picasso.get().load(pokemon.getSprite()).into(image);
        name.setText("Name: " + pokemon.getName());
        weight.setText("Weight: " + pokemon.getWeight());
        height.setText("Height: " + pokemon.getHeight());
        baseExperience.setText("Base Experience: " + pokemon.getBase_experience());
        order.setText("Order: " + pokemon.getOrder());
        species.setText("Species: " + pokemon.getSpecies());
        String abilitiesStr = "";
        for (int i = 0; i < pokemon.getAbilities().size(); i++) {
            abilitiesStr += pokemon.getAbilities().get(i);
            if (i < pokemon.getAbilities().size() - 1) {
                abilitiesStr += ", ";
            }

        }
        abilities.setText("Abilities: " + abilitiesStr);
    }
}