package com.example.electivefinals;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SeventhGuidedExercise extends AppCompatActivity {

    RatingBar ratingBar;
    TextView rate;
    Button click, close;
    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seventh_guided_exercise);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI Components
        alertDialogBuilder = new AlertDialog.Builder(this);
        ratingBar = findViewById(R.id.ratingBar);
        rate = findViewById(R.id.tvResultGE7);
        click = findViewById(R.id.btnClickGE7);
        close = findViewById(R.id.btnCloseGE7);

        showRating();
        closeApplication();
    }

    public void showRating() {
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            if (rating >= 3) {
                rate.setTextColor(Color.GREEN);
            } else {
                rate.setTextColor(Color.RED);
            }
            rate.setText("Rate: " + rating);
        });

        click.setOnClickListener(view -> Toast.makeText(getApplicationContext(), "Rate: " + ratingBar.getRating(), Toast.LENGTH_SHORT).show());
    }

    public void closeApplication() {
        close.setOnClickListener(view -> alertDialogBuilder.setTitle("Warning Message!")
                .setMessage("Do you want to close the Application?")
                .setPositiveButton("Yes", (dialogInterface, i) -> finish())
                .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel())
                .setCancelable(false)
                .show());
    }

    @Override
    public void onBackPressed() {
        alertDialogBuilder.setTitle("Warning Message!")
                .setMessage("Do you want to close the Application?")
                .setPositiveButton("Yes", (dialogInterface, i) -> finish())
                .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel())
                .setCancelable(false)
                .show();
    }
}
