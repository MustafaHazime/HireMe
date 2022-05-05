package com.example.trial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class redirectory extends AppCompatActivity {
    ImageButton settingsbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirectory);
        settingsbtn= (ImageButton) findViewById(R.id.settings);
        settingsbtn.setOnClickListener(new View.OnClickListener() {

        });
    }
}