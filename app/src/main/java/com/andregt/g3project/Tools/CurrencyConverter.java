package com.andregt.g3project.Tools;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.andregt.g3project.R;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyConverter extends AppCompatActivity {
    EditText input_uang;
    Button rp_usd, rp_euro, rp_yen;
    TextView hasil_konversi;

    double angka;
    private String formatRupiah(Double number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        this.setTitle(R.string.main_CC);

        input_uang = (EditText) findViewById(R.id.uang_input);
        rp_usd = (Button) findViewById(R.id.rpusd);
        rp_euro = (Button) findViewById(R.id.rpeuro);
        rp_yen = (Button) findViewById(R.id.rpyen);
        hasil_konversi = (TextView) findViewById(R.id.hasil_konversi);
    }

    public boolean cek(){
        if (input_uang.getText().toString().isEmpty()){
            Toast.makeText(this, "Silahkan masukan jumlah uang", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void toYEN(View v){
        if (!cek()){
            return;
        }

        try{
            angka = Double.parseDouble(input_uang.getText().toString());
        }catch(Exception ex){
            Toast.makeText(this, "Masukkan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka / 131;
        hasil_konversi.setText(NumberFormat.getCurrencyInstance(Locale.JAPAN).format(hasil));
        Toast.makeText(this, "1 RP = 0,0075 YEN", Toast.LENGTH_SHORT).show();
    }

    public void toEuro(View v){
        if (!cek()){
            return;
        }

        try{
            angka = Double.parseDouble(input_uang.getText().toString());
        }catch(Exception e){
            Toast.makeText(this, "Masukkan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka / 17208;
        hasil_konversi.setText(NumberFormat.getCurrencyInstance(Locale.GERMANY).format(hasil));
        Toast.makeText(this, "1 RP = 0,000058 EUR", Toast.LENGTH_SHORT).show();
    }

    public void toUSD(View v){
        if (!cek()){
            return;
        }

        try{
            angka = Double.parseDouble(input_uang.getText().toString());
        }catch(Exception e){
            Toast.makeText(this, "Masukkan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka / 14493;
        hasil_konversi.setText(NumberFormat.getCurrencyInstance(Locale.US).format(hasil));
        Toast.makeText(this, "1 RP = 0,000001 USD", Toast.LENGTH_SHORT).show();
    }


    public void toRP_usd(View view) {
        if (!cek()){
            return;
        }

        try{
            angka = Double.parseDouble(input_uang.getText().toString());
        }catch(Exception e){
            Toast.makeText(this, "Masukkan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka * 14493;
        hasil_konversi.setText(formatRupiah(hasil));
        Toast.makeText(this, "1 U$D = Rp 14.493", Toast.LENGTH_SHORT).show();
    }

    public void toRP_euro(View view) {
        if (!cek()){
            return;
        }

        try{
            angka = Double.parseDouble(input_uang.getText().toString());
        }catch(Exception e){
            Toast.makeText(this, "Masukkan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka * 17208;
        hasil_konversi.setText(formatRupiah(hasil));
        Toast.makeText(this, "1 Euro = Rp 17.208", Toast.LENGTH_SHORT).show();
    }

    public void toRP_yen(View view) {
        if (!cek()){
            return;
        }

        try{
            angka = Double.parseDouble(input_uang.getText().toString());
        }catch(Exception ex){
            Toast.makeText(this, "Masukkan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka * 131;
        hasil_konversi.setText(formatRupiah(hasil));
        Toast.makeText(this, "1 Yen = Rp 131", Toast.LENGTH_SHORT).show();
    }
}