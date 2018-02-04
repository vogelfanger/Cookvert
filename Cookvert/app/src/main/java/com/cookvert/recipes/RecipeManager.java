package com.cookvert.recipes;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.cookvert.data.DBContract;
import com.cookvert.data.DBHelper;
import com.cookvert.data.GoogleDriveManager;
import com.cookvert.recipes.model.Ingredient;
import com.cookvert.recipes.model.Recipe;
import com.cookvert.recipes.model.RecipeCategory;
import com.cookvert.shoppinglist.model.ShopItem;
import com.cookvert.shoppinglist.model.ShopList;
import com.cookvert.util.Cookvert;
import com.cookvert.util.ResourceHelper;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Control object responsible for maintaining and updating recipes in UI.
 */
public class RecipeManager {

    //Argument key for transaction between RecipesActivity and EditRecipeActivity
    public static final String ARG_SELECTED_RECIPE_POSITION = "selectedRecipePosition";
    public static final String ARG_SELECTED_CATEGORY_POSITION = "selectedCategoryPosition";
    //Argument key for importing recipe instructions from EditRecipeActivity to ConvertActivity
    public static final String ARG_RECIPE_INSTRUCTIONS = "recipeInstructions";

    public static final String LOG_TAG = "RecipeManager"; // tag for Log entries

    private static RecipeManager manager = new RecipeManager();
    public ArrayList<RecipeCategory> recipeCategories;
    public RecipeCategory uncategorized; //recipes uncategorized by the user
    public int focusCategory; //index of the category currently in focus
    public int focusRecipe; //index of the recipe currently in focus
    public int focusIngredient; //index of the ingredient currently in focus

    private ArrayList<Recipe> allRecipes;

    //maps connecting object ids to primary keys in database.
    private HashMap<Integer, Long> categoryMap;
    private HashMap<Integer, Long> ingredientMap;
    private HashMap<Integer, Long> recipeMap;

    public static RecipeManager getInstance(){
        return manager;
    }

    public ArrayList<RecipeCategory> getRecipeCategories() {
        return recipeCategories;
    }

    public void setRecipeCategories(ArrayList<RecipeCategory> recipeCategories) {
        this.recipeCategories = recipeCategories;
    }

    public RecipeCategory getUncategorized() {
        return uncategorized;
    }

    public void setUncategorized(RecipeCategory uncategorized) {
        this.uncategorized = uncategorized;
    }

    public int getFocusCategory() {
        return focusCategory;
    }

    public void setFocusCategory(int focusCategory) {
        this.focusCategory = focusCategory;
    }

    public int getFocusRecipe() {
        return focusRecipe;
    }

    public void setFocusRecipe(int focusRecipe) {
        this.focusRecipe = focusRecipe;
    }

    public int getFocusIngredient() {
        return focusIngredient;
    }

    public void setFocusIngredient(int focusIngredient) {
        this.focusIngredient = focusIngredient;
    }

    public HashMap<Integer, Long> getCategoryMap() {
        return categoryMap;
    }

    public void setCategoryMap(HashMap<Integer, Long> categoryMap) {
        this.categoryMap = categoryMap;
    }

    public HashMap<Integer, Long> getIngredientMap() {
        return ingredientMap;
    }

    public void setIngredientMap(HashMap<Integer, Long> ingredientMap) {
        this.ingredientMap = ingredientMap;
    }

    public HashMap<Integer, Long> getRecipeMap() {
        return recipeMap;
    }

    public void setRecipeMap(HashMap<Integer, Long> recipeMap) {
        this.recipeMap = recipeMap;
    }

    public ArrayList<Recipe> getAllRecipes() {
        return allRecipes;
    }

    /**
     * Private constructor to prevent instantiation
     */
    private RecipeManager(){
        recipeCategories = new ArrayList<RecipeCategory>();
        categoryMap = new HashMap<>();
        ingredientMap = new HashMap<>();
        recipeMap = new HashMap<>();

        // read categories from database to manager list
        readCategoriesFromDB();

        // read recipes for each category
        for(RecipeCategory rc : recipeCategories){
            readRecipesFromDB(rc);

            // read ingredients for each recipe
            for(Recipe r : rc.getRecipes()){
                readIngredientsFromDB(r);
            }
        }

        sortRecipes();
        focusCategory = 0;
        focusRecipe = 0;
        focusIngredient = 0;

        // this is filled only when needed
        allRecipes = new ArrayList<Recipe>();
    }



    //****************************************************************************************************
    //                                      PUBLIC METHODS
    //****************************************************************************************************



