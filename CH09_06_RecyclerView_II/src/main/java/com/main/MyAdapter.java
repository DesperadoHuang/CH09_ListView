package com.main;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by ki264 on 2016/12/9.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private int[] imageID;

    public MyAdapter(int[] imageData) {
        this.imageID = imageData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_image_view, parent, false);
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i("mytest", "建立圖片:" + position);
        holder.mImageView.setImageResource(imageID[position]);
    }

    @Override
    public int getItemCount() {
        return imageID.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.myImageView);

        }
    }
}
