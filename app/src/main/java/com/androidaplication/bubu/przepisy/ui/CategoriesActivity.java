package com.androidaplication.bubu.przepisy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.androidaplication.bubu.przepisy.recipes.Categories;
import com.androidaplication.bubu.przepisy.recipes.KeyClas;
import com.androidaplication.bubu.przepisy.R;
import com.androidaplication.bubu.przepisy.adapters.ListCategotyAdapters;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class CategoriesActivity extends AppCompatActivity {
    @Bind(R.id.categoryListView) ListView mCategoryListView;

    private List<Categories> mCategoriesList = new ArrayList<>();
    private ListCategotyAdapters mListCategotyAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        addCategories(R.drawable.sniadania, "Sniadania");
        //addCategories(R.drawable.cloudy, "Przekaski");

        mListCategotyAdapters = new ListCategotyAdapters(this, mCategoriesList);
        mCategoryListView.setAdapter(mListCategotyAdapters);
    }

    private void addCategories(int iconId, String name){
        Categories category = new Categories();
        category.setIcon(iconId);
        category.setName(name);
        mCategoriesList.add(category);
    }

    @OnItemClick(R.id.categoryListView)
    public void showCategory(int position){
        Categories category = (Categories) mListCategotyAdapters.getItem(position);
        Intent intent = new Intent(this, RecipesActivity.class);
        intent.putExtra(KeyClas.CATEGORY, category);
        startActivity(intent);
    }
}
