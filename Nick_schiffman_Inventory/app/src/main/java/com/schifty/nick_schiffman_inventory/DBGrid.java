package com.schifty.nick_schiffman_inventory;

import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class DBGrid extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dbgrid);

    }


    public void btnSettings(View v){
        setContentView(R.layout.activity_sms);

    }




}