package com.example.mygamebirkanak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Fight extends AppCompatActivity {
    MaterialListView selectedMaterialListView;
    MaterialListView enemyMaterialListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        selectedMaterialListView= (MaterialListView) findViewById(R.id.fightMaterialListViewPicked);
        enemyMaterialListView=(MaterialListView) findViewById(R.id.fightMaterialListViewEnemy);

        this.loadCharacters();
    }

    private void loadCharacters() {
        for (Characters c:getData()){
            if(c.selected==true){
                this.createCharacter(c);
            }
        }
    }

    private Characters[] getData() {
        CharactersArray.getInstance();
        return CharactersArray.characters;
    }

    private void createCharacter(final Characters c) {
        Card charactercard=new Card.Builder(this).withProvider(new CardProvider()).setLayout(R.layout.material_basic_image_buttons_card_layout).setTitle(c.getName()).setTitleGravity(Gravity.END).setDescription(c.getDescription()+"\n\n"+ "Strength:"+c.getStrength()+"\n"+ "Intelligence:"+c.getIntelligence()+"\n"+ "Agility:"+c.getAgility()+"\n"+ "Crafting:"+c.getCrafting()+"\n"+ "Charisma:"+c.getCharisma()).setDescriptionGravity(Gravity.END).setDrawable(c.getImage()).setDrawableConfiguration(new CardProvider.OnImageConfigListener() {
            @Override
            public void onImageConfigure(@NonNull RequestCreator requestCreator) {
                requestCreator.resize(155,77);
            }
        }).endConfig().build();

        selectedMaterialListView.getAdapter().add(charactercard);
    }

}