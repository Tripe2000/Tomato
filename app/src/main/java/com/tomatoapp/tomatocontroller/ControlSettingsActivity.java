package com.tomatoapp.tomatocontroller;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import static com.tomatoapp.tomatocontroller.MainActivity.PACKAGE_NAME;

public class ControlSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_settings);

        //setup data persistence
        final SharedPreferences prefs = this.getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE);

        //setup widgets
        Switch switch_tempControl = (Switch) findViewById(R.id.tempControl);
        Switch switch_phControl = (Switch) findViewById(R.id.phControl);
        Switch switch_lightControl = (Switch) findViewById(R.id.lightControl);
        Switch switch_D = (Switch) findViewById(R.id.switch5);
        Switch switch_E = (Switch) findViewById(R.id.switch6);
        Switch switch_F = (Switch) findViewById(R.id.switch7);

        //set initial values of widgets
        switch_tempControl.setChecked(prefs.getBoolean(PACKAGE_NAME + R.string.control_temp_key, true));
        switch_phControl.setChecked(prefs.getBoolean(PACKAGE_NAME + R.string.control_ph_key, true));
        switch_lightControl.setChecked(prefs.getBoolean(PACKAGE_NAME + R.string.control_light_key, true));
        //TO DO: to be changed to receive initial value data from raspberry pi
        switch_D.setChecked(prefs.getBoolean(PACKAGE_NAME + ".switch.d", true));
        switch_E.setChecked(prefs.getBoolean(PACKAGE_NAME + ".switch.e", true));
        switch_F.setChecked(prefs.getBoolean(PACKAGE_NAME + ".switch.f", true));

        //setup listeners
        switch_tempControl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(PACKAGE_NAME + R.string.control_temp_key, isChecked);
                editor.apply();
            }
        });

        switch_phControl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(PACKAGE_NAME + R.string.control_ph_key, isChecked);
                editor.apply();
            }
        });

        switch_lightControl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(PACKAGE_NAME + R.string.control_light_key, isChecked);
                editor.apply();
            }
        });

        switch_D.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(PACKAGE_NAME + ".switch.d", isChecked);
                editor.apply();
            }
        });

        switch_E.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(PACKAGE_NAME + ".switch.e", isChecked);
                editor.apply();
            }
        });

        switch_F.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(PACKAGE_NAME + ".switch.f", isChecked);
                editor.apply();
            }
        });
    }
}
