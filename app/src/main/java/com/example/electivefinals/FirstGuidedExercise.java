package com.example.electivefinals;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FirstGuidedExercise extends AppCompatActivity {

    // Define EditText, TextView, and Button variables
    EditText name, age;
    TextView result;
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge layout
        EdgeToEdge.enable(this);

        // Set the content view for the activity
        setContentView(R.layout.activity_first_guided_exercise);

        // Set up insets for system bars (for Edge-to-Edge layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize the UI elements (EditText, TextView, and Button)
        name = findViewById(R.id.etNameGE1);
        age = findViewById(R.id.etAgeGE1);
        result = findViewById(R.id.tvResultGE1);
        click = findViewById(R.id.btnClickGE1);

        // Set up the button click listener
        showResult();
    }

    public void showResult() {
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When the button is clicked, get the text from EditText and show it in the TextView
                result.setText("Name: " + name.getText().toString() +
                        "\nAge: " + age.getText().toString());

                // Clear the EditText fields and focus on the name field
                name.setText("");
                age.setText("");
                name.requestFocus();
            }
        });
    }
}
