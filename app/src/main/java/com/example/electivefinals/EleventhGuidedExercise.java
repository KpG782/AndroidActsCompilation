package com.example.electivefinals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class EleventhGuidedExercise extends AppCompatActivity {

    EditText name, age;
    RadioButton male, female;
    CheckBox appdet, intcomp, comprog1, comprog2;
    Spinner job;
    ListView thesis;
    Button submit;
    ArrayAdapter<String> adapter;
    String[] jobList = {"Software Developer", "Software QA", "System Analyst", "Data Scientist"};
    String[] thesisTopics = {"Web Based/On-Line Application", "Network-Based Application", "System/Software Development", "Computer Aided Instruction"};
    String gender, subjects, topic = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleventh_guided_exercise);

        // Initialize views
        init();

        // Set up the event handler
        setupSubmitButton();
    }

    public void init() {
        name = findViewById(R.id.etNameGE11);
        age = findViewById(R.id.etAgeGE11);
        male = findViewById(R.id.rbtnMaleGE11);
        female = findViewById(R.id.rbtnFemaleGE11);
        appdet = findViewById(R.id.chkAppdetGE11);
        intcomp = findViewById(R.id.chkIntcompGE11);
        comprog1 = findViewById(R.id.chkComprog1GE11);
        comprog2 = findViewById(R.id.chkComprog2GE11);
        submit = findViewById(R.id.btnSubmitGE11);

        job = findViewById(R.id.spnrJobGE11);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, jobList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        job.setAdapter(adapter);

        thesis = findViewById(R.id.lvThesisGE11);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thesisTopics);
        thesis.setAdapter(adapter);

        // Listener to capture the selected thesis topic
        thesis.setOnItemClickListener((parent, view, position, id) -> topic = thesisTopics[position]);
    }

    public void setupSubmitButton() {
        submit.setOnClickListener(v -> {
            if (!validateInputs()) return;

            Intent intent = new Intent(this, EleventhGuidedExerciseGetIntent.class);
            intent.putExtra("id_name", name.getText().toString());
            intent.putExtra("id_age", age.getText().toString());
            intent.putExtra("id_gender", getGender());
            intent.putExtra("id_subjects", getSubjects());
            intent.putExtra("id_job", job.getSelectedItem().toString());
            intent.putExtra("id_thesis", topic);
            startActivity(intent);
        });
    }

    public boolean validateInputs() {
        if (name.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (age.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter your age", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (getSubjects().isEmpty()) {
            Toast.makeText(this, "Please select at least one favorite subject", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (topic.isEmpty()) {
            Toast.makeText(this, "Please select your Thesis Topic", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public String getSubjects() {
        subjects = "";
        if (appdet.isChecked()) subjects += appdet.getText().toString() + "\n";
        if (intcomp.isChecked()) subjects += intcomp.getText().toString() + "\n";
        if (comprog1.isChecked()) subjects += comprog1.getText().toString() + "\n";
        if (comprog2.isChecked()) subjects += comprog2.getText().toString() + "\n";
        return subjects.trim();
    }

    public String getGender() {
        return male.isChecked() ? male.getText().toString() : female.isChecked() ? female.getText().toString() : "Not specified";
    }
}
