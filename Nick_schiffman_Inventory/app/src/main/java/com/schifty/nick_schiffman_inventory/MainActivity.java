package com.schifty.nick_schiffman_inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void btnSignIn(View v){

        setContentView(R.layout.activity_dbgrid);

    }

    public void btnCreateAccount(View v){
        setContentView(R.layout.activity_dbgrid);

    }
}