    /**
     * Creates a new recipe category, adds it to category list, sorts the list,
     * inserts the new category into database and adds primary key to category map.
     * @param name recipe category name
     */
    public void addCategory(String name){
        RecipeCategory rc = new RecipeCategory(name);
        recipeCategories.add(rc);
        sortRecipes(); //sort recipe list to keep it in alphabetical order

        //insert new category to database
        long dbID = DBHelper.getInstance(Cookvert.getAppContext()).insertRecipeCategory(name);
        //put category primary key to map
        categoryMap.put(rc.getId(), dbID);
        sortRecipes();
    }

    /**
     * Creates new ingredient, adds it to ingredient list,
     * inserts the ingredient into database and puts primary key to ingredient map.
     * @param amount ingredient amount
     * @param unitKey ingredient unit
     * @param name ingredient name
     */
    public void addIngredient(double amount, int unitKey, String name){
        Ingredient ingredient = new Ingredient(amount, unitKey, name);
        getFocusedRecipe().getIngredients().add(ingredient);

        int recipeID = getFocusedRecipe().getId();
        long recipeDbID = recipeMap.get(recipeID);
        //insert new ingredient to database
        long dbID = DBHelper.getInstance(Cookvert.getAppContext()).insertIngredient(
                amount, name, unitKey, recipeDbID);
        ingredientMap.put(ingredient.getId(), dbID);

    }

    /**
     * Creates a new recipe, adds it to recipe list, sorts recipes,
     * inserts recipe into database and puts primary key to recipe map.
     * @param name recipe name
     * @param categoryPosition recipe's parent category index in category list
     */
    public void addRecipe(String name, int categoryPosition){
        Recipe recipe = new Recipe(name);
        focusCategory = categoryPosition; //put focus to new category
        recipeCategories.get(focusCategory).recipes.add(recipe);
        sortRecipes(); //sort recipe list to keep it in alphabetical order
        //get new recipe position and set to focus
        focusRecipe = recipeCategories.get(focusCategory).recipes.indexOf(recipe);

        int catID = recipeCategories.get(focusCategory).getId();
        long catDbID = categoryMap.get(catID);
        //insert new recipe to database
        long dbID = DBHelper.getInstance(Cookvert.getAppContext()).insertRecipe(
                name, recipe.getInstructions(), catDbID);
        //put recipe primary key to map
        recipeMap.put(recipe.getId(), dbID);
    }

    /**
     * Changes the category of focused recipe to one in given position
     * and updates changes to database.
     * @param position Position of new category
     */
    public void changeCategory(int position){
        Recipe recipe = getFocusedRecipe();
        //remove focused recipe from current category
        recipeCategories.get(focusCategory).recipes.remove(focusRecipe);
        //add recipe to new category
        recipeCategories.get(position).recipes.add(recipe);
        // update focus
        focusCategory = position;
        focusRecipe = recipeCategories.get(position).getRecipes().indexOf(recipe);
        //sort lists in case alphabetical order was changed
        sortRecipes();

        //get primary keys for database access
        long recipeDbID = recipeMap.get(recipe.getId());
        long categoryDbID = categoryMap.get(recipeCategories.get(position).getId());

        //update new category for the recipe
        DBHelper.getInstance(Cookvert.getAppContext()).updateRecipeReference(recipeDbID, categoryDbID);
    }

    /**
     * If focused category is not uncategorized, deletes the category and reassigns
     * all contained recipes to uncategorized category.
     * Changes are made in both manager lists and the database.
     */
    public void deleteCategory(){
        RecipeCategory focusRC = recipeCategories.get(focusCategory);
        //skip uncategorized list
        if(focusRC == uncategorized){
            return;
        }else{
            //Move recipes to uncategorized list before removing the category
            for(Recipe r : focusRC.recipes){
                uncategorized.recipes.add(r);
            }
            //get category primary keys for database access
            long catDbID = categoryMap.get(focusRC.getId());
            long uncategorizedDbID = categoryMap.get(uncategorized.getId());

            //delete category from database and manager list
            DBHelper.getInstance(Cookvert.getAppContext()).deleteRecipeCategory(
                    catDbID, uncategorizedDbID);
            recipeCategories.remove(focusCategory);
        }
    }

    /**
     * Deletes ingredient from manager lists and the database.
     */
    public void deleteIngredient(){
        long dbID = ingredientMap.get(getFocusedIngredient().getId());
        DBHelper.getInstance(Cookvert.getAppContext()).deleteIngredient(dbID);
        getFocusedRecipe().getIngredients().remove(focusIngredient);
    }

