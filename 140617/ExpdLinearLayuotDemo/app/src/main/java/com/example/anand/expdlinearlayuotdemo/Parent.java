package com.example.anand.expdlinearlayuotdemo;

import java.util.ArrayList;

/**
 * Created by Anand on 15-06-2017.
 */

class Parent {
    String name;
    int image;
    ArrayList<Child> childArrayList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ArrayList<Child> getChildArrayList() {
        return childArrayList;
    }

    public void setChildArrayList(ArrayList<Child> childArrayList) {
        this.childArrayList = childArrayList;
    }

}
