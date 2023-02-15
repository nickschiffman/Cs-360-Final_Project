package com.schifty.nick_schiffman_inventory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InventoryDb extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "movies.db";
    private static final int VERSION = 1;

    public InventoryDb(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    private static final class InventoryTable {
        private static final String TABLE = "TABLE";
        private static final String item = "item";
        private static final String description = "description";
        private static final String inventory = "inventory";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + InventoryTable.TABLE + " (" +
                InventoryTable.item + " integer primary key autoincrement, " +
                InventoryTable.description + " text, " +
                InventoryTable.inventory + " text, )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("drop table if exists " + InventoryTable.TABLE);
        onCreate(db);
    }
}