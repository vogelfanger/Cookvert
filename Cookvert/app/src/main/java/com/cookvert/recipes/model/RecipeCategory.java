package com.cookvert.recipes.model;

import java.util.ArrayList;

/**
 *
 */
public class RecipeCategory {

    public ArrayList<Recipe> recipes;
    public String name;

    public RecipeCategory(){
        recipes = new ArrayList<Recipe>();
        name = "";
    }
}
