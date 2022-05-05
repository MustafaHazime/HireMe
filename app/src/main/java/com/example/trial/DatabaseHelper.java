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




        }