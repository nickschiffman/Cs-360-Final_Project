package com.schifty.nick_schiffman_inventory;

import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;


public class DBGrid extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dbgrid);


        public void getMoviesByRating(String rating) {
            SQLiteDatabase db = getReadableDatabase();

            String sql = "select * from " + MovieTable.TABLE + " where rating = ?";
            Cursor cursor = db.rawQuery(sql, new String[] { rating });
            if (cursor.moveToFirst()) {
                do {
                    long id = cursor.getLong(0);
                    String title = cursor.getString(1);
                    String rated = cursor.getString(2);
                    float stars = cursor.getFloat(3);

                } while (cursor.moveToNext());
            }
            cursor.close();
        }

    }


    public void btnSettings(View v){
        setContentView(R.layout.activity_sms);

    }
}