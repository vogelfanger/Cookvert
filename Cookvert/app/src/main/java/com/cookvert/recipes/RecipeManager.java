package com.cookvert.recipes;

import com.cookvert.recipes.model.Ingredient;
import com.cookvert.recipes.model.Recipe;
import com.cookvert.recipes.model.Unit;

import java.util.ArrayList;

/**
 * Control object responsible for maintaining and updating state data about recipes visible in UI.
 */
public class RecipeManager {

    private static RecipeManager manager = new RecipeManager();
    public ArrayList<Recipe> recipes;

    public static RecipeManager getInstance(){
        return manager;
    }


    /**
     * Private construction to prevent instantiation from outside
     * TODO import recipe list from database
     */
    private RecipeManager(){
        recipes = new ArrayList<Recipe>();
        recipes.add(new Recipe());
        recipes.get(0).name = "Mama's meatballs";
        recipes.get(0).getIngredients().add(new Ingredient(0.0, Unit.CUP_UK, "Minced meat"));
        recipes.add(new Recipe());
        recipes.get(1).name = "Papa's pizza";
    }
}
