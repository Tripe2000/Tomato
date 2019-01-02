package com.tomatoapp.tomatocontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static String PACKAGE_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PACKAGE_NAME = getApplicationContext().getPackageName();
    }

    public void goToSensorFeedActivity(View view) {
        Intent intent = new Intent(this, SensorFeedActivity.class);
        startActivity(intent);
    }

    public void goToControlSettingsActivity(View view) {
        Intent intent = new Intent(this, ControlSettingsActivity.class);
        startActivity(intent);
    }
}
