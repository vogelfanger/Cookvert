package com.cookvert.recipes.model;

import android.support.annotation.NonNull;

import java.text.CollationKey;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class RecipeCategory implements Comparable<RecipeCategory> {

    public ArrayList<Recipe> recipes;
    public String name;

    private int id; //unique identifier, not stored in database

    public static AtomicInteger atomicInt = new AtomicInteger();

    public RecipeCategory(){
        recipes = new ArrayList<Recipe>();
        name = "";
        this.id = atomicInt.incrementAndGet();
    }

    public RecipeCategory(String name){
        recipes = new ArrayList<Recipe>();
        this.name = name;
        this.id = atomicInt.incrementAndGet();
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(@NonNull RecipeCategory rc) {
        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);
        return collator.compare(this.name, rc.name);
    }
}
