package com.hukazawa.user.lesson_1024_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    CheckBox chb;
    RadioGroup rdg;
    RadioButton rb;
    ProgressBar pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pg = (ProgressBar) findViewById(R.id.progressBar2);
        chb = (CheckBox) findViewById(R.id.checkBox);
        chb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("MYLOG", "chb:" + isChecked);
            }


        });
        rb = (RadioButton) findViewById(R.id.radioButton2);
        rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

        rdg = (RadioGroup) findViewById(R.id.radioGroup);
        rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radioButton2) {
                    Log.d("狀態", "要訂閱");
                } else if (checkedId == R.id.radioButton3) {
                    Log.d("狀態", "不要發送任何報導");
                }
            }
        });
    }

    public void send(View v)
    {
        pg.setVisibility(View.VISIBLE);
        new Thread(){

            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pg.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }.start();

    }

}



