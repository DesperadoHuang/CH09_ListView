package com.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ki264 on 2016/12/11.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] data;
    private static Context mContext;

    public MyAdapter(String[] data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_textview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        if (position % 2 == 0) {
            holder.mTextView.setTextColor(0xff000000);
        } else {
            holder.mTextView.setTextColor(0xffaaaaaa);
        }
        holder.mTextView.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.textView);
            mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
