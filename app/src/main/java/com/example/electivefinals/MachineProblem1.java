package com.example.electivefinals;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MachineProblem1 extends AppCompatActivity {

    private EditText etFirstNumber, etSecondNumber;
    private TextView tvResult;
    private Button btnAdd, btnDiff, btnProd, btnQuo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_machine_problem1);

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSecondNumber = findViewById(R.id.etSecondNumber);
        tvResult = findViewById(R.id.tvResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnDiff = findViewById(R.id.btnDiff);
        btnProd = findViewById(R.id.btnProd);
        btnQuo = findViewById(R.id.btnQuo);

        // Set button listeners
        btnAdd.setOnClickListener(v -> calculate('+'));
        btnDiff.setOnClickListener(v -> calculate('-'));
        btnProd.setOnClickListener(v -> calculate('*'));
        btnQuo.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operator) {
        String firstNumStr = etFirstNumber.getText().toString();
        String secondNumStr = etSecondNumber.getText().toString();

        // Check if inputs are valid
        if (firstNumStr.isEmpty() || secondNumStr.isEmpty()) {
            tvResult.setText("Enter both numbers");
            tvResult.setTextColor(Color.RED);
            return;
        }

        int firstNum = Integer.parseInt(firstNumStr);
        int secondNum = Integer.parseInt(secondNumStr);
        int result = 0;

        // Perform calculation
        switch (operator) {
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '/':
                if (secondNum != 0) {
                    result = firstNum / secondNum;
                } else {
                    tvResult.setText("Cannot divide by zero");
                    tvResult.setTextColor(Color.BLUE);
                    return;
                }
                break;
        }

        // Display result
        tvResult.setText(String.valueOf(result));
        tvResult.setTextColor(result % 2 == 0 ? Color.BLUE : Color.RED);
    }
}
