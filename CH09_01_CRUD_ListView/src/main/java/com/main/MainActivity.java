package com.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.bt_addRecord)
    Button btAddRecord;

    private Context context;
    private ListAdapter adapter;
    private ArrayList<String> mArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = this;
        listView.setEmptyView(textView);
        mArrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_expandable_list_item_1,
                mArrayList);
        listView.setAdapter(adapter);
        listView.setDivider(null);//消除格線
        registerForContextMenu(listView);
    }

    @OnClick(R.id.bt_addRecord)
    public void onClick() {
        mArrayList.add(getRandomString());
        ((BaseAdapter) adapter).notifyDataSetChanged();
        listView.setSelection(adapter.getCount() - 1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.content_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = menuInfo.position;
        switch (item.getItemId()) {
            case R.id.show:
                Toast.makeText(context,
                        listView.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.update:
                mArrayList.set(position, "Update:" + getRandomString());
                ((BaseAdapter) adapter).notifyDataSetChanged();
                break;
            case R.id.delete:
                mArrayList.remove(position);
                ((BaseAdapter) adapter).notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private String getRandomString() {
        return String.valueOf((int) (Math.random() * 1000));
    }
}
