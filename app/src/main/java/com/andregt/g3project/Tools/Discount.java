package com.andregt.g3project.Tools;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.andregt.g3project.R;
import androidx.appcompat.app.AppCompatActivity;

public class Discount extends AppCompatActivity {

    EditText harga, diskon;
    Button hasil;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);

        this.setTitle(R.string.main_DC);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        harga = (EditText)findViewById(R.id.edit1);
        diskon = (EditText)findViewById(R.id.edit2);
        hasil = (Button)findViewById(R.id.button1);
        total = (TextView)findViewById(R.id.teks4);

        hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int nharga = Integer.parseInt(harga.getText().toString());
                int ndiskon = Integer.parseInt(diskon.getText().toString());
                int diskon = ndiskon * nharga;
                int totaldiskon = diskon / 100;
                int totalprice = nharga -totaldiskon;
                total.setText(String.valueOf(totalprice));
            }
        });
    }
    public void exit (View view){
        finish();
    }
}
