package com.main;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ki264 on 2016/11/23.
 */

public class FastfoodAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private ArrayList<Fastfood> mFastfoodsList;

    public FastfoodAdapter(Context context, ArrayList<Fastfood> mFastfoodsList) {
        Log.i("test123", "建構子");
        mLayoutInflater = LayoutInflater.from(context);
        this.mFastfoodsList = mFastfoodsList;
    }

    @Override
    public int getCount() {
        Log.i("test123", "getCount");
        return mFastfoodsList.size();
    }

    @Override
    public Object getItem(int i) {
        Log.i("test123", "getItem");
        return mFastfoodsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        Log.i("test123", "getItemId");
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.i("test123", "getView");
        ViewHolder viewHolder;

        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.row, null);

            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.name);
            viewHolder.price = (TextView) view.findViewById(R.id.price);
            viewHolder.image = (ImageView) view.findViewById(R.id.image);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Fastfood fastfood = mFastfoodsList.get(i);

        viewHolder.name.setText(fastfood.getName());
        viewHolder.price.setText(String.valueOf(fastfood.getPrice()));
        viewHolder.image.setImageResource(fastfood.getImageID());


        return view;
    }

    private class ViewHolder {
        TextView name;
        TextView price;
        ImageView image;
    }

}
