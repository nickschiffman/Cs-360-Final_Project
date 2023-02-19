package com.schifty.nick_schiffman_inventory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class login extends SQLiteOpenHelper {

    // Var Def
    public static final String USER_TABLE =  "USER_TABLE";
    public static final String USER_NAME = "USER_NAME";
    public static final String PASS = "PASS";

    public login(@Nullable Context context) {

        super(context, "Login", null, 1);
    }

    @Override // Needed for creating SQL open helper Db also inits the SQL DB
    public void onCreate(SQLiteDatabase db) {
        String createDb = "CREATE TABLE " + USER_TABLE  + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_NAME + " TEXT, " + PASS + " TEXT)";
        db.execSQL(createDb);
    }




    @Override  // Needed for SQL Helper to satisfy over SQL versions
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // Creates new entry into the SQL DB
    public boolean addUser(String user, String pass){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USER_NAME, user);
        cv.put(PASS, pass);

        long insert = db.insert(USER_TABLE, null, cv);

        return insert != -1;


    }

    // Returns all entries within SQL DB This will SB a list of Inventory models
    public List<String[]> getEntries(){
        List<String[]> allEntries = new ArrayList<>();

        String search = "SELECT * FROM " + USER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(search, null);

        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String UserName = cursor.getString(1);
                String Password = cursor.getString(2);

                String[] user = {UserName, Password};

                allEntries.add(user);

            }while (cursor.moveToNext());
        }else {

        }

        cursor.close();
        db.close();
        return allEntries;
    }


}
