package com.schifty.nick_schiffman_inventory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

// DB constructer this is what talks to the SQL Helper

public class DbConstructor extends SQLiteOpenHelper {

    // Var Def
    public static final String INVENTORY = "INVENTORY";
    public static final String INVENTORY_TABLE = INVENTORY + "_TABLE";
    public static final String ITEM = "ITEM";
    public static final String DISCRIPTION = "DISCRIPTION";

    public DbConstructor(@Nullable Context context) {
        super(context, "Inventory", null, 1);
    }

    @Override // Needed for creating SQL open helper Db also inits the SQL DB
    public void onCreate(SQLiteDatabase db) {
        String createDb = "CREATE TABLE " + INVENTORY_TABLE + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + ITEM + " TEXT, " + DISCRIPTION + " TEXT, " + INVENTORY + " INT)";
        db.execSQL(createDb);
    }




    @Override  // Needed for SQL Helper to satisfy over SQL versions
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // Creates new entry into the SQL DB
    public boolean addEntry(InventoryModel inventoryModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(ITEM, inventoryModel.getItem());
        cv.put(DISCRIPTION, inventoryModel.getDiscription());
        cv.put(INVENTORY, inventoryModel.getInventory());

        long insert = db.insert(INVENTORY_TABLE, null, cv);

        return insert != -1;


    }


    // Updates the SQL DB based of unique ID
    public boolean updateEntry(InventoryModel inventoryModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(ITEM, inventoryModel.getItem());
        cv.put(DISCRIPTION, inventoryModel.getDiscription());
        cv.put(INVENTORY, inventoryModel.getInventory());

        long insert = db.update(INVENTORY_TABLE, cv, "WHERE ID = ?", new String[]{ Integer.toString(inventoryModel.getId())});

        return insert != -1;


    }

    // Deletes entry based off ID
    public boolean delete(InventoryModel inventoryModel){

        SQLiteDatabase db = this.getWritableDatabase();
        String search = "DELETE FROM " + INVENTORY_TABLE + " WHERE ID" + " = " + inventoryModel.getId();

        Cursor cursor = db.rawQuery(search, null);

        if(cursor.moveToFirst()){
            return true;

        }else{
            return false;
        }

    }


    // Returns all entries within SQL DB This will SB a list of Inventory models
    public List<InventoryModel> getEntries(){
        List<InventoryModel> allEntries = new ArrayList<>();

        String search = "SELECT * FROM " + INVENTORY_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(search, null);

        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String item = cursor.getString(1);
                String discription = cursor.getString(2);
                int incentory = cursor.getInt(3);

                InventoryModel inventoryModel = new InventoryModel(id, item, incentory, discription);
                allEntries.add(inventoryModel);

            }while (cursor.moveToNext());
        }else {

        }

        cursor.close();
        db.close();
        return allEntries;
    }





}
