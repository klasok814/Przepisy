package com.androidaplication.bubu.przepisy.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

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
    @Bind(R.id.recipeLabel)  TextView mRecipeLabel;

    private List<Recipe> mRecipeList = new ArrayList<>();
    private ListRecipesAdapter mRecipesAdapter;
    private Categories mCategory;
    private int mposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);

        getCategory();
        getCategoryData(mposition);
        setRecipeIcon(mposition);

        getSupportActionBar().setSubtitle(mCategory.getName());
        mRecipeLabel.setText(mCategory.getName());

        mRecipesAdapter = new ListRecipesAdapter(this, mRecipeList);
        mRecipeListView.setAdapter(mRecipesAdapter);
    }

    private void getCategoryData(int position){
        switch(position){
            case 0:
                getData(DBMenager.TABLE_BREAKFAST_NAME);
                break;
            case 1:
                getData(DBMenager.TABLE_SNACKS_NAME);
                break;
            case 2:
                getData(DBMenager.TABLE_SALADS_NAME);
                break;
            case 3:
                getData(DBMenager.TABLE_SOUPS_NAME);
                break;
            case 4:
                getData(DBMenager.TABLE_CAKES_NAME);
                break;
            case 5:
                getData((DBMenager.TABLE_DRINKS_NAME));
                break;
        }
    }

    private void getData(String tableName){
        DBMenager dbMenager = new DBMenager(this);
        Cursor cursor = dbMenager.readRecipeForDatabase(tableName);
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

    private void getCategory(){
        mCategory = getIntent().getExtras().getParcelable(KeyClas.CATEGORY);
        mposition = getIntent().getExtras().getInt(KeyClas.POSITION);
    }

    private void setRecipeIcon(int position){
        switch(position){
            case 0:
                mRecipeList.get(0).setIcon(R.drawable.jajecznica_z_jarmuzem);
                mRecipeList.get(1).setIcon(R.drawable.omlet_sniadaniowy);
                mRecipeList.get(2).setIcon(R.drawable.babeczki);
                break;
            case 1:
                mRecipeList.get(0).setIcon(R.drawable.wrapy);
                break;
            case 2:
                mRecipeList.get(0).setIcon(R.drawable.salatka_arbuzowa);
                break;
            case 3:
                mRecipeList.get(0).setIcon(R.drawable.zupa_dyniowa);
                break;
            case 4:
                mRecipeList.get(0).setIcon(R.drawable.kulki_koksowe);
                break;
            case 5:
                mRecipeList.get(0).setIcon(R.drawable.koktajl_szpinakowy);
                break;
        }

    }

    @OnItemClick(R.id.recipeListView)
    public void clickOnRecipeList(int position){
        Recipe recipe = (Recipe) mRecipesAdapter.getItem(position);
        Intent intent = new Intent(this, RecipeDetailsActivity.class);
        intent.putExtra(KeyClas.RECIPE, recipe);
        startActivity(intent);
    }
}
