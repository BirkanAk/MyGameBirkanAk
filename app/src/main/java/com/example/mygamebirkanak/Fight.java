package com.example.mygamebirkanak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Random;


public class Fight extends AppCompatActivity {
    ImageView selectedPortrait;
    ImageView enemyPortrait;
    RadioButton strengthradio;
    RadioButton intradio;
    RadioButton agilityradio;
    RadioButton craftradio;
    RadioButton charismaradio;
    Button fightButton;

    Characters selectedCharacter;
    Characters enemyCharacter;


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

        fightButton=(Button) findViewById(R.id.fightButton);
        fightButton.setBackgroundColor(Color.parseColor("#DB3436"));

        this.loadCharacters();
    }

    private void loadCharacters() {
        for (Characters c:getData()){
            if(c.selected==true){
                selectedCharacter=c;
                selectedPortrait.setImageResource(c.getImage());
                strengthradio.setText("Strength: "+c.getStrength());
                intradio.setText("Intelligence: "+c.getIntelligence());
                agilityradio.setText("Agility: "+c.getAgility());
                craftradio.setText("Crafting: "+c.getCrafting());
                charismaradio.setText("Charisma: "+c.getCharisma());

                Random ran = new Random();
                int randomCharacter = ran.nextInt(CharactersArray.characters.length);
                enemyCharacter = CharactersArray.characters[randomCharacter];
                enemyPortrait.setImageResource(enemyCharacter.getImage());
            }
        }
    }

    private Characters[] getData() {
        CharactersArray.getInstance();
        return CharactersArray.characters;
    }

    public void onFight(View view) {
        if(strengthradio.isChecked())
        {
            Toast.makeText(getApplicationContext(), "STR", Toast.LENGTH_SHORT).show();
        }
        else if (intradio.isChecked())
        {
            Toast.makeText(getApplicationContext(), "INT", Toast.LENGTH_SHORT).show();
        }

        else if (agilityradio.isChecked())
        {
            Toast.makeText(getApplicationContext(), "Agility", Toast.LENGTH_SHORT).show();
        }

        else if (craftradio.isChecked())
        {
            Toast.makeText(getApplicationContext(), "Craft", Toast.LENGTH_SHORT).show();
        }

        else if (charismaradio.isChecked())
        {
            Toast.makeText(getApplicationContext(), "Charisma", Toast.LENGTH_SHORT).show();
        }
    }
}