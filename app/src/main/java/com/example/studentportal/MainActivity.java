package com.example.studentportal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Portal> portals;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        portals = new ArrayList<>();
        gridLayout = findViewById(R.id.gridLayoutPortals);

        FloatingActionButton addButton = findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, AddPortalActivity.class), 1);
            }
        });
    }

    public void addPortal(Portal portal) {
        Button newButton = new Button(this);
        newButton.setText(portal.title);
        gridLayout.addView(newButton);

        newButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PortalActivity.class);
                //intent.putExtra("URL", portal.url);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String url = data.getStringExtra("url");
                String title = data.getStringExtra("title");

                Portal newPortal = new Portal(url, title);
                addPortal(newPortal);
            }
        }
    }
}
