package com.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ki264 on 2016/11/28.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;
    private String[] data;

    public MyAdapter(Context mContext, String[] data) {
        this.mContext = mContext;
        this.data = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.textView1);
            mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (view instanceof TextView) {
                        Toast.makeText(mContext, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_iew, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position % 2 == 0) {
            holder.mTextView.setTextColor(0xFF000000);
        } else {
            holder.mTextView.setTextColor(0xFFAAAAAA);
        }
        holder.mTextView.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
}
