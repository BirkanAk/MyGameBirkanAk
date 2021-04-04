package com.example.mygamebirkanak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions2);
    }

    public void onBackClick(View view) {
        Intent act_action = new Intent(this,SplashScreen.class);
        startActivity(act_action);
    }
}