package com.example.electivefinals;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class TenthGuidedExercise extends AppCompatActivity {

    WebView browser;
    AutoCompleteTextView suggestedURL;
    ArrayAdapter<String> adapter;
    Button submit;
    String[] urls = {"google.com", "yahoo.com", "facebook.com", "youtube.com"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth_guided_exercise);

        // Initialize UI components
        browser = findViewById(R.id.webView);
        suggestedURL = findViewById(R.id.actvURLGE10);
        submit = findViewById(R.id.btnOpenURLGE10);

        // Set up the adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, urls);
        suggestedURL.setThreshold(2);
        suggestedURL.setAdapter(adapter);

        initializeWebView();
        loadWebURL();
    }

    public void initializeWebView() {
        browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());
        browser.setScrollBarStyle(WebView.SCROLLBARS_INSIDE_OVERLAY);
    }

    public void loadWebURL() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = suggestedURL.getText().toString();

                // Ensure the URL is properly formatted
                if (!url.startsWith("www.") && !url.startsWith("http://")) {
                    url = "www." + url;
                }
                if (!url.startsWith("http://")) {
                    url = "http://" + url;
                }

                // Load the URL in the WebView
                browser.loadUrl(url);
            }
        });
    }
}
