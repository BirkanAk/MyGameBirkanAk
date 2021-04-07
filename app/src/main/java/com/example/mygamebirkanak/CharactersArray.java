package com.example.mygamebirkanak;

public class CharactersArray {
    private static CharactersArray CHARACTERS=null;
    public static Characters[] characters;

    public CharactersArray(){
        characters=new Characters[15];
        Characters c;

        //Basically copy paste below and change values and the index for the rest.
        c=new Characters("Aule","The Smith, the Crafter. The God of Earth and Substances. God fo Dwarves.",81,83,41,99,82,R.drawable.aule);
        characters[0]=c;

        c=new Characters("Este","The Healer of the Hurt and Weary.",21,45,13,12,44,R.drawable.este);
        characters[1]=c;

        c=new Characters("Lorien","The God of Dreams, Illusions. The Master of Desires.",53,82,27,71,79,R.drawable.lorien);
        characters[2]=c;

        c=new Characters("Mandos","The Doomsayer, judge of all spirits. God of death.",38,97,14,44,78,R.drawable.mandos);
        characters[3]=c;

        c=new Characters("Manwe","The Blessed One. The Leader. The God of Wind and Eagles.",89,92,88,79,96,R.drawable.manwe);
        characters[4]=c;

        c=new Characters("Melkor","Morgoth, the Black Foe of the World. The Dark Lord. God of Darkness, Chaos and Corruption.",88,73,76,84,98,R.drawable.melkor);
        characters[5]=c;

        c=new Characters("Nessa","The Fast, the Young, the Dancer, the Swift. As fast as a Deer or an Arrow. Wife of Tulkas",55,62,98,43,67,R.drawable.nessa);
        characters[6]=c;

        c=new Characters("Nienna","She who cries, the weeping one. God of Grief, Sadness and Mourning.",13,67,17,56,36,R.drawable.nienna);
        characters[7]=c;

        c=new Characters("Orome","The Horn Blower. The Hunter. The God of Hunting.",96,66,95,21,88,R.drawable.orome);
        characters[8]=c;

        c=new Characters("Tulkas","The Strong, Steadfast. Champian of Valar. God of Strength.",99,27,79,24,88,R.drawable.tulkas);
        characters[9]=c;

        c=new Characters("Ulmo","The Rainer, the Lord of the Waters. The God of Seas and Rivers.",84,93,72,64,90,R.drawable.ulmo);
        characters[10]=c;

        c=new Characters("Vaire","The Weaver. The God of Creating the Story of All.",19,87,34,82,63,R.drawable.vaire);
        characters[11]=c;

        c=new Characters("Vana","The Beautiful One. The Young. The God of Youth and Flowers.",11,69,74,76,84,R.drawable.vana);
        characters[12]=c;

        c=new Characters("Varda","The Lady of the Stars. The creator of Stars and Planets. The God of Zodiacs. ",47,86,46,92,81,R.drawable.varda);
        characters[13]=c;

        c=new Characters("Yavanna","The God of Growth. The Fruit Giver. The Queen of the Valar. The Creator of Ents. The God of Everything Green",69,86,71,90,89,R.drawable.yavanna);
        characters[14]=c;
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
