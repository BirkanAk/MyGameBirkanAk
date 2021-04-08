package com.example.mygamebirkanak;

import android.app.Activity;

public class Score extends Activity {
    private static Score SCORE=null;
    public static int point =0;
    public static int highscore=0;


    public static Score getInstance(){
        if(Score.SCORE==null){
            Score.SCORE=new Score();
        }
        return Score.SCORE;
    }
}
