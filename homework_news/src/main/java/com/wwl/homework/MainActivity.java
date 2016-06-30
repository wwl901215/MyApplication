package com.wwl.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private  String urlpath="http://www.3dmgame.com/sitemap/api.php?row=10&typeid=1&paging=1&page=";
   private int indexs=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Intent intent1=new Intent(this,MyService.class);
        intent1.putExtra("urlpath",urlpath+indexs);
        startService(intent1);


        Button btn= (Button) this.findViewById(R.id.btn_shownews);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,OtherActivity.class);
                    stopService(intent1);
                startActivity(intent);
            }
        });
    }
}
