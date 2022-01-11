package com.andregt.g3project.Settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.andregt.g3project.R;

import static android.content.ContentValues.TAG;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_help);
    }

    public void sendEmail(View view) {
        Log.d(TAG, "sendmail: ");

        String[] TO_EMAILS = {"toolmulti3@gmail.com"};

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, TO_EMAILS);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Multi Tools Apps Helps: ");

        startActivity(Intent.createChooser(intent, "choose one aplication"));
    }

}