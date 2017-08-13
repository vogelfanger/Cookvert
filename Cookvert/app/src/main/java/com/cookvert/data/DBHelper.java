package com.cookvert.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.cookvert.util.Cookvert;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * SQLiteOpenHelper class containing methods to access and modify the database.
 */
public class DBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "recipes.db";

    public static final String LOG_TAG = "DBHelper"; // tag for Log entries

    // default system path to app database
    private static String dbPath = "/data/data/com.cookvert/databases/";

    private static DBHelper dbHelper; //singleton instance

    //private constructor to prevent multiple instances
    private DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    //****************************************************************************************************
    //                         METHODS FOR IMPORTING DATABASE FROM ASSETS FOLDER
    //****************************************************************************************************



    /**
     * Returns instance of the DBHelper.
     * If the instance is not yet created, new instance is created.
     * @param context Context for SQLiteOpenHelper constructor
     * @return Instance of DBHelper
     * @throws IOException If there's an issue creating the database
     */
    public static DBHelper getInstance(Context context){
        if(dbHelper == null){
            dbHelper = new DBHelper(context.getApplicationContext());
            try {
                dbHelper.createDB();
            }catch (IOException e){
                new Error("Unable to create database");
            }
        }
        return dbHelper;
    }

    /**
     * Creates a new database and rewrites it with asset database.
     * If database is already created, this method does nothing.
     * @throws IOException if there's issue with copying asset database
     */
    public void createDB() throws IOException{

        if(DataBaseExists()){
            // do nothing
        } else{
            // calling this method creates an empty database to default system path
            this.getReadableDatabase();

            try{
                copyDB();
            } catch (IOException e){
                throw new Error("Error copying database");
            }
        }
    }

    /**
     * Checks if database already exists in default system path.
     * @return true, if db exists, false if it doesn't
     */
    public boolean DataBaseExists(){

        SQLiteDatabase testDB = null;

        //try opening the database to see if it exists
        try{
            String path = dbPath + DATABASE_NAME;
            testDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        } catch(SQLiteException e){
            // database does not exist
        }

        // if database exists, close it and return true
        if(testDB != null){
            testDB.close();
            return true;
        } else{
            return false;
        }
    }

    /**
     * Copies asset database to the database in default system path using byte stream.
     * @throws IOException If there's an issue with data transfer
     */
    public void copyDB() throws IOException{

        Log.d(LOG_TAG, "accessing copyDB");
        // use local database as input
        InputStream in = Cookvert.getAppContext().getAssets().open(DATABASE_NAME);
        String outputFileName = dbPath + DATABASE_NAME;
        // use empty default database as output
        OutputStream out = new FileOutputStream(outputFileName);

        //transfer bytes from input to output
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer))>0){
            out.write(buffer, 0, length);
            Log.d(LOG_TAG, "transferring files...");
        }

        // close streams
        out.flush();
        out.close();
        in.close();

    }



    //****************************************************************************************************
    //                                   SQL CREATE TABLES
    //****************************************************************************************************

    // String commands to create tables

    private static final String SQL_CREATE_TABLE_INGREDIENT =
            "CREATE TABLE IF NOT EXISTS "
            + DBContract.Ingredient.TABLE_INGREDIENT + " ("
            + DBContract.Ingredient._ID + " INTEGER PRIMARY KEY,"
            + DBContract.Ingredient.AMOUNT + " REAL,"
            + DBContract.Ingredient.UNIT + " INTEGER,"
            + DBContract.Ingredient.NAME + " TEXT)";

    private static final String SQL_CREATE_TABLE_INGREDIENT_REFERENCES =
            "CREATE TABLE IF NOT EXISTS "
                    + DBContract.IngredientReferences.TABLE_INGREDIENT_REFERENCES + " ("
                    + DBContract.IngredientReferences._ID + " INTEGER PRIMARY KEY,"

                    + DBContract.IngredientReferences.RECIPE_ID + " INTEGER,"
                    + DBContract.IngredientReferences.INGREDIENT_ID + " INTEGER,"

                    + "FOREIGN KEY ("+DBContract.IngredientReferences.RECIPE_ID+") "
                    + "REFERENCES "+DBContract.Recipe.TABLE_RECIPE
                    + " ("+DBContract.Recipe._ID+"), "
                    + "FOREIGN KEY ("+DBContract.IngredientReferences.INGREDIENT_ID + ") "
                    + "REFERENCES "+DBContract.Ingredient.TABLE_INGREDIENT +
                    " ("+DBContract.Ingredient._ID+"))";

    private static final String SQL_CREATE_TABLE_RECIPE =
            "CREATE TABLE IF NOT EXISTS "
            + DBContract.Recipe.TABLE_RECIPE + " ("
            + DBContract.Recipe._ID + " INTEGER PRIMARY KEY,"
            + DBContract.Recipe.NAME + " TEXT,"
            + DBContract.Recipe.INSTRUCTIONS + " TEXT)";

    private static final String SQL_CREATE_TABLE_RECIPE_CAT =
            "CREATE TABLE IF NOT EXISTS "
            + DBContract.RecipeCategory.TABLE_RECIPE_CAT + " ("
            + DBContract.RecipeCategory._ID + " INTEGER PRIMARY KEY,"
            + DBContract.RecipeCategory.NAME + " TEXT)";

    private static final String SQL_CREATE_TABLE_RECIPE_REFERENCES =
            "CREATE TABLE IF NOT EXISTS "
            + DBContract.RecipeReferences.TABLE_RECIPE_REFERENCES + " ("
            + DBContract.RecipeReferences._ID + " INTEGER PRIMARY KEY,"

            + DBContract.RecipeReferences.CAT_ID + " INTEGER,"
            + DBContract.RecipeReferences.RECIPE_ID + " INTEGER,"

            + "FOREIGN KEY ("+DBContract.RecipeReferences.CAT_ID+") "
            + "REFERENCES "+DBContract.RecipeCategory.TABLE_RECIPE_CAT
            + " ("+DBContract.RecipeCategory._ID+"), "
            + "FOREIGN KEY ("+DBContract.RecipeReferences.RECIPE_ID+") "
            + "REFERENCES "+DBContract.Recipe.TABLE_RECIPE+" ("+DBContract.Recipe._ID+"))";

    private static final String SQL_CREATE_TABLE_SHOP_ITEM =
            "CREATE TABLE IF NOT EXISTS "
            + DBContract.ShopItem.TABLE_SHOP_ITEM + " ("
            + DBContract.ShopItem._ID + " INTEGER PRIMARY KEY, "
            + DBContract.ShopItem.NAME + " TEXT, "
            + DBContract.ShopItem.SELECTED + " INTEGER)";

    private static final String SQL_CREATE_TABLE_SHOPPING_LIST =
            "CREATE TABLE IF NOT EXISTS "
            + DBContract.ShoppingList.TABLE_SHOPPING_LIST + " ("
            + DBContract.ShoppingList._ID + " INTEGER PRIMARY KEY, "
            + DBContract.ShoppingList.NAME + " TEXT)";

    // Table connects each shop item to a shopping list,
    // so there are two foreign keys to each table
    private static final String SQL_CREATE_TABLE_SHOPPING_LIST_REFERENCES =
            "CREATE TABLE IF NOT EXISTS "
            + DBContract.ShoppingListReferences.TABLE_SHOPPING_LIST_REFERENCES + " ("
            + DBContract.ShoppingListReferences._ID + " INTEGER PRIMARY KEY,"

            + DBContract.ShoppingListReferences.SHOP_ITEM_ID + " INTEGER, "
            + DBContract.ShoppingListReferences.SHOPPING_LIST_ID + " INTEGER, "
            + "FOREIGN KEY ("+DBContract.ShoppingListReferences.SHOP_ITEM_ID+") "
            + "REFERENCES "+DBContract.ShopItem.TABLE_SHOP_ITEM+"("+DBContract.ShopItem._ID+"), "

            + "FOREIGN KEY ("+DBContract.ShoppingListReferences.SHOPPING_LIST_ID+") "
            + "REFERENCES "+DBContract.ShoppingList.TABLE_SHOPPING_LIST
            + "("+DBContract.ShoppingList._ID+"))";



    //****************************************************************************************************
    //                                      SQL DELETE TABLES
    //****************************************************************************************************



    private static final String SQL_DELETE_TABLE_INGREDIENT = "DROP TABLE IF EXISTS "
            + DBContract.Ingredient.TABLE_INGREDIENT;
    private static final String SQL_DELETE_TABLE_INGREDIENT_REFERENCES = "DROP TABLE IF EXISTS "
            + DBContract.IngredientReferences.TABLE_INGREDIENT_REFERENCES;
    private static final String SQL_DELETE_TABLE_RECIPE = "DROP TABLE IF EXISTS "
            + DBContract.Recipe.TABLE_RECIPE;
    private static final String SQL_DELETE_TABLE_RECIPE_CAT = "DROP TABLE IF EXISTS "
            + DBContract.RecipeCategory.TABLE_RECIPE_CAT;
    private static final String SQL_DELETE_TABLE_RECIPE_REFERENCES = "DROP TABLE IF EXISTS "
            + DBContract.RecipeReferences.TABLE_RECIPE_REFERENCES;
    private static final String SQL_DELETE_TABLE_SHOP_ITEM = "DROP TABLE IF EXISTS "
            + DBContract.ShopItem.TABLE_SHOP_ITEM;
    private static final String SQL_DELETE_TABLE_SHOPPING_LIST = "DROP TABLE IF EXISTS "
            + DBContract.ShoppingList.TABLE_SHOPPING_LIST;
    private static final String SQL_DELETE_TABLE_SHOPPING_LIST_REFERENCES =
            "DROP TABLE IF EXISTS "
            + DBContract.ShoppingListReferences.TABLE_SHOPPING_LIST_REFERENCES;



    //****************************************************************************************************
    //                                   SQLiteOpenHelper METHODS
    //****************************************************************************************************



    // Enable foreign key support when configuring the database.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_INGREDIENT);
        db.execSQL(SQL_CREATE_TABLE_INGREDIENT_REFERENCES);
        db.execSQL(SQL_CREATE_TABLE_RECIPE);
        db.execSQL(SQL_CREATE_TABLE_RECIPE_CAT);
        db.execSQL(SQL_CREATE_TABLE_RECIPE_REFERENCES);
        db.execSQL(SQL_CREATE_TABLE_SHOP_ITEM);
        db.execSQL(SQL_CREATE_TABLE_SHOPPING_LIST);
        db.execSQL(SQL_CREATE_TABLE_SHOPPING_LIST_REFERENCES);
    }

    // Drop tables and create new ones.
    // TODO If database version is increased, handle changes here.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.Ingredient.TABLE_INGREDIENT);
        db.execSQL("DROP TABLE IF EXISTS "
                + DBContract.IngredientReferences.TABLE_INGREDIENT_REFERENCES);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.Recipe.TABLE_RECIPE);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.RecipeCategory.TABLE_RECIPE_CAT);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.RecipeReferences.TABLE_RECIPE_REFERENCES);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.ShopItem.TABLE_SHOP_ITEM);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.ShoppingList.TABLE_SHOPPING_LIST);
        db.execSQL("DROP TABLE IF EXISTS "
                + DBContract.ShoppingListReferences.TABLE_SHOPPING_LIST_REFERENCES);
        onCreate(db);
    }



    //****************************************************************************************************
    //                                      INSERT METHODS
    //****************************************************************************************************



    /**
     * Inserts new ingredient into ingredient table
     * and inserts or updates a row in ingredient reference table.
     * If first ingredient reference of a recipe is null,
     * the value in reference table is updated with the new ingredient id.
     * Otherwise a new row is inserted into reference table.
     * @param amount Ingredient amount
     * @param name Ingredient name
     * @param unitID Ingredient unit id
     * @param recipeID Recipe primary key
     * @return Primary key of the inserted row in ingredient table
     */
    public long insertIngredient(double amount, String name, int unitID, long recipeID){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.Ingredient.AMOUNT, amount);
        values.put(DBContract.Ingredient.NAME, name);
        values.put(DBContract.Ingredient.UNIT, unitID);

        //insert new row into ingredient table
        long ingrID = db.insert(DBContract.Ingredient.TABLE_INGREDIENT, null, values);

        // values for reference table
        ContentValues values1 = new ContentValues();
        values1.put(DBContract.IngredientReferences.INGREDIENT_ID, ingrID);
        values1.put(DBContract.IngredientReferences.RECIPE_ID, recipeID);

        long rtID = db.insert(DBContract.IngredientReferences.TABLE_INGREDIENT_REFERENCES,
                null, values1);

        Log.d(LOG_TAG, "ingredient inserted, id:" + String.valueOf(ingrID));
        return ingrID;
    }

    /**
     * Inserts new row into recipe table and
     * inserts or updates a row in recipe reference table.
     * If the first recipe reference of a category is null,
     * the value in reference table is updated with the new recipe id.
     * Otherwise a new row is inserted into reference table.
     * @param name Recipe name
     * @param instructions Recipe instructions
     * @param categoryID Primary key of recipe category
     * @return Primary key of the inserted row is recipe table
     */
    public long insertRecipe(String name, String instructions, long categoryID){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.Recipe.NAME, name);
        values.put(DBContract.Recipe.INSTRUCTIONS, instructions);

        // insert row into recipe table
        long recipeID = db.insert(DBContract.Recipe.TABLE_RECIPE, null, values);

        // values for reference table
        ContentValues values1 = new ContentValues();
        values1.put(DBContract.RecipeReferences.RECIPE_ID, recipeID);
        // selection for updating reference table
        String selection = DBContract.RecipeReferences.CAT_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(categoryID)};

        Cursor cursor = readRecipeReferences(categoryID);
        if(cursor.moveToFirst()){
            //if first recipe reference is null, replace null value with recipe id
            if(cursor.isNull(cursor.getColumnIndexOrThrow(
                    DBContract.RecipeReferences.RECIPE_ID))){
                int count = db.update(
                        DBContract.RecipeReferences.TABLE_RECIPE_REFERENCES,
                        values1, selection, selectionArgs);
            }
            //if first reference is not null, insert new row
            else{
                values1.put(DBContract.RecipeReferences.CAT_ID, categoryID);
                long rtID = db.insert(
                        DBContract.RecipeReferences.TABLE_RECIPE_REFERENCES, null, values1);
            }
        }
        Log.d(LOG_TAG, "recipe inserted, id:" + String.valueOf(recipeID));
        return recipeID;
    }

    /**
     * Inserts new category into recipe category and recipe reference tables.
     * Inserted row in reference table will have a null value at category_id.
     * @param name Recipe category name
     * @return row id of inserted category in recipe category table
     */
    public long insertRecipeCategory(String name){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.RecipeCategory.NAME, name);

        //insert row to recipe category table
        long rcID = db.insert(DBContract.RecipeCategory.TABLE_RECIPE_CAT, null, values);

        //put null value to recipe_id, it will be replaced when needed
        ContentValues values1 = new ContentValues();
        values1.put(DBContract.RecipeReferences.CAT_ID, rcID);
        values1.putNull(DBContract.RecipeReferences.RECIPE_ID);

        //insert row to reference table
        long rcrID = db.insert(
                DBContract.RecipeReferences.TABLE_RECIPE_REFERENCES, null, values1);

        Log.d(LOG_TAG, "category inserted, id:" + rcID);
        return rcID;
    }

    /**
     * Inserts new item into shop item table and
     * inserts or updates a row in shopping list reference table.
     * If first shop item in reference table is null,
     * the value is updated with the new shop item id.
     * Otherwise a new row is inserted into reference table.
     * @param name shop item name
     * @param selected 1, if item is selected, 0 if unselected
     * @param listID row id of shopping list
     * @return row id of inserted item in shop item table
     */
    public long insertShopItem(String name, Boolean selected, long listID){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.ShopItem.NAME, name);

        //put boolean into values as an integer
        if(selected){
            values.put(DBContract.ShopItem.SELECTED, 1);
        } else{
            values.put(DBContract.ShopItem.SELECTED, 0);
        }

        //insert new row into shop item table
        long siID = db.insert(DBContract.ShopItem.TABLE_SHOP_ITEM, null, values);

        //values for reference table
        ContentValues values1 = new ContentValues();
        values1.put(DBContract.ShoppingListReferences.SHOP_ITEM_ID, siID);

        String selection = DBContract.ShoppingListReferences.SHOPPING_LIST_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(listID)};

        Cursor cursor = readShopItemReferences(listID);
        if(cursor.moveToFirst()){
            //if first item reference is null, update item id
            if(cursor.isNull(cursor.getColumnIndexOrThrow(
                    DBContract.ShoppingListReferences.SHOP_ITEM_ID))){
                db.update(
                        DBContract.ShoppingListReferences.TABLE_SHOPPING_LIST_REFERENCES,
                        values1,
                        selection,
                        selectionArgs
                );
            }
            //if first item reference is not null, insert a new row
            else{
                values1.put(DBContract.ShoppingListReferences.SHOPPING_LIST_ID, listID);
                long slrID = db.insert(
                        DBContract.ShoppingListReferences.TABLE_SHOPPING_LIST_REFERENCES,
                        null, values1);
            }
        }
        Log.d(LOG_TAG, "shop item inserted, id:" + siID);
        return siID;
    }

    /**
     * Inserts new shopping list to shopping list table and shopping list reference table.
     * New row in reference table will have null value at shop_item_id.
     * @param name shopping list name
     * @return id of inserted row in shopping list table
     */
    public long insertShoppingList(String name){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.ShoppingList.NAME, name);

        //insert new row into shopping list table
        long slID = db.insert(DBContract.ShoppingList.TABLE_SHOPPING_LIST, null, values);

        ContentValues values1 = new ContentValues();
        //put first shop item reference to null and replace it later
        values1.putNull(DBContract.ShoppingListReferences.SHOP_ITEM_ID);
        values1.put(DBContract.ShoppingListReferences.SHOPPING_LIST_ID, slID);

        //insert new row into reference table
        long slrID = db.insert(DBContract.ShoppingListReferences.TABLE_SHOPPING_LIST_REFERENCES,
                null, values1);

        Log.d(LOG_TAG, "shopping list inserted, id:" + String.valueOf(slID));
        return slID;
    }



    //****************************************************************************************************
    //                                      DELETE METHODS
    //****************************************************************************************************



    public void deleteIngredient(long ingredientID){
        SQLiteDatabase db = getWritableDatabase();

        //use row id to select row in ingredient table
        String selection = DBContract.Ingredient._ID + " = ?";
        String[] selectionArgs = { String.valueOf(ingredientID)};

        //use row id to select row in reference table
        String selection1 = DBContract.IngredientReferences.INGREDIENT_ID + " = ?";
        String[] selectionArgs1 = { String.valueOf(ingredientID)};

        //delete ingredient row in both tables
        db.delete(DBContract.Ingredient.TABLE_INGREDIENT, selection, selectionArgs);
        db.delete(DBContract.IngredientReferences.TABLE_INGREDIENT_REFERENCES,
                selection1, selectionArgs1);

        Log.d(LOG_TAG, "ingredient deleted, id: " + String.valueOf(ingredientID));
    }

    /**
     * Deletes recipe and any ingredients referencing it from all tables.
     * @param recipeID row id of recipe being deleted
     */
    public void deleteRecipe(long recipeID){
        SQLiteDatabase db = getWritableDatabase();

        //use row id to select row in recipe table
        String selection = DBContract.Recipe._ID + " = ?";
        String[] selectionArgs = { String.valueOf(recipeID)};

        //use row id to select rows in reference table
        String selection1 = DBContract.RecipeReferences.RECIPE_ID + " LIKE ?";
        String[] selectionArgs1 = { String.valueOf(recipeID)};

        //get ingredients with reference to the recipe
        List itemIDs = new ArrayList();
        Cursor cursor = readIngredientsInRecipe(recipeID);
        while(cursor.moveToNext()){
            itemIDs.add(cursor.getLong(
                    cursor.getColumnIndexOrThrow(DBContract.Ingredient._ID)));
        }
        cursor.close();

        //delete ingredients from ingredient and ingredient reference tables
        for(int i=0; itemIDs.size()>0; i++){
            deleteIngredient((long) itemIDs.get(i));
        }

        //delete recipe rows from recipe and recipe reference tables
        db.delete(DBContract.Recipe.TABLE_RECIPE, selection, selectionArgs);
        db.delete(DBContract.RecipeReferences.TABLE_RECIPE_REFERENCES, selection1, selectionArgs1);

        Log.d(LOG_TAG, "recipe deleted, id:" + String.valueOf(recipeID));
    }

    /**
     * Deletes a recipe category and reassigns any references into another category.
     * @param catID row id of category being deleted
     * @param newCatID id of category used as a new reference for
     *                 any recipes that were referencing the deleted category
     */
    public void deleteRecipeCategory(long catID, long newCatID){
        SQLiteDatabase db = getWritableDatabase();

        //use rowID to select row in category table
        String selection = DBContract.RecipeCategory._ID + " = ?";
        String[] selectionArgs = { String.valueOf(catID)};

        //reassign references to another category
        this.reassignCategory(catID, newCatID);

        //delete category
        db.delete(DBContract.RecipeCategory.TABLE_RECIPE_CAT, selection, selectionArgs);

        Log.d(LOG_TAG, "category deleted");
    }


    public void deleteShopItem(long itemID){
        SQLiteDatabase db = getWritableDatabase();

        //use rowID to select row in ingredient table
        String selection = DBContract.ShopItem._ID + " = ?";
        String[] selectionArgs = { String.valueOf(itemID)};

        //use rowID to select row in reference table
        String selection1 = DBContract.ShoppingListReferences.SHOP_ITEM_ID + " = ?";
        String[] selectionArgs1 = { String.valueOf(itemID)};

        //delete shop item row in both tables
        db.delete(DBContract.ShopItem.TABLE_SHOP_ITEM, selection, selectionArgs);
        db.delete(DBContract.ShoppingListReferences.TABLE_SHOPPING_LIST_REFERENCES,
                selection1, selectionArgs1);

        Log.d(LOG_TAG, "shop item deleted, id:" + String.valueOf(itemID));
    }

    /**
     * Deletes shop list and any shop items referencing the list from all tables.
     * @param listID id of shop list being deleted
     */
    public void deleteShoppingList(long listID){
        SQLiteDatabase db = getWritableDatabase();

        //use rowID to select row in shopping list table
        String selection = DBContract.ShoppingList._ID + " = ?";
        String[] selectionArgs = { String.valueOf(listID)};

        //use rowID to select rows in reference table
        String selection1 = DBContract.ShoppingListReferences.SHOPPING_LIST_ID + " LIKE ?";
        String[] selectionArgs1 = { String.valueOf(listID)};

        //get all shop item ids in the shopping list
        List itemIDs = new ArrayList();
        Cursor cursor = readShopItemsInList(listID);
        while(cursor.moveToNext()){
            itemIDs.add(cursor.getLong(
                    cursor.getColumnIndexOrThrow(DBContract.ShopItem._ID)));
        }
        cursor.close();

        //delete shop item rows from shop item table
        for (int i = 0; itemIDs.size() > 0; i++){
            deleteShopItem((long) itemIDs.get(i));
        }

        //delete shopping list row from tables
        db.delete(DBContract.ShoppingList.TABLE_SHOPPING_LIST, selection, selectionArgs);
        db.delete(DBContract.ShoppingListReferences.TABLE_SHOPPING_LIST_REFERENCES,
                selection1, selectionArgs1);

        Log.d(LOG_TAG, "shopping list deleted, id:" + listID);
    }



    //****************************************************************************************************
    //                                           READ METHODS
    //****************************************************************************************************



    public Cursor readIngredientsInRecipe(long recipeID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //select all ingredients with reference to recipe
        String selectQuery = "SELECT "
                + "i." + DBContract.Ingredient._ID + ", "
                + DBContract.Ingredient.AMOUNT + ", "
                + DBContract.Ingredient.NAME + ", "
                + DBContract.Ingredient.UNIT + " "
                + "FROM " + DBContract.Ingredient.TABLE_INGREDIENT + " i "
                + "INNER JOIN " + DBContract.IngredientReferences.TABLE_INGREDIENT_REFERENCES
                + " iref ON i." + DBContract.Ingredient._ID + "="
                + "iref." + DBContract.IngredientReferences.INGREDIENT_ID + " "
                + "WHERE " + DBContract.IngredientReferences.RECIPE_ID + "=?";

        String[] selectionArgs = {String.valueOf(recipeID)};

        //use raw query instead of normal query to join multiple tables
        return db.rawQuery(selectQuery, selectionArgs);
    }

    public Cursor readRecipesInCat(long catID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //select all recipes with reference to category
        String selectQuery = "SELECT "
                + "r." + DBContract.Recipe._ID + ", "
                + DBContract.Recipe.NAME + ", "
                + DBContract.Recipe.INSTRUCTIONS + " "
                + "FROM " + DBContract.Recipe.TABLE_RECIPE + " r "
                + "INNER JOIN " + DBContract.RecipeReferences.TABLE_RECIPE_REFERENCES + " rf "
                + "ON r." + DBContract.Recipe._ID + "="
                + "rf." + DBContract.RecipeReferences.RECIPE_ID + " "
                + "WHERE " + DBContract.RecipeReferences.CAT_ID + "=?";

        String[] selectionArgs = {String.valueOf(catID)};

        //use raw query instead of normal query to join multiple tables
        return db.rawQuery(selectQuery, selectionArgs);
    }

    public Cursor readAllRecipeCategories(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //select whole recipe category table
        String selectQuery = "SELECT * FROM " + DBContract.RecipeCategory.TABLE_RECIPE_CAT;

        return db.rawQuery(selectQuery, null);
    }


    public Cursor readShopItemsInList(long shopListID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //select all shop items with reference to shopListID
        String selectQuery = "SELECT "
                + "si." + DBContract.ShopItem._ID + ", "
                + DBContract.ShopItem.NAME + ", "
                + DBContract.ShopItem.SELECTED + " "
                + "FROM " + DBContract.ShopItem.TABLE_SHOP_ITEM + " si "
                + "INNER JOIN "
                + DBContract.ShoppingListReferences.TABLE_SHOPPING_LIST_REFERENCES + " slf "
                + "ON si." + DBContract.ShopItem._ID + "="
                + "slf." + DBContract.ShoppingListReferences.SHOP_ITEM_ID + " "
                + "WHERE " + DBContract.ShoppingList._ID + "=?";

        String[] selectionArgs = {String.valueOf(shopListID)};

        //use raw query instead of normal query to join multiple tables
        return db.rawQuery(selectQuery, selectionArgs);
    }


    public Cursor readAllShoppingLists(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //select whole shopping list table
        String selectQuery = "SELECT * FROM " + DBContract.ShoppingList.TABLE_SHOPPING_LIST;

        return db.rawQuery(selectQuery, null);
    }



    public Cursor readIngredient(long id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                DBContract.Ingredient._ID,
                DBContract.Ingredient.AMOUNT,
                DBContract.Ingredient.NAME,
                DBContract.Ingredient.UNIT
        };

        String selection = DBContract.Ingredient._ID + "=?";
        String[] selectionArgs = {Long.toString(id)};

        return db.query(
                DBContract.Ingredient.TABLE_INGREDIENT,
                projection,
                selection,
                selectionArgs,
                null, null, null
        );
    }

    /**
     * Reads reference ingredients of a recipe.
     * @param recipeID row id of recipe
     * @return Cursor containing reference columns
     *         with reference to the recipe
     */
    public Cursor readIngredientReferences(long recipeID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                DBContract.IngredientReferences._ID,
                DBContract.IngredientReferences.INGREDIENT_ID
        };

        String selection = DBContract.IngredientReferences.RECIPE_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(recipeID)};

        return db.query(
                DBContract.IngredientReferences.TABLE_INGREDIENT_REFERENCES,
                projection,
                selection,
                selectionArgs,
                null, null, null
        );
    }

    public Cursor readRecipe(long id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                DBContract.Recipe._ID,
                DBContract.Recipe.NAME,
                DBContract.Recipe.INSTRUCTIONS
        };

        String selection = DBContract.Recipe._ID + "= ?";
        String[] selectionArgs = {Long.toString(id)};

        return db.query(
                DBContract.Recipe.TABLE_RECIPE,
                projection,
                selection,
                selectionArgs,
                null, null, null
        );
    }

    public Cursor readRecipeCat(long id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                DBContract.RecipeCategory._ID,
                DBContract.RecipeCategory.NAME
        };

        String selection = DBContract.RecipeCategory._ID + "= ?";
        String[] selectionArgs = {String.valueOf(id)};

        return db.query(
                DBContract.RecipeCategory.TABLE_RECIPE_CAT,
                projection,
                selection,
                selectionArgs,
                null, null, null
        );
    }

    /**
     * Reads reference recipes of a recipe category.
     * @param catID row id of recipe category
     * @return Cursor containing reference columns
     *         with reference to the recipe category
     */
    public Cursor readRecipeReferences(long catID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                DBContract.RecipeReferences._ID,
                DBContract.RecipeReferences.RECIPE_ID
        };

        String selection = DBContract.RecipeReferences.CAT_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(catID)};

        return db.query(
                DBContract.RecipeReferences.TABLE_RECIPE_REFERENCES,
                projection,
                selection,
                selectionArgs,
                null, null, null
        );
    }

    public Cursor readShopItem(long id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                DBContract.ShopItem._ID,
                DBContract.ShopItem.NAME,
                DBContract.ShopItem.SELECTED
        };

        //use shop item id for WHERE clause
        String selection = DBContract.ShopItem._ID + "= ?";
        String[] selectionArgs = {Long.toString(id)};

        return db.query(
                DBContract.ShopItem.TABLE_SHOP_ITEM,
                projection,
                selection,
                selectionArgs,
                null, null, null
        );
    }

    /**
     * Reads reference items of a shopping list.
     * @param listID row id of shopping list
     * @return Cursor containing reference columns
     */
    public Cursor readShopItemReferences(long listID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                DBContract.ShoppingListReferences._ID,
                DBContract.ShoppingListReferences.SHOP_ITEM_ID
        };

        String selection = DBContract.ShoppingListReferences.SHOPPING_LIST_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(listID)};

        return db.query(
                DBContract.ShoppingListReferences.TABLE_SHOPPING_LIST_REFERENCES,
                projection,
                selection,
                selectionArgs,
                null, null, null
        );
    }

    public Cursor readShoppingList(long id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String[] projection = {
                DBContract.ShoppingList._ID,
                DBContract.ShoppingList.NAME
        };

        String selection = DBContract.ShoppingList._ID + "=?";
        String[] selectionArgs = {Long.toString(id)};

        return db.query(
                DBContract.ShoppingList.TABLE_SHOPPING_LIST,
                projection,
                selection,
                selectionArgs,
                null, null, null
        );
    }



    //****************************************************************************************************
    //                                      UPDATE METHODS
    //****************************************************************************************************



    public void updateIngredient(double amount, String name, int unit, long rowID){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.Ingredient.AMOUNT, amount);
        values.put(DBContract.Ingredient.NAME, name);
        values.put(DBContract.Ingredient.UNIT, unit);

        //use rowID to select updatable ingredient
        String selection = DBContract.Ingredient._ID + " = ?";
        String[] selectionArgs = { String.valueOf(rowID)};

        //row is updated but number of affected rows i is not used
        int i = db.update(DBContract.Ingredient.TABLE_INGREDIENT,
                values,
                selection,
                selectionArgs);
    }

    public void updateRecipe(String name, String instructions, long rowID){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.Recipe.NAME, name);
        values.put(DBContract.Recipe.INSTRUCTIONS, instructions);

        //use rowID to select updatable recipe
        String selection = DBContract.Recipe._ID + " = ?";
        String[] selectionArgs = { String.valueOf(rowID)};

        //row is updated but number of affected rows i is not used
        int i = db.update(DBContract.Recipe.TABLE_RECIPE,
                values,
                selection,
                selectionArgs);
    }


    public void updateRecipeCategory(String name, long rowID){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.RecipeCategory.NAME, name);

        //use rowID to select updatable category
        String selection = DBContract.RecipeCategory._ID + " = ?";
        String[] selectionArgs = { String.valueOf(rowID)};

        //row is updated but number of affected rows i is not used
        int i = db.update(DBContract.RecipeCategory.TABLE_RECIPE_CAT,
                values,
                selection,
                selectionArgs);
    }

    /**
     * Updates category reference of a recipe.
     * @param recipeID id of recipe
     * @param newCatID new reference category for the recipe
     */
    public void updateRecipeReference(long recipeID, long newCatID){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.RecipeReferences.CAT_ID, newCatID);

        String selection = DBContract.RecipeReferences.RECIPE_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(recipeID)};

        //row is updated but number of affected rows i is not used
        int i = db.update(DBContract.RecipeReferences.TABLE_RECIPE_REFERENCES,
                values,
                selection,
                selectionArgs);
    }


    public void updateShopItem(String name, boolean selected, long rowID){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.ShopItem.NAME, name);
        values.put(DBContract.ShopItem.SELECTED, selected);

        //use rowID to select updatable shop item
        String selection = DBContract.ShopItem._ID + " = ?";
        String[] selectionArgs = { String.valueOf(rowID)};

        //row is updated but number of affected rows i is not used
        int i = db.update(DBContract.ShopItem.TABLE_SHOP_ITEM,
                values,
                selection,
                selectionArgs);
    }


    public void updateShoppingList(String name, long rowID){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.ShoppingList.NAME, name);

        //use rowID to select updatable shopping list
        String selection = DBContract.ShoppingList._ID + " = ?";
        String[] selectionArgs = { String.valueOf(rowID)};

        //row is updated but number of affected rows i is not used
        int i = db.update(DBContract.ShoppingList.TABLE_SHOPPING_LIST,
                values,
                selection,
                selectionArgs);
    }


    //****************************************************************************************************
    //                                      OTHER METHODS
    //****************************************************************************************************



    /**
     * Creates an IN query String with given number of placeholders
     * @param length number of placeholders in returned String
     * @return IN query String
     */
    public static String getInQueryString(int length){
        StringBuilder sb = new StringBuilder();
        if(length > 0){
            sb.append(" IN ( ");
            String placeholder = "";
            for(int i=0; i<length; i++){
                sb.append(placeholder);
                sb.append("?");
                placeholder = ",";
            }
            sb.append(" )");
        }
        return sb.toString();
    }

    /**
     * Replaces a category reference with another. This method only affects references
     * in RecipesTable and doesn't change anything in RecipeCategory table.
     * @param catID id of old category
     * @param newCatID id of new category
     */
    public void reassignCategory(long catID, long newCatID){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.RecipeReferences.CAT_ID, newCatID);

        String selection = DBContract.RecipeReferences.CAT_ID + " LIKE ?";
        String[] selectionArgs = { String.valueOf(catID) };

        //rows are updated but number of affected rows i is not used
        int i = db.update(DBContract.RecipeReferences.TABLE_RECIPE_REFERENCES,
                values,
                selection,
                selectionArgs);
    }
}
