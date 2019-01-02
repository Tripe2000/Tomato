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
        Switch switch_A = (Switch) findViewById(R.id.switch2);
        Switch switch_B = (Switch) findViewById(R.id.switch3);
        Switch switch_C = (Switch) findViewById(R.id.switch4);
        Switch switch_D = (Switch) findViewById(R.id.switch5);
        Switch switch_E = (Switch) findViewById(R.id.switch6);
        Switch switch_F = (Switch) findViewById(R.id.switch7);

        //set initial values of widgets
        switch_A.setChecked(prefs.getBoolean(PACKAGE_NAME + ".switch.a", true));
        switch_B.setChecked(prefs.getBoolean(PACKAGE_NAME + ".switch.b", true));
        switch_C.setChecked(prefs.getBoolean(PACKAGE_NAME + ".switch.c", true));
        switch_D.setChecked(prefs.getBoolean(PACKAGE_NAME + ".switch.d", true));
        switch_E.setChecked(prefs.getBoolean(PACKAGE_NAME + ".switch.e", true));
        switch_F.setChecked(prefs.getBoolean(PACKAGE_NAME + ".switch.f", true));

        //setup listeners
        switch_A.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(PACKAGE_NAME + ".switch.a", isChecked);
                editor.apply();
            }
        });

        switch_B.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(PACKAGE_NAME + ".switch.b", isChecked);
                editor.apply();
            }
        });

        switch_C.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(PACKAGE_NAME + ".switch.c", isChecked);
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
