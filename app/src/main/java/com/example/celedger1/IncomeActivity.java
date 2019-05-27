package com.example.celedger1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

//CLASS FOR INCOME ACTIVITY
public class IncomeActivity extends AppCompatActivity {

    DatabaseHelper income_db;
    SQLiteDatabase incdb;
    IncmeAdaptor icAdaptor;
    float icTotal;

    private static final String TAG = IncomeActivity.class.getSimpleName();

    //CREATE LAYOUT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        income_db = new DatabaseHelper(this);
        incdb = income_db.getWritableDatabase();

        //DECLARATION & DEFINITION
        RecyclerView IncmelistRCV = findViewById(R.id.IncmelistRCV);
        TextView Totalincome = findViewById(R.id.Totalincome);

        //SHOWS SCROLLABLE INCOME LIST (LIST WILL INCLUDE USER ENTRIES)
        IncmelistRCV.setLayoutManager(new LinearLayoutManager(this));
        //String[] Income = {"Salary", "Others", "Salary", "Bonus", "Rent", "Others", "Salary", "Bonus", "Rent", "Others", "Salary", "Bonus", "Rent", "Others", "Salary", "Bonus", "Rent", "Others"};
        icAdaptor = new IncmeAdaptor(this, getAllIncome());
        IncmelistRCV.setAdapter(icAdaptor);

        Cursor dcursor = incdb.rawQuery("SELECT SUM(" + CeledgerContract.IncomeEntry.COL_5 + ") as Total FROM " + CeledgerContract.IncomeEntry.INCOME_TABLE, null);

        if (dcursor.moveToFirst()) {
            icTotal = dcursor.getFloat(dcursor.getColumnIndex("Total"));// get final total
            }
        Totalincome.setText(String.valueOf(icTotal));
    }

    private Cursor getAllIncome(){
        Cursor cursor = incdb.query(CeledgerContract.IncomeEntry.INCOME_TABLE,
                null,
                null,
                null,
                null,
                null,
                CeledgerContract.IncomeEntry.COL_6 +" DESC");
        return cursor;
        }
}
