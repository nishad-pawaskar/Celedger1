package com.example.celedger1;

import android.provider.BaseColumns;

public class CeledgerContract {
    private CeledgerContract() {}
    public static final class IncomeEntry implements BaseColumns {
        public static final String INCOME_TABLE = "income_table";
        public static final String COL_2 = "date";
        public static final String COL_3 = "paymentmethod";
        public static final String COL_4 = "source";
        public static final String COL_5 = "amount";
        public static final String COL_6 = "timestamp";
    }

    public static final class XpenseEntry implements BaseColumns{
        public static final String XPENSE_TABLE = "xpense_teble";
        public static final String DATE = "date";
        public static final String PAYMENTMETHOD = "paymentmethod";
        public static final String CATEGORY = "category";
        public static final String AMOUNT = "amount";
        public static final String TIMESTAMP = "timstamp";
    }
}
