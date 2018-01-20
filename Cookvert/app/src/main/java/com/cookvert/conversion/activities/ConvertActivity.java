package com.cookvert.conversion.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.cookvert.R;
import com.cookvert.conversion.ConvertManager;
import com.cookvert.conversion.fragments.ChangeUnitDialog;
import com.cookvert.conversion.fragments.ConvertTemperatureDialog;
import com.cookvert.conversion.fragments.ConvertedRecipeFragment;
import com.cookvert.conversion.fragments.ExportRecipeDialog;
import com.cookvert.conversion.fragments.ExportShopListDialog;
import com.cookvert.conversion.fragments.ImportRecipeDialog;
import com.cookvert.conversion.fragments.SignInDialog;
import com.cookvert.data.DBHelper;
import com.cookvert.data.GoogleDriveManager;
import com.cookvert.help.activities.HelpActivity;
import com.cookvert.help.activities.SignInOptionsActivity;
import com.cookvert.recipes.RecipeManager;
import com.cookvert.recipes.activities.EditRecipeActivity;
import com.cookvert.recipes.activities.RecipesActivity;
import com.cookvert.recipes.fragments.EditIngredientDialog;
import com.cookvert.recipes.fragments.InstructionFragment;
import com.cookvert.conversion.adapters.MyConvertedIngredientRecyclerViewAdapter;
import com.cookvert.recipes.adapters.MyIngredientRecyclerViewAdapter;
import com.cookvert.recipes.fragments.NewIngredientDialog;
import com.cookvert.recipes.fragments.OriginalRecipeFragment;
import com.cookvert.conversion.fragments.ScaleRecipeDialog;
import com.cookvert.recipes.model.Ingredient;
import com.cookvert.recipes.model.Recipe;
import com.cookvert.recipes.model.Unit;
import com.cookvert.shoppinglist.ShopListManager;
import com.cookvert.shoppinglist.activities.EditShopListActivity;
import com.cookvert.shoppinglist.activities.ShopListsActivity;
import com.cookvert.shoppinglist.model.ShopList;
import com.cookvert.util.Cookvert;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveClient;
import com.google.android.gms.drive.DriveResourceClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

/**
 *
 */
