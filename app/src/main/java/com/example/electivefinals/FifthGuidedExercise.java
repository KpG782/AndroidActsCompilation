package com.example.electivefinals;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FifthGuidedExercise extends AppCompatActivity {

    RadioButton red, blue, yellow, green;
    RadioGroup rgColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fifth_guided_exercise);

        // Apply edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        red = findViewById(R.id.rbRed);
        blue = findViewById(R.id.rbBlue);
        yellow = findViewById(R.id.rbYellow);
        green = findViewById(R.id.rbGreen);

        rgColors = findViewById(R.id.rgColors);
        rgColors.setOnCheckedChangeListener((group, checkedId) -> {
            changeBackgroundColor(checkedId);
        });
    }

    public void showSelectedColor() {
        if (red.isChecked()) {
            Toast.makeText(getApplicationContext(), "Color: RED", Toast.LENGTH_SHORT).show();
        }
        if (blue.isChecked()) {
            Toast.makeText(getApplicationContext(), "Color: BLUE", Toast.LENGTH_SHORT).show();
        }
        if (yellow.isChecked()) {
            Toast.makeText(getApplicationContext(), "Color: YELLOW", Toast.LENGTH_SHORT).show();
        }
        if (green.isChecked()) {
            Toast.makeText(getApplicationContext(), "Color: GREEN", Toast.LENGTH_SHORT).show();
        }
    }

    public void changeBackgroundColor(int checkedId) {
        if (checkedId == R.id.rbRed) {
            getWindow().getDecorView().setBackgroundColor(Color.RED);
            Toast.makeText(this, "Color: RED", Toast.LENGTH_SHORT).show();
        } else if (checkedId == R.id.rbBlue) {
            getWindow().getDecorView().setBackgroundColor(Color.BLUE);
            Toast.makeText(this, "Color: BLUE", Toast.LENGTH_SHORT).show();
        } else if (checkedId == R.id.rbYellow) {
            getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
            Toast.makeText(this, "Color: YELLOW", Toast.LENGTH_SHORT).show();
        } else if (checkedId == R.id.rbGreen) {
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
            Toast.makeText(this, "Color: GREEN", Toast.LENGTH_SHORT).show();
        }
    }
}
