package com.askjeffreyliu.androidarch;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // The ViewModelStore provides a new ViewModel or one previously created.
//        ChronometerViewModel chronometerViewModel
//                = ViewModelProviders.of(this).get(ChronometerViewModel.class);
//
//        // Get the chronometer reference
//        Chronometer chronometer =  findViewById(R.id.chronometer);
//
//        if (chronometerViewModel.getStartDate() == null) {
//            // If the start date is not defined, it's a new ViewModel so set it.
//            long startTime = SystemClock.elapsedRealtime();
//            chronometerViewModel.setStartDate(startTime);
//            chronometer.setBase(startTime);
//        } else {
//            // Otherwise the ViewModel has been retained, set the chronometer's base to the original
//            // starting time.
//            chronometer.setBase(chronometerViewModel.getStartDate());
//        }
//
//        chronometer.start();
//    }


    private LiveDataTimerViewModel mLiveDataTimerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mLiveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);

        subscribe();
    }

    private void subscribe() {
        final Observer<Long> elapsedTimeObserver = new Observer<Long>() {
            @Override
            public void onChanged(@Nullable final Long aLong) {
                ((TextView) findViewById(R.id.hello_textview)).setText("time " + aLong);
                Log.d("ChronoActivity3", "Updating timer");
            }
        };

        mLiveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver);
    }
}
