package com.andregt.g3project.Settings;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.andregt.g3project.R;


public class about_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        this.setTitle(R.string.about_us);
    }
}