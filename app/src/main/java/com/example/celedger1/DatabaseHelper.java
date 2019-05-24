package com.example.celedger1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String CELEDGER_DB = "celedger_database.db";
    public static final String INCOME_TABLE = "income_table";
    public static final String COL_1 = "sr_no";
    public static final String COL_2 = "date";
    public static final String COL_3 = "paymentmethod";
    public static final String COL_4 = "source";
    public static final String COL_5 = "amount";

    public DatabaseHelper(Context context) {
        super(context, CELEDGER_DB, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + INCOME_TABLE + " (sr_no INTEGER PRIMARY KEY AUTOINCREMENT, date DATE, paymentmethod TEXT, source TEXT, amount INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + INCOME_TABLE);
        onCreate(db);
    }

    public boolean insertincomedata(String source, String amount, String date, String paymentmethod){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_4, source);
        contentValues.put(COL_5, amount);
        contentValues.put(COL_2, date);
        contentValues.put(COL_3, paymentmethod);
        long result = db.insert(INCOME_TABLE, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}
