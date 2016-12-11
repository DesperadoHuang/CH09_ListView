package com.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private MyAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager manager;
    private int[] imageID =
            {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                    R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10,
                    R.drawable.pic11, R.drawable.pic12, R.drawable.pic13, R.drawable.pic14, R.drawable.pic15,
                    R.drawable.pic16, R.drawable.pic17, R.drawable.pic18, R.drawable.pic19, R.drawable.pic20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mAdapter = new MyAdapter(imageID);
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        manager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
