package com.example.raj.bcs421rajdeliwalahwktip;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Raj on 5/10/2017.
 */

public class tipDBContract {
    private tipDBContract() {}
    public static final Uri CONTENT_URI = Uri.parse("Content");
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "tipApplication.db";
    public static final String Authority = "package com.example.raj.bcs421rajdeliwalahwktip;";
    private static final String FLOAT_TYPE = "FLOAT";
    private static final String TEXT_TYPE = "TEXT";
    private static final String COMMA_SEP = ",";

    public static final int ALLROWS = 1;
    public static final int SINGLE_ROW = 2;


    //Table name and columns
    public static class tipTable implements BaseColumns {
        public static final String TABLE_NAME = "Tips";

        public static final String ColumnID = "_ID";
        public static final String ColumnRestaurantName = "RestaurantName";
        public static final String ColumnBillAmount = "BillAmount";
        public static final String ColumnTipPct = "TipPct";
        public static final String ColumnTipAmount = "TipAmount";
        public static final String ColumnSpeedOfServices = "SpeedOfServices";
        public static final String ColumnFriendliness = "FriendlinessOfServices";
        public static final String ColumnOrderAccuracy = "AccuracyOfOrder";

        public static final String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "(" +
                _ID+"Integer primary key autoincrement" + COMMA_SEP + ColumnRestaurantName + TEXT_TYPE + COMMA_SEP
                + ColumnBillAmount + FLOAT_TYPE + COMMA_SEP + ColumnTipPct + FLOAT_TYPE +COMMA_SEP
                +ColumnTipAmount + FLOAT_TYPE + COMMA_SEP + ColumnSpeedOfServices + FLOAT_TYPE + COMMA_SEP +
                ColumnFriendliness + FLOAT_TYPE + COMMA_SEP + ColumnOrderAccuracy + FLOAT_TYPE + ")";

        public static final String DELETE_TALE = "Drop table if it exist" + TABLE_NAME;

    }




}
