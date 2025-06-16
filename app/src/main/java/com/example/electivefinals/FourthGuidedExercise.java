package com.example.electivefinals;

import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FourthGuidedExercise extends AppCompatActivity {

    EditText username, password;
    TextView result;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourth_guided_exercise);

        // Apply insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.etUsernameGE4);
        password = findViewById(R.id.etPasswordGE4);
        result = findViewById(R.id.tvResultGE4);
        login = findViewById(R.id.btnLoginGE4);

        setupLoginButton();
    }

    private void setupLoginButton() {
        login.setOnClickListener(view -> {
            String enteredUsername = username.getText().toString();
            String enteredPassword = password.getText().toString();

            if ("papsi".equals(enteredUsername) && "android".equals(enteredPassword)) {
                result.setText("Welcome " + enteredUsername + "!");
                result.setTextColor(Color.GREEN);
            } else {
                result.setText("Username and Password do not exist!");
                result.setTextColor(Color.RED);
            }

            clearInputFields();
        });
    }

    private void clearInputFields() {
        result.setVisibility(View.VISIBLE);
        username.setText("");
        password.setText("");
        username.requestFocus();
    }
}
