package com.example.mygamebirkanak;

public class Characters {
    private String name,description;
    private int strength,intelligence,agility,crafting,charisma;
    private int image;
    public boolean selected=false;
    public int strCounter,intCounter,agiCounter,craftingCounter,charismaCounter=0;

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

    public int getStrength() { return strength-(strCounter*5); }

    public int getIntelligence() {return intelligence-(intCounter*5);}

    public int getAgility() {return agility-(agiCounter*5);}

    public int getCrafting() {
        return crafting-(craftingCounter*5);
    }

    public int getCharisma() {
        return charisma-(charismaCounter*5);
    }

    public int getImage() {
        return image;
    }

}
