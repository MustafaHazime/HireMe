package com.example.trial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

public ArrayList<String> getEmployees(String occupation, int budget,int years){

    ArrayList<String> tempArrayList = new ArrayList<String>();
    SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
    String query =   "SELECT name,phone from Employee WHERE occupation= \"" + occupation + "\""
                   + " AND budget BETWEEN \"" + (int)Math.floor(budget-(budget*0.2)) +"\" AND \"" + (int)Math.ceil(budget+(budget*0.2)) +"\""
                   + " AND years BETWEEN \""  + (int)Math.floor(years-(years*0.2)) + "\" AND \"" + (int)Math.ceil(years+(years*0.2)) + "\"";
    Log.d("DEBUGGGG",query);
    Cursor cursor = sqLiteDatabase.rawQuery(query,null);
    if (cursor.getCount() > 0) {
        if (cursor != null)
            cursor.moveToFirst();
        while (cursor.moveToNext()) {
            String temp = new String();
            temp += cursor.getString(0);
            temp+="\n";
            temp+= cursor.getString(1);
            tempArrayList.add(temp);
        }
    }
    return tempArrayList;
}

public String checkEmail(String username){
    SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
    Cursor cursor = sqLiteDatabase.rawQuery("SELECT email FROM user WHERE username=?", new String[]{username});
    if (cursor.getCount() > 0) {
        if (cursor != null)
            cursor.moveToFirst();
        return cursor.getString(0);
    } else {
        return "";
    }
}

    public String checkCountry(String username){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT country FROM user WHERE username=?", new String[]{username});
        if (cursor.getCount() > 0) {
            if (cursor != null)
                cursor.moveToFirst();
            return cursor.getString(0);
        } else {
            return "";
        }
    }

    public String checkPhone(String username){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT phone FROM user WHERE username=?", new String[]{username});
        if (cursor.getCount() > 0) {
            if (cursor != null)
                cursor.moveToFirst();
            return cursor.getString(0);
        } else {
            return "";
        }
    }

    public String checkFullName(String username){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT fullname FROM user WHERE username=?", new String[]{username});
        if (cursor.getCount() > 0) {
            if (cursor != null)
                cursor.moveToFirst();
            return cursor.getString(0);
        } else {
            return "";
        }
    }
        }