    /**
     * Deletes recipe from manager lists and the database.
     */
    public void deleteRecipe() {
        long dbID = recipeMap.get(getFocusedRecipe().getId());
        DBHelper.getInstance(Cookvert.getAppContext()).deleteRecipe(dbID);
        recipeCategories.get(focusCategory).recipes.remove(focusRecipe);
    }

    /**
     * Updates focused category data in manager lists and the database.
     * @param name
     */
    public void editCategory(String name) {
        recipeCategories.get(focusCategory).name = name;
        long dbID = categoryMap.get(recipeCategories.get(focusCategory).getId());
        DBHelper.getInstance(Cookvert.getAppContext()).updateRecipeCategory(name, dbID);
        sortRecipes();
    }

    /**
     * Updates focused ingredient data in manager lists and the database
     * @param amount new ingredient amount
     * @param unitKey new ingredient unit
     * @param name new ingredient name
     */
    public void editIngredient(double amount, int unitKey, String name){
        getFocusedIngredient().setAmount(amount);
        getFocusedIngredient().assignUnit(unitKey);
        getFocusedIngredient().setName(name);

        //get ingredient primary key and update database
        long dbID = ingredientMap.get(getFocusedIngredient().getId());
        DBHelper.getInstance(Cookvert.getAppContext()).updateIngredient(
                amount, name, unitKey, dbID);
    }

    /**
     * Updates recipe instructions in manager lists and the database
     * @param instructions New instruction String for focused Recipe
     */
    public void editInstructions(String instructions){
        getFocusedRecipe().setInstructions(instructions);

        //get recipe primary key and update database
        long dbID = recipeMap.get(getFocusedRecipe().getId());
        DBHelper.getInstance(Cookvert.getAppContext()).updateRecipe(
                getFocusedRecipe().getName(), instructions, dbID);
    }

    public ShopList exportAsShopList(Context context, String name){
        ShopList list = new ShopList(name);
        String itemName;
        for(Ingredient i : getFocusedRecipe().getIngredients()){
            // add new shop item using ingredient data for new objects
            itemName = Ingredient.roundAmount(i.getAmount()) + "  "
                    + ResourceHelper.getStringFromRes(context, i.getUnit().getRes()) + "  "
                    + i.getName();
            list.getItems().add(new ShopItem(itemName));
        }
        return list;
    }

    public void importRecipe(Recipe recipe){
        int categoryIndex = recipeCategories.indexOf(uncategorized);
        // add recipe to database
        addRecipe(recipe.getName(), categoryIndex);
        // add each ingredient to database
        for(Ingredient i : recipe.getIngredients()){
            addIngredient(i.getAmount(), i.getUnit().getUnitKey(), i.getName());
        }
        GoogleDriveManager.getInstance().setUnsavedData(true);
    }

    /**
     * Updates recipe name to manager lists and the database.
     * @param name new recipe name
     */
    public void renameRecipe(String name){
        getFocusedRecipe().setName(name);
        long dbID = recipeMap.get(getFocusedRecipe().getId());
        DBHelper.getInstance(Cookvert.getAppContext()).updateRecipe(
                name, getFocusedRecipe().getInstructions(), dbID);
        sortRecipes();
    }

    /**
     * Reads all recipe categories from database, creates new objects,
     * adds them to manager list and puts primary keys to map.
     */
    public void readCategoriesFromDB(){
        Cursor cursor = DBHelper.getInstance(Cookvert.getAppContext()).readAllRecipeCategories();

        String nameArg;
        long idArg;
        RecipeCategory rc;

        while(cursor.moveToNext()){
            //read primary key and name from database
            idArg = cursor.getLong(
                    cursor.getColumnIndexOrThrow(DBContract.RecipeCategory._ID));
            nameArg = cursor.getString(
                    cursor.getColumnIndexOrThrow(DBContract.RecipeCategory.NAME));

            //create new recipe category and put primary key into map
            rc = new RecipeCategory(nameArg);
            recipeCategories.add(rc);
            categoryMap.put(rc.getId(), idArg);

            //set reference to uncategorized category object
            if(idArg == 1){
                uncategorized = rc;
            }
        }
        cursor.close();

        Log.d(LOG_TAG, "categories were read successfully from db, num of categories:"
                + String.valueOf(recipeCategories.size()));
    }

