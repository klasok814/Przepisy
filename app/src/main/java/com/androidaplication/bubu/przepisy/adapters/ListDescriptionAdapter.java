package com.androidaplication.bubu.przepisy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidaplication.bubu.przepisy.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Klaudia on 2016-04-19.
 */
public class ListDescriptionAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mDescriptionTab;

    public ListDescriptionAdapter(Context context, String[] descriptionTab){
        mContext = context;
        mDescriptionTab = descriptionTab;
    }

    @Override
    public int getCount() {
        return mDescriptionTab.length;
    }

    @Override
    public Object getItem(int position) {
        return mDescriptionTab[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.description_list_layout, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else holder = (ViewHolder) convertView.getTag();

        String ingredient = mDescriptionTab[position];
        holder.mSimpleDescriptionTex.setText(ingredient);

        return convertView;
    }

    public class ViewHolder{
        @Bind(R.id.simpleDescriptionText)
        TextView mSimpleDescriptionTex;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}

