package com.cookvert.recipes.model;

import android.support.annotation.NonNull;

import java.text.Collator;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a recipe containing ingredients and instructions.
 */
public class Recipe implements Comparable<Recipe>{

    private ArrayList<Ingredient> ingredients;
    public String instructions;
    public String name;
    private int id; //unique identifier, not stored in database

    public static AtomicInteger atomicInt = new AtomicInteger();

    public int getId() {
        return id;
    }

    public Recipe() {
        ingredients = new ArrayList<Ingredient>();
        instructions = "";
        name = "";
        this.id = atomicInt.incrementAndGet();
    }

    public Recipe(String name) {
        ingredients = new ArrayList<Ingredient>();
        instructions = "";
        this.name = name;
        this.id = atomicInt.incrementAndGet();
    }

    public Recipe(String name, String instructions) {
        this.instructions = instructions;
        this.name = name;
        ingredients = new ArrayList<Ingredient>();
        this.id = atomicInt.incrementAndGet();
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //*********** METHODS ***********

    @Override
    public int compareTo(@NonNull Recipe recipe) {
        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);
        return collator.compare(this.name, recipe.name);
    }
}
