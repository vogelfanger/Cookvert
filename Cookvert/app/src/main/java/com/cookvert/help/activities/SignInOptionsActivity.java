package com.cookvert.help.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cookvert.BuildConfig;
import com.cookvert.R;
import com.cookvert.conversion.activities.ConvertActivity;
import com.cookvert.data.GoogleDriveManager;
import com.cookvert.recipes.activities.RecipesActivity;
import com.cookvert.shoppinglist.activities.ShopListsActivity;
import com.cookvert.util.Cookvert;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class SignInOptionsActivity extends AppCompatActivity {

    public static final int SIGN_IN_REQUEST = 1;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    private GoogleSignInClient signInClient;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // When sign in intent is done, do silent sign in,
        // show toast when done, change preferences so that future sign in is automatic
        // and open ConvertActivity.
        if(requestCode == SIGN_IN_REQUEST && resultCode == RESULT_OK){
            GoogleDriveManager.getInstance().googleSignInAccountTask(signInClient.silentSignIn().addOnCompleteListener(new OnCompleteListener<GoogleSignInAccount>() {
                @Override
                public void onComplete(@NonNull Task<GoogleSignInAccount> task) {

                    // Save signed in account to manager so the info can be used later
                    Task<GoogleSignInAccount> accountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
                    try {
                        GoogleDriveManager.getInstance().setAccount(accountTask.getResult(ApiException.class));

                    } catch (ApiException e) {
                        // The ApiException status code indicates the detailed failure reason.
                        Log.w("SignInOptionsActivity", "Account retrieval failed:" + e.getStatusCode());
                    }

                    SharedPreferences prefs = getSharedPreferences(Cookvert.PREFS_NAME, 0);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean(Cookvert.PREF_SIGN_IN_SETTING, true);
                    editor.putBoolean(Cookvert.PREF_SIGN_IN_SHOW, false);
                    editor.apply();

                    Toast toast = Toast.makeText(getApplicationContext(), R.string.toast_signed_in, Toast.LENGTH_SHORT);
                    toast.show();
                    startActivity(new Intent(SignInOptionsActivity.this, SignInOptionsActivity.class));

                }
            }), getApplicationContext(), this);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_options);

        TextView info = findViewById(R.id.text_sign_in_info);

        // If user is signed in, make sign out button visible and create listener
        if(GoogleDriveManager.getInstance().signedIn()){
            signInClient = GoogleDriveManager.getInstance().getGoogleSignInClient();
            String name = GoogleDriveManager.getInstance().getAccount().getDisplayName();

            if(name != null) {
                info.setText(getString(R.string.sign_in_info_when_signed_in) + " " + name);
            }else{
                info.setText(getString(R.string.sign_in_info_when_signed_in2));
            }

            Button signOutButton= (Button) findViewById(R.id.button_google_sign_out);
            signOutButton.setVisibility(View.VISIBLE);
            signOutButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            SharedPreferences prefs = getSharedPreferences(Cookvert.PREFS_NAME, 0);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean(Cookvert.PREF_SIGN_IN_SETTING, false);
                            editor.putBoolean(Cookvert.PREF_SIGN_IN_SHOW, true);
                            editor.apply();

                            GoogleDriveManager.getInstance().signOut();
                            Toast toast = Toast.makeText(getApplicationContext(), R.string.toast_signed_out, Toast.LENGTH_SHORT);
                            toast.show();
                            startActivity(new Intent(SignInOptionsActivity.this, SignInOptionsActivity.class));
                        }
                    });
                }
            });
        }

        // If user has not signed in, make sign in button visible and create listener
        else{
            info.setText(getString(R.string.sign_in_info_when_signed_out));

            SignInButton signInButton= (SignInButton) findViewById(R.id.button_google_sign_in);
            signInButton.setVisibility(View.VISIBLE);
            signInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signIn();
                }
            });
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // set up drawer from layout
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        // make home button in app bar visible
        getSupportActionBar().setHomeButtonEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.navigation_item_convert:
                        startActivity(new Intent(SignInOptionsActivity.this, ConvertActivity.class));
                        return true;
                    case R.id.navigation_item_recipes:
                        startActivity(new Intent(SignInOptionsActivity.this, RecipesActivity.class));
                        return true;
                    case R.id.navigation_item_shop_lists:
                        startActivity(new Intent(SignInOptionsActivity.this, ShopListsActivity.class));
                        return true;
                    case R.id.navigation_item_sign_in:
                        // activity already selected, NOP
                        return true;
                    case R.id.navigation_item_help:
                        startActivity(new Intent(SignInOptionsActivity.this, HelpActivity.class));
                        return true;
                }
                return false;
            }
        });

        // preselect item based on current activity
        navigationView.getMenu().getItem(3).setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_help, menu);
        return true;
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

        }
        return super.onOptionsItemSelected(item);
    }

    private void signIn(){
        GoogleDriveManager.getInstance().buildGoogleSignInClient(this);
        signInClient = GoogleDriveManager.getInstance().getGoogleSignInClient();
        Intent intent = signInClient.getSignInIntent();
        startActivityForResult(intent, SIGN_IN_REQUEST);
    }

    /**
     * Change sign in info text, hide sign in button and make sign out button visible.
     */
    private void updateUIOnSignIn(){
        TextView info = findViewById(R.id.text_sign_in_info);
        String name = GoogleDriveManager.getInstance().getAccount().getDisplayName();

        if(name != null) {
            info.setText(getString(R.string.sign_in_info_when_signed_in) + " " + name);
        }else{
            info.setText(getString(R.string.sign_in_info_when_signed_in2));
        }

        SignInButton signInButton = findViewById(R.id.button_google_sign_in);
        signInButton.setVisibility(View.GONE);

        Button signOutButton= findViewById(R.id.button_google_sign_out);
        signOutButton.setVisibility(View.VISIBLE);
    }

    /**
     * Change sign in info text, hide sign out button and make sign in button visible.
     */
    private void updateUIOnSignOut(){
        TextView info = findViewById(R.id.text_sign_in_info);
        info.setText(getString(R.string.sign_in_info_when_signed_out));

        Button signOutButton= findViewById(R.id.button_google_sign_out);
        signOutButton.setVisibility(View.GONE);

        SignInButton signInButton = findViewById(R.id.button_google_sign_in);
        signInButton.setVisibility(View.VISIBLE);
    }

}











