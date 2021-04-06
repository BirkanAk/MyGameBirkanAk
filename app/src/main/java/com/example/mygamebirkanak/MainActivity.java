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
       CharactersArray.getInstance();
       return CharactersArray.characters;
    }


    private void createCharacter(final Characters c) {
        Card charactercard=new Card.Builder(this).withProvider(new CardProvider()).setLayout(R.layout.material_basic_image_buttons_card_layout).setTitle(c.getName()).setTitleGravity(Gravity.END).setDescription(c.getDescription()+"\n\n"+ "Strength:"+c.getStrength()+"\n"+ "Intelligence:"+c.getIntelligence()+"\n"+ "Agility:"+c.getAgility()+"\n"+ "Crafting:"+c.getCrafting()+"\n"+ "Charisma:"+c.getCharisma()).setDescriptionGravity(Gravity.END).setDrawable(c.getImage()).setDrawableConfiguration(new CardProvider.OnImageConfigListener() {
            @Override
            public void onImageConfigure(@NonNull RequestCreator requestCreator) {
                requestCreator.resize(150,250);
            }
        })
                .addAction(R.id.left_text_button,new TextViewAction(this).setText("Pick "+c.getName()).setTextResourceColor(R.color.orange_button).setListener(new OnActionClickListener() {
                    @Override
                    public void onActionClicked(View view, Card card) {
                        Toast.makeText(getApplicationContext(), "Picked Character: " +c.getName(), Toast.LENGTH_SHORT).show();
                        for (Characters temp: getData()){
                            temp.selected=false;
                        }
                        c.selected=true;


                        Intent act_action = new Intent(getApplicationContext(),Fight.class);
                        startActivity(act_action);
                    }
                }))
                .endConfig().build();

        materialListView.getAdapter().add(charactercard);
    }


}