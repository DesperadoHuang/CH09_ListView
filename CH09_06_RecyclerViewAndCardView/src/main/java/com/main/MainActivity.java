package com.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private LinearLayoutManager mLayoutManager;
    private MyAdapter myAdapter;
    private RecyclerView mRecyclerView;
    private String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(mLayoutManager);
        data = getResources().getStringArray(R.array.languages);
        myAdapter = new MyAdapter(data, mContext);
        mRecyclerView.setAdapter(myAdapter);
    }
}
