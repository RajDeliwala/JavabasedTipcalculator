package com.example.raj.bcs421rajdeliwalahwktip;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

import static com.example.raj.bcs421rajdeliwalahwktip.tipDBContract.SINGLE_ROW;

/**
 * Created by Raj on 5/11/2017.
 */

public class tipDBContentProvider extends ContentProvider {
    private MyDBOpenHelper MyDBOpenHelper;
    private static final UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(tipDBContract.Authority,tipDBContract.tipTable.TABLE_NAME, tipDBContract.ALLROWS);
        uriMatcher.addURI(tipDBContract.Authority,tipDBContract.tipTable.TABLE_NAME + "/#", SINGLE_ROW);
    }

    @Override
    public boolean onCreate() {
        MyDBOpenHelper = new MyDBOpenHelper(getContext(),tipDBContract.DATABASE_NAME, null, tipDBContract.DATABASE_VERSION);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor resultCursor;
        SQLiteDatabase db;
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        switch (uriMatcher.match(uri))
        {
            case tipDBContract.SINGLE_ROW:
                String rowID = uri.getPathSegments().get(1);
                qb.appendWhere(tipDBContract.tipTable._ID + " = " + rowID);
                break;
            default:
                break;
        }
        qb.setTables(tipDBContract.tipTable.TABLE_NAME);
        db = MyDBOpenHelper.getWritableDatabase();
        resultCursor = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);

        return resultCursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db;
        db = MyDBOpenHelper.getWritableDatabase();

        long insertedId;
        insertedId = db.insert(tipDBContract.tipTable.TABLE_NAME, null, values);

        if (insertedId > -1) {
            Uri insertedUri = ContentUris.withAppendedId(tipDBContract.CONTENT_URI, insertedId);
            return insertedUri;
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
