package com.andregt.g3project.Tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.andregt.g3project.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QR_Generator extends AppCompatActivity {

    EditText etInput;
    Button btnGenerate;
    ImageView ivOutput;
    Button btndownload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr__generator);

        this.setTitle(R.string.gc_btnQR);

        etInput = findViewById(R.id.etInput);
        btnGenerate = findViewById(R.id.btnGenerate);
        ivOutput = findViewById(R.id.ivOutput);

        btndownload = findViewById(R.id.download);
        btndownload.setVisibility(View.INVISIBLE);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sText = etInput.getText().toString().trim();

                //inisialisasi multi format writer
                MultiFormatWriter writer = new MultiFormatWriter();

                try {

                    //inisialisasi bit matrix
                    BitMatrix matrix = writer.encode(sText, BarcodeFormat.QR_CODE
                            , 350, 350);

                    //inisialisasi barcode encoder
                    BarcodeEncoder encoder = new BarcodeEncoder();

                    //inisialisasi bitmap
                    Bitmap bitmap = encoder.createBitmap(matrix);

                    //set bitmap on imgae View
                    ivOutput.setImageBitmap(bitmap);

                    btndownload.setVisibility(View.VISIBLE);
                    btndownload.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Multi Tools"
                                    , null);
                            Toast.makeText(QR_Generator.this, "Saved to galary", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    });

                    //inisialisasi input manager
                    InputMethodManager manager = (InputMethodManager) getSystemService(
                            Context.INPUT_METHOD_SERVICE
                    );

                    //Hide soft keyboard
                    manager.hideSoftInputFromWindow(etInput.getApplicationWindowToken()
                            ,0);

                } catch (WriterException e){
                    e.printStackTrace();
                }

            }
        });
    }
}