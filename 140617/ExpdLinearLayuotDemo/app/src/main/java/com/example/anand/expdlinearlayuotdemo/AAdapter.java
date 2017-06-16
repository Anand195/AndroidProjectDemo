package com.example.anand.expdlinearlayuotdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Anand on 15-06-2017.
 */

class AAdapter extends BaseExpandableListAdapter {
    Context context;
    ArrayList<Parent> parentArrayList;
    LayoutInflater layoutInflater;


    public AAdapter(MainActivity mainActivity, ArrayList<Parent> parentList) {
        this.context = mainActivity;
        this.parentArrayList = parentList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return parentArrayList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return parentArrayList.get(i).getChildArrayList().size();
    }

    @Override
    public Object getGroup(int i) {
        return parentArrayList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return parentArrayList.get(i).getChildArrayList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.custom_group, null, false);
        TextView p_tv = (TextView) view.findViewById(R.id.p_tv);
        ImageView p_iv = (ImageView) view.findViewById(R.id.p_iv);
        p_tv.setText(parentArrayList.get(i).getName());
        p_iv.setImageResource(parentArrayList.get(i).getImage());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.custom_child, null, false);
        TextView c_tv = (TextView) view.findViewById(R.id.c_tv);
        ImageView c_iv = (ImageView) view.findViewById(R.id.c_iv);
        c_tv.setText(parentArrayList.get(i).getChildArrayList().get(i1).getChildName());
        c_iv.setImageResource(parentArrayList.get(i).getChildArrayList().get(i1).getChildImage());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
