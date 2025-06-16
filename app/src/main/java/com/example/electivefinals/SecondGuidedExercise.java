package com.example.electivefinals;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondGuidedExercise extends AppCompatActivity {

    EditText name;
    Button click;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_guided_exercise);

        // Adjust padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        name = findViewById(R.id.etNameGE2);
        click = findViewById(R.id.btnClickGE2);

        // Set up button click listener
        showResult();
    }

    public void showResult() {
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display a customized Toast message
                toast = Toast.makeText(getApplicationContext(),
                        "Hello " + name.getText().toString() + "! \nWelcome to Android Development!", Toast.LENGTH_SHORT);

                // Customize Toast appearance
                View toastView = toast.getView();
                if (toastView != null) {
                    toastView.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
                }

                // Center the Toast on the screen
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
    }
}
