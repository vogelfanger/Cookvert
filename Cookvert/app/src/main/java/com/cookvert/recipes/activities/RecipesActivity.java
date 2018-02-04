package com.cookvert.recipes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.cookvert.R;
import com.cookvert.conversion.activities.ConvertActivity;
import com.cookvert.data.DBHelper;
import com.cookvert.data.GoogleDriveManager;
import com.cookvert.help.activities.HelpActivity;
import com.cookvert.help.activities.SignInOptionsActivity;
import com.cookvert.recipes.RecipeManager;
import com.cookvert.recipes.adapters.RecipeRecyclerViewAdapter;
import com.cookvert.recipes.fragments.ChangeCategoryDialog;
import com.cookvert.recipes.fragments.DeleteCategoryDialog;
import com.cookvert.recipes.fragments.DeleteRecipeDialog;
import com.cookvert.recipes.fragments.EditCategoryDialog;
import com.cookvert.recipes.fragments.NewCategoryDialog;
import com.cookvert.recipes.fragments.NewRecipeDialog;
import com.cookvert.recipes.fragments.RecipeListFragment;
import com.cookvert.shoppinglist.activities.ShopListsActivity;

public class RecipesActivity extends AppCompatActivity
                             implements ChangeCategoryDialog.OnChangeCategoryListener,
                                        DeleteCategoryDialog.OnDeleteCategoryListener,
                                        DeleteRecipeDialog.OnDeleteRecipeListener,
                                        EditCategoryDialog.OnEditCategoryListener,
                                        RecipeListFragment.OnRecipeListFragmentInteractionListener,
                                        NewCategoryDialog.OnNewCategoryListener,
                                        NewRecipeDialog.OnNewRecipeListener{


    private RecipeRecyclerViewAdapter recipeAdapter;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

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

        // set up drawer from layout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        // make home button in app bar visible
        getSupportActionBar().setHomeButtonEnabled(true);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.navigation_item_convert:
                        startActivity(new Intent(RecipesActivity.this, ConvertActivity.class));
                        return true;
                    case R.id.navigation_item_recipes:
                        // activity already selected, NOP
                        return true;
                    case R.id.navigation_item_shop_lists:
                        startActivity(new Intent(RecipesActivity.this, ShopListsActivity.class));
                        return true;
                    case R.id.navigation_item_sign_in:
                        startActivity(new Intent(RecipesActivity.this, SignInOptionsActivity.class));
                        return true;
                    case R.id.navigation_item_help:
                        startActivity(new Intent(RecipesActivity.this, HelpActivity.class));
                        return true;
                }
                return false;
            }
        });

        // preselect item based on current activity
        navigationView.getMenu().getItem(1).setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recipes, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        // close database connection when activity is destroyed
        DBHelper.getInstance(getApplicationContext()).close();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        if(GoogleDriveManager.getInstance().signedIn()){
            try {
                GoogleDriveManager.getInstance().saveAppDataToDrive(this);
            }catch (Exception e){
                Log.e("RecipesActivity", "Saving to Drive failed", e);
            }
        }
        super.onStop();
    }



    //****************************************************************************************************
    //                               FRAGMENT INTERACTION METHODS
    //****************************************************************************************************



    @Override
    public void onChangeCategory(int categoryPosition) {
        RecipeManager.getInstance().changeCategory(categoryPosition);
        recipeAdapter.notifyDataSetChanged();
        GoogleDriveManager.getInstance().setUnsavedData(true);
    }

    @Override
    public void onDeleteCategory() {
        //if category is uncategorized, show toast
        if(RecipeManager.getInstance().focusCategory ==
                RecipeManager.getInstance().recipeCategories.size() - 1){
            Toast toast = Toast.makeText(this, R.string.toast_edit_uncategorized, Toast.LENGTH_SHORT);
            toast.show();
            return;
        }else{
            RecipeManager.getInstance().deleteCategory();
            recipeAdapter.notifyDataSetChanged();
            GoogleDriveManager.getInstance().setUnsavedData(true);
        }
    }

    @Override
    public void onDeleteRecipe() {
        RecipeManager.getInstance().deleteRecipe();
        recipeAdapter.notifyDataSetChanged();
        GoogleDriveManager.getInstance().setUnsavedData(true);
    }

    @Override
    public void onEditCategory(String name) {
        //if focused category is uncategorized, show toast
        if(RecipeManager.getInstance().focusCategory ==
                RecipeManager.getInstance().recipeCategories.size() - 1){
            Toast toast = Toast.makeText(this, R.string.toast_edit_uncategorized, Toast.LENGTH_SHORT);
            toast.show();
            return;
        }else {
            RecipeManager.getInstance().editCategory(name);
            GoogleDriveManager.getInstance().setUnsavedData(true);
        }
    }

    @Override
    public void onCategoryContextMenuCreated(int categoryPosition) {
        RecipeManager.getInstance().setFocusCategory(categoryPosition);
    }

    @Override
    public void onRecipeContextMenuCreated(int categoryPosition, int recipePosition) {
        RecipeManager.getInstance().setFocusCategory(categoryPosition);
        RecipeManager.getInstance().setFocusRecipe(recipePosition);
    }

    @Override
    public void onRecipeListFragmentInteraction(int categoryPosition, int recipePosition) {

        //set focus point for RecipeManager so that the right recipe is being edited
        RecipeManager.getInstance().focusCategory = categoryPosition;
        RecipeManager.getInstance().focusRecipe = recipePosition;

        //start new activity where recipe data can be edited
        startActivity(new Intent(getApplicationContext(), EditRecipeActivity.class));
    }

    @Override
    public void setRecipeListAdapter(RecipeRecyclerViewAdapter adapter) {
        recipeAdapter = adapter;
    }

    @Override
    public void onNewCategory(String name) {
        RecipeManager.getInstance().addCategory(name);
        recipeAdapter.notifyDataSetChanged();
        GoogleDriveManager.getInstance().setUnsavedData(true);
    }

    @Override
    public void onNewRecipe(String name, int categoryPosition) {

        //add new recipe to RecipeManager
        RecipeManager.getInstance().addRecipe(name, categoryPosition);
        recipeAdapter.notifyDataSetChanged();
        GoogleDriveManager.getInstance().setUnsavedData(true);

        //start new activity where recipe can be edited
        Intent intent = new Intent(getApplicationContext(), EditRecipeActivity.class);
        Bundle args = new Bundle();
        args.putInt(RecipeManager.ARG_SELECTED_RECIPE_POSITION, RecipeManager.getInstance().focusRecipe);
        args.putInt(RecipeManager.ARG_SELECTED_CATEGORY_POSITION, RecipeManager.getInstance().focusCategory);
        intent.putExtras(args);
        startActivity(intent);
    }

    //****************************************************************************************************
    //                                  MENU INTERACTION METHODS
    //****************************************************************************************************



    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.d("", "Context item detected");
        // Select recipe
        if(item.getTitle() == getResources().getString(R.string.action_select_recipe)){
            //start new activity where ingredient data can be edited
            startActivity(new Intent(getApplicationContext(), EditRecipeActivity.class));
            return true;
        }

        // Change category
        if(item.getTitle() == getResources().getString(R.string.action_change_category)){
            //pass category position as argument for dialog
            ChangeCategoryDialog.newInstance(RecipeManager.getInstance().getFocusCategory())
                    .show(getSupportFragmentManager(), "changeCategory");
            return true;
        }

        // Edit category
        if(item.getTitle() == getResources().getString(R.string.action_edit_recipe_category)){
            // show toast when trying to edit uncategorized category
            if(RecipeManager.getInstance().focusOnUncategorized()){
                Toast toast = Toast.makeText(
                        this, R.string.toast_edit_uncategorized, Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }else{
                //pass category name as argument for dialog
                String argName = RecipeManager.getInstance().recipeCategories.get(
                        RecipeManager.getInstance().getFocusCategory()).name;
                EditCategoryDialog eDialog = EditCategoryDialog.newInstance(argName);
                eDialog.show(getSupportFragmentManager(), "editCategoryDialog");
                return true;
            }
        }

        // Delete recipe
        if(item.getTitle() == getResources().getString(R.string.action_delete_recipe)){
            //show dialog when deleting recipe
            DeleteRecipeDialog.newInstance().show(
                    getSupportFragmentManager(), "deleteRecipeDialog");
            return true;
        }

        // Delete category
        if(item.getTitle() == getResources().getString(R.string.action_delete_category)){
            // show toast when trying to delete uncategorized category
            if(RecipeManager.getInstance().focusOnUncategorized()){
                Toast toast = Toast.makeText(
                        this, R.string.toast_edit_uncategorized, Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }else{
                //show dialog when deleting category
                DeleteCategoryDialog.newInstance().show(
                        getSupportFragmentManager(), "deleteCategoryDialog");
                return true;
            }
        }
        return false;
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
        switch (item.getItemId()) {
            case R.id.action_new_category:
                NewCategoryDialog nDialog = NewCategoryDialog.newInstance();
                nDialog.show(getSupportFragmentManager(), "newCategoryDialog");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
