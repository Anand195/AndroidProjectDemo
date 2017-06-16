package com.example.anand.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RealtiveLayout_Activity extends AppCompatActivity {

    /*

        RadioGroup rg_gender;
        CheckBox cb_android, cb_php, cb_ios;
        Button btn_submit;
        RadioButton rb;
        int id;
        StringBuilder sb;
    */
    String[] array_str = {"A", "B", "C", "A", "B", "C", "A", "B", "C", "A", "B", "C"};
    ArrayAdapter<String> adapter;
    ListView lv_sample;
    Button btn_submit;
    ArrayList<String> arrayList;
    SparseBooleanArray array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtivelayout);

//        Initialization of variables and wireup!
        btn_submit = (Button) findViewById(R.id.btn_submit);
        lv_sample = (ListView) findViewById(R.id.lv_sample);
        //adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_multichoice, array_str);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array_str);
//      set list view mode and set adapter to listview
//        lv_sample.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv_sample.setAdapter(adapter);

//      action performed on lisr view selection
        lv_sample.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                array = lv_sample.getCheckedItemPositions();
                arrayList = new ArrayList<String>();
//              get selected value of selected items from listview using for loop
                for (int i = 0; i < array.size(); i++) {
//                  get selected item key from sparsebooleanarray
                    int p = array.keyAt(i);
//                  get selected item value from sparseBooleanArray
                    if (array.valueAt(i)) {
//                      add selected item from arrayapater to arraslist
                        arrayList.add(adapter.getItem(p));
                    }
                }
            }
        });

//      action performed on button click
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arrayList != null) {
                    Toast.makeText(RealtiveLayout_Activity.this, "Data Fetched in arrayList", Toast.LENGTH_SHORT).show();
//                  get arraylist size to ss stringarray and store that values in ss stringarray
                    String[] ss = new String[arrayList.size()];
                    for (int i = 0; i < arrayList.size(); i++) {
                        ss[i] = arrayList.get(i);
                    }
                    Bundle b = new Bundle();
                    b.putStringArray("data", ss);
                    Intent i = new Intent(RealtiveLayout_Activity.this, ListViewActivity.class);
                    i.putExtras(b);
                    startActivity(i);
                } else {
                    Toast.makeText(RealtiveLayout_Activity.this, "!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
      /*  ListView lv = new ListView(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_multichoice, array_str);
        lv.setAdapter(adapter);

        cb_android = (CheckBox) findViewById(R.id.cb_android);
        cb_ios = (CheckBox) findViewById(R.id.cb_ios);
        cb_php = (CheckBox) findViewById(R.id.cb_php);
        rg_gender = (RadioGroup) findViewById(R.id.rg_gender);
        btn_submit = (Button) findViewById(R.id.btn_submit);


        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                id = rg_gender.getCheckedRadioButtonId();
                rb = (RadioButton) findViewById(id);
                Toast.makeText(RealtiveLayout_Activity.this, rb.getText().toString().trim(), Toast.LENGTH_SHORT).show();
            }
        });


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb = new StringBuilder();
                if (cb_android.isChecked()) {
                    sb.append(" " + cb_android.getText().toString());
                    //Toast.makeText(RealtiveLayout_Activity.this, "Android", Toast.LENGTH_SHORT).show();
                }
                if (cb_php.isChecked()) {
                    sb.append("\n " + cb_php.getText().toString());
                    //Toast.makeText(RealtiveLayout_Activity.this, "php", Toast.LENGTH_SHORT).show();
                }
                if (cb_ios.isChecked()) {
                    sb.append("\n " + cb_ios.getText().toString());
                    //Toast.makeText(RealtiveLayout_Activity.this, "ios", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(RealtiveLayout_Activity.this, sb, Toast.LENGTH_SHORT).show();
            }
        });
*/
    }

}