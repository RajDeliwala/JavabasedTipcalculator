package com.example.raj.bcs421rajdeliwalahwktip;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Raj on 5/11/2017.
 */

public class MyDBOpenHelper extends SQLiteOpenHelper{

    public MyDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tipDBContract.tipTable.CREATE_TABLE);

    }

    public void insert(tipData tip)
    {
        SQLiteDatabase db;
        db = getWritableDatabase();

        ContentValues rowData = new ContentValues();
        rowData.put(tipDBContract.tipTable.ColumnRestaurantName, tip.getRestaurantName());
        rowData.put(tipDBContract.tipTable.ColumnBillAmount, tip.getBillAmount());
        rowData.put(tipDBContract.tipTable.ColumnTipPct, tip.getTipPercentage());
        rowData.put(tipDBContract.tipTable.ColumnTipAmount, tip.getTipAmount());
        rowData.put(tipDBContract.tipTable.ColumnSpeedOfServices, tip.getSpeedService());
        rowData.put(tipDBContract.tipTable.ColumnFriendliness, tip.getFriendService());
        rowData.put(tipDBContract.tipTable.ColumnOrderAccuracy, tip.getAccuracyService());

        db.insert(tipDBContract.tipTable.TABLE_NAME,null, rowData);


    }
    public Cursor queryItems()
    {
        SQLiteDatabase db;
        Cursor result;

        String[] resultColumn = new String[]{
        tipDBContract.tipTable.ColumnRestaurantName,
                tipDBContract.tipTable.ColumnBillAmount,
                tipDBContract.tipTable.ColumnTipPct,
                tipDBContract.tipTable.ColumnTipAmount,
                tipDBContract.tipTable.ColumnSpeedOfServices,
                tipDBContract.tipTable.ColumnFriendliness,
                tipDBContract.tipTable.ColumnOrderAccuracy};

        db = getWritableDatabase();
        result = db.query(tipDBContract.tipTable.TABLE_NAME, resultColumn, null, null, null, null, null);
        return result;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old, int newVer)
    {
        Log.w("StudentDB","Upgrading from version" + old + "to" + newVer + ",which will destroy all old data");
        db.execSQL(tipDBContract.tipTable.CREATE_TABLE);
        onCreate(db);
    }
}







