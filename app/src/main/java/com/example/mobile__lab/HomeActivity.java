package com.example.mobile__lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final Button button = findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new CountDownTimer(60000, 1000) {

                    final EditText timerMin = (EditText) findViewById(R.id.TimerMin);
                    final EditText timerSec = (EditText) findViewById(R.id.TimerSec);
                    final ProgressBar simpleProgressBar = (ProgressBar) findViewById(R.id.progressBar2);

                    public void onTick(long millisUntilFinished) {
                        int min, sec, i = 1000;
                        millisUntilFinished = millisUntilFinished / 1000;
                        min = (int) (millisUntilFinished / 60);
                        sec = (int) (millisUntilFinished % 60);
                        timerMin.setText(min + "");
                        timerSec.setText(sec + "");
                        simpleProgressBar.setMax(60000);
                        setProgressValue(i,60000);
                    }

                    public void onFinish() {
                        timerMin.setText("done!");
                    }

                    private void setProgressValue(final int progress, final int max) {

                        int val = simpleProgressBar.getProgress();
                        simpleProgressBar.setProgress(val+progress);

                    }

                }.start();
            }
        });
    }

}
