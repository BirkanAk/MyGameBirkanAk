package com.example.mygamebirkanak;

import androidx.annotation.NonNull;
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

        Characters[] characters=new Characters[6];

        Characters c;

        //Basically copy paste below and change values and the index for the rest.
        c=new Characters("Mandos","The Doomsayer, judge of all spirits. God of death.",38,97,14,44,78,R.drawable.mandos);
        characters[0]=c;

        c=new Characters("Melkor","Morgoth, the Black Foe of the World. The Dark Lord. God of Darkness, Chaos and Corruption.",88,73,76,84,98,R.drawable.melkor);
        characters[1]=c;

        c=new Characters("Nienna","She who cries, the weeping one. God of Grief, Sadness and Mourning.",13,67,17,56,36,R.drawable.nienna);
        characters[2]=c;

        c=new Characters("Tulkas","The Strong, Steadfast. Champian of Valar. God of Strength.",99,27,79,24,88,R.drawable.tulkas);
        characters[3]=c;

        c=new Characters("Ulmo","The Rainer, the Lord of the Waters. The god of Seas and Rivers.",84,93,72,64,90,R.drawable.ulmo);
        characters[4]=c;

        c=new Characters("Varda","The Lady of the Stars. The creator of Stars and Planets. The god of Zodiacs. ",47,86,46,92,81,R.drawable.varda);
        characters[5]=c;


        return  characters;
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
                    }
                }))
                .endConfig().build();

        materialListView.getAdapter().add(charactercard);
    }


}