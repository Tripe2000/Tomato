package com.tomatoapp.tomatocontroller;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import static com.tomatoapp.tomatocontroller.MainActivity.PACKAGE_NAME;

public class SensorFeedActivity extends AppCompatActivity {
    //persistence
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    //widgets
    SeekBar seekBar_temp;
    SeekBar seekBar_ph;
    SeekBar seekBar_light;
    TextView textView_desiredTemp;
    TextView textView_desiredPh;
    TextView textView_desiredLight;
    Button button_apply;

    private void init() {
        //setup data persistence
        prefs = this.getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE);;
        editor = prefs.edit();

        //widgets
        seekBar_temp = (SeekBar)findViewById(R.id.desiredTempBar);
        seekBar_ph = (SeekBar)findViewById(R.id.desiredPhBar);
        seekBar_light = (SeekBar)findViewById(R.id.desiredLightBar);
        textView_desiredTemp = (TextView)findViewById(R.id.desiredTemp);
        textView_desiredPh = (TextView)findViewById(R.id.desiredPh);
        textView_desiredLight = (TextView)findViewById(R.id.desiredLight);
        button_apply = (Button)findViewById(R.id.apply);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_feed);

        //initiate variables
        init();

        //set initial values of widgets
        button_apply.setEnabled(false);

        textView_desiredTemp.setText(String.valueOf(prefs.getInt(PACKAGE_NAME + R.string.desired_temp_key, 5)));
        textView_desiredPh.setText(String.valueOf(prefs.getInt(PACKAGE_NAME + R.string.desired_ph_key, 5)));
        textView_desiredLight.setText(String.valueOf(prefs.getInt(PACKAGE_NAME + R.string.desired_light_key, 5)));

        seekBar_temp.setProgress(Integer.parseInt(textView_desiredTemp.getText().toString()));
        seekBar_ph.setProgress(Integer.parseInt(textView_desiredPh.getText().toString()));
        seekBar_light.setProgress(Integer.parseInt(textView_desiredLight.getText().toString()));

        if(prefs.getBoolean(PACKAGE_NAME + "", true))

        //add seekbar listeners
        seekBar_temp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView_desiredTemp.setText(String.valueOf(progress));
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
                textView_desiredPh.setText(String.valueOf(progress));
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
                textView_desiredLight.setText(String.valueOf(progress));
                button_apply.setEnabled(true);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    public void apply(View view) {
        editor.putInt(PACKAGE_NAME + R.string.desired_temp_key, Integer.parseInt(textView_desiredTemp.getText().toString()));
        editor.putInt(PACKAGE_NAME + R.string.desired_ph_key, Integer.parseInt(textView_desiredPh.getText().toString()));
        editor.putInt(PACKAGE_NAME + R.string.desired_light_key, Integer.parseInt(textView_desiredLight.getText().toString()));
        editor.apply();
        button_apply.setEnabled(false);
    }
}
