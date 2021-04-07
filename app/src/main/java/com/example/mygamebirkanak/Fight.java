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
import android.widget.TextView;
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
    Button changeCharacterButton;
    TextView selectedName,selectedDesc,enemyName,enemyDesc,guide;

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
        changeCharacterButton=(Button) findViewById(R.id.changeCharacter);
        changeCharacterButton.setBackgroundColor(Color.parseColor("#DCCC0F"));

        selectedName=(TextView) findViewById(R.id.selectedName);
        selectedDesc=(TextView) findViewById(R.id.selectedDesc);
        enemyDesc=(TextView) findViewById(R.id.enemyDesc);
        enemyName=(TextView) findViewById(R.id.enemyName);
        guide=(TextView)findViewById(R.id.guide);

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
                selectedName.setText(c.getName());
                selectedDesc.setText(c.getDescription());


                Random ran = new Random();
                int randomCharacter = ran.nextInt(CharactersArray.characters.length);
                enemyCharacter = CharactersArray.characters[randomCharacter];
                if (enemyCharacter==selectedCharacter){
                    randomCharacter = ran.nextInt(CharactersArray.characters.length);
                    enemyCharacter = CharactersArray.characters[randomCharacter];
                }
                enemyPortrait.setImageResource(enemyCharacter.getImage());
                enemyName.setText(enemyCharacter.getName());
                enemyDesc.setText(enemyCharacter.getDescription());
                guide.setText("You are now fighting with "+enemyCharacter.getName()+" as " +c.getName()+". Your enemy's stats are unknown, so select a stat to fight with, but remember, if you win, your Vala will get tired, and that stat will decrease so you can't spam the strongest stat!");
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
            if(selectedCharacter.getStrength()>enemyCharacter.getStrength()){
                Toast.makeText(getApplicationContext(), "You win", Toast.LENGTH_SHORT).show();
                selectedCharacter.strCounter+=1;

            }
            else{
                Toast.makeText(getApplicationContext(), "You lost", Toast.LENGTH_SHORT).show();

            }
            refresh();
        }
        else if (intradio.isChecked())
        {
            if(selectedCharacter.getIntelligence()>enemyCharacter.getIntelligence()){
                Toast.makeText(getApplicationContext(), "You win", Toast.LENGTH_SHORT).show();
                selectedCharacter.intCounter+=1;
            }
            else{
                Toast.makeText(getApplicationContext(), "You lost", Toast.LENGTH_SHORT).show();

            }
            refresh();
        }

        else if (agilityradio.isChecked())
        {
            if(selectedCharacter.getAgility()>enemyCharacter.getAgility()){
                Toast.makeText(getApplicationContext(), "You win", Toast.LENGTH_SHORT).show();
                selectedCharacter.agiCounter+=1;
            }
            else{
                Toast.makeText(getApplicationContext(), "You lost", Toast.LENGTH_SHORT).show();

            }
            refresh();
        }

        else if (craftradio.isChecked())
        {
            if(selectedCharacter.getCrafting()>enemyCharacter.getCrafting()){
                Toast.makeText(getApplicationContext(), "You win", Toast.LENGTH_SHORT).show();
                selectedCharacter.craftingCounter+=1;
            }
            else{
                Toast.makeText(getApplicationContext(), "You lost", Toast.LENGTH_SHORT).show();

            }
            refresh();
        }

        else if (charismaradio.isChecked())
        {
            if(selectedCharacter.getCharisma()>enemyCharacter.getCharisma()){
                Toast.makeText(getApplicationContext(), "You win", Toast.LENGTH_SHORT).show();
                selectedCharacter.charismaCounter+=1;
            }
            else{
                Toast.makeText(getApplicationContext(), "You lost", Toast.LENGTH_SHORT).show();

            }
            refresh();
        }
    }

    private void refresh(){
        Intent refresh = getIntent();
        finish();
        startActivity(refresh);
    }

    public void onChangeCharacter(View view) {
        Intent act_action = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(act_action);
    }
}