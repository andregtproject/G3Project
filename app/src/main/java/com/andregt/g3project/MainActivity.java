package com.andregt.g3project;

import android.animation.ArgbEvaluator;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.andregt.g3project.Settings.SettingsActivity;
import com.andregt.g3project.Tools.TextRecognition;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private long backpressedTime;
    ViewPager viewPager;
    Adapter adapter;
    java.util.List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.photo_scanner, "Text Recognition", "Convert your images into text, with these tools you don't have to bother typing"));
        models.add(new Model(R.drawable.podcast, "Speech Text", "Scan your barcode or QRcode"));
        models.add(new Model(R.drawable.code_scanner, "Code Scanner", "Scan your barcode or QRcode"));
        models.add(new Model(R.drawable.code_maker, "Code Generetor", "Build your barcode or QRcode"));
        models.add(new Model(R.drawable.stopwatch, "Stopwatch", "Measure the length of your activity"));
        models.add(new Model(R.drawable.compas, "Compass", "Compass is a navigational tool to determine the cardinal directions"));
        models.add(new Model(R.drawable.flashlight, "Flashlight", "Light up the light around you"));
        models.add(new Model(R.drawable.money_converter, "Money Converter", "Convert the value of your currency into Indonesian rupiah currency"));
        models.add(new Model(R.drawable.discount, "Discount Counter", "Calculate the price of your item after deducting the discount"));
        models.add(new Model(R.drawable.body_indication, "Index Body", "Body index tool is a digital tool that is used to check the stability of body mass"));

        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(100, 0, 100, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
                getResources().getColor(R.color.color6),
                getResources().getColor(R.color.color7),
                getResources().getColor(R.color.color8),
                getResources().getColor(R.color.color9),
                getResources().getColor(R.color.color11),
                getResources().getColor(R.color.color12),
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                } else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed(){

        if (backpressedTime + 2000>System.currentTimeMillis()){
            finishAffinity();
            System.exit(0);
            return;
        } else{
            Toast.makeText(this, "Click back to exit", Toast.LENGTH_SHORT).show();
        }
        backpressedTime = System.currentTimeMillis();

    }

    public void setting(View view) {
        Intent moveSetting = new Intent(MainActivity.this, SettingsActivity.class );
        startActivity(moveSetting);
    }
}
