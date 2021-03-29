package com.example.mygamebirkanak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;
import com.dexafree.materialList.card.OnActionClickListener;
import com.dexafree.materialList.card.action.TextViewAction;
import com.dexafree.materialList.view.MaterialListView;
import com.squareup.picasso.RequestCreator;

public class MainActivity extends AppCompatActivity {
    MaterialListView materialListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        materialListView= (MaterialListView) findViewById(R.id.materialListView);
        this.loadCharacters();
    }

    private void loadCharacters() {
        for (Characters c: getData()){
            this.createCharacter(c);
        }
    }

    private Characters[] getData() {
    }

    private void createCharacter(Characters c) {
    }


}