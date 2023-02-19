package com.schifty.nick_schiffman_inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.DngCreator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Var Def
    EditText item;
    EditText inventory;
    EditText inventory1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Button used to sign in
    public void btnSignIn(View v){
        setContentView(R.layout.activity_dbgrid);
        List<InventoryModel> entries = getInventoryModels();
        Toast.makeText(MainActivity.this, entries.toString(), Toast.LENGTH_LONG).show();

    }


    // Displays and updates the display for SQL DB
    public List<InventoryModel> getInventoryModels() {
        ListView list = findViewById(R.id.listView);
        DbConstructor dbConstructor = new DbConstructor(MainActivity.this);
        List<InventoryModel> entries = dbConstructor.getEntries();
        ArrayAdapter<InventoryModel> inventory = new ArrayAdapter<InventoryModel>(MainActivity.this, android.R.layout.simple_list_item_1, entries);
        list.setAdapter(inventory);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override // Creates OnClick listeners for each item in the list and also updates Update and delete
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                InventoryModel selected = (InventoryModel) adapterView.getItemAtPosition(i);
                item = findViewById(R.id.txtItem);
                inventory1 = findViewById(R.id.txtInventory);
                item.setText(selected.getItem());
                inventory1.setText(selected.getInventoryStr());
                Button btn = findViewById(R.id.btn_up);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override // Connects update button to currently selected entry
                    public void onClick(View view) {
                        dbConstructor.updateEntry(selected);
                        List<InventoryModel> entries = getInventoryModels();
                    }
                });
                Button btnDel = findViewById(R.id.btn_del);
                btnDel.setOnClickListener(new View.OnClickListener() {
                    @Override // Connects delete to current entry
                    public void onClick(View view) {
                        dbConstructor.delete(selected);
                        List<InventoryModel> entries = getInventoryModels();
                    }
                });



            }
        });

        // Return DB entries
        return entries;
    }

    // Open Settings
    public void btn_sett(View v){
        setContentView(R.layout.activity_sms);

    }

    // Create new account
    public void btnCreateAccount(View v){
        setContentView(R.layout.activity_dbgrid);
        List<InventoryModel> entries = getInventoryModels();

    }

    // Add new entry into the DB and update the GUI
    public void btn_Add(View v) {

        item = findViewById(R.id.txtItem);
        inventory = findViewById(R.id.txtInventory);

        // Create new model and sync with the SQL data base
        InventoryModel inventoryModel;
        Log.d(item.getText().toString(), inventory.getText().toString());
        try {

            inventoryModel = new InventoryModel(1, item.getText().toString(), Integer.parseInt(inventory.getText().toString()), "testD");
            Toast.makeText(MainActivity.this, item.getText().toString() + " Added to DataBase", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Entry Not Created", Toast.LENGTH_SHORT).show();
            inventoryModel = new InventoryModel(-1, "Fail", 2, "Fail");
        }

        DbConstructor DbConstruct = new DbConstructor(MainActivity.this);

        Boolean test = DbConstruct.addEntry(inventoryModel);
        Log.d(item.getText().toString(), test.toString());



        List<InventoryModel> entries = getInventoryModels();
    }



}