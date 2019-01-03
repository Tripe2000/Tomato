package com.tomatoapp.tomatocontroller;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

public class TemperatureLogActivity extends AppCompatActivity {
    //graph related
    GraphView tempGraph;
    GridLabelRenderer glr;
    Viewport vp;
    LineGraphSeries<DataPoint> series;

    //others
    Activity currentActivity;

    private void init() {
        currentActivity = this;

        tempGraph = findViewById(R.id.graph);
        tempGraph.setTitle("Temperature Log");

        glr = tempGraph.getGridLabelRenderer();
        glr.setHorizontalAxisTitle("time");
        glr.setVerticalAxisTitle("temp");

        vp = tempGraph.getViewport();
        vp.setXAxisBoundsManual(true);
        vp.setMinX(0);
        vp.setMaxX(10);
        vp.setYAxisBoundsManual(true);
        vp.setMinY(0);
        vp.setMaxY(10);
        vp.setScrollable(true);

        //fake data
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6),
                new DataPoint(5, 2),
                new DataPoint(6, 2),
                new DataPoint(7, 2),
                new DataPoint(8, 2),
                new DataPoint(9, 2),
                new DataPoint(10, 1),
                new DataPoint(11, 5),
                new DataPoint(12, 3),
                new DataPoint(13, 2),
                new DataPoint(14, 6),
                new DataPoint(15, 2),
                new DataPoint(16, 2),
                new DataPoint(17, 2),
                new DataPoint(18, 2),
                new DataPoint(19, 2),
                new DataPoint(20, 2),
                new DataPoint(21, 2)

        });

        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);

        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(currentActivity, "Data Point: " + dataPoint, Toast.LENGTH_SHORT)
                        .show();
            }
        });

        tempGraph.addSeries(series);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_log);

        //initialize varaibles
        init();
    }
}
