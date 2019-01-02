package com.tomatoapp.tomatocontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class SensorFeedActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_feed);

        //add seekbar listeners
        SeekBar seekBar_A = (SeekBar)findViewById(R.id.seekBar);
        SeekBar seekBar_B = (SeekBar)findViewById(R.id.seekBar2);
        SeekBar seekBar_C = (SeekBar)findViewById(R.id.seekBar3);
        seekBar_A.setOnSeekBarChangeListener(this);
        seekBar_B.setOnSeekBarChangeListener(this);
        seekBar_C.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar l) {
    }
}
