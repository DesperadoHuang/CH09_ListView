package com.main;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    private Context mContext;
    private FastfoodAdapter mFastfoodAdapter;
    private ArrayList<Fastfood> mFastfoodsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        mFastfoodsList = new ArrayList<>();
        mFastfoodsList.add(new Fastfood("漢堡", 50, R.drawable.hamburger));
        mFastfoodsList.add(new Fastfood("薯條", 40, R.drawable.french_fries));
        mFastfoodsList.add(new Fastfood("可樂", 20, R.drawable.coca_cola));

        mFastfoodAdapter = new FastfoodAdapter(mContext, mFastfoodsList);

        setListAdapter(mFastfoodAdapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fastfood mFastfood = (Fastfood) adapterView.getItemAtPosition(i);
                Log.i("test123", mFastfood.getName().toString() + " " + String.valueOf(mFastfood.getPrice()));
            }
        });
    }
}
