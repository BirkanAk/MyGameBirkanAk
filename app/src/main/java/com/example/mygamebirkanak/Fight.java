package com.example.mygamebirkanak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class Fight extends AppCompatActivity {
    ImageView selected;
    ImageView enemy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        /*selected= (ImageView) findViewById(R.id.);
        enemy=(ImageView) findViewById(R.id.);*/

        this.loadCharacters();
    }

    private void loadCharacters() {
        for (Characters c:getData()){
            if(c.selected==true){

            }
        }
    }

    private Characters[] getData() {
        CharactersArray.getInstance();
        return CharactersArray.characters;
    }
}