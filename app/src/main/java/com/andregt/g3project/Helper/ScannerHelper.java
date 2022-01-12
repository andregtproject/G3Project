package com.andregt.g3project.Helper;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.andregt.g3project.R;
import com.andregt.g3project.Tools.Scanner;
import com.bumptech.glide.Glide;

public class ScannerHelper extends AppCompatActivity {

    Button scanbtn;
    public static EditText scantext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_r__scanner_helper);

        this.setTitle(R.string.main_BQ);

        ImageView imgGif = (ImageView) findViewById(R.id.imageGif);
        Glide.with(ScannerHelper.this)
                .load(R.drawable.scan)
                .asGif()
                .placeholder(R.drawable.scan)
                .crossFade()
                .into(imgGif);

        scantext=(EditText) findViewById(R.id.scantext);
        scanbtn=(Button) findViewById(R.id.scanbtn);

        scanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Scanner.class));
            }
        });
    }
}
