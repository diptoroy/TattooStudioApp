package com.example.tattoostudioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    private ImageView splashBtn;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashBtn = findViewById(R.id.goBtn);
        splashBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreen.this, RegistrationActivity.class);
                animation = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.slide_out_from_right);
                splashBtn.startAnimation(animation);
                startActivity(intent);
            }
        });

    }




}