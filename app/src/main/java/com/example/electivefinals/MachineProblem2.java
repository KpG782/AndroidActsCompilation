package com.example.electivefinals;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MachineProblem2 extends AppCompatActivity {

    // Declare UI elements
    CheckBox cbCaffeVanilla, cbGreenTea, cbSmores, cbMocha;
    RadioGroup rgDiscount;
    RadioButton rbFive, rbTen, rbFifth, rbNoDiscount;
    TextView tvSubtotal, tvDiscount, tvNetAmount;
    Button btnCompute, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_machine_problem2);

        // Enable Edge-to-Edge Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI elements
        cbCaffeVanilla = findViewById(R.id.cbCaffeVanilla);
        cbGreenTea = findViewById(R.id.cbGreenTea);
        cbSmores = findViewById(R.id.cbSmores);
        cbMocha = findViewById(R.id.cbMocha);

        rgDiscount = findViewById(R.id.rg_discount);
        rbFive = findViewById(R.id.rbFive);
        rbTen = findViewById(R.id.rbTen);
        rbFifth = findViewById(R.id.rbFifth);
        rbNoDiscount = findViewById(R.id.rbNoDiscount);

        tvSubtotal = findViewById(R.id.tvSubtotal);
        tvDiscount = findViewById(R.id.tvDiscount);
        tvNetAmount = findViewById(R.id.tvNetAmount);

        btnCompute = findViewById(R.id.btnCompute);
        btnClear = findViewById(R.id.btnClear);

        // Set Frappuccino checkboxes listeners with Toasts
        setCheckBoxListener(cbCaffeVanilla, "Caffe Vanilla Frappuccino", 150);
        setCheckBoxListener(cbGreenTea, "Green Tea Creme Frappuccino", 190);
        setCheckBoxListener(cbSmores, "Smores Frappuccino", 199);
        setCheckBoxListener(cbMocha, "Mocha Frappuccino", 130);

        // Set Discount radio buttons listeners with Toasts
        setRadioButtonListener(rbFive, "5%");
        setRadioButtonListener(rbTen, "10%");
        setRadioButtonListener(rbFifth, "15%");
        setRadioButtonListener(rbNoDiscount, "No Discount");

        // Compute button logic
        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double subtotal = 0;

                // Calculate subtotal based on selected Frappuccino
                if (cbCaffeVanilla.isChecked()) subtotal += 150;
                if (cbGreenTea.isChecked()) subtotal += 190;
                if (cbSmores.isChecked()) subtotal += 199;
                if (cbMocha.isChecked()) subtotal += 130;

                // Calculate discount
                double discountRate = 0;
                if (rbFive.isChecked()) discountRate = 0.05;
                else if (rbTen.isChecked()) discountRate = 0.10;
                else if (rbFifth.isChecked()) discountRate = 0.15;

                double discountAmount = subtotal * discountRate;
                double netAmount = subtotal - discountAmount;

                // Display calculated values
                tvSubtotal.setText(String.format("Subtotal: %.2f", subtotal));
                tvDiscount.setText(String.format("Discount: %.2f", discountAmount));
                tvNetAmount.setText(String.format("Net Amount: %.2f", netAmount));
            }
        });

        // Clear button logic
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbCaffeVanilla.setChecked(false);
                cbGreenTea.setChecked(false);
                cbSmores.setChecked(false);
                cbMocha.setChecked(false);

                rgDiscount.check(R.id.rbNoDiscount);

                tvSubtotal.setText("Subtotal: 0.00");
                tvDiscount.setText("Discount: 0.00");
                tvNetAmount.setText("Net Amount: 0.00");
            }
        });
    }

    // Method to show toast when a Frappuccino is selected
    private void setCheckBoxListener(CheckBox checkBox, String name, int price) {
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    Toast.makeText(MachineProblem2.this,
                            "You have selected: " + name + " - PHP " + price,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to show toast when a discount is selected
    private void setRadioButtonListener(RadioButton radioButton, String discount) {
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MachineProblem2.this,
                        "You selected " + discount + " discount",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
