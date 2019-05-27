package com.example.celedger1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

//CLASS FOR MAIN ACTIVITY
public class MainActivity extends AppCompatActivity {

    //CREATE LAYOUT
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //DECLARATION & DEFINITION
        LinearLayout linearLayoutIncme = findViewById(R.id.linearLayoutIncme);
        LinearLayout linearLayoutxpnd = findViewById(R.id.linearLayoutxpnd);
        TextView ExpenseAmount = findViewById(R.id.expendamt);
        LinearLayout linearaddincomebtn = findViewById(R.id.addincome);
        LinearLayout linearaddxpensebtn = findViewById(R.id.addxpense);
        RecyclerView Incmelist = findViewById(R.id.Incmelist);
        RecyclerView Xpnselist = findViewById(R.id.Xpnselist);


        //Linear Layout Income
        linearLayoutIncme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntentIncme = new Intent(getApplicationContext(), IncomeActivity.class);

                startActivity(startIntentIncme);
            }
        });

        //Latest Income List
        Incmelist.setLayoutManager(new LinearLayoutManager(this));
        /*String[] Income = {"Salary", "Rent", "Others"};    //NOT FINAL. THESE WILL THE 3 LATEST ENTRIES
        Incmelist.setAdapter(new IncmeAdaptor(Income));*/

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

        //ExpenseAmount.setText(ExpendActivity.exp);

        //Latest Expense List
        Xpnselist.setLayoutManager(new LinearLayoutManager(this));
        //String[] Expenditure = {"Travel", "Food", "Fees"};    //NOT FINAL. THESE WILL THE 3 LATEST ENTRIES
        //Xpnselist.setAdapter(new XpnseAdaptor(Expenditure));

        linearaddxpensebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntentaddxpense = new Intent(getApplicationContext(),AddXpense.class);

                startActivity(startIntentaddxpense);
            }
        });

    }
}
