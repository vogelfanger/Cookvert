package com.cookvert.data;

import android.provider.BaseColumns;

/**
 * Created by elmo on 12.8.2016.
 */
public final class DBContract {

    public DBContract(){
    }

    public static abstract class IngredientsTable implements BaseColumns{
        public final static String TABLE_INGREDIENTS = "ingredients";
        public final static String COLUMN_NAME = "name";
        public final static String COLUMN_AMOUNT = "amount";
        public final static String COLUMN_UNIT = "unit";
        public final static String COLUMN_RECIPE = "recipe";
    }

    public static abstract class InstructionsTable implements BaseColumns{
        public final static String TABLE_INSTRUCTIONS = "instructions";
        public final static String COLUMN_RECIPE = "recipe";
    }

    public static abstract class RecipesTable implements BaseColumns{
        public final static String TABLE_RECIPES = "recipes";
        public final static String COLUMN_NAME = "name";
    }

    public static abstract class ShoppingListsTable implements BaseColumns{
        public final static String TABLE_SHOPPING_LISTS = "shopping_lists";
        public final static String COLUMN_NAME = "name";
    }

    public static abstract class InstructionItemsTable implements BaseColumns {
        public final static String TABLE_INSTRUCTION_ITEMS = "instruction_items";
        public final static String COLUMN_INSTRUCTION_ROW = "instruction_row";
        public final static String COLUMN_INSTRUCTION = "instruction";
    }

    public static abstract class ShopItemsTable implements BaseColumns {
        public final static String TABLE_SHOP_ITEMS = "shop_items";
        public final static String COLUMN_NAME = "name";
        public final static String COLUMN_SHOPPING_LIST = "shopping_list";
    }
}
