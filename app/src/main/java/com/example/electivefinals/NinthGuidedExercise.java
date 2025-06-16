package com.example.electivefinals;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NinthGuidedExercise extends AppCompatActivity {

    ListView nameListView;
    ArrayAdapter<String> adapter;
    String[] listOfNames = {"Papsi", "Majoy", "Pol", "Che", "Tin", "Lou", "Renz", "Pet", "Roven", "Chan", "Jher"};
    double[] listOfSemGrades = {1.00, 1.50, 2.00, 1.25, 3.00, 5.00, 1.75, 2.25, 3.00, 1.00, 2.25};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninth_guided_exercise);

        // Initialize UI components
        nameListView = findViewById(R.id.lvNameGE9);

        // Set up the adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listOfNames);
        nameListView.setAdapter(adapter);

        // Show semester grades on item click
        showSemGrade();
    }

    public void showSemGrade() {
        nameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Name: " + listOfNames[position] + "\nSem Grade: " + listOfSemGrades[position],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
