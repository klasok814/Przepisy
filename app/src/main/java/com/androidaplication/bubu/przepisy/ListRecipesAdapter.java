package com.androidaplication.bubu.przepisy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListRecipesAdapter extends BaseAdapter {
    private Context mContext;
    private List<Recipe> mRecipeList;

    public ListRecipesAdapter(Context context, List<Recipe> recipeList){
        mContext = context;
        mRecipeList = recipeList;
    }

    @Override
    public int getCount() {
        return mRecipeList.size();
    }

    @Override
    public Object getItem(int position) {
        return mRecipeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.recipes_list_layout, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else holder = (ViewHolder) convertView.getTag();

        Recipe recipe = mRecipeList.get(position);
        holder.mRecipeIconView.setImageResource(recipe.getIcon());
        holder.mRecipeTextView.setText(recipe.getName());

        return convertView;
    }

    public class ViewHolder{
        @Bind(R.id.recipeImage) ImageView mRecipeIconView;
        @Bind(R.id.recipeText) TextView mRecipeTextView;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
