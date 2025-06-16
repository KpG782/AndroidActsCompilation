package com.example.electivefinals;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class MachineProblem3 extends AppCompatActivity {

    Spinner employeeIdSpinner, positionCodeSpinner, daysWorkedSpinner;
    RadioGroup civilStatusGroup;
    Button computeButton, clearButton;
    TextView employeeName;

    String[] employeeIDs = {"Employee", "E001", "E002", "E003", "E004", "E005"};
    String[] employeeNames = {"Employee", "Papsi", "Ken", "Timothy", "Lanz", "Mars"};
    double positionARate = 500, positionBRate = 400, positionCRate = 300;

    // Database helper instance
    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_problem3);

        // Initialize UI components
        employeeIdSpinner = findViewById(R.id.employeeIdSpinner);
        positionCodeSpinner = findViewById(R.id.positionCodeSpinner);
        daysWorkedSpinner = findViewById(R.id.daysWorkedSpinner);
        civilStatusGroup = findViewById(R.id.civilStatusGroup);
        computeButton = findViewById(R.id.computeButton);
        clearButton = findViewById(R.id.clearButton);
        employeeName = findViewById(R.id.employeeName);

        // Initialize the database helper
        myDatabaseHelper = new MyDatabaseHelper(this);

        // Set Employee ID Spinner Data
        ArrayAdapter<String> employeeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, employeeIDs);
        employeeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        employeeIdSpinner.setAdapter(employeeAdapter);

        // Set Position Code Spinner Data
        ArrayAdapter<CharSequence> positionAdapter = ArrayAdapter.createFromResource(this, R.array.position_codes, android.R.layout.simple_spinner_item);
        positionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        positionCodeSpinner.setAdapter(positionAdapter);

        // Set Days Worked Spinner Data
        ArrayAdapter<CharSequence> daysAdapter = ArrayAdapter.createFromResource(this, R.array.days_worked, android.R.layout.simple_spinner_item);
        daysAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daysWorkedSpinner.setAdapter(daysAdapter);

        // Set the Employee Name based on Employee ID selection
        employeeIdSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                employeeName.setText(employeeNames[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                employeeName.setText("");
            }
        });

        // Compute Button
        computeButton.setOnClickListener(v -> computeAndSavePayroll());

        // Clear Button
        clearButton.setOnClickListener(v -> clearFields());
    }

    private void computeAndSavePayroll() {
        if (employeeIdSpinner.getSelectedItemPosition() == 0 ||
                positionCodeSpinner.getSelectedItemPosition() == 0 ||
                daysWorkedSpinner.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "Please make sure all fields are selected", Toast.LENGTH_SHORT).show();
            return;
        }

        String selectedEmployeeId = employeeIdSpinner.getSelectedItem().toString();
        String selectedEmployeeName = employeeNames[employeeIdSpinner.getSelectedItemPosition()];
        String positionCode = positionCodeSpinner.getSelectedItem().toString();
        int selectedCivilStatusId = civilStatusGroup.getCheckedRadioButtonId();

        if (selectedCivilStatusId == -1) {
            Toast.makeText(this, "Please select your civil status", Toast.LENGTH_SHORT).show();
            return;
        }

        int daysWorked = Integer.parseInt(daysWorkedSpinner.getSelectedItem().toString());
        double dailyRate = getRateForPosition(positionCode);
        double basicPay = daysWorked * dailyRate;
        double sssContribution = basicPay * 0.045;
        double withholdingTax = basicPay * 0.10;
        double netPay = basicPay - (sssContribution + withholdingTax);
        String civilStatus = getCivilStatus(selectedCivilStatusId);

        // Save payroll data to the database
        myDatabaseHelper.addPayroll(selectedEmployeeName, positionCode, civilStatus, daysWorked, basicPay, sssContribution, withholdingTax, netPay);

        Toast.makeText(this, "Payroll computed and saved to database", Toast.LENGTH_SHORT).show();

        // Start SummaryActivity to show the results
        Intent intent = new Intent(MachineProblem3.this, SummaryActivity1.class);
        intent.putExtra("employeeId", selectedEmployeeId);
        intent.putExtra("employeeName", selectedEmployeeName);
        intent.putExtra("positionCode", positionCode);
        intent.putExtra("civilStatus", civilStatus);
        intent.putExtra("daysWorked", daysWorked);
        intent.putExtra("basicPay", basicPay);
        intent.putExtra("sssContribution", sssContribution);
        intent.putExtra("withholdingTax", withholdingTax);
        intent.putExtra("netPay", netPay);
        startActivity(intent);
    }

    private double getRateForPosition(String positionCode) {
        switch (positionCode) {
            case "A": return positionARate;
            case "B": return positionBRate;
            case "C": return positionCRate;
            default: return 0;
        }
    }

    private String getCivilStatus(int civilStatusId) {
        if (civilStatusId == R.id.radioSingle) {
            return "Single";
        } else if (civilStatusId == R.id.radioMarried) {
            return "Married";
        } else if (civilStatusId == R.id.radioWidowed) {
            return "Widowed";
        }
        return "";
    }

    private void clearFields() {
        employeeIdSpinner.setSelection(0);
        positionCodeSpinner.setSelection(0);
        daysWorkedSpinner.setSelection(0);
        civilStatusGroup.clearCheck();
        employeeName.setText("");
    }
}
