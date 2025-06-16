package com.example.electivefinals;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirteenthGuidedExercise extends AppCompatActivity {

    Button send, capturePic;
    EditText receiver, subject, message;
    ImageView pic;
    Intent intent, chooser;
    public static final int RequestPermissionCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirteenth_guided_exercise);

        init();
        enableRuntimePermission();
        setupSendEmail();
        setupCapturePic();

        // Handle system insets (if needed for layout adjustments)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void init() {
        receiver = findViewById(R.id.etReceiver);
        subject = findViewById(R.id.etSubject);
        message = findViewById(R.id.etMessage);
        pic = findViewById(R.id.ivPic);
        send = findViewById(R.id.btnSend);
        capturePic = findViewById(R.id.btnCapturePic);
    }

    public void enableRuntimePermission() {
        // Check and request runtime permission for camera access
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            Toast.makeText(getApplicationContext(), "Camera permission allows us to access the Camera app.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, RequestPermissionCode);
        }
    }

    public void setupSendEmail() {
        send.setOnClickListener(view -> {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {receiver.getText().toString()};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent, "Send Email");

            if (receiver.getText().toString().isEmpty()) {
                receiver.setError("Email required!");
            } else {
                startActivity(chooser);
            }
        });
    }

    public void setupCapturePic() {
        capturePic.setOnClickListener(view -> {
            intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 7);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 7 && resultCode == RESULT_OK && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            pic.setImageBitmap(bitmap);
        }
    }
}
