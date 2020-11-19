package com.nlnd.pokemonsearch.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Pokemon implements Parcelable {
    private int base_experience;
    private int height;
    private int id;
    private boolean is_default;
    private String location_area_encounters;
    private String name;
    private int order;
    private int weight;
    private String sprite;
    private String species;
    private List<String> abilities;

    public Pokemon() {

    }

    protected Pokemon(Parcel in) {
        base_experience = in.readInt();
        height = in.readInt();
        id = in.readInt();
        is_default = in.readByte() != 0;
        location_area_encounters = in.readString();
        name = in.readString();
        order = in.readInt();
        weight = in.readInt();
        sprite = in.readString();
        species = in.readString();
        abilities = in.createStringArrayList();
    }

    public static final Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };

    public int getBase_experience() {
        return base_experience;
    }

    public int getHeight() {
        return height;
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

    public List<String> getAbilities() {
        return abilities;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIs_default(boolean is_default) {
        this.is_default = is_default;
    }

    public void setLocation_area_encounters(String location_area_encounters) {
        this.location_area_encounters = location_area_encounters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(base_experience);
        dest.writeInt(height);
        dest.writeInt(id);
        dest.writeByte((byte) (is_default ? 1 : 0));
        dest.writeString(location_area_encounters);
        dest.writeString(name);
        dest.writeInt(order);
        dest.writeInt(weight);
        dest.writeString(sprite);
        dest.writeString(species);
        dest.writeStringList(abilities);
    }
}
