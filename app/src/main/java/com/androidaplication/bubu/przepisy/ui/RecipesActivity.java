package com.androidaplication.bubu.przepisy.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.androidaplication.bubu.przepisy.R;
import com.androidaplication.bubu.przepisy.adapters.ListRecipesAdapter;
import com.androidaplication.bubu.przepisy.database.DBMenager;
import com.androidaplication.bubu.przepisy.recipes.Categories;
import com.androidaplication.bubu.przepisy.recipes.KeyClas;
import com.androidaplication.bubu.przepisy.recipes.Recipe;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class RecipesActivity extends AppCompatActivity {
    @Bind(R.id.recipeListView) ListView mRecipeListView;

    private List<Recipe> mRecipeList = new ArrayList<>();
    private ListRecipesAdapter mRecipesAdapter;
    private Categories mCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);


        getData();
        setRecipeIcon();

        mRecipesAdapter = new ListRecipesAdapter(this, mRecipeList);
        mRecipeListView.setAdapter(mRecipesAdapter);
    }

    private void getData(){
        DBMenager dbMenager = new DBMenager(this);
        Cursor cursor = dbMenager.readRecipeForDatabase();
        while(cursor.moveToNext()){
            Recipe recipe = new Recipe();
            recipe.setName(cursor.getString(0));
            recipe.setTime(cursor.getInt(1));
            recipe.setServes(cursor.getInt(2));
            recipe.setIngeedients(cursor.getString(3).split("`"));
            recipe.setDescriptions(cursor.getString(4).split("`"));
            mRecipeList.add(recipe);
        }
    }

    private void setRecipeIcon(){
        mRecipeList.get(0).setIcon(R.drawable.jajecznica_z_jarmuzem);
        mRecipeList.get(1).setIcon(R.drawable.omlet_sniadaniowy);
    }

    @OnItemClick(R.id.recipeListView)
    public void clickOnRecipeList(int position){
        Recipe recipe = (Recipe) mRecipesAdapter.getItem(position);
        Intent intent = new Intent(this, RecipeDetailsActivity.class);
        intent.putExtra(KeyClas.RECIPE, recipe);
        startActivity(intent);
    }
}
