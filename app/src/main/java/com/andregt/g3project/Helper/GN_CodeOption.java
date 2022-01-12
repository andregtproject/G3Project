package com.andregt.g3project.Helper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.andregt.g3project.R;
import com.andregt.g3project.Tools.Bar_Generator;
import com.andregt.g3project.Tools.QR_Generator;


public class GN_CodeOption extends AppCompatActivity {

    Button btnBar, btnQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gncode_option);

        this.setTitle(R.string.main_GN);

        btnQR = findViewById(R.id.btnQR);
        btnQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GN_CodeOption.this, QR_Generator.class);
                startActivity(intent);
            }
        });

        btnBar = findViewById(R.id.btnBar);
        btnBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GN_CodeOption.this, Bar_Generator.class);
                startActivity(intent);
            }
        });
    }
}