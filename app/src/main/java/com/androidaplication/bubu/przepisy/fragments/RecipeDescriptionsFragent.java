package com.androidaplication.bubu.przepisy.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.androidaplication.bubu.przepisy.R;
import com.androidaplication.bubu.przepisy.adapters.ListDescriptionAdapter;
import com.androidaplication.bubu.przepisy.recipes.KeyClas;
import com.androidaplication.bubu.przepisy.recipes.Recipe;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Klaudia on 2016-04-19.
 */
public class RecipeDescriptionsFragent extends Fragment {
    @Bind(R.id.descriptionListView)  ListView mDescriptionListView;

    private ListDescriptionAdapter mListDescriptionAdapter;
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
        View view = inflater.inflate(R.layout.description_layout, container, false);
        ButterKnife.bind(this, view);
        initUiComponents();
        return view;
    }

    private void initUiComponents() {

        mListDescriptionAdapter = new ListDescriptionAdapter(getActivity(), mRecipe.getDescriptions());
        mDescriptionListView.setAdapter(mListDescriptionAdapter);
    }
    public static RecipeDescriptionsFragent getInstance(Recipe recipe){
        RecipeDescriptionsFragent fragment = new RecipeDescriptionsFragent();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KeyClas.RECIPE, recipe);
        fragment.setArguments(bundle);

        return fragment;
    }
}
