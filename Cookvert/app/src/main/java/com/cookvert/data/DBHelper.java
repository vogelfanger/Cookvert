package com.cookvert.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by elmo on 13.8.2016.
 */
public class DBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "recipe.db";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //****************************************   SQL CREATE STRINGS   ****************************************

    private static final String SQL_CREATE_TABLE_RECIPES = "CREATE TABLE " +
            DBContract.RecipesTable.TABLE_RECIPES + " (" +
            DBContract.RecipesTable._ID + " INTEGER PRIMARY KEY," +
            DBContract.RecipesTable.COLUMN_NAME + " TEXT" + " )";

    private static final String SQL_CREATE_TABLE_SHOPPING_LISTS = "CREATE TABLE " +
            DBContract.ShoppingListsTable.TABLE_SHOPPING_LISTS + " (" +
            DBContract.ShoppingListsTable._ID + " INTEGER PRIMARY KEY," +
            DBContract.ShoppingListsTable.COLUMN_NAME + " TEXT" + " )";

    private static final String SQL_CREATE_TABLE_INGREDIENTS = "CREATE TABLE " +
            DBContract.IngredientsTable.TABLE_INGREDIENTS + " (" +
            DBContract.IngredientsTable._ID + " INTEGER PRIMARY KEY," +
            DBContract.IngredientsTable.COLUMN_AMOUNT + " REAL" +
            DBContract.IngredientsTable.COLUMN_UNIT + " INTEGER" +
            DBContract.IngredientsTable.COLUMN_NAME + " TEXT" +
            DBContract.IngredientsTable.COLUMN_RECIPE + " INTEGER" +" )";

    private static final String SQL_CREATE_TABLE_INSTRUCTIONS = "CREATE TABLE " +
            DBContract.InstructionsTable.TABLE_INSTRUCTIONS + " (" +
            DBContract.InstructionsTable._ID + " INTEGER PRIMARY KEY," +
            DBContract.InstructionsTable.COLUMN_RECIPE + " INTEGER" + " )";

    private static final String SQL_CREATE_TABLE_INSTRUCTION_ITEMS = "CREATE TABLE " +
            DBContract.InstructionItemsTable.TABLE_INSTRUCTION_ITEMS + " (" +
            DBContract.InstructionItemsTable._ID + " INTEGER PRIMARY KEY," +
            DBContract.InstructionItemsTable.COLUMN_INSTRUCTION_ROW + " TEXT" +
            DBContract.InstructionItemsTable.COLUMN_INSTRUCTION + " INTEGER" +" )";

    private static final String SQL_CREATE_TABLE_SHOP_ITEMS = "CREATE TABLE " +
            DBContract.ShopItemsTable.TABLE_SHOP_ITEMS + " (" +
            DBContract.ShopItemsTable._ID + " INTEGER PRIMARY KEY," +
            DBContract.ShopItemsTable.COLUMN_NAME + " TEXT" +
            DBContract.ShopItemsTable.COLUMN_SHOPPING_LIST + " INTEGER" +" )";

    //****************************************   SQL DELETE STRINGS   ****************************************

    private static final String SQL_DELETE_TABLE_RECIPES = "DROP TABLE IF EXISTS " + DBContract.RecipesTable.TABLE_RECIPES;
    private static final String SQL_DELETE_TABLE_SHOPPING_LISTS = "DROP TABLE IF EXISTS " + DBContract.ShoppingListsTable.TABLE_SHOPPING_LISTS;
    private static final String SQL_DELETE_TABLE_INGREDIENTS = "DROP TABLE IF EXISTS " + DBContract.IngredientsTable.TABLE_INGREDIENTS;
    private static final String SQL_DELETE_TABLE_INSTRUCTIONS = "DROP TABLE IF EXISTS " + DBContract.InstructionsTable.TABLE_INSTRUCTIONS;
    private static final String SQL_DELETE_TABLE_INSTRUCTION_ITEMS = "DROP TABLE IF EXISTS " + DBContract.InstructionItemsTable.TABLE_INSTRUCTION_ITEMS;
    private static final String SQL_DELETE_TABLE_SHOP_ITEMS = "DROP TABLE IF EXISTS " + DBContract.ShopItemsTable.TABLE_SHOP_ITEMS;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_RECIPES);
        db.execSQL(SQL_CREATE_TABLE_SHOPPING_LISTS);
        db.execSQL(SQL_CREATE_TABLE_INGREDIENTS);
        db.execSQL(SQL_CREATE_TABLE_INSTRUCTIONS);
        db.execSQL(SQL_CREATE_TABLE_INSTRUCTION_ITEMS);
        db.execSQL(SQL_CREATE_TABLE_SHOP_ITEMS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.RecipesTable.TABLE_RECIPES);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.ShoppingListsTable.TABLE_SHOPPING_LISTS);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.IngredientsTable.TABLE_INGREDIENTS);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.InstructionsTable.TABLE_INSTRUCTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.InstructionItemsTable.TABLE_INSTRUCTION_ITEMS);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.ShopItemsTable.TABLE_SHOP_ITEMS);

        onCreate(db);
    }
}
