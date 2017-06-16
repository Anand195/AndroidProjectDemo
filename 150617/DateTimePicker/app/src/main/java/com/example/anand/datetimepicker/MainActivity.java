package com.example.anand.datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static java.lang.System.currentTimeMillis;
import static java.util.Calendar.MINUTE;

public class MainActivity extends AppCompatActivity {

    Button btn_date, btn_time;
    Calendar calendar, calender2;
    DatePickerDialog d;
    TimePickerDialog t;
    int tHour,tMinut;
    TimePicker timePicker;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_date = (Button) findViewById(R.id.btn_date);
        btn_time = (Button) findViewById(R.id.btn_time);

        calendar = Calendar.getInstance();
        calender2 = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR, i);
                calendar.set(Calendar.MONTH, i1);
                calendar.set(Calendar.DAY_OF_MONTH, i2);

                SimpleDateFormat datef = new SimpleDateFormat("dd-MM-yy", Locale.US);
                Toast.makeText(MainActivity.this, datef.format(calendar.getTime()), Toast.LENGTH_SHORT).show();
            }
        };

        btn_date.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                d = new DatePickerDialog(MainActivity.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                d.getDatePicker().setMinDate(currentTimeMillis() - 1000);
                d.show();

            }
        });

        final TimePickerDialog.OnTimeSetListener timet = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                String s = null;
<<<<<<< HEAD
                calender2.set(Calendar.HOUR, i);
                calender2.set(MINUTE, i1);
=======
                calender2.set(Calendar.HOUR_OF_DAY, i);
                calender2.set(Calendar.MINUTE, i1);
>>>>>>> 1f3a7ffa48ff0efcde14c36972bebd21bded0a29
                if (i < 12) {
                    s = "AM";
                } else {
                    s = "PM";
                }
                String s1;
                if (i1 < 10) {
                    s1 = "0" + i1;
                } else {
                    s1 = "" + i1;
                }
                Toast.makeText(MainActivity.this, String.valueOf(i) + ":" + s1 + s, Toast.LENGTH_SHORT).show();
            }
        };
        

        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = new TimePickerDialog(MainActivity.this, timet, calender2.get(Calendar.HOUR), calender2.get(MINUTE), false);
<<<<<<< HEAD
=======
                t.updateTime(calender2.get(Calendar.HOUR_OF_DAY),calender2.get(MINUTE));
>>>>>>> 1f3a7ffa48ff0efcde14c36972bebd21bded0a29
                t.show();
            }
        });

    }
}
