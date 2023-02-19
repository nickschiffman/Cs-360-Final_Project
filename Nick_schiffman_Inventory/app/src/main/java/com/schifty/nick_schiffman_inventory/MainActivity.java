package com.schifty.nick_schiffman_inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    public void btn_Add(View v) {
        Log.d("Test", "Test");

        InventoryModel inventoryModel;

        try {
            inventoryModel = new InventoryModel(1, "test", 2, "testD");
            Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Entry Not Created", Toast.LENGTH_SHORT).show();
            inventoryModel = new InventoryModel(-1, "Fail", 2, "Fail");
        }

        DbConstructor DbConstruct = new DbConstructor(MainActivity.this);

        DbConstruct.addEntry(inventoryModel);
    }

}