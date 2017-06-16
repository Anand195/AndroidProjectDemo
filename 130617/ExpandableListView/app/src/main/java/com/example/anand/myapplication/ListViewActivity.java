package com.example.anand.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    ListView lv_second;
    ArrayAdapter<String> array_value;
    String[] s;
    Button btn_back;
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lv_second = (ListView) findViewById(R.id.lv_second);
        btn_back = (Button) findViewById(R.id.btn_back);
        b = getIntent().getExtras();

        s = b.getStringArray("data");
        //s = i.getStringArrayExtra("key");
        array_value = new ArrayAdapter<String>(this, android.R.layout.select_dialog_multichoice, s);
        lv_second.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv_second.setAdapter(array_value);

       /* if(s != null)
        {
            Toast.makeText(this, "Got data to second activity", Toast.LENGTH_SHORT).show();
        }

        else {
            Toast.makeText(this, "!!!", Toast.LENGTH_SHORT).show();
        }*/

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(ListViewActivity.this,RealtiveLayout_Activity.class);
                finish();
                startActivity(back);
            }
        });
    }
}
