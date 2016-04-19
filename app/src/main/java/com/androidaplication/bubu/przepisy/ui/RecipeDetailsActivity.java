package com.androidaplication.bubu.przepisy.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.androidaplication.bubu.przepisy.R;
import com.androidaplication.bubu.przepisy.adapters.RecipePagerAdapter;
import com.androidaplication.bubu.przepisy.recipes.KeyClas;
import com.androidaplication.bubu.przepisy.recipes.Recipe;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecipeDetailsActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    @Bind(R.id.tabLayout) TabLayout mTabLayout;

    Recipe mRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        ButterKnife.bind(this);

        mRecipe = getIntent().getExtras().getParcelable(KeyClas.RECIPE);

        RecipePagerAdapter recipePagerAdapter = new RecipePagerAdapter(getSupportFragmentManager(), this, mRecipe);
        mViewPager.setAdapter(recipePagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
