package com.cookvert.conversion;

import android.content.Context;
import android.content.Intent;

import com.cookvert.R;
import com.cookvert.conversion.activities.ConvertActivity;
import com.cookvert.recipes.RecipeManager;
import com.cookvert.recipes.model.Ingredient;
import com.cookvert.recipes.model.Recipe;
import com.cookvert.recipes.model.Unit;
import com.cookvert.shoppinglist.model.ShopItem;
import com.cookvert.shoppinglist.model.ShopList;
import com.cookvert.util.ResourceHelper;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;


/**
 * Contains all the actions that the conversion ui needs for the conversions.
 * This class also contains the temporary recipe objects that can be seen in the conversion view.
 * Transfers temporary objects to recipe and shopping list databases when necessary.
 *
 */
public class ConvertManager {

    private static ConvertManager manager = new ConvertManager();
    public Recipe original;
    public Recipe converted;
    private double multiplier; //used for scaling the recipe
    public int focusPosition; // index of the focus ingredient

    private Ingredient originalTemperature;
    private Ingredient convertedTemperature;

    public static ConvertManager getInstance(){
        return manager;
    }

    private ConvertManager() {
        original = new Recipe();
        converted = new Recipe();
        initRecipes(); //add first elements to lists
        focusPosition = 0;
        multiplier = 1;
        originalTemperature = new Ingredient(0, Unit.CELSIUS, "");
        convertedTemperature = new Ingredient(0, Unit.FAHRENHEIT, "");
        convertTemperature();
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

    public Ingredient getOriginalTemperature() {
        return originalTemperature;
    }

    public void setOriginalTemperature(Ingredient originalTemperature) {
        this.originalTemperature = originalTemperature;
    }

    public Ingredient getConvertedTemperature() {
        return convertedTemperature;
    }

    public void setConvertedTemperature(Ingredient convertedTemperature) {
        this.convertedTemperature = convertedTemperature;
    }

    //TODO use resource strings instead
    public void initRecipes(){
        original.getIngredients().add(new Ingredient(0, Unit.CUP_UK, "Tap to edit ingredient"));
        converted.getIngredients().add(new Ingredient(0, Unit.CUP_UK, "Tap to change unit"));
    }


    //*************************************************************************************************
    //                                   CONVERSION METHODS
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
     */
    public void convertIngredient(int position) {
        Ingredient orig = findIngredient(position, original);
        Ingredient conv = findIngredient(position, converted);
        //use scaled amount in conversion so that multiplier is taken into account
        conv.setAmount(orig.getUnit().convert(conv.getUnit(), scaleIngredient(position)));
    }

    /**
     * Sets new value for converted temperature amount by running a conversion.
     */
    public void convertTemperature(){
        convertedTemperature.setAmount(originalTemperature.getUnit().convert(
                convertedTemperature.getUnit(), originalTemperature.getAmount()));
    }

    /**
     * Multiplies ingredient with the multiplier and returns the new amount.
     */
    public double scaleIngredient(int position){
        Ingredient orig = findIngredient(position, original);
        return orig.getAmount()*multiplier;
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
    //                                          PUBLIC METHODS
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

    public void changeMultiplier(double multiplier){
        this.multiplier = multiplier;
        convertRecipe(); //update the recipe data according to the new multiplier
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

    public void deleteAllIngredients(){
        for(int i=0; i<original.getIngredients().size(); i++){
            original.getIngredients().remove(i);
            converted.getIngredients().remove(i);
        }
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
     * Sets new amount for original temperature and converts it.
     * If given amount is lower than absolute zero temperature,
     * absolute zero temperature is used instead.
     * @param amount new temperature amount
     */
    public void editTemperature(double amount){
        if(originalTemperature.getUnit() == Unit.CELSIUS && amount < -271.15){
            amount = -271.15;
        }else if(originalTemperature.getUnit() == Unit.FAHRENHEIT && amount < -459.67){
            amount = -459.67;
        }
        originalTemperature.setAmount(amount);
        convertTemperature();
    }

    /**
     * Sets new unit for original and converted temperatures and runs a conversion.
     * Converted temperature is always different from original.
     * @param unit new temperature unit
     */
    public void editTemperature(Unit unit){
        originalTemperature.setUnit(unit);
        if(unit == Unit.CELSIUS){
            convertedTemperature.setUnit(Unit.FAHRENHEIT);
        }else{
            convertedTemperature.setUnit(Unit.CELSIUS);
        }
        convertTemperature();
    }

    /**
     * Returns copy of a Recipe used in manager.
     * @param name Recipe name
     * @param useOriginal If true, ingredients are copied from original recipe.
     *                    If false, ingredients are copied from converted recipe.
     * @return New Recipe object
     */
    public Recipe exportAsRecipe(String name, boolean useOriginal){
        Recipe recipe = new Recipe(name);
        Ingredient ingredient;
        Recipe sourceRecipe;
        if(useOriginal){
            sourceRecipe = original;
        }else{
            sourceRecipe = converted;
        }
        for(Ingredient i : sourceRecipe.getIngredients()){
            // add new ingredient using manager list
            recipe.getIngredients().add(new Ingredient(i.getAmount(), i.getUnit(), i.getName()));
        }
        return recipe;
    }

    public ShopList exportAsShopList(Context context, String name){
        ShopList list = new ShopList(name);
        String itemName;
        for(Ingredient i : original.getIngredients()){
            // add new shop item using ingredient data for new objects
            itemName = Ingredient.roundAmount(i.getAmount()) + "  "
                    + ResourceHelper.getStringFromRes(context, i.getUnit().getRes()) + "  "
                    + i.getName();
            list.getItems().add(new ShopItem(itemName));
        }
        return list;
    }

    public List<Ingredient> getOriginalIngredientList(){
        return original.getIngredients();
    }

    public List<Ingredient> getConvertedIngredientList(){
        return converted.getIngredients();
    }

    /**
     * Returns a String containing the converted temperature and it's unit.
     * Temperature is rounded for presentation.
     * @param context Context used to access resource folder
     * @return String describing temperature amount and unit
     */
    public String getTemperatureText(Context context){
        String unitText = ResourceHelper.getStringFromRes(
                context, convertedTemperature.getUnit().getRes());
        // round the temperature amount for presentation
        return "= " + Ingredient.roundTemperature(convertedTemperature.getAmount()) + " " + unitText;
    }

    /**
     * Copies recipe data from focused recipe in RecipeManager
     * to original and converted recipes.
     */
    public void importRecipe(){
        Recipe impRecipe = RecipeManager.getInstance().getFocusedRecipe();

        // create new objects using data from imported recipe
        original = new Recipe(impRecipe.getName(), impRecipe.getInstructions());
        original.setIngredients(new ArrayList<Ingredient>());
        converted = new Recipe(impRecipe.getName(), impRecipe.getInstructions());
        converted.setIngredients(new ArrayList<Ingredient>());

        // create new ingredients using data from imported recipe
        for(Ingredient i : impRecipe.getIngredients()){
            original.getIngredients().add(new Ingredient(i.getAmount(), i.getUnit(), i.getName()));
            converted.getIngredients().add(new Ingredient(i.getAmount(), i.getUnit(), i.getName()));
        }
        focusPosition = 0;
    }

    public void importRecipeFromDialog(int recipePosition){
        Recipe impRecipe = RecipeManager.getInstance().getAllRecipes().get(recipePosition);

        original = new Recipe(impRecipe.getName(), impRecipe.getInstructions());
        original.setIngredients(new ArrayList<Ingredient>());
        converted = new Recipe(impRecipe.getName(), impRecipe.getInstructions());
        converted.setIngredients(new ArrayList<Ingredient>());

        int counter = 0;

        // create new ingredients using data from imported recipe
        for(Ingredient i : impRecipe.getIngredients()){
            original.getIngredients().add(new Ingredient(i.getAmount(), i.getUnit(), i.getName()));
            converted.getIngredients().add(new Ingredient(i.getAmount(), i.getUnit(), i.getName()));
            // convert ingredients in case multiplier was changed before
            convertIngredient(counter);
            counter++;
        }
        focusPosition = 0;
    }
}