    /**
     * Reads ingredients contained in a recipe from the database,
     * creates new ingredient objects, adds them to manager lists
     * and puts primary keys into map.
     * @param recipe recipe from which ingredients are read
     */
    public void readIngredientsFromDB(Recipe recipe){
        long dbID = recipeMap.get(recipe.getId());
        Cursor cursor = DBHelper.getInstance(Cookvert.getAppContext()).readIngredientsInRecipe(dbID);

        double amountArg;
        String nameArg;
        int unitArg;
        long idArg;
        Ingredient ingredient;

        while(cursor.moveToNext()){
            //read primary key and other ingredient data from database
            idArg = cursor.getLong(
                    cursor.getColumnIndexOrThrow(DBContract.Ingredient._ID));
            amountArg = cursor.getDouble(
                    cursor.getColumnIndexOrThrow(DBContract.Ingredient.AMOUNT));
            nameArg = cursor.getString(
                    cursor.getColumnIndexOrThrow(DBContract.Ingredient.NAME));
            unitArg = cursor.getInt(
                    cursor.getColumnIndexOrThrow(DBContract.Ingredient.UNIT));

            ingredient = new Ingredient(amountArg, unitArg, nameArg);
            recipe.getIngredients().add(ingredient);
            ingredientMap.put(ingredient.getId(), idArg);
        }
        cursor.close();

        Log.d(LOG_TAG, "ingredients were read successfully from recipe, num of ingredients:"
                + String.valueOf(recipe.getIngredients().size()));
    }

    /**
     * Reads recipes contained in a category from the database,
     * creates new recipe objects, adds them to manager lists and
     * puts primary keys into map.
     * @param rc recipe category, from which recipes are read.
     */
    public void readRecipesFromDB(RecipeCategory rc){
        long dbID = categoryMap.get(rc.getId());
        Cursor cursor = DBHelper.getInstance(Cookvert.getAppContext()).readRecipesInCat(dbID);

        String nameArg;
        String instructionsArg;
        long idArg;
        Recipe recipe;

        while(cursor.moveToNext()){
            //read primary key, name and instructions from database
            idArg = cursor.getLong(
                    cursor.getColumnIndexOrThrow(DBContract.Recipe._ID));
            nameArg = cursor.getString(
                    cursor.getColumnIndexOrThrow(DBContract.Recipe.NAME));
            instructionsArg = cursor.getString(
                    cursor.getColumnIndexOrThrow(DBContract.Recipe.INSTRUCTIONS));

            //create new recipe and put primary key into map
            recipe = new Recipe(nameArg, instructionsArg);
            rc.getRecipes().add(recipe);
            recipeMap.put(recipe.getId(), idArg);
        }
        cursor.close();
        Log.d(LOG_TAG, "recipes were read successfully from cat, num of recipes:"
                + String.valueOf(rc.getRecipes().size()));
    }

    /**
     * Returns true, if currently focused category is the uncategorized one.
     * @return true, if focused category is uncategorized, otherwise false
     */
    public boolean focusOnUncategorized(){
        if(focusCategory == recipeCategories.indexOf(uncategorized)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Creates a list of all recipes and eturns an ArrayList containing names of each category.
     * @return list of names
     */
    public ArrayList<String> getCategoryNames(){
        ArrayList<String> list = new ArrayList<String>();
        for(RecipeCategory rc : recipeCategories){
            list.add(rc.getName());
        }
        return list;
    }

    /**
     * Help method that returns the recipe currently in focus
     * @return focused Recipe
     */
    public Recipe getFocusedRecipe(){
        return recipeCategories.get(focusCategory).recipes.get(focusRecipe);
    }

    /**
     * Help method that returns the ingredient currently in focus
     * @return focused Ingredient
     */
    public Ingredient getFocusedIngredient(){
        return recipeCategories.get(focusCategory).recipes.get(focusRecipe).getIngredients().get(focusIngredient);
    }

    /**
     * Creates a list of all recipes from all categories, sorts it in alphabetical order
     * and returns a list containing all recipe names.
     * Corresponding list of Recipe objects is kept in manager.
     * @return List of recipe names
     */
    public ArrayList<String> listAllRecipes(){
        ArrayList<String> list = new ArrayList<String>();
        // create a new list to erase any old data
        allRecipes = new ArrayList<Recipe>();

        for(RecipeCategory rc : recipeCategories){
            for(Recipe r : rc.getRecipes()){
                list.add(r.getName());
                allRecipes.add(r);
            }
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                Collator collator = Collator.getInstance();
                collator.setStrength(Collator.PRIMARY);
                return collator.compare(s, t1);
            }
        });
        Collections.sort(allRecipes);
        return list;
    }

    /**
     * Sorts recipe categories and recipes to alphabetical order. Uncategorized recipes are put to last.
     */
    public void sortRecipes(){
        Collections.sort(recipeCategories);
        //move uncategorized recipes to bottom of the list
        recipeCategories.remove(uncategorized);
        recipeCategories.add(uncategorized);
        for(RecipeCategory rc : recipeCategories){
            Collections.sort(rc.recipes);
        }
    }
}
