package com.cookvert.conversion;

import android.content.Context;

import com.cookvert.R;
import com.cookvert.conversion.activities.ConvertActivity;
import com.cookvert.recipes.model.Ingredient;
import com.cookvert.recipes.model.Recipe;
import com.cookvert.recipes.model.Unit;
import com.cookvert.util.ResourceHelper;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.List;


/**
 * Contains all the actions that the conversion ui needs for the conversions.
 * This class also contains the temporary recipe objects that can be seen in the conversion view.
 * Transfers temporary objects to recipe and shopping list databases when necessary.
 * TODO decide which parts are static
 * TODO optimize by removing unnecessary getters and setters
 *
 */
public class ConvertManager {

    private static ConvertManager manager = new ConvertManager();
    private Recipe original;
    private Recipe converted;
    private Ingredient focusIngredient;
    private double multiplier; //used for scaling the recipe
    //TODO focus ingredient is too difficult to handle, use focusPosition instead
    private int focusPosition; // index of the focus ingredient
    private boolean focusInOriginal;
    private Context context;

    public static ConvertManager getInstance(){
        return manager;
    }

    private ConvertManager() {
        original = new Recipe();
        converted = new Recipe();
        initRecipes(); //add first elements to lists
        focusIngredient = original.getIngredients().get(0);
        focusPosition = 0;
        focusInOriginal = true;
        multiplier = 1;
    }

    public Recipe getOriginal() {
        return original;
    }

    public void setOriginal(Recipe original) {
        this.original = original;
    }

    public Recipe getConverted() {
        return converted;
    }

    public void setConverted(Recipe converted) {
        this.converted = converted;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public Ingredient getConvertedFocusIngredient() {
        return findIngredient(focusPosition, converted);
    }

    public Ingredient getOriginalFocusIngredient() {
        return findIngredient(focusPosition, original);
    }

    public void setFocusPosition(int focusPosition) {
        this.focusPosition = focusPosition;
    }

    public int getFocusPosition() {
        return focusPosition;
    }

    public void setContext(Context context){
        this.context = context;
    }

    //TODO use resource strings instead
    public void initRecipes(){
        original.getIngredients().add(new Ingredient(0, Unit.CUP_UK, "Tap to edit ingredient"));
        converted.getIngredients().add(new Ingredient(0, Unit.CUP_UK, "Tap to change unit"));
    }


    //*************************************************************************************************
    //*****                              CONVERSION METHODS                                       *****
    //*************************************************************************************************

    /**
 e   * Converts all ingredients in the recipe
     */
    public void convertRecipe(){
        for(int i=0; i<converted.getIngredients().size(); i++){
            convertIngredient(i);
        }
    }

    /**
     * Converts a single ingredient.
     * @param position Index of the ingredient in the recipe lists.
     * TODO Implement double rounding
     */
    public void convertIngredient(int position){
        Ingredient orig = findIngredient(position, original);
        Ingredient conv = findIngredient(position, converted);
        //use scaled amount in conversion so that multiplier is taken into account
        conv.setAmount(orig.getUnit().convert(conv.getUnit(), scaleIngredient(position)));
    }

    /**
     * Multiplies ingredient with the multiplier and returns the new amount.
     */
    public double scaleIngredient(int position){
        Ingredient orig = findIngredient(position, original);
        return orig.getAmount()*multiplier;
    }

    /**
     * Goes through the recipe lists and multiplies each ingredient amount by the multiplier.
     * Should be used only when the multiplier is changed. Use scaleIngredient() for a single ingredients.
     */
    public void scaleRecipe(){
        for (int i=0; i<converted.getIngredients().size(); i++){
            scaleIngredient(i); //multiply ingredient amount
        }
    }

    /**
     * Help method that finds an ingredient in a recipe.
     * @param index Position of the ingredient in the recipe.
     * @param recipe Recipe that the ingredient is searched from.
     * @return The ingredient.
     */
    public Ingredient findIngredient(int index, Recipe recipe){
        return recipe.getIngredients().get(index);
    }


    //****************************************************************************************************
    //*****                                     PUBLIC METHODS                                       *****
    //****************************************************************************************************

    /**
     * This should be called when a new ingredient is added to the original recipe.
     * @param amount
     * @param unitKey
     * @param name
     */
    public void addIngredient(double amount, int unitKey, String name){
        original.getIngredients().add(new Ingredient(amount, unitKey, name));
        converted.getIngredients().add(new Ingredient(amount, unitKey, name));
        //convert and scale the new ingredient to keep recipe lists updated
        convertIngredient(original.getIngredients().size()-1);
    }

    public void addIngredient(Ingredient ingredient){
        original.getIngredients().add(ingredient);
        converted.getIngredients().add(ingredient);
        //convert and scale the new ingredient in order to keep recipe lists updated
        convertIngredient(original.getIngredients().size()-1);
    }

    /**
     * Used when an ingredient in the original recipe list is modified.
     * Sets arguments for the focus ingredient
     * and performs conversion to keep the recipe lists updated.
     * @param amount New amount
     * @param unitType New unit
     * @param name New name
     */
    public void editIngredient(Double amount, int unitType, String name){
        findIngredient(focusPosition, original).setAmount(amount);
        findIngredient(focusPosition, original).assignUnit(unitType);
        findIngredient(focusPosition, original).setName(name);

        //set the name and unit for the same ingredient in converted recipe
        findIngredient(focusPosition, converted).setAmount(amount);
        findIngredient(focusPosition, converted).assignUnit(unitType);
        findIngredient(focusPosition, converted).setName(name);
        //convert and scale the ingredient in order to keep recipe lists updated
        convertIngredient(focusPosition);
    }

    /**
     * Used when a unit is changed in the converted recipe list.
     * Sets parameter unit for the focus ingredient
     * and performs conversion to keep the recipe lists updated.
     * @param unitType New unit
     */
    public void changeUnit(int unitType) {
        findIngredient(focusPosition, converted).assignUnit(unitType);
        //convert and scale the ingredient in order to keep recipe lists updated
        convertIngredient(focusPosition);
    }


    /**
     * This should be called when an ingredient is removed from the original recipe.
     * Removes an ingredient from original and converted at the focused position
     */
    public void deleteIngredient(){
        try {
            original.getIngredients().remove(focusPosition);
            converted.getIngredients().remove(focusPosition);
        } catch (NullPointerException e){}
    }

    public void changeMultiplier(double multiplier){
        this.multiplier = multiplier;
        convertRecipe(); //update the recipe data according to the new multiplier
    }

    public List<Ingredient> getOriginalIngredientList(){
        return original.getIngredients();
    }

    public List<Ingredient> getConvertedIngredientList(){
        return converted.getIngredients();
    }
}
