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


    Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dbgrid);

        btn_add = findViewById(R.id.add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Toast.makeText(DBGrid.this, "Test", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(DBGrid.this, "Entry Not Created", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


    public void btnSettings(View v){
        setContentView(R.layout.activity_sms);

    }
}