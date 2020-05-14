package com.example.raj.bcs421rajdeliwalahwktip;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by Raj on 4/22/2017.
 */

public class Singleton{

    //Creating array and instance of singleton
    int arrayPostion = 0;
    private ArrayList<tipData> tipArray;
    private static Singleton instance = new Singleton();

    //Constructor
    private Singleton() {
        tipArray = new ArrayList<tipData>();
    }
    //Get list
    public ArrayList<tipData> getTipArray() {
        return tipArray;
    }
    //Get instance
    public static Singleton getInstance() {
        return instance;
    }
    public void setArrayPostion(int p)
    {
        arrayPostion = p;
    }
    public int getArrayPostion()
    {
        return arrayPostion;
    }
}
