package com.example.anand.d;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MActivity extends AppCompatActivity {

    Button btn_admin, btn_guest, btn_android, btn_php, btn_java, btn_back;

    ImageView iv_a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btn_admin = (Button) findViewById(R.id.btn_login);
        btn_guest = (Button) findViewById(R.id.btn_guest);
        btn_android = (Button) findViewById(R.id.btn_android);
        btn_php = (Button) findViewById(R.id.btn_php);
        btn_java = (Button) findViewById(R.id.btn_java);
        btn_back = (Button) findViewById(R.id.btn_back);
        iv_a = (ImageView) findViewById(R.id.iv_a);

        btn_java.setVisibility(View.GONE);
        btn_php.setVisibility(View.GONE);
        btn_android.setVisibility(View.GONE);
        btn_back.setVisibility(View.GONE);

        btn_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_admin.isShown() && btn_guest.isShown()) {
                    btn_admin.setVisibility(View.GONE);
                    btn_guest.setVisibility(View.GONE);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn_back.setVisibility(View.VISIBLE);
                        btn_android.setVisibility(View.VISIBLE);
                        btn_java.setVisibility(View.VISIBLE);
                        btn_php.setVisibility(View.VISIBLE);
                    }
                },2000);
                AlphaAnimation anim = new AlphaAnimation(0,1);
                anim.setDuration(5000);
                iv_a.startAnimation(anim);

            }
        });

        btn_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScaleAnimation sanim = new ScaleAnimation(1.0f,4.2f,1.0f,4.2f,120,120);
                sanim.setDuration(2000);
                iv_a.setAnimation(sanim);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ScaleAnimation ssanim = new ScaleAnimation(4.2f,1.0f,4.2f,1.0f,120,120);
                        ssanim.setDuration(2000);
                        iv_a.setAnimation(ssanim);
                    }
                },2000);

                btn_back.setVisibility(View.VISIBLE);
                btn_android.setVisibility(View.VISIBLE);
                btn_java.setVisibility(View.VISIBLE);
                if (btn_admin.isShown() && btn_guest.isShown()) {
                    btn_admin.setVisibility(View.GONE);
                    btn_guest.setVisibility(View.GONE);
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RotateAnimation ranim = new RotateAnimation(360,0,130,130);
                ranim.setDuration(2000);
                iv_a.startAnimation(ranim);
                btn_back.setVisibility(View.GONE);
                btn_android.setVisibility(View.GONE);
                btn_java.setVisibility(View.GONE);
                btn_php.setVisibility(View.GONE);
                btn_admin.setVisibility(View.VISIBLE);
                btn_guest.setVisibility(View.VISIBLE);
            }
        });

    }
}
