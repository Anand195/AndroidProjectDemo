package com.example.anand.expdlinearlayuotdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ExpandableListView ex_lv;
    String[] names = {"No key", "Alphabet Key", "Funtion Key"},
            no_key_array = {"1", "2", "3"},
            alpha_key_array = {"A", "B", "C"},
            funcation_key_array = {"F1", "F2", "F3"};
    int[] images_array = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher},
            sub_images = {R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round};
    Parent parent;
    Child child;
    AAdapter adapter;
    ArrayList<Parent> parentList;
    ArrayList<Child> childList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ex_lv = (ExpandableListView) findViewById(R.id.ex_lv);
        parentList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            parent = new Parent();
            parent.setName(names[i]);
            parent.setImage(images_array[i]);
            if (i == 0) {
                childList = new ArrayList<>();
                for (int j = 0; j < no_key_array.length; j++) {
                    child = new Child();
                    child.setChildName(no_key_array[j]);
                    child.setChildImage(sub_images[j]);
                    childList.add(child);
                    parent.setChildArrayList(childList);
                }
            }
            if (i == 1) {
                childList = new ArrayList<>();
                for (int j = 0; j < alpha_key_array.length; j++) {
                    child = new Child();
                    child.setChildName(alpha_key_array[j]);
                    child.setChildImage(sub_images[j]);
                    childList.add(child);
                    parent.setChildArrayList(childList);
                }
            }
            if (i == 2) {
                childList = new ArrayList<>();
                for (int j = 0; j < funcation_key_array.length; j++) {
                    child = new Child();
                    child.setChildName(funcation_key_array[j]);
                    child.setChildImage(sub_images[j]);
                    childList.add(child);
                    parent.setChildArrayList(childList);
                }
            }
            parentList.add(parent);
        }
        adapter = new AAdapter(MainActivity.this, parentList);
        ex_lv.setAdapter(adapter);
    }
}