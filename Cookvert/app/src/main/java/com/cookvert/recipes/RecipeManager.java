package com.cookvert.recipes;

import com.cookvert.recipes.model.Ingredient;
import com.cookvert.recipes.model.Recipe;
import com.cookvert.recipes.model.RecipeCategory;
import com.cookvert.recipes.model.Unit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Control object responsible for maintaining and updating recipes in UI.
 * TODO implement database interaction for all methods dealing with recipe data
 */
public class RecipeManager {

    //Argument key for trasaction between RecipesActivity and EditRecipeActivity
    public static final String ARG_SELECTED_RECIPE_POSITION = "selectedRecipePosition";
    public static final String ARG_SELECTED_CATEGORY_POSITION = "selectedCategoryPosition";
    //Argument key for importing recipe instructions from EditRecipeActivity to ConvertActivity
    public static final String ARG_RECIPE_INSTRUCTIONS = "recipeInstructions";

    private static RecipeManager manager = new RecipeManager();
    public ArrayList<RecipeCategory> recipeCategories;
    public RecipeCategory uncategorized; //recipes uncategorized by the user
    public int focusCategory; //index of the category currently in focus
    public int focusRecipe; //index of the recipe currently in focus
    public int focusIngredient; //index of the ingredient currently in focus

    public static RecipeManager getInstance(){
        return manager;
    }


    /**
     * Private constructor to prevent instantiation
     * TODO import recipe list from database and remove test recipes
     */
    private RecipeManager(){
        recipeCategories = new ArrayList<RecipeCategory>();
        recipeCategories.add(new RecipeCategory());
        recipeCategories.get(0).name = "Italian food";
        recipeCategories.get(0).recipes.add(new Recipe());
        recipeCategories.get(0).recipes.get(0).name = "Mama's meatballs";
        recipeCategories.get(0).recipes.get(0).getIngredients().add(new Ingredient(0.0, Unit.CUP_UK, "Tap to edit ingredient (mama)"));
        recipeCategories.get(0).recipes.add(new Recipe());
        recipeCategories.get(0).recipes.get(1).name = "Papa's pizza";
        recipeCategories.get(0).recipes.get(1).getIngredients().add(new Ingredient(0.0, Unit.CUP_UK, "Tap to edit ingredient (papa)"));
        recipeCategories.add(new RecipeCategory());
        recipeCategories.get(1).name = "Chinese food";
        recipeCategories.get(1).recipes.add(new Recipe());
        recipeCategories.get(1).recipes.get(0).name = "Kung Pao Chicken";
        recipeCategories.get(1).recipes.get(0).getIngredients().add(new Ingredient(0.0, Unit.CUP_UK, "Tap to edit ingredient (kung)"));
        //TODO use resource string instead
        recipeCategories.add(new RecipeCategory("UNCATEGORIZED"));
        uncategorized = recipeCategories.get(recipeCategories.size()-1);

        sortRecipes();
        focusCategory = 0;
        focusRecipe = 0;
        focusIngredient = 0;

    }

    public void addCategory(String name){
        recipeCategories.add(new RecipeCategory(name));
        sortRecipes(); //sort recipe list to keep it in alphabetical order
    }

    public void addIngredient(double amount, int unitKey, String name){
        getFocusedRecipe().getIngredients().add(new Ingredient(amount, unitKey, name));
    }

    public void addRecipe(String name, int categoryPosition){
        Recipe recipe = new Recipe(name);
        focusCategory = categoryPosition; //put focus to new category
        recipeCategories.get(focusCategory).recipes.add(recipe);
        sortRecipes(); //sort recipe list to keep it in alphabetical order
        //get new recipe position and set to focus
        focusRecipe = recipeCategories.get(focusCategory).recipes.indexOf(recipe);
    }

    /**
     * Changes the category of focused recipe to given one in given position.
     * @param position Position of new category
     */
    public void changeCategory(int position){
        Recipe recipe = getFocusedRecipe();
        //remove focused recipe from current category
        recipeCategories.get(focusCategory).recipes.remove(focusRecipe);
        //add recipe to new category
        recipeCategories.get(position).recipes.add(recipe);
        //sort lists in case alphabetical order was changed
        sortRecipes();
    }

    public void deleteCategory(){
        RecipeCategory focusRC = recipeCategories.get(focusCategory);
        //skip uncategorized list
        //TODO this should result in a Toast
        if(focusRC == uncategorized){
            return;
        }else{
            //Move recipes to uncategorized list before removing the category
            for(Recipe r : focusRC.recipes){
                uncategorized.recipes.add(r);
            }
            recipeCategories.remove(focusCategory);
        }

    }

    public void deleteIngredient(){
        getFocusedRecipe().getIngredients().remove(focusIngredient);
    }

    public void deleteRecipe() {
        recipeCategories.get(focusCategory).recipes.remove(focusRecipe);
    }

    public void editCategory(String name) {
        recipeCategories.get(focusCategory).name = name;
    }

    public void editIngredient(double amount, int unitKey, String name){
        getFocusedIngredient().setAmount(amount);
        getFocusedIngredient().assignUnit(unitKey);
        getFocusedIngredient().setName(name);
    }

    /**
     * Replaces focused recipe's instructions with given parameter
     * @param instructions New instruction String for focused Recipe
     */
    public void editInstructions(String instructions){
        getFocusedRecipe().instructions = instructions;
    }

    /**
     * Replaces focused recipe's name with given parameter
     * @param name New recipe name
     */
    public void renameRecipe(String name){
        getFocusedRecipe().name = name;
    }

    /**
     * Returns an Arraylist containing names of each category.
     * @return list of names
     */
    public ArrayList<String> getCategoryNames(){
        ArrayList<String> list = new ArrayList<String>();
        for(RecipeCategory rc : recipeCategories){
            list.add(rc.name);
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
