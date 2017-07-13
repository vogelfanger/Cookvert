package com.cookvert.recipes.model;

import android.support.annotation.NonNull;

import java.text.Collator;
import java.util.ArrayList;

/**
 * Represents a recipe containing ingredients and instructions.
 */
public class Recipe implements Comparable<Recipe>{

    private ArrayList<Ingredient> ingredients;
    public String instructions;
    public String name;

    public Recipe() {
        ingredients = new ArrayList<Ingredient>();
        instructions = "";
        name = "";
    }

    public Recipe(String name) {
        ingredients = new ArrayList<Ingredient>();
        instructions = "";
        this.name = name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    //*********** METHODS ***********

    @Override
    public int compareTo(@NonNull Recipe recipe) {
        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);
        return collator.compare(this.name, recipe.name);
    }
}
