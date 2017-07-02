package com.cookvert.recipes;

import com.cookvert.recipes.model.Ingredient;
import com.cookvert.recipes.model.Recipe;
import com.cookvert.recipes.model.RecipeCategory;
import com.cookvert.recipes.model.Unit;

import java.util.ArrayList;

/**
 * Control object responsible for maintaining and updating state data about recipes visible in UI.
 */
public class RecipeManager {

    private static RecipeManager manager = new RecipeManager();
    public ArrayList<RecipeCategory> recipeCategories;
    public int focusCategory; //index of the category currently in focus
    public int focusRecipe; //index of the recipe currently in focus
    public int focusIngredient; //index of the ingredient currently in focus

    public static RecipeManager getInstance(){
        return manager;
    }


    /**
     * Private construction to prevent instantiation from outside
     * TODO import recipe list from database
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

        focusCategory = 0;
        focusRecipe = 0;
        focusIngredient = 0;
    }

    public void addIngredient(double amount, int unitKey, String name){
        getFocusedRecipe().getIngredients().add(new Ingredient(amount, unitKey, name));
    }

    public void deleteIngredient(){
        getFocusedRecipe().getIngredients().remove(focusIngredient);
    }

    public void editIngredient(double amount, int unitKey, String name){
        getFocusedIngredient().setAmount(amount);
        getFocusedIngredient().assignUnit(unitKey);
        getFocusedIngredient().setName(name);
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
}
