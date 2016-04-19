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
public class ListIngridientAdapter extends BaseAdapter{
        private Context mContext;
        private String[] mIngridientsTab;

        public ListIngridientAdapter(Context context, String[] ingridientsTab){
            mContext = context;
            mIngridientsTab = ingridientsTab;
        }

        @Override
        public int getCount() {
            return mIngridientsTab.length;
        }

        @Override
        public Object getItem(int position) {
            return mIngridientsTab[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if(convertView == null){
                convertView = LayoutInflater.from(mContext).inflate(R.layout.ingridient_list_layout, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else holder = (ViewHolder) convertView.getTag();

            String ingredient = mIngridientsTab[position];
            holder.mSimpleIngridientTex.setText(ingredient);

            return convertView;
        }

        public class ViewHolder{
            @Bind(R.id.simpleIngridientText)
            TextView mSimpleIngridientTex;

            public ViewHolder(View view){
                ButterKnife.bind(this, view);
            }
        }
    }


