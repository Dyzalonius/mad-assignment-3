package com.example.studentportal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class AddPortalActivity extends AppCompatActivity {

    private TextInputEditText url, title;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);

        url = findViewById(R.id.textInputEditTextUrl);
        title = findViewById(R.id.textInputEditTextTitle);
        button = findViewById(R.id.buttonAddPortal);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("url", url.getText().toString());
                returnIntent.putExtra("title", title.getText().toString());

                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}
