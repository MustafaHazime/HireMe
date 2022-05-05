package com.example.trial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity  {

    ImageButton settingsbtn;
    EditText budget,yearsOfExp;
    Button searchbtn;
    Spinner spinner;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        databaseHelper = new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        spinner = (Spinner) findViewById(R.id.jobs_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Jobs_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        budget=(EditText) findViewById(R.id.budget);
        searchbtn=(Button) findViewById(R.id.searchbtn);
        yearsOfExp=(EditText) findViewById(R.id.yearsOfExp);
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


                if(budget.getText().toString().isEmpty() && yearsOfExp.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Required fields are missing",Toast.LENGTH_SHORT).show();
                }
               else if(budget.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please select a budget",Toast.LENGTH_SHORT).show();
               }else if(yearsOfExp.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please choose number of years",Toast.LENGTH_SHORT).show();
                }
                else {


                    ArrayList<String> emp = databaseHelper.getEmployees(spinner.getSelectedItem().toString(),Integer.parseInt(budget.getText().toString()),Integer.parseInt(yearsOfExp.getText().toString()));

                    for(String a : emp){



                    }
                    Toast.makeText(getApplicationContext(),"redirecting..",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), redirectory.class);
                    intent.putExtra("values", emp);
                    startActivity(intent);

                }
            }
        });
    }


}