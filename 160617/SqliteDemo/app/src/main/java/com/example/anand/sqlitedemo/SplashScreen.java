package com.example.anand.sqlitedemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        count++;
                        if (count == 1) {
                            A(R.id.t).setVisibility(View.VISIBLE);
                        }
                        if (count == 2) {
                            A(R.id.tt).setVisibility(View.VISIBLE);
                        }
                        if (count == 3) {
                            A(R.id.ttt).setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        }, 1000, 1000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, RegistrationActivity.class);
                finish();
                startActivity(i);
            }
        }, 3000);
    }

    private View A(int id) {
        return findViewById(id);
    }

    }
