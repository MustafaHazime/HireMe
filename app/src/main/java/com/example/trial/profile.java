package com.example.trial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class profile extends AppCompatActivity {

  TextView tv_fullname,tv_country,tv_phone,tv_email,tv_username;
  EditText et_fullname,et_country,et_phone,et_email,et_username;
  DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        TextView tv_fullname=(TextView) findViewById(R.id.tv_fullname);
        TextView tv_country=(TextView) findViewById(R.id.tv_country);
        TextView tv_phone=(TextView) findViewById(R.id.tv_phone);
        TextView tv_email=(TextView) findViewById(R.id.tv_email);
        TextView tv_username=(TextView) findViewById(R.id.tv_username);

//        EditText et_fullname  = (EditText) findViewById(R.id.et_fullname);
//        EditText et_country  = (EditText) findViewById(R.id.et_country);
//        EditText et_phone  = (EditText) findViewById(R.id.et_phone);
//        EditText et_email  = (EditText) findViewById(R.id.et_email);
//        EditText et_username  = (EditText) findViewById(R.id.et_username);



//        String fullname=et_fullname.getText().toString();
//        String country=et_country.getText().toString();
//        String phone=et_phone.getText().toString();
//        String email=et_email.getText().toString();
//        String username=et_username.getText().toString();
//
//        tv_fullname.setText(fullname+"");
//        tv_country.setText(country+"");
//        tv_phone.setText(phone+"");
//        tv_email.setText(email+"");
//        tv_username.setText(username+"");
        singleToneClass singleton = com.example.trial.singleToneClass.getInstance();
        tv_username.setText(singleton.getData());
        tv_username.setPaintFlags(View. INVISIBLE);
        databaseHelper = new DatabaseHelper(this);
        String checkingEmail= databaseHelper.checkEmail(singleton.getData());
        tv_email.setText(checkingEmail);
        tv_email.setPaintFlags(View. INVISIBLE);
        String checkingFullName= databaseHelper.checkFullName(singleton.getData());
        tv_fullname.setText(checkingFullName);
        tv_fullname.setPaintFlags(View. INVISIBLE);
        String checkingphone= databaseHelper.checkPhone(singleton.getData());
        tv_phone.setText(checkingphone);
        tv_phone.setPaintFlags(View. INVISIBLE);
        String checkingCountry= databaseHelper.checkCountry(singleton.getData());
        tv_country.setText(checkingCountry);
        tv_country.setPaintFlags(View. INVISIBLE);

        Button logoutbtn;
        logoutbtn=(Button) findViewById(R.id.btn_llogout);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Logout Successful",Toast.LENGTH_SHORT).show();
            }
        });
    }
}