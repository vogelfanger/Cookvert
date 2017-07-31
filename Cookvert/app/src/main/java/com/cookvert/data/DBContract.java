package com.cookvert.data;

import android.provider.BaseColumns;

/**
 * Utility class describing structure of the database.
 * Each table also has an id column, which is defined in DBHelper when table is created.
 */
public final class DBContract {

    public DBContract(){
    }

    public static abstract class Ingredient implements BaseColumns{
        public final static String TABLE_INGREDIENT = "ingredient";
        public final static String NAME = "name";
        public final static String AMOUNT = "amount";
        public final static String UNIT = "unit";
    }

    public static abstract class RecipeCategory implements BaseColumns{
        public final static String TABLE_RECIPE_CAT = "recipe_category";
        public final static String NAME = "name";
    }

    public static abstract class Recipe implements BaseColumns{
        public final static String TABLE_RECIPE = "recipe";
        public final static String NAME = "name";
        public final static String INSTRUCTIONS = "instructions";
    }

    //connects all categories, recipes and ingredients by their id
    public static abstract class RecipesTable implements BaseColumns{
        public final static String TABLE_RECIPES_TABLE = "recipes_table";
        public final static String CAT_ID = "category_id";
        public final static String RECIPE_ID = "recipe_id";
        public final static String INGREDIENT_ID = "ingredient_id";
    }

    public static abstract class ShopItem implements BaseColumns {
        public final static String TABLE_SHOP_ITEM = "shop_item";
        public final static String NAME = "name";
        public final static String SELECTED = "selected";
    }

    public static abstract class ShoppingList implements BaseColumns {
        public final static String TABLE_SHOPPING_LIST = "shopping_list";
        public final static String NAME = "name";
    }

    //connects all shop items to shopping lists by their id
    public static abstract class ShoppingListsTable implements BaseColumns{
        public final static String TABLE_SHOPPING_LISTS_TABLE = "shopping_lists_table";
        public final static String SHOPPING_LIST_ID = "shopping_list_id";
        public final static String SHOP_ITEM_ID = "shop_item_id";
    }

}
