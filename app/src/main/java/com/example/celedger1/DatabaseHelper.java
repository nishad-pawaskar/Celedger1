package com.example.celedger1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.celedger1.CeledgerContract.*;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String CELEDGER_DB = "celedger_database.db";


    public DatabaseHelper(Context context) {
        super(context, CELEDGER_DB, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + IncomeEntry.INCOME_TABLE + " (" +
                IncomeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                IncomeEntry.COL_4 +  " TEXT NOT NULL, " +
                IncomeEntry.COL_5 + " FLOAT NOT NULL, " +
                IncomeEntry.COL_2 + " DATE NOT NULL, " +
                IncomeEntry.COL_3 + " TEXT NOT NULL, "+
                IncomeEntry.COL_6 + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");");
        db.execSQL("create table " + XpenseEntry.XPENSE_TABLE + " (" +
                XpenseEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                XpenseEntry.CATEGORY+  " TEXT NOT NULL, " +
                XpenseEntry.AMOUNT + " FLOAT NOT NULL, " +
                XpenseEntry.DATE + " DATE NOT NULL, " +
                XpenseEntry.PAYMENTMETHOD + " TEXT NOT NULL, "+
                XpenseEntry.TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + IncomeEntry.INCOME_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + XpenseEntry.XPENSE_TABLE);
        onCreate(db);
    }

    public boolean insertincomedata(String source, String amount, String date, String paymentmethod){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(IncomeEntry.COL_4, source);
        contentValues.put(IncomeEntry.COL_5, amount);
        contentValues.put(IncomeEntry.COL_2, date);
        contentValues.put(IncomeEntry.COL_3, paymentmethod);
        long icresult = db.insert(IncomeEntry.INCOME_TABLE, null, contentValues);
        if(icresult == -1)
            return false;
        else
            return true;
    }

    public boolean insertxpnsedata(String category, String amount, String date, String paymentmethod){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(XpenseEntry.CATEGORY, category);
        cv.put(XpenseEntry.AMOUNT, amount);
        cv.put(XpenseEntry.DATE, date);
        cv.put(XpenseEntry.PAYMENTMETHOD, paymentmethod);
        long xpresult = db.insert(XpenseEntry.XPENSE_TABLE, null, cv);
        if(xpresult == -1)
            return false;
        else
            return true;
    }
}
