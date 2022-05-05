package com.example.trial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class HomePage extends AppCompatActivity  {

    ImageButton settingsbtn;
    EditText budget;
    Button searchbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Spinner spinner = (Spinner) findViewById(R.id.jobs_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Jobs_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        budget=(EditText) findViewById(R.id.budget);
        searchbtn=(Button) findViewById(R.id.searchbtn);
        settingsbtn= (ImageButton) findViewById(R.id.settings);
        settingsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), profile.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Profile Page",Toast.LENGTH_SHORT).show();

            }
        });

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(budget.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please select a budget",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"redirecting..",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), redirectory.class);
                    startActivity(intent);
                }
            }
        });
    }


}