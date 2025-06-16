package com.example.electivefinals;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge layout
        EdgeToEdge.enable(this);

        // Set the content view to the activity's layout
        setContentView(R.layout.activity_main);

        // Set up insets for system bars (for Edge-to-Edge layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Button 1: Guided Exercise 1
        Button btnGuidedExercise1 = findViewById(R.id.btn_guided_1);
        btnGuidedExercise1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, FirstGuidedExercise.class);
            startActivity(intent);
        });

        // Button 2: Guided Exercise 2
        Button btnGuidedExercise2 = findViewById(R.id.btn_guided_2);
        btnGuidedExercise2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondGuidedExercise.class);
            startActivity(intent);
        });

        // Button 3: Guided Exercise 3
        Button btnGuidedExercise3 = findViewById(R.id.btn_guided_3);
        btnGuidedExercise3.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ThirdGuidedExercise.class);
            startActivity(intent);
        });

        // Button 4: Guided Exercise 4
        Button btnGuidedExercise4 = findViewById(R.id.btn_guided_4);
        btnGuidedExercise4.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, FourthGuidedExercise.class);
            startActivity(intent);
        });

        // Button 5: Guided Exercise 5
        Button btnGuidedExercise5 = findViewById(R.id.btn_guided_5);
        btnGuidedExercise5.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, FifthGuidedExercise.class);
            startActivity(intent);
        });

        // Button 6: Guided Exercise 6
        Button btnGuidedExercise6 = findViewById(R.id.btn_guided_6);
        btnGuidedExercise6.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SixthGuidedExercise.class);
            startActivity(intent);
        });

        // Button 7: Guided Exercise 7
        Button btnGuidedExercise7 = findViewById(R.id.btn_guided_7);
        btnGuidedExercise7.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SeventhGuidedExercise.class);
            startActivity(intent);
        });

        // Button 8: Guided Exercise 8
        Button btnGuidedExercise8 = findViewById(R.id.btn_guided_8);
        btnGuidedExercise8.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, EightGuidedExercise.class);
            startActivity(intent);
        });

        // Button 9: Guided Exercise 9
        Button btnGuidedExercise9 = findViewById(R.id.btn_guided_9);
        btnGuidedExercise9.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NinthGuidedExercise.class);
            startActivity(intent);
        });

        // Button 10: Guided Exercise 10
        Button btnGuidedExercise10 = findViewById(R.id.btn_guided_10);
        btnGuidedExercise10.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TenthGuidedExercise.class);
            startActivity(intent);
        });

        // Button 11: Guided Exercise 11
        Button btnGuidedExercise11 = findViewById(R.id.btn_guided_11);
        btnGuidedExercise11.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, EleventhGuidedExercise.class);
            startActivity(intent);
        });

        // Button 12: Guided Exercise 12
        Button btnGuidedExercise12 = findViewById(R.id.btn_guided_12);
        btnGuidedExercise12.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, EleventhGuidedExerciseDragAndDrop.class);
            startActivity(intent);
        });

        // Button 13: Guided Exercise 13
        Button btnGuidedExercise13 = findViewById(R.id.btn_guided_13);
        btnGuidedExercise13.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ThirteenthGuidedExercise.class);
            startActivity(intent);
        });

        // Button 14: Guided Exercise 14
        Button btnGuidedExercise14 = findViewById(R.id.btn_guided_14);
        btnGuidedExercise14.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, FourteenthGuidedExercise.class);
            startActivity(intent);
        });

        // Button 15: Guided Exercise 15
        Button btnGuidedExercise15 = findViewById(R.id.btn_guided_15);
        btnGuidedExercise15.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, FifteenthGuidedExercise.class);
            startActivity(intent);
        });

        // Button 1: Problem 1 (opens MachineProblem1)
        Button btnProblem1 = findViewById(R.id.btn_problem_1);
        btnProblem1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MachineProblem1.class);
            startActivity(intent);
        });

        // Button 2: Problem 2 (opens MachineProblem2)
        Button btnProblem2 = findViewById(R.id.btn_problem_2);
        btnProblem2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MachineProblem2.class);
            startActivity(intent);
        });

        // Button 3: Problem 3 (opens MachineProblem3)
        Button btnProblem3 = findViewById(R.id.btn_problem_3);
        btnProblem3.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MachineProblem3.class);
            startActivity(intent);
        });
    }
}
