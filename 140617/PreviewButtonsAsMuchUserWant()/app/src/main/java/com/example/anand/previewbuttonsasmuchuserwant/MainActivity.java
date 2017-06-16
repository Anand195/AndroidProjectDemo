package com.example.anand.previewbuttonsasmuchuserwant;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.editable;

public class MainActivity extends AppCompatActivity {

    Button btn_generate,btn_preview;
    ArrayList<String> arrayList;
    EditText et_userInput;
    RadioGroup rg_orientation;
    String s;
    LinearLayout v_preview;
    int num;
    RadioButton rb_vertical,rb_horizontal;
    ScrollView sv_scroll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Variable Initialization
        btn_generate = (Button) findViewById(R.id.btn_genrate);
        et_userInput = (EditText) findViewById(R.id.et_userInput);
        rg_orientation = (RadioGroup) findViewById(R.id.rg_orientation);
        v_preview = (LinearLayout) findViewById(R.id.v_preview);
        rb_horizontal = (RadioButton) findViewById(R.id.rb_Horizontal);
        rb_vertical = (RadioButton) findViewById(R.id.rb_vertical);
        sv_scroll = (ScrollView) findViewById(R.id.sv_scroll);

        et_userInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

                public void afterTextChanged(Editable editable) {

                    s = et_userInput.getText().toString().trim();
                    if(!s.equals("")){
                        num=Integer.parseInt(s);
                        if(num<=100){
//                            et_userInput.setText(""+num);
                        }else{
                            et_userInput.setText("");
                        }
                    }
            }
        });

        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = et_userInput.getText().toString().trim();
                Toast.makeText(MainActivity.this, "You Have Entered: "+ s, Toast.LENGTH_SHORT).show();

                for (int i = 1; i<=num; i++)
                {

                    btn_preview = new Button(MainActivity.this);
                    btn_preview.setText("" + i);
                    btn_preview.setId(i);
                    btn_preview.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    v_preview.addView(btn_preview);
                }
                Toast.makeText(MainActivity.this, "Button Generated ", Toast.LENGTH_SHORT).show();
            }
        });


        rb_horizontal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                v_preview.setOrientation(LinearLayout.VERTICAL);
            }
        });

        rb_vertical.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                sv_scroll.fullScroll)
                v_preview.setOrientation(LinearLayout.HORIZONTAL);
            }
        });
    }
}
