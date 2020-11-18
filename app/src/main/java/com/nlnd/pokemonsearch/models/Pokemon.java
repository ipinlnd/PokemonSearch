package com.nlnd.pokemonsearch.models;

public class Pokemon {
    private int base_experience;
    private int height;
    private int held_items;
    private int id;
    private boolean is_default;
    private String location_area_encounters;
    private String name;
    private int order;
    private int weight;
    private String sprite;
    private String species;
    private String[] abilities;

    public int getBase_experience() {
        return base_experience;
    }

    public int getHeight() {
        return height;
    }

    public int getHeld_items() {
        return held_items;
    }

    public int getId() {
        return id;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public String getLocation_area_encounters() {
        return location_area_encounters;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public int getWeight() {
        return weight;
    }

    public String getSprite() {
        return sprite;
    }

    public String getSpecies() {
        return species;
    }

    public String[] getAbilities() {
        return abilities;
    }
}
