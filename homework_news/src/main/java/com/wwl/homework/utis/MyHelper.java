package com.wwl.homework.utis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/6/24.
 */
public class MyHelper extends SQLiteOpenHelper{


    public MyHelper(Context context) {
        super(context, "mynews.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists mynews(title varchar(100),litpic varchar(100),shorttitle varchar(50),description varchar(1000))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
