package com.cookvert.recipes.model;

import java.util.ArrayList;

/**
 * Represents a recipe containing ingredients and instructions.
 */
public class Recipe {

    private ArrayList<Ingredient> ingredients;
    private ArrayList<String> instructions;
    public String name;

    public Recipe() {
        ingredients = new ArrayList<Ingredient>();
        instructions = new ArrayList<String>();
        name = "";
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<String> instructions) {
        this.instructions = instructions;
    }

    //*********** METHODS ***********

}
