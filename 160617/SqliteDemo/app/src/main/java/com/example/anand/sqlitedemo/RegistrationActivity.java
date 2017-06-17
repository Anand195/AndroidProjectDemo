package com.example.anand.sqlitedemo;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText etuEmail, etuPass, etuCPass;
    RadioGroup rgGender;
    Button btnRegister;
    String sEmail, sPass, sGender = null, sValidateEmail =
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$",
            sValidatePass = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$",
            sVP1 = "^(?=.*[0-9])",
            sVP2 = "(?=.*[a-z])",
            sVP3 = "(?=.*[A-Z])",
            sVP4 = "(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();

        etuEmail = (EditText) findViewById(R.id.et_Emailid);
        etuPass = (EditText) findViewById(R.id.et_Password);
        etuCPass = (EditText) findViewById(R.id.et_CPassword);

        rgGender = (RadioGroup) findViewById(R.id.rg_gender);
        btnRegister = (Button) findViewById(R.id.btn_register);


        db = openOrCreateDatabase("HoDoRs", Context.MODE_PRIVATE, null);
        db.execSQL("Create table if not exists Registration (Id  INTEGER(5) PRIMARY KEY AUTOINCREMENT,Email varchar2(255),Pass varchar2(255),Gender varchar2(255))");


        etuEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (etuEmail.getText().toString().matches(sValidateEmail) && etuEmail.getText().toString().length() > 0) {
                    sEmail = etuEmail.getText().toString().trim();
                } else {
                    etuEmail.setError("Enter valid emailid!");
                }
            }
        });


        etuPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (etuPass.getText().toString().matches(sValidatePass) && etuPass.getText().toString().trim().length() > 0) {
                } else {
                    etuPass.setError("Must contain \n 1.0-9\n 2.a-z \n 3.A-Z \n 4.special character");
                }
            }
        });

        etuCPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (etuCPass.getText().toString().matches(etuPass.getText().toString()) && etuCPass.getText().toString().length() > 0) {
                    sPass = etuCPass.getText().toString().trim();
                } else {
                    etuCPass.setError("Password dosen't match!");
                }
            }
        });

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                if (i == R.id.rb_male) {
                    sGender = "Male";
                    Toast.makeText(RegistrationActivity.this, sGender, Toast.LENGTH_SHORT).show();
                } else if (i == R.id.rb_female) {
                    sGender = "Female";
                    Toast.makeText(RegistrationActivity.this, sGender, Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("insert into Registration (Email,Pass,Gender) values ('" + sEmail + "','" + sPass + "','" + sGender + "')");
                Toast.makeText(RegistrationActivity.this, "User " + sEmail + sPass + sGender, Toast.LENGTH_SHORT).show();
//               db.delete("Registration",null,null);
                Intent i = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}