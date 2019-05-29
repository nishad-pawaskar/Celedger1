package com.example.celedger1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

//CLASS FOR MAIN ACTIVITY
public class MainActivity extends AppCompatActivity {

    String limit = "3";
    float xTotal, iTotal, sTotal;
    DatabaseHelper xpense_db;
    SQLiteDatabase expdb;
    XpnseAdaptor xpAdaptor;
    IncmeAdaptor icAdaptor;

    //CREATE LAYOUT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DECLARATION & DEFINITION
        LinearLayout linearLayoutIncme = findViewById(R.id.linearLayoutIncme);
        LinearLayout linearLayoutxpnd = findViewById(R.id.linearLayoutxpnd);
        TextView ExpenseAmount = findViewById(R.id.expendamt);
        TextView IncomeAmount = findViewById(R.id.incomeamt);
        TextView SavingAmount = findViewById(R.id.savingamt);
        LinearLayout linearaddincomebtn = findViewById(R.id.addincome);
        LinearLayout linearaddxpensebtn = findViewById(R.id.addxpense);
        RecyclerView Incmelist = findViewById(R.id.Incmelist);
        RecyclerView Xpnselist = findViewById(R.id.Xpnselist);

        xpense_db = new DatabaseHelper(this);
        expdb = xpense_db.getWritableDatabase();

        //Linear Layout Income
        linearLayoutIncme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntentIncme = new Intent(getApplicationContext(), IncomeActivity.class);
                startActivity(startIntentIncme);
            }
        });

        Cursor icursor = expdb.rawQuery("SELECT SUM(" + CeledgerContract.IncomeEntry.COL_5 + ") as Total FROM " + CeledgerContract.IncomeEntry.INCOME_TABLE, null);
        if (icursor.moveToFirst()) {
            iTotal = icursor.getFloat(icursor.getColumnIndex("Total"));// get final total
        }
        IncomeAmount.setText(String.valueOf(iTotal));

        //Latest Income List
        Incmelist.setLayoutManager(new LinearLayoutManager(this));
        icAdaptor = new IncmeAdaptor(this, getAllIncome());
        Incmelist.setAdapter(icAdaptor);

        //Income Add Image
        linearaddincomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntentaddincome = new Intent(getApplicationContext(),AddIncome.class);
                startActivity(startIntentaddincome);
            }
        });

        //Linear Layout Expenditure
        linearLayoutxpnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntentxpnd = new Intent(getApplicationContext(),ExpendActivity.class);
                startActivity(startIntentxpnd);
            }
        });

        Cursor ecursor = expdb.rawQuery("SELECT SUM(" + CeledgerContract.XpenseEntry.AMOUNT + ") as Total FROM " + CeledgerContract.XpenseEntry.XPENSE_TABLE, null);
        if (ecursor.moveToFirst()) {
            xTotal = ecursor.getFloat(ecursor.getColumnIndex("Total"));// get final total
        }
        ExpenseAmount.setText(String.valueOf(xTotal));

        //Latest Expense List
        Xpnselist.setLayoutManager(new LinearLayoutManager(this));
        xpAdaptor = new XpnseAdaptor(this, getAllXpense());
        Xpnselist.setAdapter(xpAdaptor);

        linearaddxpensebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntentaddxpense = new Intent(getApplicationContext(),AddXpense.class);
                startActivity(startIntentaddxpense);
            }
        });

        sTotal = iTotal - xTotal;
        SavingAmount.setText(String.valueOf(sTotal));
    }

    private Cursor getAllXpense(){
        Cursor cursor = expdb.query(CeledgerContract.XpenseEntry.XPENSE_TABLE,
                null,
                null,
                null,
                null,
                null,
                CeledgerContract.XpenseEntry.TIMESTAMP +" DESC",
                limit);
        return cursor;
    }

    private Cursor getAllIncome(){
        Cursor cursor = (Cursor) expdb.query(CeledgerContract.IncomeEntry.INCOME_TABLE,
                null,
                null,
                null,
                null,
                null,
                CeledgerContract.IncomeEntry.COL_6 +" DESC",
                limit);
        return cursor;
    }
}
