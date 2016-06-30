package com.wwl.tuya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class TuYaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        TuYaView tuYaView=new TuYaView(TuYaActivity.this,displayMetrics.widthPixels,displayMetrics.heightPixels);
        setContentView(tuYaView);
    }
}
