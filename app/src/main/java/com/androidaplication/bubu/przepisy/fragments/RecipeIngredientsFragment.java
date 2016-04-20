package com.androidaplication.bubu.przepisy.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.androidaplication.bubu.przepisy.R;
import com.androidaplication.bubu.przepisy.adapters.ListIngridientAdapter;
import com.androidaplication.bubu.przepisy.recipes.KeyClas;
import com.androidaplication.bubu.przepisy.recipes.Recipe;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecipeIngredientsFragment extends Fragment {
    @Bind(R.id.timeTetView) TextView mTimeText;
    @Bind(R.id.servesTetView) TextView mServeText;
    @Bind(R.id.ingredientsListView) ListView mIngridientsListView;

    private ListIngridientAdapter mListIngridientAdapter;
    private Recipe mRecipe;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if(bundle != null){
            mRecipe = bundle.getParcelable(KeyClas.RECIPE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ingridients_layout, container, false);
        ButterKnife.bind(this, view);
        initUiComponents();
        return view;
    }

    private void initUiComponents() {
        getActivity().setTitle(mRecipe.getName());
        mTimeText.setText(mRecipe.getTime() + " minut");
        mServeText.setText(mRecipe.getServes() + "");
        mListIngridientAdapter = new ListIngridientAdapter(getActivity(), mRecipe.getIngeedients());
        mIngridientsListView.setAdapter(mListIngridientAdapter);
    }

    public static RecipeIngredientsFragment getInstance(Recipe recipe){
        RecipeIngredientsFragment fragment = new RecipeIngredientsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KeyClas.RECIPE, recipe);
        fragment.setArguments(bundle);

        return fragment;
    }
}
