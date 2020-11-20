package com.nlnd.pokemonsearch.Utils;

import com.nlnd.pokemonsearch.models.Pokemon;

public interface PokemonFetchCallback {
    void onSuccess(Pokemon pokemon);
}
