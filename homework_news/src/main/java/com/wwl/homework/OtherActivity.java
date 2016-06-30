package com.wwl.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import com.wwl.homework.utis.MyAdapter;
import com.wwl.homework.utis.MyHelper;

public class OtherActivity extends AppCompatActivity {
private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        lv= (ListView) this.findViewById(R.id.lv_shownews);
        //获取数据库中的数据
        MyAdapter adapter=new MyAdapter(this);
        lv.setAdapter(adapter);


    }
}
