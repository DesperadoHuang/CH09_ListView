package com.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by ki264 on 2016/12/11.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private int[] imageData;

    public MyAdapter(int[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_image_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mImageView.setImageResource(imageData[position]);
    }

    @Override
    public int getItemCount() {
        return imageData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.mImageView);
        }
    }
}
