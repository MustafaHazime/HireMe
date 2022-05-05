package com.example.trial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "loginDB.db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,1);
    }

@Override
public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, fullname TEXT, country TEXT, phone TEXT, email TEXT)");
        }

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

       db.execSQL("DROP TABLE IF EXISTS user");
        }

public boolean Insert(String username, String password,String fullname, String country, String phone, String email){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("fullname", fullname);
        contentValues.put("country", country);
        contentValues.put("phone", phone);
        contentValues.put("email", email);

        long result = sqLiteDatabase.insert("user", null, contentValues);
        if(result == -1){
        return false;
        }else{
        return true;
        }
        }

public Boolean CheckUsername(String username){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE username=?", new String[]{username});
        if(cursor.getCount() > 0){
        return false;
        }else{
        return true;
        }
        }

public Boolean CheckLogin(String username, String password) {
    SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
    Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE username=? AND password=?", new String[]{username, password});
    if (cursor.getCount() > 0) {
        return true;
    } else {
        return false;
    }
}



        }