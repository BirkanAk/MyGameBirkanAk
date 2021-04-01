package com.example.mygamebirkanak;

public class Characters {
    private String name,description;
    private int strength,intelligence,agility,crafting,charisma;
    private int image;
    public boolean selected=false;

    public Characters(String name, String description, int strength,int intelligence,int agility,int crafting,int charisma,int image) {
        this.name = name;
        this.description = description;
        this.strength=strength;
        this.intelligence=intelligence;
        this.agility=agility;
        this.crafting=crafting;
        this.charisma=charisma;
        this.image = image;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public int getCrafting() {
        return crafting;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getImage() {
        return image;
    }
}
