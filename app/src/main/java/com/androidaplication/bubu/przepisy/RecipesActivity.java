package com.androidaplication.bubu.przepisy;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecipesActivity extends AppCompatActivity {
    @Bind(R.id.recipeListView) ListView mRecipeListView;

    private List<Recipe> mRecipeList = new ArrayList<>();
    private ListRecipesAdapter mRecipesAdapter;

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
}
