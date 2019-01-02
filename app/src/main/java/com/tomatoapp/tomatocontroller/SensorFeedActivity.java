package com.tomatoapp.tomatocontroller;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import static com.tomatoapp.tomatocontroller.MainActivity.PACKAGE_NAME;

public class SensorFeedActivity extends AppCompatActivity {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    SeekBar seekBar_A;
    SeekBar seekBar_B;
    SeekBar seekBar_C;
    TextView textView_A;
    TextView textView_B;
    TextView textView_C;

    private void init() {
        //setup data persistence
        prefs = this.getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE);;
        editor = prefs.edit();;

        //widgets
        seekBar_A = (SeekBar)findViewById(R.id.seekBar);
        seekBar_B = (SeekBar)findViewById(R.id.seekBar2);
        seekBar_C = (SeekBar)findViewById(R.id.seekBar3);
        textView_A = (TextView)findViewById(R.id.textView4);
        textView_B = (TextView)findViewById(R.id.textView7);
        textView_C = (TextView)findViewById(R.id.textView12);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_feed);

        //initiate variables
        init();

        //set initial values of widgets
        textView_A.setText(String.valueOf(prefs.getInt(PACKAGE_NAME + ".textview.a", 5)));
        textView_B.setText(String.valueOf(prefs.getInt(PACKAGE_NAME + ".textview.b", 5)));
        textView_C.setText(String.valueOf(prefs.getInt(PACKAGE_NAME + ".textview.c", 5)));
        seekBar_A.setProgress(Integer.parseInt(textView_A.getText().toString()));
        seekBar_B.setProgress(Integer.parseInt(textView_B.getText().toString()));
        seekBar_C.setProgress(Integer.parseInt(textView_C.getText().toString()));

        //add seekbar listeners
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

    public void apply(View view) {
        editor.putInt(PACKAGE_NAME + ".textview.a", Integer.parseInt(textView_A.getText().toString()));
        editor.putInt(PACKAGE_NAME + ".textview.b", Integer.parseInt(textView_B.getText().toString()));
        editor.putInt(PACKAGE_NAME + ".textview.c", Integer.parseInt(textView_C.getText().toString()));
        editor.apply();
    }
}
