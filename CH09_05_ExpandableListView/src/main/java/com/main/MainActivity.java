package com.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
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

        for (int i = 0; i < menu_group.length; i++) {
            //group
            Map<String, String> groupFood = new HashMap<>();
            groupFood.put("groupKey", menu_group[i]);
            group.add(groupFood);

            //sub
            List<Map<String, String>> children = new ArrayList<>();
            for (int j = 0; j < menu_sub[i].length; j++) {
                Map<String, String> childrenMap = new HashMap<>();
                childrenMap.put("childKey", menu_sub[i][j]);
                children.add(childrenMap);
            }
            childrenList.add(children);
        }

        SimpleExpandableListAdapter mAdapter = new SimpleExpandableListAdapter(
                mContext,
                group,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{"groupKey"},
                new int[]{android.R.id.text1},
                childrenList,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{"childKey"},
                new int[]{android.R.id.text1}
        );

        mExpandableListView.setAdapter(mAdapter);
        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                String mainFood = menu_group[i];
                String subFood = menu_sub[i][i1];
                Toast.makeText(mContext, mainFood + ":" + subFood, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
