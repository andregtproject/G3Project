package com.andregt.g3project.Tools;

import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.ToggleButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.andregt.g3project.R;

import java.util.Timer;
import java.util.TimerTask;

public class Flashlight extends AppCompatActivity {

    boolean isFlashAvailable;
    CameraManager CameraManager;
    String CameraId;
    boolean flashIsOn = false;

    Switch switchImpuler;
    ToggleButton toggleButton;
    int milliSeconds_HIGH =1000;
    int milliSedonds_LOW =1000;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashlight);

        this.setTitle(R.string.main_FL);

        switchImpuler=findViewById(R.id.switchFlasher);
        toggleButton= findViewById(R.id.btnToggleLight);

        SeekBar seekbarHIGH =findViewById(R.id.seekBarHIGH);
        milliSeconds_HIGH =seekbarHIGH.getMax();
        seekbarHIGH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                milliSeconds_HIGH =i;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        SeekBar seekbarLOW =findViewById(R.id.seekBarLOW);
        milliSedonds_LOW =seekbarLOW.getMax();
        seekbarLOW.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                milliSedonds_LOW =i;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        isFlashAvailable = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        CameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
        try {
            CameraId = CameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            //e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void btnToggleLight(View view) {
        flashLightMain();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void switchImpulses(View view) {
        flashLightMain();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private  void flashLightMain(){

        if (toggleButton.isChecked() ==true) {
            if (switchImpuler.isChecked())
            {
                start_flash_Impule_HIGH();
            } else {
                setFlashLightON();
            }
        }
        else {
            setFlashLightOFF();
            set_FlashImpulses_OFF();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setFlashLightON()    {
        try {
            flashIsOn = true;
            CameraManager.setTorchMode(CameraId, true);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setFlashLightOFF()    {
        try {
            flashIsOn = false;
            CameraManager.setTorchMode(CameraId, false);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public void start_flash_Impule_HIGH() {

        if (!toggleButton.isChecked()) return;
        if (!switchImpuler.isChecked()) return;

        Timer timerPulsHIGH = new Timer();
        timerPulsHIGH.schedule(new TimerTask() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void run()
            {
                try {
                    flashIsOn = true;
                    CameraManager.setTorchMode(CameraId, true);
                    start_flash_Impule_LOW();
                }
                catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        }, milliSedonds_LOW);
      }

    public void start_flash_Impule_LOW() {

        Timer timerPulsLOW = new Timer();
        timerPulsLOW.schedule(new TimerTask() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void run()
            {
                try {
                    flashIsOn = false;
                    CameraManager.setTorchMode(CameraId, false);
                    start_flash_Impule_HIGH();
                }
                catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        }, milliSeconds_HIGH);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void set_FlashImpulses_OFF() {

        try {
            CameraManager.setTorchMode(CameraId, false);
            flashIsOn = false;

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
}