package com.main;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity {
    private Context mContext;
    private ArrayList<HashMap<String, Object>> itemArrayList;
    private SimpleAdapter mSimpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        HashMap<String, Object> hamburger = new HashMap<>();
        hamburger.put("name", "Hamburger");
        hamburger.put("price", 50);
        hamburger.put("image", R.drawable.hamburger);

        HashMap<String, Object> french = new HashMap<>();
        french.put("name", "French");
        french.put("price", 30);
        french.put("image", R.drawable.french_fries);

        HashMap<String, Object> coca = new HashMap<>();
        coca.put("name", "Coca Cola");
        coca.put("price", 20);
        coca.put("image", R.drawable.coca_cola);

        itemArrayList = new ArrayList<>();
        itemArrayList.add(hamburger);
        itemArrayList.add(french);
        itemArrayList.add(coca);

        mSimpleAdapter = new SimpleAdapter(
                mContext,
                itemArrayList,
                R.layout.row,
                new String[]{"name", "price", "image"},
                new int[]{R.id.name, R.id.price, R.id.image}
        );

        setListAdapter(mSimpleAdapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HashMap<String, Object> item = (HashMap<String, Object>) adapterView.getItemAtPosition(i);
                String message = "您選擇的是：" + item.get("name").toString() + "，價格：" + item.get("price");
                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
