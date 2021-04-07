package com.example.mygamebirkanak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
                Toast.makeText(getApplicationContext(), "You win!", Toast.LENGTH_SHORT).show();
                dialogAlert(true,selectedCharacter.getStrength(),enemyCharacter.getStrength(),"Strength");
                selectedCharacter.strCounter+=1;

            }
            else{
                Toast.makeText(getApplicationContext(), "You lost!", Toast.LENGTH_SHORT).show();
                dialogAlert(false,selectedCharacter.getStrength(),enemyCharacter.getStrength(),"Strength");
            }
        }
        else if (intradio.isChecked())
        {
            if(selectedCharacter.getIntelligence()>enemyCharacter.getIntelligence()){
                Toast.makeText(getApplicationContext(), "You win!", Toast.LENGTH_SHORT).show();
                dialogAlert(true,selectedCharacter.getIntelligence(),enemyCharacter.getIntelligence(),"Intelligence");
                selectedCharacter.intCounter+=1;
            }
            else{
                Toast.makeText(getApplicationContext(), "You lost!", Toast.LENGTH_SHORT).show();
                dialogAlert(false,selectedCharacter.getIntelligence(),enemyCharacter.getIntelligence(),"Intelligence");

            }
        }

        else if (agilityradio.isChecked())
        {
            if(selectedCharacter.getAgility()>enemyCharacter.getAgility()){
                Toast.makeText(getApplicationContext(), "You win!", Toast.LENGTH_SHORT).show();
                dialogAlert(true,selectedCharacter.getAgility(),enemyCharacter.getAgility(),"Agility");
                selectedCharacter.agiCounter+=1;
            }
            else{
                Toast.makeText(getApplicationContext(), "You lost!", Toast.LENGTH_SHORT).show();
                dialogAlert(false,selectedCharacter.getAgility(),enemyCharacter.getAgility(),"Agility");
            }
        }

        else if (craftradio.isChecked())
        {
            if(selectedCharacter.getCrafting()>enemyCharacter.getCrafting()){
                Toast.makeText(getApplicationContext(), "You win!", Toast.LENGTH_SHORT).show();
                dialogAlert(true,selectedCharacter.getCrafting(),enemyCharacter.getCrafting(),"Crafting");
                selectedCharacter.craftingCounter+=1;
            }
            else{
                Toast.makeText(getApplicationContext(), "You lost!", Toast.LENGTH_SHORT).show();
                dialogAlert(false,selectedCharacter.getCrafting(),enemyCharacter.getCrafting(),"Crafting");
            }
        }

        else if (charismaradio.isChecked())
        {
            if(selectedCharacter.getCharisma()>enemyCharacter.getCharisma()){
                Toast.makeText(getApplicationContext(), "You win!", Toast.LENGTH_SHORT).show();
                dialogAlert(true,selectedCharacter.getCharisma(),enemyCharacter.getCharisma(),"Charisma");
                selectedCharacter.charismaCounter+=1;
            }
            else{
                Toast.makeText(getApplicationContext(), "You lost!", Toast.LENGTH_SHORT).show();
                dialogAlert(false,selectedCharacter.getCharisma(),enemyCharacter.getCharisma(),"Charisma");

            }

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
    private void dialogAlert(boolean win,int x,int y,String stat){

        AlertDialog postFightDialog = new AlertDialog.Builder(Fight.this).create();
        if(win==true){
            postFightDialog.setTitle("You won! Match Summary");
            postFightDialog.setMessage("Your Vala was: "+selectedCharacter.getName()+"\nYour "+stat+" was: "+x+"\n\nYour enemy was:"+enemyCharacter.getName()+"\nIts "+stat+" was: "+y+"\n\nYour Vala got tired and its "+stat+" got decreased by 5.");
        }
        else{
            postFightDialog.setTitle("You lost... Match Summary");
            postFightDialog.setMessage("Your Vala was: "+selectedCharacter.getName()+"\nYour "+stat+" was: "+x+"\n\nYour enemy was:"+enemyCharacter.getName()+"\nIts "+stat+" was: "+y+"\n\nYour Vala couldn't win so its stat didn't change.");
        }
        postFightDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Fight another Vala!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        refresh();
                    }
                });
        postFightDialog.show();

    }
}