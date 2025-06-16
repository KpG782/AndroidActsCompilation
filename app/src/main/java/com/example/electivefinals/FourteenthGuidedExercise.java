package com.example.electivefinals;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FourteenthGuidedExercise extends AppCompatActivity {

    Button sendSMS, sendBSMS, call;
    EditText phoneNo, message;
    ProgressDialog progressDialog;
    Intent smsIntent, callIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourteenth_guided_exercise);

        // Handle system insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
        sendMessage();
        sendMessageBuiltIn();
        phoneCall();
    }

    public void init() {
        progressDialog = new ProgressDialog(this);
        sendSMS = findViewById(R.id.btnSMS);
        sendBSMS = findViewById(R.id.btnBSMS);
        call = findViewById(R.id.btnPhoneCall);
        phoneNo = findViewById(R.id.etPhoneNo);
        message = findViewById(R.id.etSMS);
    }

    public void sendMessage() {
        sendSMS.setOnClickListener(view -> {
            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(
                        phoneNo.getText().toString(),
                        null,
                        message.getText().toString(),
                        null,
                        null
                );

                progressDialog.setTitle("Sending...");
                progressDialog.setMessage("Message Sent!");
                progressDialog.show();

                new android.os.Handler().postDelayed(progressDialog::cancel, 3000);

            } catch (Exception e) {
                progressDialog.setTitle("Sending...");
                progressDialog.setMessage("Message was not delivered!");
                progressDialog.show();

                new android.os.Handler().postDelayed(progressDialog::cancel, 3000);
            }
        });
    }

    public void sendMessageBuiltIn() {
        sendBSMS.setOnClickListener(view -> {
            smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNo.getText().toString()));
            smsIntent.putExtra("sms_body", message.getText().toString());
            startActivity(smsIntent);
        });
    }

    public void phoneCall() {
        call.setOnClickListener(view -> {
            callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNo.getText().toString()));
            if (ContextCompat.checkSelfPermission(FourteenthGuidedExercise.this, Manifest.permission.CALL_PHONE)
                    != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(FourteenthGuidedExercise.this,
                        new String[]{Manifest.permission.CALL_PHONE}, 1);
            } else {
                try {
                    startActivity(callIntent);
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
