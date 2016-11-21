package com.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private String[] fastfood;
    private ListAdapter adapter;
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.emptyView)
    TextView emptyView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = this;

        listView.setEmptyView(emptyView);
        fastfood = getResources().getStringArray(R.array.fastfood);

        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_expandable_list_item_1, fastfood);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = adapterView.getItemAtPosition(i).toString();
                Log.i("test1", "onItemClick " + i + " " + l + " " + str);
            }
        });
    }
}
