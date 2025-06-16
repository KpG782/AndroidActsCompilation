package com.example.electivefinals;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EleventhGuidedExerciseGetIntent extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleventh_guided_exercise_get_intent);

        result = findViewById(R.id.textViewResult);

        String name = getIntent().getStringExtra("id_name");
        String age = getIntent().getStringExtra("id_age");
        String gender = getIntent().getStringExtra("id_gender");
        String subjects = getIntent().getStringExtra("id_subjects");
        String job = getIntent().getStringExtra("id_job");
        String thesis = getIntent().getStringExtra("id_thesis");

        String display = "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Gender: " + gender + "\n" +
                "Subjects:\n" + subjects + "\n" +
                "Job: " + job + "\n" +
                "Thesis: " + thesis;

        result.setText(display);
    }
}
