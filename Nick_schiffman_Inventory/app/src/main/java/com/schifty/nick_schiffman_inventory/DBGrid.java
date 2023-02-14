package com.schifty.nick_schiffman_inventory;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


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