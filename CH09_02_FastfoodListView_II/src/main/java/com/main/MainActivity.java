package com.main;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    private Context mContext;
    private String[] fastfood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        fastfood = getResources().getStringArray(R.array.fastfood);
        ListAdapter mListAdapter = new ArrayAdapter<String>(mContext,
                android.R.layout.simple_expandable_list_item_1,
                fastfood);
        setListAdapter(mListAdapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(mContext,
                        "Click" + adapterView.getItemAtPosition(i).toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
