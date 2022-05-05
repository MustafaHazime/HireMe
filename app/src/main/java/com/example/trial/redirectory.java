package com.example.trial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class redirectory extends AppCompatActivity {
    ImageButton settingsbtn;
    ArrayAdapter adapter;

    ArrayList<String> empDesc=new ArrayList<String>();

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirectory);
        settingsbtn= (ImageButton) findViewById(R.id.settings);
        listView=(ListView) findViewById(R.id.listview);
        ArrayList<String> empDesc = (ArrayList<String>) getIntent().getSerializableExtra("values");
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,empDesc);
        listView.setAdapter(adapter);
        settingsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), profile.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Profile Page",Toast.LENGTH_SHORT).show();

            }
        });
    }
}