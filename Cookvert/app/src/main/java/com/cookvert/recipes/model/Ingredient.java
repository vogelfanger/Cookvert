package com.cookvert.recipes.model;


import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a single ingredient in a recipe.
 */
public class Ingredient {

    private String name;
    private double amount;
    private Unit unit;
    private int id; //unique identifier, not stored in database

    public static AtomicInteger atomicInt = new AtomicInteger();


    public Ingredient(double amount, Unit unit, String name){
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.id = atomicInt.incrementAndGet();
    }

    public Ingredient(double amount, int unitKey, String name){
        this.name = name;
        this.amount = amount;
        assignUnit(unitKey);
        this.id = atomicInt.incrementAndGet();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //******************** METHODS ********************

    /**
     * Help method that sets the unit type based on the key number.
     * @param unitKey Number that identifies the unit.
     * TODO Update new units alphabetically
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
                unit = Unit.GALLON_US_DRY;
                return;
            case 15:
                unit = Unit.GALLON_US;
                return;
            case 16:
                unit = Unit.LITER;
                return;
            case 17:
                unit = Unit.MILLILITER;
                return;
            case 18:
                unit = Unit.PINT_UK;
                return;
            case 19:
                unit = Unit.PINT_US_DRY;
                return;
            case 20:
                unit = Unit.PINT_US;
                return;
            case 21:
                unit = Unit.QUART_UK;
                return;
            case 22:
                unit = Unit.QUART_US_DRY;
                return;
            case 23:
                unit = Unit.QUART_US;
                return;
            case 24:
                unit = Unit.TABLESPOON_EU;
                return;
            case 25:
                unit = Unit.TABLESPOON_UK;
                return;
            case 26:
                unit = Unit.TABLESPOON_US;
                return;
            case 27:
                unit = Unit.TEASPOON_EU;
                return;
            case 28:
                unit = Unit.TEASPOON_UK;
                return;
            case 29:
                unit = Unit.TEASPOON_US;
                return;
            case 30:
                unit = Unit.PIECE;
        }
    }

    /**
     * Rounds given double to more presentable decimal format
     * and returns the rounded amount as a String.
     * Rounding depends on the magnitude of given double.
     * Values over 1 are rounded to 4 significant numbers.
     * Anything below 1 is rounded to 4 decimals after 0.
     * @param amount Amount being rounded
     * @return Rounded amount
     */
    public static String roundAmount(double amount) {
        DecimalFormat df;
        if(amount >= 10000){
            // round last digit to nearest 10
            amount = Math.round(amount / 10.0) * 10.0;
            df = new DecimalFormat("####0");
        }else if(amount >= 1000){
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
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(amount);
    }

    public static String roundTemperature(double amount) {
        DecimalFormat df;
        if (amount >= 10000) {
            // round last digit to nearest 10
            amount = Math.round(amount / 10.0) * 10.0;
            df = new DecimalFormat("####0");
        } else if (amount >= 1000) {
            df = new DecimalFormat("###0");
        } else if (1000 >= amount && amount >= 100) {
            df = new DecimalFormat("##0.#");
        } else if (100 >= amount && amount >= 0){
            df = new DecimalFormat("#0.##");
        } else if (amount <= -100){
            df = new DecimalFormat("##0.#;-##0.#");
        } else if (amount <= -10){
            df = new DecimalFormat("#0.##;-#0.##");
        } else{
            df = new DecimalFormat("#0.##;-#0.##");
        }
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(amount);
    }

    @Override
    public String toString() {
        return String.valueOf(amount) + " " + unit.toString() + " " + name;
    }
}

