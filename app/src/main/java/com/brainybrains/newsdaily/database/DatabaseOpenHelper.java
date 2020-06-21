package com.brainybrains.newsdaily.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "Data.db";
    public static int VERSION = 1;
    public static String TABLE_NAME = "Data";
    public static String COL_ID = "Id";
    public static String COL_TITLE = "Title";
    public static String COL_AUTHOR = "Author";
    public static String COL_DES = "Description";

    private  SQLiteDatabase database;

    public static  String create_table = "create table "+TABLE_NAME+
            " (Id integer primary key, Title text, Author text, Description text)";
    public DatabaseOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    public void openDatabase(){
        database = getWritableDatabase();
    }

    public void closeDatabase(){
        database.close();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Cursor getData(){
        openDatabase();
        String data = "Select * From "+TABLE_NAME;
        Cursor cursor = database.rawQuery(data,null);

        return cursor;

    }
    public void deleteData(int id){
        getWritableDatabase().delete(TABLE_NAME,"Id=?",new String[]{String.valueOf(id)});
    }

    public long addPlace(String title, String author,String description ){

        openDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_TITLE,title);
        values.put(COL_AUTHOR,author);
        values.put(COL_DES,description);
        long id = database.insert(TABLE_NAME,null,values);
        closeDatabase();
        return id;
    }
}
