package com.cookvert.recipes.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.cookvert.R;
import com.cookvert.menu.MainActivity;
import com.cookvert.recipes.RecipeManager;
import com.cookvert.recipes.adapters.RecipeRecyclerViewAdapter;
import com.cookvert.recipes.fragments.ChangeCategoryDialog;
import com.cookvert.recipes.fragments.DeleteCategoryDialog;
import com.cookvert.recipes.fragments.DeleteRecipeDialog;
import com.cookvert.recipes.fragments.EditCategoryDialog;
import com.cookvert.recipes.fragments.NewCategoryDialog;
import com.cookvert.recipes.fragments.NewRecipeDialog;
import com.cookvert.recipes.fragments.RecipeListFragment;

public class RecipesActivity extends AppCompatActivity
                             implements ChangeCategoryDialog.OnChangeCategoryListener,
                                        DeleteCategoryDialog.OnDeleteCategoryListener,
                                        DeleteRecipeDialog.OnDeleteRecipeListener,
                                        EditCategoryDialog.OnEditCategoryListener,
                                        RecipeListFragment.OnRecipeListFragmentInteractionListener,
                                        NewCategoryDialog.OnNewCategoryListener,
                                        NewRecipeDialog.OnNewRecipeListener,
                                        PopupMenu.OnMenuItemClickListener{


    RecipeRecyclerViewAdapter recipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewRecipeDialog.newInstance().show(getSupportFragmentManager(), "newRecipeDialog");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recipes, menu);
        return true;
    }

    //****************************************************************************************************
    //*****                               FRAGMENT INTERACTION METHODS                               *****
    //****************************************************************************************************


    @Override
    public void onLongCategoryClick(View view, int categoryPosition) {
        //if long clicked category is uncategorized, show toast
        if(categoryPosition == RecipeManager.getInstance().recipeCategories.size() - 1){
            Toast toast = Toast.makeText(this, R.string.toast_edit_uncategorized, Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        //show popup when long clicking other categories
        else {
            RecipeManager.getInstance().focusCategory = categoryPosition;
            PopupMenu popup = new PopupMenu(this, view);
            popup.setOnMenuItemClickListener(this);
            popup.inflate(R.menu.menu_popup_recipe_category);
            popup.show();
        }
    }

    @Override
    public void onLongChildClick(View view, int categoryPosition, int childPosition) {
        RecipeManager.getInstance().focusCategory = categoryPosition;
        RecipeManager.getInstance().focusRecipe = childPosition;
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_popup_recipe);
        popup.show();
    }

    @Override
    public void onChangeCategory(int categoryPosition) {
        RecipeManager.getInstance().changeCategory(categoryPosition);
        recipeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDeleteCategory() {
        RecipeManager.getInstance().deleteCategory();
        recipeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDeleteRecipe() {
        RecipeManager.getInstance().deleteRecipe();
        recipeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onEditCategory(String name) {
        RecipeManager.getInstance().editCategory(name);
    }

    @Override
    public void onRecipeListFragmentInteraction(int categoryPosition, int recipePosition) {

        //set focus point for RecipeManager so that the right recipe is being edited
        RecipeManager.getInstance().focusCategory = categoryPosition;
        RecipeManager.getInstance().focusRecipe = recipePosition;

        //start new activity where ingredient data can be edited
        Intent intent = new Intent(getApplicationContext(), EditRecipeActivity.class);
        Bundle args = new Bundle();
        //pass recipe position in RecipeManager as arguments
        args.putInt(RecipeManager.ARG_SELECTED_RECIPE_POSITION, RecipeManager.getInstance().focusRecipe);
        args.putInt(RecipeManager.ARG_SELECTED_CATEGORY_POSITION, RecipeManager.getInstance().focusCategory);
        intent.putExtras(args);
        startActivity(intent);
    }

    @Override
    public void setRecipeListAdapter(RecipeRecyclerViewAdapter adapter) {
        recipeAdapter = adapter;
    }

    @Override
    public void onNewCategory(String name) {
        RecipeManager.getInstance().addCategory(name);
        recipeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onNewRecipe(String name, int categoryPosition) {

        //add new recipe to RecipeManager
        RecipeManager.getInstance().addRecipe(name, categoryPosition);
        recipeAdapter.notifyDataSetChanged();

        //start new activity where recipe can be edited
        Intent intent = new Intent(getApplicationContext(), EditRecipeActivity.class);
        Bundle args = new Bundle();
        args.putInt(RecipeManager.ARG_SELECTED_RECIPE_POSITION, RecipeManager.getInstance().focusRecipe);
        args.putInt(RecipeManager.ARG_SELECTED_CATEGORY_POSITION, RecipeManager.getInstance().focusCategory);
        intent.putExtras(args);
        startActivity(intent);
    }

    /**
     * Popup menu interactions
     * @param item Selected menu item
     * @return true, if item was selected
     */
    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.popup_change_category:
                //pass category position as argument for dialog
                ChangeCategoryDialog.newInstance(RecipeManager.getInstance().focusCategory)
                        .show(getSupportFragmentManager(), "changeCategory");
                return true;
            case R.id.popup_delete_category:
                //show dialog when deleting category
                DeleteCategoryDialog.newInstance().show(getSupportFragmentManager(), "deleteCategoryDialog");
                return true;
            case R.id.popup_delete_recipe:
                //show dialog when deleting recipe
                DeleteRecipeDialog.newInstance().show(getSupportFragmentManager(), "deleteRecipeDialog");
                return true;
            case R.id.popup_edit_category:
                //pass category name as argument for dialog
                String argName = RecipeManager.getInstance().recipeCategories.get(RecipeManager.getInstance().focusCategory).name;
                EditCategoryDialog eDialog = EditCategoryDialog.newInstance(argName);
                eDialog.show(getSupportFragmentManager(), "editCategoryDialog");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Handles actions for app bar menu interactions
     * @param item Selected menu item
     * @return true, if item was selected
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //TODO implement actions for each item
        switch (item.getItemId()) {
            case R.id.action_new_category:
                NewCategoryDialog nDialog = NewCategoryDialog.newInstance();
                nDialog.show(getSupportFragmentManager(), "newCategoryDialog");
                return true;
            case R.id.action_main_menu:
                startActivity(new Intent(RecipesActivity.this, MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
