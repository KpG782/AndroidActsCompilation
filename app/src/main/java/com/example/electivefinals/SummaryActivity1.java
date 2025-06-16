package com.example.electivefinals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity1 extends AppCompatActivity {

    // UI components
    TextView employeeIdTextView, employeeNameTextView, positionCodeTextView, civilStatusTextView,
            daysWorkedTextView, basicPayTextView, sssContributionTextView, withholdingTaxTextView, netPayTextView;
    Button backButton; // Add the Back button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summar1);

        // Initialize UI components
        employeeIdTextView = findViewById(R.id.employeeIdTextView);
        employeeNameTextView = findViewById(R.id.employeeNameTextView);
        positionCodeTextView = findViewById(R.id.positionCodeTextView);
        civilStatusTextView = findViewById(R.id.civilStatusTextView);
        daysWorkedTextView = findViewById(R.id.daysWorkedTextView);
        basicPayTextView = findViewById(R.id.basicPayTextView);
        sssContributionTextView = findViewById(R.id.sssContributionTextView);
        withholdingTaxTextView = findViewById(R.id.withholdingTaxTextView);
        netPayTextView = findViewById(R.id.netPayTextView);

        // Initialize Back button
        backButton = findViewById(R.id.backButton);

        // Set up the Back button functionality
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity and return to the previous one
                finish();
            }
        });

        // Retrieve data from the Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String employeeId = extras.getString("employeeId", "N/A");
            String employeeName = extras.getString("employeeName", "N/A");
            String positionCode = extras.getString("positionCode", "N/A");
            String civilStatus = extras.getString("civilStatus", "N/A");
            int daysWorked = extras.getInt("daysWorked", 0);
            double basicPay = extras.getDouble("basicPay", 0.0);
            double sssContribution = extras.getDouble("sssContribution", 0.0);
            double withholdingTax = extras.getDouble("withholdingTax", 0.0);
            double netPay = extras.getDouble("netPay", 0.0);

            // Display the data in TextViews
            employeeIdTextView.setText(employeeId);
            employeeNameTextView.setText(employeeName);
            positionCodeTextView.setText(positionCode);
            civilStatusTextView.setText(civilStatus);
            daysWorkedTextView.setText(String.valueOf(daysWorked));
            basicPayTextView.setText(String.format("%.2f", basicPay));
            sssContributionTextView.setText(String.format("%.2f", sssContribution));
            withholdingTaxTextView.setText(String.format("%.2f", withholdingTax));
            netPayTextView.setText(String.format("%.2f", netPay));
        }
    }
}
