package com.example.mygamebirkanak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    Button playbutton;
    Button instructionsbutton;
    TextView highscoresplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        playbutton=(Button) findViewById(R.id.play_button);
        instructionsbutton=(Button) findViewById(R.id.instruction_button);
        highscoresplash=(TextView)findViewById(R.id.highscoresplash);

        highscoresplash.setAllCaps(true);
        highscoresplash.setTextSize(44);
        highscoresplash.setTextColor(Color.parseColor("#D2310F"));

        playbutton.setBackgroundColor(Color.parseColor("#529930"));
        instructionsbutton.setBackgroundColor(Color.parseColor("#1F4775"));

        highscoresplash.setText("HIGHSCORE:");


    }

    public void onPlayClick(View view) {
        Intent act_action = new Intent(this,MainActivity.class);
        startActivity(act_action);
    }

    public void onInstructionClick(View view) {
        Intent act_action = new Intent(this,Instructions.class);
        startActivity(act_action);
    }
}