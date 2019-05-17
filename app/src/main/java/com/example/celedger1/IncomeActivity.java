package com.example.celedger1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

//CLASS FOR INCOME ACTIVITY
public class IncomeActivity extends AppCompatActivity {

    //CREATE LAYOUT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        //DECLARATION & DEFINITION
        RecyclerView IncmelistRCV = (RecyclerView)findViewById(R.id.IncmelistRCV);

        //SHOWS SCROLLABLE INCOME LIST (LIST WILL INCLUDE USER ENTRIES)
        IncmelistRCV.setLayoutManager(new LinearLayoutManager(this));
        String[] Income = {"Salary", "Others", "Salary", "Bonus", "Rent", "Others", "Salary", "Bonus", "Rent", "Others", "Salary", "Bonus", "Rent", "Others", "Salary", "Bonus", "Rent", "Others"};
        IncmelistRCV.setAdapter(new IncmeAdaptor(Income));

    }
}
