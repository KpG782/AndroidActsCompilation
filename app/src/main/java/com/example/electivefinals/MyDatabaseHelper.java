package com.example.electivefinals;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "EmployeePayroll.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "employee_payroll";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_EMPLOYEE_NAME = "employee_name";
    private static final String COLUMN_POSITION_CODE = "position_code";
    private static final String COLUMN_CIVIL_STATUS = "civil_status";
    private static final String COLUMN_DAYS_WORKED = "days_worked";
    private static final String COLUMN_BASIC_PAY = "basic_pay";
    private static final String COLUMN_SSS_CONTRIBUTION = "sss_contribution";
    private static final String COLUMN_WITHHOLDING_TAX = "withholding_tax";
    private static final String COLUMN_NET_PAY = "net_pay";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_EMPLOYEE_NAME + " TEXT, "
                + COLUMN_POSITION_CODE + " TEXT, "
                + COLUMN_CIVIL_STATUS + " TEXT, "
                + COLUMN_DAYS_WORKED + " INTEGER, "
                + COLUMN_BASIC_PAY + " REAL, "
                + COLUMN_SSS_CONTRIBUTION + " REAL, "
                + COLUMN_WITHHOLDING_TAX + " REAL, "
                + COLUMN_NET_PAY + " REAL);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addPayroll(String employeeName, String positionCode, String civilStatus,
                           int daysWorked, double basicPay, double sssContribution,
                           double withholdingTax, double netPay) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_EMPLOYEE_NAME, employeeName);
        cv.put(COLUMN_POSITION_CODE, positionCode);
        cv.put(COLUMN_CIVIL_STATUS, civilStatus);
        cv.put(COLUMN_DAYS_WORKED, daysWorked);
        cv.put(COLUMN_BASIC_PAY, basicPay);
        cv.put(COLUMN_SSS_CONTRIBUTION, sssContribution);
        cv.put(COLUMN_WITHHOLDING_TAX, withholdingTax);
        cv.put(COLUMN_NET_PAY, netPay);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed to save payroll data", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Payroll data saved successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
