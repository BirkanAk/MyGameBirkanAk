package com.example.mygamebirkanak;

public class CharactersArray {
    private static CharactersArray CHARACTERS=null;
    public static Characters[] characters;

    public CharactersArray(){
        characters=new Characters[6];
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
    }
    public static CharactersArray getInstance(){
        if(CharactersArray.CHARACTERS==null){
            CharactersArray.CHARACTERS=new CharactersArray();
            return CharactersArray.CHARACTERS;
        }else{
            return CharactersArray.CHARACTERS;
        }

    }


}