public class ConvertActivity extends AppCompatActivity
        implements OriginalRecipeFragment.OnOriginalListFragmentInteractionListener,
                    ConvertedRecipeFragment.OnConvertedListFragmentInteractionListener,
                    InstructionFragment.OnEditInstructionsListener,
                    NewIngredientDialog.OnNewIngredientListener,
                    EditIngredientDialog.OnEditIngredientListener,
                    ScaleRecipeDialog.OnScaleRecipeListener,
                    ChangeUnitDialog.OnChangeUnitListener,
                    ExportShopListDialog.OnExportShopListListener,
                    ExportRecipeDialog.OnExportRecipeListener,
                    ImportRecipeDialog.OnImportRecipeListener,
                    SignInDialog.OnSignInListener{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    /**
     * The {@link ViewPager} that will host the section contents.
     */

    // tags fragment manager
    public static final String TAG_DISPLAY_INSTRUCTIONS = "displayInstructions";
    public static final String TAG_SAVED_STATE_INSTRUCTIONS = "bundleInstructions";

    public static final int SIGN_IN_REQUEST = 1;

    private ViewPager mViewPager;
    // page adapter for each page fragment
    private SectionsPagerAdapter mSectionsPagerAdapter;
    //list of fragments used in view pager
    private ArrayList<Fragment> fragments = new ArrayList<>();

    // list adapters for original and converted recipes
    private MyIngredientRecyclerViewAdapter originalAdapter;
    private MyConvertedIngredientRecyclerViewAdapter convertedAdapter;

    private FloatingActionButton fab;
    // text view at the bottom of the activity
    private TextView multiplierView;
    // text for multiplierView, multplier is added after this text dynamically
    private String muliplierText;

    //recipe instructions given as argument from another Activity
    private String argInstructions;
    private Boolean displayInstructions;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    private GoogleSignInClient googleSignInClient;
    private boolean signInFlag;
    private boolean signInDialogFlag;
    private SignInDialog signInDialog; // dialog that is dismissed when login succeeds


    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SIGN_IN_REQUEST && resultCode == RESULT_OK){
            GoogleDriveManager.getInstance().googleSignInAccountTask(googleSignInClient.silentSignIn().addOnCompleteListener(new OnCompleteListener<GoogleSignInAccount>() {
                @Override
                public void onComplete(@NonNull Task<GoogleSignInAccount> task) {

                    // Save signed in account to manager so the info can be used later
                    Task<GoogleSignInAccount> accountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
                    try {
                        GoogleDriveManager.getInstance().setAccount(accountTask.getResult(ApiException.class));

                    } catch (ApiException e) {
                        // The ApiException status code indicates the detailed failure reason.
                        Log.w("ConvertActivity", "Account retrieval failed:" + e.getStatusCode());
                    }

                    SharedPreferences prefs = getSharedPreferences(Cookvert.PREFS_NAME, 0);

                    // If user just signed in with an account for the first time, show toast
                    if(!prefs.getBoolean(Cookvert.PREF_SIGN_IN_SETTING, false)){
                        Toast toast = Toast.makeText(getApplicationContext(), R.string.toast_signed_in, Toast.LENGTH_SHORT);
                        toast.show();
                    }

                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean(Cookvert.PREF_SIGN_IN_SETTING, true);
                    editor.putBoolean(Cookvert.PREF_SIGN_IN_SHOW, false);
                    editor.apply();

                    if(signInDialog != null){
                        signInDialog.dismiss();
                    }
                }
            }), getApplicationContext(), this);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Create the database so it can be overwritten with file from Drive.
        DBHelper.getInstance(this);

        // See if user has some previous sign in setting and set flag.
        final SharedPreferences prefs = getSharedPreferences(Cookvert.PREFS_NAME, 0);
        signInFlag = prefs.getBoolean(Cookvert.PREF_SIGN_IN_SETTING, false);
        signInDialogFlag = prefs.getBoolean(Cookvert.PREF_SIGN_IN_SHOW, true);

        // If user has not signed in with google and dialog flag is on, show dialog
        if(!GoogleDriveManager.getInstance().signedIn() && signInDialogFlag){
            SignInDialog signInDialog = SignInDialog.newInstance();
            signInDialog.show(getSupportFragmentManager(), "signInDialog");
        }

        // If user has not signed in and auto sign in flag is on, sign in.
        else if(!GoogleDriveManager.getInstance().signedIn() && signInFlag){
            GoogleDriveManager.getInstance().buildGoogleSignInClient(this);
            googleSignInClient = GoogleDriveManager.getInstance().getGoogleSignInClient();
            startActivityForResult(googleSignInClient.getSignInIntent(), SIGN_IN_REQUEST);
        }

        setContentView(R.layout.activity_convert);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        OriginalRecipeFragment oFrag = OriginalRecipeFragment.newInstance(1);
        ConvertedRecipeFragment cFrag = ConvertedRecipeFragment.newInstance(1,1);
        fragments.add(OriginalRecipeFragment.newInstance(1));
        fragments.add(ConvertedRecipeFragment.newInstance(1,1));

        // preliminary value, that is changed later if instructions fragment is added to the activity
        displayInstructions = false;

        //if recipe instructions were given as extra, add instruction fragment
        if(getIntent().hasExtra(RecipeManager.ARG_RECIPE_INSTRUCTIONS)) {
            displayInstructions = true;
            argInstructions = getIntent().getExtras().
                    getString(RecipeManager.ARG_RECIPE_INSTRUCTIONS);
            InstructionFragment insFrag = InstructionFragment.newInstance(2, 0, argInstructions);
            fragments.add(insFrag);
        }
        //if instructions were loaded during activity's previous lifetime, add instructions fragment
        else if(ConvertManager.getInstance().getLoadedInstructions() != null) {
            displayInstructions = true;
            argInstructions = ConvertManager.getInstance().getLoadedInstructions();
            InstructionFragment insFrag = InstructionFragment.newInstance(2, 0, argInstructions);
            fragments.add(insFrag);
        }

        // add instructions fragment if there was one in previous state
        if(savedInstanceState != null){
            if(savedInstanceState.containsKey(TAG_DISPLAY_INSTRUCTIONS) &&
                    savedInstanceState.containsKey(TAG_SAVED_STATE_INSTRUCTIONS)) {
                displayInstructions = true;
                argInstructions = savedInstanceState.getString(TAG_SAVED_STATE_INSTRUCTIONS);
                InstructionFragment insFrag = InstructionFragment.newInstance(2, 0, argInstructions);
                fragments.add(insFrag);
            }
        }

        //create pager adapter using fragment list
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), fragments);

        // Set up the ViewPager with pager adapter.
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

        PagerTabStrip tabStrip = (PagerTabStrip) findViewById(R.id.pager_strip);
        tabStrip.setTabIndicatorColorResource(R.color.colorAccent);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        fab.setVisibility(View.VISIBLE);
                        multiplierView.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        fab.setVisibility(View.VISIBLE);
                        multiplierView.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        fab.setVisibility(View.GONE);
                        multiplierView.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}

        });

        muliplierText = getResources().getString(R.string.text_multiplier_amount);
        // set text for multiplier view at the bottom of the activity
        multiplierView = (TextView) findViewById(R.id.text_multiplier_covert_activity);
        multiplierView.setText(
                muliplierText + " " + String.valueOf(ConvertManager.getInstance().getMultiplier()));

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
                        // activity already selected, NOP
                        return true;
                    case R.id.navigation_item_recipes:
                        startActivity(new Intent(ConvertActivity.this, RecipesActivity.class));
                        return true;
                    case R.id.navigation_item_shop_lists:
                        startActivity(new Intent(ConvertActivity.this, ShopListsActivity.class));
                        return true;
                    case R.id.navigation_item_sign_in:
                        startActivity(new Intent(ConvertActivity.this, SignInOptionsActivity.class));
                        return true;
                    case R.id.navigation_item_help:
                        startActivity(new Intent(ConvertActivity.this, HelpActivity.class));
                        return true;
                }
                return false;
            }
        });

        // preselect item based on current activity
        navigationView.getMenu().getItem(0).setChecked(true);

        // Set activity title manually,
        // otherwise newer Android versions use the title also as the app label.
        getSupportActionBar().setTitle(R.string.title_activity_convert);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_convert, menu);
        return true;
    }

    @Override
    public void onHideKeyboard(View view) {
        //Use InputMethodManager to hide the keyboard from view
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(TAG_DISPLAY_INSTRUCTIONS, displayInstructions);
        outState.putString(TAG_SAVED_STATE_INSTRUCTIONS, argInstructions);
    }



    //****************************************************************************************************
    //                                    FRAGMENT INTERACTION METHODS
    //****************************************************************************************************



    /**
     * Called when ingredient in list is long clicked (Context menu is created).
     * Sets selected ingredient position to focus in ConvertManager, so that actions from
     * Context menu are executed on the right list item.
     * @param itemPosition Selected ingredient position in list
     */
    @Override
    public void onContextMenuCreated(int itemPosition) {
        ConvertManager.getInstance().setFocusPosition(itemPosition);
    }



    /**
     * Called when user interacts with a list item in ConvertedRecipeFragment.
     * Opens a popup menu, where the user can change unit.
     * @param item
     */
    @Override
    public void onConvertedListFragmentInteraction(
            MyConvertedIngredientRecyclerViewAdapter.ViewHolder item, int itemPosition) {
        //set the selected ingredient to focus in ConvertManager
        ConvertManager.getInstance().setFocusPosition(itemPosition);

        //selected unit's position in spinner is given as argument for dialogs
        int argUnitPos;
        //selected unit is mass unit
        if(ConvertManager.getInstance().getOriginalFocusIngredient().getUnit().isMassUnit()){
            argUnitPos = ConvertManager.getInstance().getConvertedFocusIngredient().getUnit().massListPosition();
            ChangeUnitDialog cDialog = ChangeUnitDialog.newInstance(R.array.spinner_mass_units, argUnitPos);
            cDialog.show(getSupportFragmentManager(), "changeUnitDialog");
        }
        //selected unit is volume unit
        else if(ConvertManager.getInstance().getOriginalFocusIngredient().getUnit().isPiece() == false){
            argUnitPos = ConvertManager.getInstance().getConvertedFocusIngredient().getUnit().volumeListPosition();
            ChangeUnitDialog cDialog = ChangeUnitDialog.newInstance(R.array.spinner_volume_units, argUnitPos);
            cDialog.show(getSupportFragmentManager(), "changeUnitDialog");
        }
        //selected unit is piece, can't be converted
        else{
            Toast toast = Toast.makeText(this, R.string.error_unit_piece_converted, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * Instructions are uneditable in this Activity, so this method does nothing
     */
    @Override
    public void onEditInstructions(String instructions) {
    }



    @Override
    public void onChangeUnit(int unitKey) {
        ConvertManager.getInstance().changeUnit(unitKey);
        originalAdapter.notifyDataSetChanged();
        convertedAdapter.notifyDataSetChanged();
    }



    @Override
    public void onEditIngredient(Double amount, int unitKey, String name) {
        ConvertManager.getInstance().editIngredient(amount, unitKey, name);
        originalAdapter.notifyDataSetChanged();
        convertedAdapter.notifyDataSetChanged();
    }



    @Override
    public void onExportRecipe(String name, boolean useOriginal) {
        // set up recipe in convert manager
        Recipe recipe = ConvertManager.getInstance().exportAsRecipe(name, useOriginal);
        // add recipe to recipe manager
        RecipeManager.getInstance().importRecipe(recipe);
        startActivity(new Intent(ConvertActivity.this, EditRecipeActivity.class));

        //show toast
        Toast toast = Toast.makeText(
                this, R.string.toast_recipe_saved, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onExportShopList(String name, boolean useOriginal) {
        // Set up new shop list in convert manager
        ShopList list = ConvertManager.getInstance().exportAsShopList(
                getApplicationContext(), name, useOriginal);
        // add shop list to shop list manager
        ShopListManager.getInstance().importShopList(list);
        startActivity(new Intent(ConvertActivity.this, EditShopListActivity.class));

        // show toast
        Toast toast = Toast.makeText(
                this, R.string.toast_shop_list_saved, Toast.LENGTH_SHORT);
        toast.show();
    }



    @Override
    public void onImportRecipe(int recipePosition) {
        ConvertManager.getInstance().importRecipeFromDialog(recipePosition);
        originalAdapter.notifyDataSetChanged();
        convertedAdapter.notifyDataSetChanged();

        argInstructions = ConvertManager.getInstance().getLoadedInstructions();

        // if an old instructions fragment exists, replace text.
        if(fragments.size() >= 3){
            //fragments.remove(2);
            InstructionFragment f = (InstructionFragment) fragments.get(2);
            f.setNewInstructions(argInstructions);
        }

        // add instructions fragment to pager
        else {
            InstructionFragment iFrag = InstructionFragment.newInstance(2, 0, argInstructions);
            displayInstructions = true;
            fragments.add(iFrag);
        }

        mSectionsPagerAdapter.notifyDataSetChanged();
        Toast toast = Toast.makeText(
                this, R.string.toast_recipe_loaded, Toast.LENGTH_SHORT);
        toast.show();
    }



    @Override
    public void onNewIngredient(Double amount, int unitKey, String name){
        ConvertManager.getInstance().addIngredient(amount, unitKey, name);
        originalAdapter.notifyDataSetChanged();
        convertedAdapter.notifyDataSetChanged();
    }



    /**
     * Called when user interacts with a list item in OriginalRecipeFragment.
     * Opens a popup menu, where the user can edit the ingredient.
     * @param item
     */
    @Override
    public void onOriginalListFragmentInteraction(MyIngredientRecyclerViewAdapter.ViewHolder item,
                                                  int itemPosition) {
        //set selected ingredient to focus, so that ConvertManager can edit the correct ingredient
        ConvertManager.getInstance().setFocusPosition(itemPosition);

        //create dialog using selected ingredient data as arguments
        String argAmount = Double.toString(ConvertManager.getInstance().getOriginalFocusIngredient().getAmount());
        //selected unit's position when spinner contains all units
        int argUnitPos1 = ConvertManager.getInstance().getOriginalFocusIngredient().getUnit().wholeListPosition();
        String argName = ConvertManager.getInstance().getOriginalFocusIngredient().getName();

        EditIngredientDialog eDialog = EditIngredientDialog.newInstance(argAmount, argUnitPos1, argName);
        eDialog.show(getSupportFragmentManager(), "editIngredientDialog");
    }



    /**
     * Called when recipe is being scaled.
     * Calls scaling method in ConvertManager and updates the UI components.
     * @param multiplier
     */
    @Override
    public void onScaleRecipe(double multiplier) {
        ConvertManager.getInstance().changeMultiplier(multiplier);
        originalAdapter.notifyDataSetChanged();
        convertedAdapter.notifyDataSetChanged();
        multiplierView.setText(muliplierText + " " + String.valueOf(multiplier));
    }



    // Called when user chooses to sign in with Google in SignInDialog.
    @Override
    public void onSignIn(boolean notNow, SignInDialog dialog) {

        signInDialog = dialog;

        // User doesn't want to sign in, don't prompt sign in again.
        if(notNow){
            SharedPreferences prefs = getSharedPreferences(Cookvert.PREFS_NAME, 0);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(Cookvert.PREF_SIGN_IN_SETTING, false);
            editor.putBoolean(Cookvert.PREF_SIGN_IN_SHOW, false);
            editor.apply();
        }else{
            GoogleDriveManager.getInstance().buildGoogleSignInClient(this);
            googleSignInClient = GoogleDriveManager.getInstance().getGoogleSignInClient();
            startActivityForResult(googleSignInClient.getSignInIntent(), SIGN_IN_REQUEST);
        }
    }

    @Override
    public void setOriginalRecipeAdapter(MyIngredientRecyclerViewAdapter adapter) {
        originalAdapter = adapter;
    }



    @Override
    public void setConvertedRecipeAdapter(MyConvertedIngredientRecyclerViewAdapter adapter) {
        convertedAdapter = adapter;
    }




    //****************************************************************************************************
    //*****                                  MENU INTERACTION METHODS                                ********
    //****************************************************************************************************



    @Override
    public boolean onContextItemSelected(MenuItem item) {

        // Change unit
        if(item.getTitle() == getResources().getString(R.string.action_change_unit)) {
            //selected unit's position in spinner is given as argument for dialogs
            int argUnitPos;
            //selected unit is mass unit
            if (ConvertManager.getInstance().getOriginalFocusIngredient().getUnit().isMassUnit()) {
                argUnitPos = ConvertManager.getInstance().getConvertedFocusIngredient().getUnit().massListPosition();
                ChangeUnitDialog cDialog = ChangeUnitDialog.newInstance(R.array.spinner_mass_units, argUnitPos);
                cDialog.show(getSupportFragmentManager(), "changeUnitDialog");
            }
            //selected unit is volume unit
            else if (ConvertManager.getInstance().getOriginalFocusIngredient().getUnit().isPiece() == false) {
                argUnitPos = ConvertManager.getInstance().getConvertedFocusIngredient().getUnit().volumeListPosition();
                ChangeUnitDialog cDialog = ChangeUnitDialog.newInstance(R.array.spinner_volume_units, argUnitPos);
                cDialog.show(getSupportFragmentManager(), "changeUnitDialog");
            }
            //selected unit is piece, can't be converted
            else {
                Toast toast = Toast.makeText(this, R.string.error_unit_piece_converted, Toast.LENGTH_SHORT);
                toast.show();
            }
            return true;
        }

        // Edit ingredient
        if(item.getTitle() == getResources().getString(R.string.action_edit_ingredient)) {
            //create dialog using selected ingredient data as arguments
            String argAmount = Double.toString(ConvertManager.getInstance().getOriginalFocusIngredient().getAmount());
            //selected unit's position when spinner contains all units
            int argUnitPos1 = ConvertManager.getInstance().getOriginalFocusIngredient().getUnit().wholeListPosition();
            String argName = ConvertManager.getInstance().getOriginalFocusIngredient().getName();

            EditIngredientDialog eDialog = EditIngredientDialog.newInstance(argAmount, argUnitPos1, argName);
            eDialog.show(getSupportFragmentManager(), "editIngredientDialog");
            return true;
        }

        // Delete ingredient
        if(item.getTitle() == getResources().getString(R.string.action_delete)) {
            //delete ingredient and update lists
            ConvertManager.getInstance().deleteIngredient();
            originalAdapter.notifyDataSetChanged();
            convertedAdapter.notifyDataSetChanged();
            return true;
        }
        return false;
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

            // home button opens drawer
            case R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);

            case R.id.action_clear_lists:
                ConvertManager.getInstance().deleteAllIngredients();
                originalAdapter.notifyDataSetChanged();
                convertedAdapter.notifyDataSetChanged();
                Toast toast = Toast.makeText(
                        this, R.string.toast_ingredients_removed, Toast.LENGTH_SHORT);
                toast.show();
                return true;

            case R.id.action_convert_temperature:
                Ingredient temp = ConvertManager.getInstance().getOriginalTemperature();
                if(temp.getUnit() == Unit.CELSIUS){
                    ConvertTemperatureDialog cDialog = ConvertTemperatureDialog.newInstance(
                            temp.getAmount(), 0);
                    cDialog.show(getSupportFragmentManager(), "convertTemperatureDialog");
                }else{
                    ConvertTemperatureDialog cDialog = ConvertTemperatureDialog.newInstance(
                            temp.getAmount(), 1);
                    cDialog.show(getSupportFragmentManager(), "convertTemperatureDialog");
                }
                return true;

            case R.id.action_load_recipe:
                ImportRecipeDialog imDialog = ImportRecipeDialog.newInstance();
                imDialog.show(getSupportFragmentManager(), "importRecipeDialog");
                return true;

            case R.id.action_new_recipe:
                ExportRecipeDialog erDialog = ExportRecipeDialog.newInstance();
                erDialog.show(getSupportFragmentManager(), "exportRecipeDialog");
                return true;

            case R.id.action_new_shopping_list:
                ExportShopListDialog dialog = ExportShopListDialog.newInstance();
                dialog.show(getSupportFragmentManager(), "exportShopItemDialog");
                return true;

            case R.id.action_scale_recipe:
                //put recipe multiplier as argument for dialog
                ScaleRecipeDialog sDialog = ScaleRecipeDialog.newInstance(Double.toString(ConvertManager.getInstance()
                        .getMultiplier()));
                sDialog.show(getSupportFragmentManager(), "ScaleRecipeDialog");
                return true;

        }
        return super.onOptionsItemSelected(item);
    }



    //****************************************************************************************************
    //                                      PAGER ADAPTER
    //****************************************************************************************************

    /**
     * Delete a fragment from list of fragments and update ViewPager
     * @param position
     */
    public void deletePageFragment(int position){
        if(position < fragments.size()){
            fragments.remove(position);
            mSectionsPagerAdapter.notifyDataSetChanged();
        }
    }

    /**
     * A {@link FragmentStatePagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        //list of fragments in pager, given as a parameter
        private ArrayList<Fragment> pagerFragments;

        public SectionsPagerAdapter(
                FragmentManager fm, ArrayList<Fragment> pagerFragments) {
            super(fm);
            this.pagerFragments = pagerFragments;
        }

        @Override
        public Fragment getItem(int position) {
            return pagerFragments.get(position);
        }

        @Override
        public int getCount() {
            return pagerFragments.size();
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.title_pager_original_recipe);
                case 1:
                    return getResources().getString(R.string.title_pager_converted_recipe);
                case 2:
                    return getResources().getString(R.string.title_pager_recipe_instructions);
            }
            return null;
        }
    }

}
