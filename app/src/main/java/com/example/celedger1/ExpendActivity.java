package com.example.celedger1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

//CLASS FOR EXPEND ACTIVITY
public class ExpendActivity extends AppCompatActivity {

    //CREATE LAYOUT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expend);

        //DECLARATION & DEFINITION
        RecyclerView ExpenselistRCV = (RecyclerView)findViewById(R.id.ExpenselistRCV);

        //SHOWS SCROLLABLE EXPENSE LIST (LIST WILL INCLUDE USER ENTRIES)
        ExpenselistRCV.setLayoutManager(new LinearLayoutManager(this));
        String[] Expenditure = {"Travel", "Food", "Bills", "Fees", "Rent", "Travel", "Food", "Bills", "Fees", "Rent", "Travel", "Food", "Bills", "Fees", "Rent", "Travel", "Food", "Bills", "Fees", "Rent", "Travel", "Food", "Bills", "Fees", "Rent"};
        ExpenselistRCV.setAdapter(new XpnseAdaptor(Expenditure));



    }
}
