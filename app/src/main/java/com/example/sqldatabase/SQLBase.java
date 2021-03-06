package com.example.sqldatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLBase extends SQLiteOpenHelper {
    public SQLBase(@androidx.annotation.Nullable Context context) {
        super(context, cars.db, null, 1);
    }

    @Override /*runs when db is created*/
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table car(id integer primary key autoincrement,"
                + "name text,"
                + "model text);" +
                "");

    }

    @Override/*runs when db content is changed*/
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void registerCar (String name, String model){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("model", model);
        db.insertOrThrow("car",null, values);

    }
    public Cursor getAllCars(){
        String [] columns = {"id", "name", "model"};
        SQLiteDatabase db = getReadableDatabase();
        return db.query("car", columns, null, null, null, null, null)
    }
    public void deleteAllCars(){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("car", null, null);

    }
}
