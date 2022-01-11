package com.andregt.g3project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.andregt.g3project.Helper.GN_CodeOption;
import com.andregt.g3project.Helper.ScannerHelper;
import com.andregt.g3project.Settings.SettingsActivity;
import com.andregt.g3project.Tools.Compass;
import com.andregt.g3project.Tools.CurrencyConverter;
import com.andregt.g3project.Tools.Discount;
import com.andregt.g3project.Tools.Flashlight;
import com.andregt.g3project.Tools.IndexBadan;
import com.andregt.g3project.Tools.SpeechText;
import com.andregt.g3project.Tools.Stopwatch;
import com.andregt.g3project.Tools.TextRecognition;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        CardView cdRT = findViewById(R.id.cdTR);
        cdRT.setOnClickListener(this);

        CardView btnST = findViewById(R.id.cdST);
        btnST.setOnClickListener(this);

        CardView cdBQ = findViewById(R.id.cdBQ);
        cdBQ.setOnClickListener(this);

        CardView cdGN = findViewById(R.id.cdGN);
        cdGN.setOnClickListener(this);

        CardView cdSW = findViewById(R.id.cdSW);
        cdSW.setOnClickListener(this);

        CardView cdCP = findViewById(R.id.cdCP);
        cdCP.setOnClickListener(this);

        CardView cdFL = findViewById(R.id.cdFL);
        cdFL.setOnClickListener(this);

        CardView cdCC = findViewById(R.id.cdCC);
        cdCC.setOnClickListener(this);

        CardView cdDC = findViewById(R.id.cdDC);
        cdDC.setOnClickListener(this);

        CardView cdIB = findViewById(R.id.cdIB);
        cdIB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cdTR:
                Intent moveIntent = new Intent(MainActivity2.this, TextRecognition.class);
                startActivity(moveIntent);
                break;
            case R.id.cdST:
                Intent moveSpeak = new Intent(MainActivity2.this, SpeechText.class);
                startActivity(moveSpeak);
                break;
            case R.id.cdBQ:
                Intent moveScanner = new Intent(MainActivity2.this, ScannerHelper.class);
                startActivity(moveScanner);
                break;
            case R.id.cdGN:
                Intent moveGenerator = new Intent(MainActivity2.this, GN_CodeOption.class);
                startActivity(moveGenerator);
                break;
            case R.id.cdSW:
                Intent moveStopwatch = new Intent(MainActivity2.this, Stopwatch.class);
                startActivity(moveStopwatch);
                break;
            case R.id.cdCP:
                Intent moveCompass = new Intent(MainActivity2.this, Compass.class);
                startActivity(moveCompass);
                break;
            case R.id.cdFL:
                Intent moveFlashlight = new Intent(MainActivity2.this, Flashlight.class);
                startActivity(moveFlashlight);
                break;
            case R.id.cdCC:
                Intent moveConverter = new Intent(MainActivity2.this, CurrencyConverter.class);
                startActivity(moveConverter);
                break;
            case R.id.cdDC:
                Intent moveDiscount = new Intent(MainActivity2.this, Discount.class);
                startActivity(moveDiscount);
                break;
            case R.id.cdIB:
                Intent moveIndex = new Intent(MainActivity2.this, IndexBadan.class);
                startActivity(moveIndex);
                break;
        }
    }
    @Override
    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.logo)
                .setTitle(R.string.app_name)

                .setMessage("Are you sure to exit?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    public void setting(View view) {
        Intent moveSetting = new Intent(MainActivity2.this, SettingsActivity.class );
        startActivity(moveSetting);
    }
}