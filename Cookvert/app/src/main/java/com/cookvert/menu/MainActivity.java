package com.cookvert.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cookvert.R;
import com.cookvert.conversion.activities.ConvertActivity;
import com.cookvert.recipes.activities.RecipesActivity;
import com.cookvert.shoppinglist.activities.ShoplistActivity;

public class MainActivity extends AppCompatActivity {

    Button toConvert, toRecipes, toShoplists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toConvert = (Button) findViewById(R.id.convert);
        toRecipes = (Button) findViewById(R.id.recipes);
        toShoplists = (Button) findViewById(R.id.shoplists);

        toConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ConvertActivity.class));
            }
        });

        toRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecipesActivity.class));
            }
        });

        toShoplists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShoplistActivity.class));
            }
        });
    }
}
