package com.example.a2_muhammadsaadshafqat_191179;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.fragment.app.Fragment;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Fragment context) {
        super(context.getContext(), "studentRecords.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table studentInfo(std_id TEXT primary key, std_name TEXT, std_city TEXT,std_age TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists studentInfo");


    }
    public Boolean insertStudentData(String id,String name, String city, String age)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("std_id", id);
        contentValues.put("std_name", name);
        contentValues.put("std_city", city);
        contentValues.put("std_age", age);
        long result=DB.insert("studentInfo", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Cursor getStudentData()
    {
        String query="SELECT* FROM studentInfo";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=null;
        if(db!=null){
            cursor=db.rawQuery(query,null);
        }
        return cursor;

    }
}
