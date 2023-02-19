package com.schifty.nick_schiffman_inventory;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbConstructor extends SQLiteOpenHelper {
    public static final String INVENTORY = "INVENTORY";
    public static final String INVENTORY_TABLE = INVENTORY + "_TABLE";
    public static final String ITEM = "ITEM";
    public static final String DISCRIPTION = "DISCRIPTION";

    public DbConstructor(@Nullable Context context) {
        super(context, "Inventory", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createDb = "CREATE TABLE " + INVENTORY_TABLE + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + ITEM + " TEXT, " + DISCRIPTION + " TEXT, " + INVENTORY + " INT)";
        db.execSQL(createDb);
    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addEntry(InventoryModel inventoryModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(ITEM, inventoryModel.getItem());
        cv.put(DISCRIPTION, inventoryModel.getDiscription());
        cv.put(INVENTORY, inventoryModel.getInventory());

        long insert = db.insert(INVENTORY_TABLE, null, cv);

        return insert != -1;


    }
}
