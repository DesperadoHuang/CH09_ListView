package com.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private ExpandableListView mExpandableListView;
    private String[] menu_group = {"主餐", "副餐"};
    private String[][] menu_sub = {{"牛排", "義大利麵", "咖哩飯"}, {"咖啡", "紅茶", "冰淇淋", "奶酪"}};
    private List<Map<String, String>> group = new ArrayList<Map<String, String>>();
    private List<List<Map<String, String>>> childrenList = new ArrayList<List<Map<String, String>>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mExpandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
    }
}
