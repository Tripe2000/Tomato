package com.tomatoapp.tomatocontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class SensorFeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_feed);

        //add seekbar listeners
        SeekBar seekBar_A = (SeekBar)findViewById(R.id.seekBar);
        SeekBar seekBar_B = (SeekBar)findViewById(R.id.seekBar2);
        SeekBar seekBar_C = (SeekBar)findViewById(R.id.seekBar3);
        final TextView textView_A = (TextView)findViewById(R.id.textView4);
        final TextView textView_B = (TextView)findViewById(R.id.textView7);
        final TextView textView_C = (TextView)findViewById(R.id.textView12);
        textView_A.setText(String.valueOf(seekBar_A.getProgress()));
        textView_B.setText(String.valueOf(seekBar_B.getProgress()));
        textView_C.setText(String.valueOf(seekBar_C.getProgress()));

        seekBar_A.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView_A.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBar_B.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView_B.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBar_C.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView_C.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}
