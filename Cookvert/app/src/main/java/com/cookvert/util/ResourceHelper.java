package com.cookvert.util;

import android.content.Context;

import com.cookvert.R;
import com.cookvert.recipes.model.Unit;

/**
 * Created by vogelfanger on 18.9.2016.
 */
public class ResourceHelper {

    private ResourceHelper instance = new ResourceHelper();

    private ResourceHelper(){
    }

    public ResourceHelper getInstance(){
        return instance;
    }

    /**
     * Returns given resource in string form.
     * @param context current Activity
     * @param res resource id
     * @return
     */
    public static String getStringFromRes(Context context, int res){
        return context.getResources().getString(res);
    }

    /**
     * Returns Unit object of corresponding string. Use this to find Unit objects based on resource names.
     * @param name Name of the unit.
     * @param context Context from which this method is called.
     * @return Unit Unit object that corresponds the given name.
     */
    public static Unit getUnitByName(String name, Context context){

        if(name.equals(context.getResources().getString(R.string.array_unit_cup_uk))) {
            return Unit.CUP_UK;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_cup_us))) {
            return Unit.CUP_US;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_deciliter))) {
            return Unit.DECILITER;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_dessertspoon_eu))) {
            return Unit.DESSERTSPOON_EU;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_dessertspoon_uk))) {
            return Unit.DESSERTSPOON_UK;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_dessertspoon_us))) {
            return Unit.DESSERTSPOON_US;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_fluid_ounce_uk))) {
            return Unit.FLUID_OUNCE_UK;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_fluid_ounce_us))) {
            return Unit.FLUID_OUNCE_US;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_gallon_uk))) {
            return Unit.GALLON_UK;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_gallon_us_dry))) {
            return Unit.GALLON_US_DRY;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_gallon_us))) {
            return Unit.GALLON_US;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_gram))) {
            return Unit.GRAM;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_kilogram))){
            return Unit.KILOGRAM;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_liter))) {
            return Unit.LITER;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_milliliter))) {
            return Unit.MILLILITER;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_ounce))){
            return Unit.OUNCE;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_piece))) {
            return Unit.PIECE;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_pint_uk))) {
            return Unit.PINT_UK;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_pint_us_dry))) {
            return Unit.PINT_US_DRY;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_pint_us))) {
            return Unit.PINT_US;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_pound))){
            return Unit.POUND;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_quart_uk))) {
            return Unit.QUART_UK;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_quart_us_dry))) {
            return Unit.QUART_US_DRY;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_quart_us))) {
            return Unit.QUART_US;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_tablespoon_eu))) {
            return Unit.TABLESPOON_EU;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_tablespoon_uk))) {
            return Unit.TABLESPOON_UK;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_tablespoon_us))) {
            return Unit.TABLESPOON_US;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_teaspoon_eu))) {
            return Unit.TEASPOON_EU;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_teaspoon_uk))) {
            return Unit.TEASPOON_UK;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_teaspoon_us))) {
            return Unit.TEASPOON_US;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_celsius))) {
            return Unit.CELSIUS;
        }else if(name.equals(context.getResources().getString(R.string.array_unit_fahrenheit))) {
            return Unit.FAHRENHEIT;
        }else return null;
    }
}
