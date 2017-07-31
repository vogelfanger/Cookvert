package com.cookvert.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * SQLiteOpenHelper class containing methods to access and modify the database.
 */
public class DBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "recipes.db";

    private static DBHelper dbHelper; //singleton instance
    public long[] rowIds; //ids for each row in the database

    /**
     * Returns instance of the DBHelper. If the instance is not yet created,
     * new instance is created.
     * @param context Context for SQLiteOpenHelper constructor
     * @return Instance of DBHelper
     */
    public static DBHelper getInstance(Context context){
        if(dbHelper == null){
            dbHelper = new DBHelper(context.getApplicationContext());
        }
        return dbHelper;
    }

    //private constructor to prevent multiple instances
    private DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //****************************************   SQL CREATE TABLES   ****************************************

    //SQL commands to create tables

    private static final String SQL_CREATE_TABLE_INGREDIENT = "CREATE TABLE " +
            DBContract.Ingredient.TABLE_INGREDIENT + " (" +
            DBContract.Ingredient._ID + " INTEGER PRIMARY KEY," +
            DBContract.Ingredient.AMOUNT + " REAL," +
            DBContract.Ingredient.UNIT + " INTEGER," +
            DBContract.Ingredient.NAME + " TEXT)";

    private static final String SQL_CREATE_TABLE_RECIPE = "CREATE TABLE " +
            DBContract.Recipe.TABLE_RECIPE + " (" +
            DBContract.Recipe._ID + " INTEGER PRIMARY KEY," +
            DBContract.Recipe.NAME + " TEXT)";

    private static final String SQL_CREATE_TABLE_RECIPE_CAT = "CREATE TABLE " +
            DBContract.RecipeCategory.TABLE_RECIPE_CAT + " (" +
            DBContract.RecipeCategory._ID + " INTEGER PRIMARY KEY," +
            DBContract.RecipeCategory.NAME + " TEXT)";

    //Table connects each ingredient, recipe and category to each other,
    // so there are three foreign keys referencing each table
    private static final String SQL_CREATE_TABLE_RECIPES_TABLE = "CREATE TABLE "
            + DBContract.RecipesTable.TABLE_RECIPES_TABLE + " ("
            + DBContract.RecipesTable._ID + " INTEGER PRIMARY KEY,"

            + DBContract.RecipesTable.CAT_ID + " INTEGER"
            + " FOREIGN_KEY ("+DBContract.RecipesTable.CAT_ID+") "
            + "REFERENCES "+DBContract.RecipeCategory.TABLE_RECIPE_CAT+"("+DBContract.RecipeCategory._ID+"), "

            + DBContract.RecipesTable.RECIPE_ID + " INTEGER"
            + " FOREIGN_KEY ("+DBContract.RecipesTable.RECIPE_ID+") "
            + "REFERENCES "+DBContract.Recipe.TABLE_RECIPE+"("+DBContract.Recipe._ID+"), "

            + DBContract.RecipesTable.INGREDIENT_ID + " INTEGER"
            + " FOREIGN_KEY ("+DBContract.RecipesTable.INGREDIENT_ID+") "
            + "REFERENCES "+DBContract.Ingredient.TABLE_INGREDIENT+"("+DBContract.Ingredient._ID+"));";

    private static final String SQL_CREATE_TABLE_SHOP_ITEM = "CREATE TABLE " +
            DBContract.ShopItem.TABLE_SHOP_ITEM + " (" +
            DBContract.ShopItem._ID + " INTEGER PRIMARY KEY," +
            DBContract.ShopItem.NAME + " TEXT," +
            DBContract.ShopItem.SELECTED + " INTEGER)";

    private static final String SQL_CREATE_TABLE_SHOPPING_LIST = "CREATE TABLE " +
            DBContract.ShoppingList.TABLE_SHOPPING_LIST + " (" +
            DBContract.ShoppingList._ID + " INTEGER PRIMARY KEY," +
            DBContract.ShoppingList.NAME + " TEXT)";

    //Table connects each shop item to a shopping list,
    // so there are two foreign keys to each table
    private static final String SQL_CREATE_TABLE_SHOPPING_LISTS_TABLE = "CREATE TABLE " +
            DBContract.ShoppingListsTable.TABLE_SHOPPING_LISTS_TABLE + " ("
            + DBContract.ShoppingListsTable._ID + " INTEGER PRIMARY KEY,"

            + DBContract.ShoppingListsTable.SHOP_ITEM_ID + " INTEGER"
            + " FOREIGN_KEY ("+DBContract.ShoppingListsTable.SHOP_ITEM_ID+")"
            + " REFERENCES "+DBContract.ShopItem.TABLE_SHOP_ITEM+"("+DBContract.ShopItem._ID+"), "

            + DBContract.ShoppingListsTable.SHOPPING_LIST_ID + " INTEGER"
            + " FOREIGN_KEY ("+DBContract.ShoppingListsTable.SHOPPING_LIST_ID+")"
            + " REFERENCES "+DBContract.ShoppingList.TABLE_SHOPPING_LIST+"("+DBContract.ShoppingList._ID+"));";

    //****************************************   SQL DELETE TABLES   ****************************************

    //SQL commands to delete tables

    private static final String SQL_DELETE_TABLE_INGREDIENT = "DROP TABLE IF EXISTS "
            + DBContract.Ingredient.TABLE_INGREDIENT;
    private static final String SQL_DELETE_TABLE_RECIPE = "DROP TABLE IF EXISTS "
            + DBContract.Recipe.TABLE_RECIPE;
    private static final String SQL_DELETE_TABLE_RECIPE_CAT = "DROP TABLE IF EXISTS "
            + DBContract.RecipeCategory.TABLE_RECIPE_CAT;
    private static final String SQL_DELETE_TABLE_RECIPES_TABLE = "DROP TABLE IF EXISTS "
            + DBContract.RecipesTable.TABLE_RECIPES_TABLE;
    private static final String SQL_DELETE_TABLE_SHOP_ITEM = "DROP TABLE IF EXISTS "
            + DBContract.ShopItem.TABLE_SHOP_ITEM;
    private static final String SQL_DELETE_TABLE_SHOPPING_LIST = "DROP TABLE IF EXISTS "
            + DBContract.ShoppingList.TABLE_SHOPPING_LIST;
    private static final String SQL_DELETE_TABLE_SHOPPING_LISTS_TABLE = "DROP TABLE IF EXISTS "
            + DBContract.ShoppingListsTable.TABLE_SHOPPING_LISTS_TABLE;


    //**************************************** SQLiteOpenHelper Methods ****************************************

    //Enable foreign key support when configuring the database.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    //Creates database tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_INGREDIENT);
        db.execSQL(SQL_CREATE_TABLE_RECIPE);
        db.execSQL(SQL_CREATE_TABLE_RECIPE_CAT);
        db.execSQL(SQL_CREATE_TABLE_RECIPES_TABLE);
        db.execSQL(SQL_CREATE_TABLE_SHOP_ITEM);
        db.execSQL(SQL_CREATE_TABLE_SHOPPING_LIST);
        db.execSQL(SQL_CREATE_TABLE_SHOPPING_LISTS_TABLE);
    }

    //Drop tables and create new ones.
    //TODO If database version is increased, handle changes here.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.Ingredient.TABLE_INGREDIENT);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.Recipe.TABLE_RECIPE);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.RecipeCategory.TABLE_RECIPE_CAT);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.RecipesTable.TABLE_RECIPES_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.ShopItem.TABLE_SHOP_ITEM);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.ShoppingList.TABLE_SHOPPING_LIST);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.ShoppingListsTable.TABLE_SHOPPING_LISTS_TABLE);
        onCreate(db);
    }



    //****************************************************************************************************
    //                                      INSERT METHODS
    //****************************************************************************************************



    /**
     * Inserts new ingredient into ingredient and reference tables.
     * If first ingredient reference of recipe is null,
     * the value is replaced by new ingredient id.
     * Otherwise new row is inserted as usual.
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

        //values for reference table
        ContentValues values1 = new ContentValues();
        values1.put(DBContract.RecipesTable.INGREDIENT_ID, ingrID);
        String selection = DBContract.RecipesTable.RECIPE_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(recipeID)};

        Cursor cursor = readIngredientsInRecipe(recipeID);
        if(cursor.moveToFirst()){
            // if first reference ingredient is null,replace it with new ingredient id
            if(cursor.isNull(cursor.getColumnIndexOrThrow(
                    DBContract.RecipesTable.INGREDIENT_ID))){
                long rtID = db.update(DBContract.RecipesTable.TABLE_RECIPES_TABLE,
                        values1, selection, selectionArgs);
            }
            //if reference is not null, insert new row
            else{
                values1.put(DBContract.RecipesTable.RECIPE_ID, recipeID);
                //get recipe's category id
                Cursor c = readIngredientReference(recipeID);
                if(c.moveToFirst()){
                    long catID = c.getLong(c.getColumnIndexOrThrow(DBContract.RecipesTable.CAT_ID));
                    values1.put(DBContract.RecipesTable.CAT_ID, catID);
                }
                long rtID = db.insert(DBContract.RecipesTable.TABLE_RECIPES_TABLE, null, values1);
            }
        }
        return ingrID;
    }

    /**
     * Inserts new row into recipe and reference tables.
     * If recipe reference is null at category position,
     * null value is replaced with recipe id.
     * Otherwise new row is inserted as usual.
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

        //insert row into recipe table
        long recipeID = db.insert(DBContract.Recipe.TABLE_RECIPE, null, values);

        //values for reference table
        ContentValues values1 = new ContentValues();
        values1.put(DBContract.RecipesTable.RECIPE_ID, recipeID);
        String selection = DBContract.RecipesTable.CAT_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(categoryID)};

        Cursor cursor = readRecipeReferences(categoryID);
        if(cursor.moveToFirst()){
            //if first recipe reference is null, replace null value with recipe id
            if(cursor.isNull(cursor.getColumnIndexOrThrow(
                    DBContract.RecipesTable.RECIPE_ID))){
                int count = db.update(
                        DBContract.RecipesTable.TABLE_RECIPES_TABLE,
                        values1, selection, selectionArgs);
            }
            //if first reference is not null, insert new row
            else{
                values1.put(DBContract.RecipesTable.CAT_ID, categoryID);
                long rtID = db.insert(DBContract.RecipesTable.TABLE_RECIPES_TABLE, null, values1);
            }
        }

        return recipeID;
    }

    /**
     * Inserts new category into recipe category and reference tables.
     * References to recipe and ingredient are set to null.
     * @param name Recipe category name
     * @return row id of inserted category in recipe category table
     */
    public long insertRecipeCategory(String name){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.RecipeCategory.NAME, name);

        //insert row to recipe category table
        long rcID = db.insert(DBContract.RecipeCategory.TABLE_RECIPE_CAT, null, values);

        //put null values to ingredient and recipe, they are replaced when needed
        ContentValues values1 = new ContentValues();
        values1.put(DBContract.RecipesTable.CAT_ID, rcID);
        values1.putNull(DBContract.RecipesTable.INGREDIENT_ID);
        values1.putNull(DBContract.RecipesTable.RECIPE_ID);

        //insert row to reference table
        long rctID = db.insert(DBContract.RecipesTable.TABLE_RECIPES_TABLE, null, values1);

        return rcID;
    }

    /**
     * Inserts new item into shop items and reference tables.
     * If reference table contains a null reference at item's
     * list location, null value is replaced with item's row id.
     * Otherwise new item inserted to reference table as usual.
     * @param name shop item name
     * @param selected 1, if item is selected, 0 if unselected
     * @param listID row id of shopping list
     * @return row id of inserted item in shop item table
     */
    public long addShopItem(String name, Boolean selected, long listID){
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
        values1.put(DBContract.ShoppingListsTable.SHOP_ITEM_ID, siID);

        String selection = DBContract.ShoppingListsTable.SHOPPING_LIST_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(listID)};

        Cursor cursor = readShopItemReferences(listID);
        if(cursor.moveToFirst()){
            //if first item reference is null, update item id
            if(cursor.isNull(cursor.getColumnIndexOrThrow(
                    DBContract.ShoppingListsTable.SHOP_ITEM_ID))){
                db.update(
                        DBContract.ShoppingListsTable.TABLE_SHOPPING_LISTS_TABLE,
                        values1,
                        selection,
                        selectionArgs
                );
            }
            //if first item reference is not null, insert a new row
            else{
                values1.put(DBContract.ShoppingListsTable.SHOPPING_LIST_ID, listID);
                long sltID = db.insert(
                        DBContract.ShoppingListsTable.TABLE_SHOPPING_LISTS_TABLE,
                        null, values1);
            }
        }
        return siID;
    }

    /**
     * Inserts new shopping list to shopping list and reference tables.
     * New row in reference table will have null value at shop item id column.
     * @param name shopping list name
     * @return id of inserted row in shopping list table
     */
    public long addShoppingList(String name){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.ShoppingList.NAME, name);

        //insert new row into shopping list table
        long id = db.insert(DBContract.ShoppingList.TABLE_SHOPPING_LIST, null, values);

        ContentValues values1 = new ContentValues();
        //put first shop item reference to null and replace it later
        values1.putNull(DBContract.ShoppingListsTable.SHOP_ITEM_ID);
        values1.put(DBContract.ShoppingListsTable.SHOPPING_LIST_ID, id);

        //insert new row into reference table
        long id1 = db.insert(DBContract.ShoppingListsTable.TABLE_SHOPPING_LISTS_TABLE,
                null, values1);

        return id;
    }



    //****************************************************************************************************
    //                                      DELETE METHODS
    //****************************************************************************************************



    public void deleteIngredient(long rowID){
        SQLiteDatabase db = getWritableDatabase();

        //use rowID to select row in ingredient table
        String selection = DBContract.Ingredient._ID + " = ?";
        String[] selectionArgs = { String.valueOf(rowID)};

        //use rowID to select row in reference table
        String selection1 = DBContract.RecipesTable.INGREDIENT_ID + " = ?";
        String[] selectionArgs1 = { String.valueOf(rowID)};

        //delete ingredient row in both tables
        db.delete(DBContract.Ingredient.TABLE_INGREDIENT, selection, selectionArgs);
        db.delete(DBContract.RecipesTable.TABLE_RECIPES_TABLE, selection1, selectionArgs1);
    }

    /**
     * Deletes recipe and any ingredients referencing it from all tables.
     * @param rowID id of recipe being deleted
     */
    public void deleteRecipe(long rowID){
        SQLiteDatabase db = getWritableDatabase();

        //use rowID to select row in recipe table
        String selection = DBContract.Recipe._ID + " = ?";
        String[] selectionArgs = { String.valueOf(rowID)};

        //use rowID to select rows in reference table
        String selection1 = DBContract.RecipesTable.RECIPE_ID + " LIKE ?";
        String[] selectionArgs1 = { String.valueOf(rowID)};

        //get ingredients with reference to the recipe
        List itemIDs = new ArrayList();
        Cursor cursor = readIngredientsInRecipe(rowID);
        while(cursor.moveToNext()){
            itemIDs.add(cursor.getLong(
                    cursor.getColumnIndexOrThrow(DBContract.Ingredient._ID)));
        }
        cursor.close();

        //delete ingredients from ingredient table
        for(int i=0; itemIDs.size()>0; i++){
            deleteIngredient((long) itemIDs.get(i));
        }

        //delete recipe rows in both tables
        db.delete(DBContract.Recipe.TABLE_RECIPE, selection, selectionArgs);
        db.delete(DBContract.RecipesTable.TABLE_RECIPES_TABLE, selection1, selectionArgs1);
    }

    /**
     * Deletes a recipe category and reassigns any references into another category.
     * @param rowID id of category being deleted
     * @param newCatID id of category used as a new reference for
     *                 any recipes that were referencing the deleted category
     */
    public void deleteRecipeCategory(long rowID, long newCatID){
        SQLiteDatabase db = getWritableDatabase();

        //use rowID to select row in category table
        String selection = DBContract.RecipeCategory._ID + " = ?";
        String[] selectionArgs = { String.valueOf(rowID)};

        //reassign references to another category
        this.reassignCategory(rowID, newCatID);

        //delete category
        db.delete(DBContract.RecipeCategory.TABLE_RECIPE_CAT, selection, selectionArgs);
    }


    public void deleteShopItem(long rowID){
        SQLiteDatabase db = getWritableDatabase();

        //use rowID to select row in ingredient table
        String selection = DBContract.ShopItem._ID + " = ?";
        String[] selectionArgs = { String.valueOf(rowID)};

        //use rowID to select row in reference table
        String selection1 = DBContract.ShoppingListsTable.SHOP_ITEM_ID + " = ?";
        String[] selectionArgs1 = { String.valueOf(rowID)};

        //delete shop item row in both tables
        db.delete(DBContract.ShopItem.TABLE_SHOP_ITEM, selection, selectionArgs);
        db.delete(DBContract.ShoppingListsTable.TABLE_SHOPPING_LISTS_TABLE, selection1, selectionArgs1);
    }

    /**
     * Deletes shop list and any shop items referencing the list from all tables.
     * @param rowID id of shop list being deleted
     */
    public void deleteShoppingList(long rowID){
        SQLiteDatabase db = getWritableDatabase();

        //use rowID to select row in shopping list table
        String selection = DBContract.ShoppingList._ID + " = ?";
        String[] selectionArgs = { String.valueOf(rowID)};

        //use rowID to select rows in reference table
        String selection1 = DBContract.ShoppingListsTable.SHOPPING_LIST_ID + " LIKE ?";
        String[] selectionArgs1 = { String.valueOf(rowID)};

        //get all shop item ids in the shopping list
        List itemIDs = new ArrayList();
        Cursor cursor = readShopItemsInList(rowID);
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
        db.delete(DBContract.ShoppingListsTable.TABLE_SHOPPING_LISTS_TABLE, selection1, selectionArgs1);
    }



    //****************************************************************************************************
    //                                      READ METHODS
    //****************************************************************************************************



    public Cursor readIngredientsInRecipe(long recipeID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //select all ingredients with reference to recipe
        String selectQuery = "SELECT "
                + DBContract.Ingredient._ID + ", "
                + DBContract.Ingredient.AMOUNT + ", "
                + DBContract.Ingredient.NAME + ", "
                + DBContract.Ingredient.UNIT
                + "FROM " + DBContract.Ingredient.TABLE_INGREDIENT + "it, "
                + DBContract.RecipesTable.TABLE_RECIPES_TABLE + "rt"
                + "WHERE " + "rt." + DBContract.RecipesTable.RECIPE_ID + "= '" + Long.toString(recipeID) + "'"
                + "AND " + "rt." + DBContract.RecipesTable.INGREDIENT_ID + "= "
                + "ig." + DBContract.Ingredient._ID;

        //use raw query instead of normal query to join multiple tables
        return db.rawQuery(selectQuery, null);
    }

    public Cursor readRecipesInCat(long catID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //select all recipes with reference to category
        String selectQuery = "SELECT "
                + DBContract.Recipe._ID + ", "
                + DBContract.Recipe.NAME + ", "
                + DBContract.Recipe.INSTRUCTIONS
                + "FROM " + DBContract.Recipe.TABLE_RECIPE + "r, "
                + DBContract.RecipesTable.TABLE_RECIPES_TABLE + "rt"
                + "WHERE " + "rt." + DBContract.RecipesTable.CAT_ID + "= '" + Long.toString(catID) + "'"
                + "AND " + "rt." + DBContract.RecipesTable.RECIPE_ID + "= "
                + "r." + DBContract.Recipe._ID;

        //use raw query instead of normal query to join multiple tables
        return db.rawQuery(selectQuery, null);
    }

    public Cursor readAllRecipeCategories(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //select whole recipe category table
        String selectQuery = "SELECT "
                + DBContract.RecipeCategory._ID + ", "
                + DBContract.RecipeCategory.NAME + ", "
                + "FROM " + DBContract.RecipeCategory.TABLE_RECIPE_CAT;

        return db.rawQuery(selectQuery, null);
    }


    public Cursor readShopItemsInList(long shopListID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //select all shop items with reference shopListID
        String selectQuery = "SELECT "
                + DBContract.ShopItem._ID + ", "
                + DBContract.ShopItem.NAME + ", "
                + DBContract.ShopItem.SELECTED
                + "FROM " + DBContract.ShopItem.TABLE_SHOP_ITEM + "si, "
                + DBContract.ShoppingListsTable.TABLE_SHOPPING_LISTS_TABLE + "slt"
                + "WHERE slt." + DBContract.ShoppingListsTable.SHOPPING_LIST_ID
                + "= '" + Long.toString(shopListID) + "'"
                + "AND " + "slt." + DBContract.ShoppingListsTable.SHOP_ITEM_ID + "= "
                + "si." + DBContract.ShopItem._ID;

        //use raw query instead of normal query to join multiple tables
        return db.rawQuery(selectQuery, null);
    }


    public Cursor readAllShoppingLists(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //select whole shopping list table
        String selectQuery = "SELECT "
                + DBContract.ShoppingList._ID + ", "
                + DBContract.ShoppingList.NAME + ", "
                + "FROM " + DBContract.ShoppingList.TABLE_SHOPPING_LIST;

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

        String selection = DBContract.Ingredient._ID + "= ?";
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
    public Cursor readIngredientReference(long recipeID){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                DBContract.RecipesTable._ID,
                DBContract.RecipesTable.INGREDIENT_ID,
                DBContract.RecipesTable.CAT_ID
        };

        String selection = DBContract.RecipesTable.RECIPE_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(recipeID)};

        return db.query(
          DBContract.RecipesTable.TABLE_RECIPES_TABLE,
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
                DBContract.RecipesTable._ID,
                DBContract.RecipesTable.RECIPE_ID
        };

        String selection = DBContract.RecipesTable.CAT_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(catID)};

        return db.query(
                DBContract.RecipesTable.TABLE_RECIPES_TABLE,
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
                DBContract.ShoppingListsTable._ID,
                DBContract.ShoppingListsTable.SHOP_ITEM_ID
        };

        String selection = DBContract.ShoppingListsTable.SHOPPING_LIST_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(listID)};

        return db.query(
                DBContract.ShoppingListsTable.TABLE_SHOPPING_LISTS_TABLE,
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

        String selection = DBContract.ShoppingList._ID + "= ?";
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
        values.put(DBContract.RecipesTable.CAT_ID, newCatID);

        String selection = DBContract.RecipesTable.CAT_ID + " LIKE ?";
        String[] selectionArgs = { String.valueOf(catID) };

        //rows are updated but number of affected rows i is not used
        int i = db.update(DBContract.RecipesTable.TABLE_RECIPES_TABLE,
                values,
                selection,
                selectionArgs);
    }
}
