package com.cookvert.recipes.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.cookvert.R;
import com.cookvert.menu.MainActivity;
import com.cookvert.recipes.RecipeManager;
import com.cookvert.recipes.adapters.MyIngredientRecyclerViewAdapter;
import com.cookvert.recipes.fragments.EditIngredientDialog;
import com.cookvert.recipes.fragments.InstructionFragment;
import com.cookvert.recipes.fragments.NewIngredientDialog;
import com.cookvert.recipes.fragments.OriginalRecipeFragment;

public class EditRecipeActivity extends AppCompatActivity implements
        OriginalRecipeFragment.OnOriginalListFragmentInteractionListener,
        InstructionFragment.OnFragmentInteractionListener,
        PopupMenu.OnMenuItemClickListener,
        NewIngredientDialog.OnNewIngredientListener,
        EditIngredientDialog.OnEditIngredientListener{

    private MyIngredientRecyclerViewAdapter ingredientListAdapter;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_recipe);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewIngredientDialog nDialog = NewIngredientDialog.newInstance();
                nDialog.show(getSupportFragmentManager(), "newIngredientDialog");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_recipe, menu);
        return true;
    }

    //****************************************************************************************************
    //*****                               FRAGMENT INTERACTION METHODS                               *****
    //****************************************************************************************************

    @Override
    public void onEditIngredient(Double amount, int unitKey, String name) {
        RecipeManager.getInstance().editIngredient(amount, unitKey, name);
        ingredientListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.popup_edit:
                //create dialog using selected ingredient data as arguments
                String argAmount = Double.toString(RecipeManager.getInstance().getFocusedIngredient().getAmount());
                //selected unit's position when spinner contains all units
                int argUnitPos1 = RecipeManager.getInstance().getFocusedIngredient().getUnit().wholeListPosition();
                String argName = RecipeManager.getInstance().getFocusedIngredient().getName();

                EditIngredientDialog eDialog = EditIngredientDialog.newInstance(argAmount, argUnitPos1, argName);
                eDialog.show(getSupportFragmentManager(), "editIngredientDialog");
                return true;
            case R.id.popup_delete:
                //delete ingredient and update lists
                RecipeManager.getInstance().deleteIngredient();
                ingredientListAdapter.notifyDataSetChanged();
                return true;
        }
        return false;
    }

    @Override
    public void onNewIngredient(Double amount, int unitKey, String name) {
        RecipeManager.getInstance().addIngredient(amount, unitKey, name);
        ingredientListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onOriginalListFragmentInteraction(MyIngredientRecyclerViewAdapter.ViewHolder item, int itemPosition) {
        PopupMenu popup = new PopupMenu(this, item.mView);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_popup_original_recipe);
        popup.show();
    }

    @Override
    public void setOriginalRecipeAdapter(MyIngredientRecyclerViewAdapter adapter) {
        ingredientListAdapter = adapter;
    }

    /**
     * Handles actions for app bar menu interactions
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //TODO implement actions for each item
        switch (item.getItemId()) {
            case R.id.action_delete_recipe:
                RecipeManager.getInstance().recipeCategories.get(RecipeManager.getInstance().focusCategory)
                        .recipes.remove(RecipeManager.getInstance().focusRecipe);
                startActivity(new Intent(getApplicationContext(), RecipesActivity.class));
                Toast toast = Toast.makeText(this, R.string.toast_recipe_deleted, Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.action_new_shopping_list:
                return true;
            case R.id.action_main_menu:
                startActivity(new Intent(EditRecipeActivity.this, MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //****************************************************************************************************
    //******                                     PAGER ADAPTER                                    ********
    //****************************************************************************************************

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {


        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                    return OriginalRecipeFragment.newInstance(0);
                case 1:
                    return InstructionFragment.newInstance(2, "one", "two");
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.title_pager_original_recipe);
                case 1:
                    return getResources().getString(R.string.title_pager_recipe_instructions);
            }
            return null;
        }
    }
}
