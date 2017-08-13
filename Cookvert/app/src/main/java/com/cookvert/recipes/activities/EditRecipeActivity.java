package com.cookvert.recipes.activities;

import android.content.Context;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.cookvert.R;
import com.cookvert.conversion.ConvertManager;
import com.cookvert.conversion.activities.ConvertActivity;
import com.cookvert.menu.MainActivity;
import com.cookvert.recipes.RecipeManager;
import com.cookvert.recipes.adapters.MyIngredientRecyclerViewAdapter;
import com.cookvert.recipes.fragments.ChangeCategoryDialog;
import com.cookvert.recipes.fragments.EditIngredientDialog;
import com.cookvert.recipes.fragments.InstructionFragment;
import com.cookvert.recipes.fragments.NewIngredientDialog;
import com.cookvert.recipes.fragments.OriginalRecipeFragment;
import com.cookvert.recipes.fragments.RenameRecipeDialog;
import com.cookvert.recipes.model.Recipe;

public class EditRecipeActivity extends AppCompatActivity implements
        ChangeCategoryDialog.OnChangeCategoryListener,
        OriginalRecipeFragment.OnOriginalListFragmentInteractionListener,
        InstructionFragment.OnEditInstructionsListener,
        PopupMenu.OnMenuItemClickListener,
        NewIngredientDialog.OnNewIngredientListener,
        EditIngredientDialog.OnEditIngredientListener,
        RenameRecipeDialog.OnRenameRecipeListener{

    private MyIngredientRecyclerViewAdapter ingredientListAdapter;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private FloatingActionButton fab;
    private int recipePosition; //recipe position in RecipeManager
    private int categoryPosition; //position of recipe's category in RecipeManager

    //TODO get adapter list for the right recipe from arguments
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_recipe);

        //get recipe and category positions from arguments
        recipePosition = getIntent().getExtras().getInt(RecipeManager.ARG_SELECTED_RECIPE_POSITION);
        categoryPosition = getIntent().getExtras().getInt(RecipeManager.ARG_SELECTED_CATEGORY_POSITION);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        //set recipe name as title for actionbar
        getSupportActionBar().setTitle(RecipeManager.getInstance().getFocusedRecipe().name);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewIngredientDialog nDialog = NewIngredientDialog.newInstance();
                nDialog.show(getSupportFragmentManager(), "newIngredientDialog");
            }
        });

        //page change listener that disables floating action button with instruction fragment
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        fab.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        fab.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
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
    public void onChangeCategory(int categoryPosition) {
        RecipeManager.getInstance().changeCategory(categoryPosition);
    }

    @Override
    public void onEditIngredient(Double amount, int unitKey, String name) {
        RecipeManager.getInstance().editIngredient(amount, unitKey, name);
        ingredientListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onEditInstructions(String instructions){
        RecipeManager.getInstance().editInstructions(instructions);
    }

    @Override
    public void onHideKeyboard(View view) {
        //Use InputMethodManager to hide the keyboard from view
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
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
        switch (item.getItemId()) {
            case R.id.action_convert_recipe:
                //Import focused recipe from RecipeManager to ConvertManager
                ConvertManager.getInstance().importRecipe();
                //put recipe instructions to Extras and start ConvertActivity
                Intent intent = new Intent(getApplicationContext(), ConvertActivity.class);
                Bundle args = new Bundle();
                args.putString(RecipeManager.ARG_RECIPE_INSTRUCTIONS,
                        RecipeManager.getInstance().getFocusedRecipe().instructions);
                intent.putExtras(args);
                startActivity(intent);
                return true;

            case R.id.action_change_recipe_category:
                //Open ChangeCategoryDialog
                ChangeCategoryDialog cDialog = ChangeCategoryDialog.newInstance(RecipeManager.getInstance().focusCategory);
                cDialog.show(getSupportFragmentManager(), "changeCategoryDialog");
                return true;

            case R.id.action_delete_recipe:
                RecipeManager.getInstance().deleteRecipe();
                startActivity(new Intent(getApplicationContext(), RecipesActivity.class));
                Toast toast = Toast.makeText(this, R.string.toast_recipe_deleted, Toast.LENGTH_SHORT);
                toast.show();
                return true;

            case R.id.action_new_shopping_list:
                //TODO open dialog and start ShopListActivity
                return true;

            case R.id.action_main_menu:
                startActivity(new Intent(EditRecipeActivity.this, MainActivity.class));
                return true;

            case R.id.action_rename_recipe:
                //open dialog and give current recipe name as argument
                RenameRecipeDialog rDialog = RenameRecipeDialog.newInstance(RecipeManager.getInstance()
                        .getFocusedRecipe().name);
                rDialog.show(getSupportFragmentManager(), "renameRecipeFragment");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRenameRecipe(String name) {
        RecipeManager.getInstance().renameRecipe(name);
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
                    //Make FloatingActionButton visible
                    return OriginalRecipeFragment.newInstance(0);
                case 1:
                    //editing instructions is enabled
                    //TODO saved instructions should be loaded as parameter
                    return InstructionFragment.newInstance(2, 1, RecipeManager.getInstance().
                            getFocusedRecipe().getInstructions());
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
                    return getResources().getString(R.string.title_pager_ingredients);
                case 1:
                    return getResources().getString(R.string.title_pager_recipe_instructions);
            }
            return null;
        }
    }
}
