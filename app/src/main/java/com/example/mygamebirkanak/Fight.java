package com.example.mygamebirkanak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;


public class Fight extends AppCompatActivity {
    ImageView selectedPortrait;
    ImageView enemyPortrait;
    RadioButton strengthradio;
    RadioButton intradio;
    RadioButton agilityradio;
    RadioButton craftradio;
    RadioButton charismaradio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        selectedPortrait= (ImageView) findViewById(R.id.pickedPortrait);
        enemyPortrait=(ImageView) findViewById(R.id.enemyPortrait);

        strengthradio=(RadioButton) findViewById(R.id.strengthradio);
        intradio=(RadioButton) findViewById(R.id.intradio);
        agilityradio=(RadioButton) findViewById(R.id.agiradio);
        craftradio=(RadioButton) findViewById(R.id.craftradio);
        charismaradio=(RadioButton) findViewById(R.id.charismaradio);

        this.loadCharacters();
    }

    private void loadCharacters() {
        for (Characters c:getData()){
            if(c.selected==true){
                selectedPortrait.setImageResource(c.getImage());
                strengthradio.setText("Strength: "+c.getStrength());
                intradio.setText("Intelligence: "+c.getIntelligence());
                agilityradio.setText("Agility: "+c.getAgility());
                craftradio.setText("Crafting: "+c.getCrafting());
                charismaradio.setText("Charisma: "+c.getCharisma());

                Characters enemy = CharactersArray.characters[2];
                enemyPortrait.setImageResource(enemy.getImage());
            }
        }
    }

    private Characters[] getData() {
        CharactersArray.getInstance();
        return CharactersArray.characters;
    }
}