package com.example.celedger1;

import android.app.DatePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.Calendar;

public class AddIncome extends AppCompatActivity {

    DatabaseHelper income_db;
    SQLiteDatabase incdb;

    EditText addincamt, addincdte;
    MaterialBetterSpinner addinccat, addincPM;
    Button addincomebtn;

    DatePickerDialog incdatePicker;

    String[] IncomeCat = {"Salary", "Payment", "Others"}, PayMethod = {"Cash", "Online Transfer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        income_db = new DatabaseHelper(this);
        incdb = income_db.getWritableDatabase();

        addincamt = findViewById(R.id.incamt);
        addinccat = findViewById(R.id.incsrc);
        addincPM = findViewById(R.id.incpm);
        addincdte = findViewById(R.id.incdte);
        addincomebtn = findViewById(R.id.addincomebtn);

        //INCOME CATEGORY ADAPTOR
        ArrayAdapter<String> IncomeCategory = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, IncomeCat);
        addinccat.setAdapter(IncomeCategory);

        //PAYMENT OPTION ADAPTOR
        ArrayAdapter<String> paymentCat = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, PayMethod);
        addincPM.setAdapter(paymentCat);

        //LISTENER FOR DATE
        addincdte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar inc_cal = Calendar.getInstance();
                final int ic_year = inc_cal.get(Calendar.YEAR);
                final int ic_month = inc_cal.get(Calendar.MONTH);
                final int ic_day = inc_cal.get(Calendar.DAY_OF_MONTH);

                incdatePicker = new DatePickerDialog(AddIncome.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = dayOfMonth+"-"+month+"-"+year;
                        addincdte.setText(date);
                    }
                },ic_year,ic_month,ic_day);
                incdatePicker.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                incdatePicker.show();
            }
        });

        addincamt.addTextChangedListener(addincometextwatcher);
        addinccat.addTextChangedListener(addincometextwatcher);
        addincPM.addTextChangedListener(addincometextwatcher);
        addincdte.addTextChangedListener(addincometextwatcher);

        AddInc();
    }

    private TextWatcher addincometextwatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String incmeamt = addincamt.getText().toString().trim();
            String incmesrc = addinccat.getText().toString().trim();
            String incmepm = addincPM.getText().toString().trim();
            String incmedte = addincdte.getText().toString().trim();

            addincomebtn.setEnabled(!incmeamt.isEmpty() && !incmesrc.isEmpty() && !incmepm.isEmpty() && !incmedte.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void AddInc(){
        addincomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = income_db.insertincomedata(addinccat.getText().toString(), addincamt.getText().toString(), addincdte.getText().toString(), addincPM.getText().toString());
                if(isInserted == true)
                    Toast.makeText(AddIncome.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(AddIncome.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }
}
