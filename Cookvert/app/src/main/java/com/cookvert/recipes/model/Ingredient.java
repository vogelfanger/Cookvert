package com.cookvert.recipes.model;


import java.text.DecimalFormat;

/**
 * Represents a single ingredient in a recipe.
 */
public class Ingredient {

    private String name;
    private double amount;
    private Unit unit;


    public Ingredient(double amount, Unit unit, String name){
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public Ingredient(double amount, int unitKey, String name){
        this.name = name;
        this.amount = amount;
        assignUnit(unitKey);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public String getRoundedAmount(){
        return roundAmount(this.amount);
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setUnit(int unitKey){
        assignUnit(unitKey);
    }

    //******************** METHODS ********************

    /**
     * Help method that sets the unit type based on the key number.
     * @param unitKey Number that identifies the unit.
     * TODO Update new ingredients alphabetically
     */
    public void assignUnit(int unitKey){

        switch (unitKey){
            case 1:
                unit = Unit.GRAM;
                return;
            case 2:
                unit = Unit.KILOGRAM;
                return;
            case 3:
                unit = Unit.OUNCE;
                return;
            case 4:
                unit = Unit.POUND;
                return;
            case 5:
                unit = Unit.CUP_UK;
                return;
            case 6:
                unit = Unit.CUP_US;
                return;
            case 7:
                unit = Unit.DECILITER;
                return;
            case 8:
                unit = Unit.DESSERTSPOON_EU;
                return;
            case 9:
                unit = Unit.DESSERTSPOON_UK;
                return;
            case 10:
                unit = Unit.DESSERTSPOON_US;
                return;
            case 11:
                unit = Unit.FLUID_OUNCE_UK;
                return;
            case 12:
                unit = Unit.FLUID_OUNCE_US;
                return;
            case 13:
                unit = Unit.GALLON_UK;
                return;
            case 14:
                unit = Unit.GALLON_US;
                return;
            case 15:
                unit = Unit.LITER;
                return;
            case 16:
                unit = Unit.MILLILITER;
                return;
            case 17:
                unit = Unit.PINT_UK;
                return;
            case 18:
                unit = Unit.PINT_US;
                return;
            case 19:
                unit = Unit.QUART_UK;
                return;
            case 20:
                unit = Unit.QUART_US;
                return;
            case 21:
                unit = Unit.TABLESPOON_EU;
                return;
            case 22:
                unit = Unit.TABLESPOON_UK;
                return;
            case 23:
                unit = Unit.TABLESPOON_US;
                return;
            case 24:
                unit = Unit.TEASPOON_EU;
                return;
            case 25:
                unit = Unit.TEASPOON_UK;
                return;
            case 26:
                unit = Unit.TEASPOON_US;
                return;
            case 27:
                unit = Unit.PIECE;
        }
    }

    /**
     * Rounds given double to more presentable decimal format and returns the rounded amount as a String.
     * Rounding depends on the magnitude of given double. Largest possible return value is 9999.
     * Values between 9999 and 1 are rounded to 4 significant numbers. Anything below 1 is rounded to 4 decimals after 0.
     * @param amount Amount being rounded
     * @return Rounded amount
     */
    public static String roundAmount(double amount){
        DecimalFormat df;
        if(amount >= 1000){
            df = new DecimalFormat("###0");
        }else if(1000 >= amount && amount >= 100){
            df = new DecimalFormat("##0.#");
        }else if(100 >= amount && amount >= 10){
            df = new DecimalFormat("#0.##");
        }else if(10 >= amount && amount >= 1){
            df = new DecimalFormat("0.###");
        }else {
            df = new DecimalFormat("0.0###");
        }
        return df.format(amount);
    }

    @Override
    public String toString() {
        return amount + " " + unit + " " + name;
    }
}

