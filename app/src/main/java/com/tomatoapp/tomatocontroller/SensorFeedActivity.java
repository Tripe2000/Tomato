package com.tomatoapp.tomatocontroller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.view.View.GONE;
import static com.tomatoapp.tomatocontroller.MainActivity.PACKAGE_NAME;

public class SensorFeedActivity extends AppCompatActivity {
    //persistence
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    //widgets
    SeekBar seekBar_temp;
    SeekBar seekBar_ph;
    SeekBar seekBar_light;

    TextView desiredTemp;
    TextView desiredPh;
    TextView desiredLight;

    Button button_apply;

    ConstraintLayout desiredTempLayout;
    ConstraintLayout desiredPhLayout;
    ConstraintLayout desiredLightLayout;

    private void init() {
        //setup data persistence
        prefs = this.getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE);;
        editor = prefs.edit();

        //widgets
        seekBar_temp = findViewById(R.id.desiredTempBar);
        seekBar_ph = findViewById(R.id.desiredPhBar);
        seekBar_light = findViewById(R.id.desiredLightBar);

        desiredTemp = findViewById(R.id.desiredTemp);
        desiredPh = findViewById(R.id.desiredPh);
        desiredLight = findViewById(R.id.desiredLight);

        button_apply = findViewById(R.id.apply);

        desiredTempLayout = findViewById(R.id.desiredTempLayout);
        desiredPhLayout = findViewById(R.id.desiredPhLayout);
        desiredLightLayout = findViewById(R.id.desiredLightLayout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_feed);

        //initiate variables
        init();

        //add seekbar listeners
        seekBar_temp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                desiredTemp.setText(String.valueOf(progress));
                button_apply.setEnabled(true);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBar_ph.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                desiredPh.setText(String.valueOf(progress));
                button_apply.setEnabled(true);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBar_light.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                desiredLight.setText(String.valueOf(progress));
                button_apply.setEnabled(true);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        //set initial values of widgets
        int flag = 0;

        if(prefs.getBoolean(PACKAGE_NAME + R.string.control_temp_key, true)) {
            desiredTemp.setText(String.valueOf(prefs.getInt(PACKAGE_NAME + R.string.desired_temp_key, 5)));
            seekBar_temp.setProgress(Integer.parseInt(desiredTemp.getText().toString()));
        } else {
            desiredTempLayout.setVisibility(GONE);
            flag++;
        }

        if(prefs.getBoolean(PACKAGE_NAME + R.string.control_ph_key, true)) {
            desiredPh.setText(String.valueOf(prefs.getInt(PACKAGE_NAME + R.string.desired_ph_key, 5)));
            seekBar_ph.setProgress(Integer.parseInt(desiredPh.getText().toString()));
        } else {
            desiredPhLayout.setVisibility(GONE);
            flag++;
        }

        if(prefs.getBoolean(PACKAGE_NAME + R.string.control_light_key, true)) {
            desiredLight.setText(String.valueOf(prefs.getInt(PACKAGE_NAME + R.string.desired_light_key, 5)));
            seekBar_light.setProgress(Integer.parseInt(desiredLight.getText().toString()));
        } else {
            desiredLightLayout.setVisibility(GONE);
            flag++;
        }

        if(flag == 3) button_apply.setVisibility(GONE);

        //apply button starts disabled
        button_apply.setEnabled(false);
    }

    public void apply(View view) {
        //saves desired values
        if(desiredTempLayout.getVisibility() != GONE) editor.putInt(PACKAGE_NAME + R.string.desired_temp_key, Integer.parseInt(desiredTemp.getText().toString()));
        if(desiredPhLayout.getVisibility() != GONE) editor.putInt(PACKAGE_NAME + R.string.desired_ph_key, Integer.parseInt(desiredPh.getText().toString()));
        if(desiredLightLayout.getVisibility() != GONE) editor.putInt(PACKAGE_NAME + R.string.desired_light_key, Integer.parseInt(desiredLight.getText().toString()));
        editor.apply();
        button_apply.setEnabled(false);
    }

    public void goToTempLog(View view) {
        Intent intent = new Intent(this, TemperatureLogActivity.class);
        startActivity(intent);
    }

    public void goToPhLog(View view) {
        Intent intent = new Intent(this, PhLogActivity.class);
        startActivity(intent);
    }

    public void goToLightLog(View view) {
        Intent intent = new Intent(this, LightLogActivity.class);
        startActivity(intent);
    }
}
