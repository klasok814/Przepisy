package com.androidaplication.bubu.przepisy.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.androidaplication.bubu.przepisy.R;
import com.androidaplication.bubu.przepisy.fragments.RecipeDescriptionsFragent;
import com.androidaplication.bubu.przepisy.fragments.RecipeIngredientsFragment;
import com.androidaplication.bubu.przepisy.recipes.Recipe;

/**
 * Created by Klaudia on 2016-04-19.
 */
public class RecipePagerAdapter extends FragmentStatePagerAdapter {
    private static final int PAGES = 2;
    private static final int INGREDIENTS_PAGE = 0;
    private static final int DESCRIPTIONS_PAGE = 1;

    private Context mContext;
    private Recipe mRecipe;


    public RecipePagerAdapter(FragmentManager fm, Context context, Recipe recipe) {
        super(fm);
        mContext = context;
        mRecipe = recipe;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case INGREDIENTS_PAGE:
                return RecipeIngredientsFragment.getInstance(mRecipe);
            case DESCRIPTIONS_PAGE:
                return RecipeDescriptionsFragent.getInstance(mRecipe);
            default: return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case INGREDIENTS_PAGE:
                return mContext.getString(R.string.ingridients);
            case DESCRIPTIONS_PAGE:
                return mContext.getString(R.string.descriptions);
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return PAGES;
    }
}
