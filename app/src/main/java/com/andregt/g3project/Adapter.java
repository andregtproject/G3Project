package com.andregt.g3project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.andregt.g3project.Helper.GN_CodeOption;
import com.andregt.g3project.Helper.ScannerHelper;
import com.andregt.g3project.Tools.Compass;
import com.andregt.g3project.Tools.CurrencyConverter;
import com.andregt.g3project.Tools.Discount;
import com.andregt.g3project.Tools.Flashlight;
import com.andregt.g3project.Tools.IndexBadan;
import com.andregt.g3project.Tools.Scanner;
import com.andregt.g3project.Tools.SpeechText;
import com.andregt.g3project.Tools.Stopwatch;
import com.andregt.g3project.Tools.TextRecognition;

public class Adapter extends PagerAdapter {

    private java.util.List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(java.util.List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull android.view.View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView;
        TextView title, desc;

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);

        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());

        view.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                if (position == 0){
                    Intent moveTR = new Intent(context, TextRecognition.class);
                    context.startActivity(moveTR);
                } else if (position == 1){
                    Intent moveST = new Intent(context, SpeechText.class);
                    context.startActivity(moveST);
                }else if (position == 2){
                    Intent moveSH = new Intent(context, ScannerHelper.class);
                    context.startActivity(moveSH);
                }else if (position == 3){
                    Intent moveGN = new Intent(context, GN_CodeOption.class);
                    context.startActivity(moveGN);
                }else if (position == 4){
                    Intent moveSW = new Intent(context, Stopwatch.class);
                    context.startActivity(moveSW);
                }else if (position == 5){
                    Intent moveCP = new Intent(context, Compass.class);
                    context.startActivity(moveCP);
                }else if (position == 6){
                    Intent moveFL = new Intent(context, Flashlight.class);
                    context.startActivity(moveFL);
                }else if (position == 7){
                    Intent moveCC = new Intent(context, CurrencyConverter.class);
                    context.startActivity(moveCC);
                }else if (position == 8){
                    Intent moveDC = new Intent(context, Discount.class);
                    context.startActivity(moveDC);
                }else if (position == 9){
                    Intent moveIB = new Intent(context, IndexBadan.class);
                    context.startActivity(moveIB);
                }
            }
        });
        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((android.view.View)object);
    }
}
