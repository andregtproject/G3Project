package com.andregt.g3project.Tools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.andregt.g3project.R;

public class IndexBadan extends AppCompatActivity {

    private EditText mEtBerat;
    private EditText mEtTinggi;
    private Button mBtnHitung;
    private TextView mTvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_badan);

        this.setTitle(R.string.main_IB);

        mEtBerat = findViewById(R.id.etBerat);
        mEtTinggi = findViewById(R.id.etTinggi);
        mBtnHitung = findViewById(R.id.btnHitung);
        mTvHasil = findViewById(R.id.tvHasil);

        mBtnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungIMT();
            }
        });
    }
    private void hitungIMT(){
        double berat = Double.parseDouble(mEtBerat.getText().toString());
        double tinggi = Double.parseDouble(mEtTinggi.getText().toString());
        double tinggiDalamMeter = tinggi/100.0;

        double imt = berat/ (tinggiDalamMeter * tinggiDalamMeter);

        String keterangan = "";
        if(imt <= 18.4) {
            keterangan = "Berat Badan Kurang";
        }else if (imt >= 18.5 && imt <= 24.9){
            keterangan = "Berat Badan Ideal";
        }else if (imt >= 25 && imt <= 29.9){
            keterangan = "Berat Badan Lebih";
        }else if (imt >= 30 && imt <= 39.9){
            keterangan = "Gemuk";
        }else {
            keterangan = "Sangat Gemuk";
        }
        String hasil = "Nilai IMT adalah " + imt + " Yaitu " + keterangan;
        mTvHasil.setText(hasil);
    }
}