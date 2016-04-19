package com.androidaplication.bubu.przepisy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidaplication.bubu.przepisy.recipes.Categories;
import com.androidaplication.bubu.przepisy.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListCategotyAdapters extends BaseAdapter {
    private Context mContext;
    private List<Categories> mCategories;

    public ListCategotyAdapters(Context context, List<Categories> categories){
        mContext = context;
        mCategories = categories;
    }

    @Override
    public int getCount() {
        return mCategories.size();
    }

    @Override
    public Object getItem(int position) {
        return mCategories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.categories_list_layout, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else  holder = (ViewHolder) convertView.getTag();

        Categories category = mCategories.get(position);
        holder.mCategoryImage.setImageResource(category.getIcon());
        holder.mCategoryText.setText(category.getName());

        return convertView;
    }

    public class ViewHolder{
        @Bind(R.id.categoryImage) ImageView mCategoryImage;
        @Bind(R.id.categoryText) TextView mCategoryText;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
