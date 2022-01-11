package com.andregt.g3project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Splash extends AppCompatActivity {
    Animation zoom, zoomText;
    ImageView img;
    LinearLayout textLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        zoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        zoomText = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_text);
        img = findViewById(R.id.image);
        img.startAnimation(zoom);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        },4000);

        textLayout = findViewById(R.id.textlayout);
        textLayout.setAnimation(zoomText);
    }
}