package com.example.electivefinals;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EightGuidedExercise extends AppCompatActivity {

    Spinner names;
    TextView result;
    ArrayAdapter<String> adapter;
    String[] listOfNames = {"Name Here", "Papsi", "Pol", "Che", "Tin",
            "Renz", "Lou", "Chan", "Ven", "Jher"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_guided);

        // Initialize UI components
        names = findViewById(R.id.spnrNamesGE8);
        result = findViewById(R.id.tvResultGE8);

        // Set up adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listOfNames);
        names.setAdapter(adapter);

        // Show selected name
        showSelectedName();
    }

    public void showSelectedName() {
        names.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (position > 0) {
                    result.setText("Name: " + listOfNames[position]);
                    Toast.makeText(getApplicationContext(),
                            "Name: " + listOfNames[position], Toast.LENGTH_SHORT).show();
                } else {
                    result.setText("Name: ");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // No action needed for this case
            }
        });
    }
}
