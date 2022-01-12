package com.andregt.g3project.Tools;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
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

public class Bar_Generator extends AppCompatActivity {

    private EditText editText;
    private ImageView imageView;
    private Button btndownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar__generator);

        this.setTitle(R.string.gc_btnBar);

        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);
        btndownload = findViewById(R.id.download1);
        btndownload.setVisibility(View.INVISIBLE);
    }

    public void barCodeButton(View view){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {

            BitMatrix bitMatrix = multiFormatWriter.encode(editText.getText().toString(),
                    BarcodeFormat.CODE_128, imageView.getWidth(), imageView.getHeight());

            Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.RGB_565);
            for (int i = 0; i<imageView.getWidth(); i++){
                for (int j = 0; j<imageView.getHeight(); j++){
                    bitmap.setPixel(i,j,bitMatrix.get(i,j)? Color.BLACK:Color.WHITE);
                }
            }

            imageView.setImageBitmap(bitmap);
            btndownload.setVisibility(View.VISIBLE);
            btndownload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Multi Tools"
                            , null);
                    Toast.makeText(Bar_Generator.this, "Saved to galary", Toast.LENGTH_SHORT)
                            .show();
                }
            });

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}