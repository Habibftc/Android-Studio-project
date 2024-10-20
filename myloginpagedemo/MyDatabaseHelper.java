package com.myapp.myloginpagedemo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "userDetails.db";
    private static final String TABLE_NAME = "user_Details";
    private static final String ID = "Id";
    private static final String NAME = "Name";
    private static final String EMAIL = "Email";
    private static final String USER_NAME = "Username";
    private static final String PASSWORD = "Password";
    private static final int VERSION_NUMBER = 5;
    private Context context;

    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255) NOT NULL,"+EMAIL+" TEXT NOT NULL, "+USER_NAME+" TEXT NOT NULL, "+PASSWORD+" TEXT NOT NULL)";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       try {
           sqLiteDatabase.execSQL(CREATE_TABLE);
           Toast.makeText(context,"onCreate is called",Toast.LENGTH_SHORT).show();
       }catch (Exception e){
           Toast.makeText(context,"Exception : "+e,Toast.LENGTH_SHORT).show();
       }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            Toast.makeText(context,"onUpgrade is called",Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        }catch (Exception e){
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_SHORT).show();
        }

    }
    public long insertData(userDetails details){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,details.getName());
        contentValues.put(EMAIL,details.getEmail());
        contentValues.put(USER_NAME,details.getUsername());
        contentValues.put(PASSWORD,details.getPassword());
        long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowId;

    }
    public boolean Findpassword(String uName,String pass){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " +TABLE_NAME ,null);
        Boolean result = false;
        if (cursor.getCount()==0){
            Toast.makeText(context,"No data found",Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                String username = cursor.getString(3);
                String password = cursor.getString(4);

                if (username.equals(uName)&&password.equals(pass)){
                    result = true;
                    break;

                }
            }
        }
                return result;

    }
}
