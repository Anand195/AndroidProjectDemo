package com.example.anand.sqlitedemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView actv_Email;
    EditText et_Password;
    TextView tv_fPass;
    Button btn_Login;
    SQLiteDatabase sqlDb;
    String sEmail, sPass, sVE, sValidateEmial =
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
    Cursor c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actv_Email = (AutoCompleteTextView) findViewById(R.id.actv_Emailid);
        et_Password = (EditText) findViewById(R.id.et_Password);
        tv_fPass = (TextView) findViewById(R.id.tv_Fpass);
        btn_Login = (Button) findViewById(R.id.btn_login);

//        c = sqlDb.rawQuery("select * from Registration", null);

        actv_Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

                /*while (c.moveToNext()) {
                    sVE = c.getString(c.getColumnIndex("Email"));
                }
                if (actv_Email.getText().toString().matches(sVE) && actv_Email.getText().toString().length() > 0) {
                    sEmail = actv_Email.getText().toString().trim();
                    sPass = et_Password.getText().toString().trim();
                } else {
                    actv_Email.setError("Register first!");
                }*/

            }
        });

        if (actv_Email.getText().toString().equalsIgnoreCase("")) {
            actv_Email.setError("Can't be empty");
        }
        if (et_Password.getText().toString().equalsIgnoreCase("")) {
            et_Password.setError("Can't be empty");
        }

        tv_fPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (actv_Email.getText().toString().equalsIgnoreCase("")) {
                } else {
                    Toast.makeText(MainActivity.this, "Check your email", Toast.LENGTH_SHORT).show();
                }

            }
        });


        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (actv_Email.getText().toString().equalsIgnoreCase("") && et_Password.getText().toString().equalsIgnoreCase("")) {
                    actv_Email.setError("Can't be empty");
                    et_Password.setError("Can't be empty");
                } else {
                    sqlDb.execSQL("select * from Registration where Email = '" + actv_Email.getText().toString() + "'AND Pass = '" + et_Password.getText().toString() + "'");
                    Intent i = new Intent(MainActivity.this, PationtAdmitForm.class);
                    Toast.makeText(MainActivity.this, "Welcome!\n" + sEmail, Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(i);
                }
            }
        });
    }
}
