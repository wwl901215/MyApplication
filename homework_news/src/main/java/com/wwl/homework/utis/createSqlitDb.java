package com.wwl.homework.utis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/6/24.
 */
public class createSqlitDb {
   private  MyHelper helper;
    public createSqlitDb(Context context){
        helper=new MyHelper(context);
    }

    public  boolean insert(HashMap<String,String> map) {
        SQLiteDatabase db = null; // alt + 方向键
        try {

            db = helper.getReadableDatabase();


            ContentValues values = new ContentValues();
            values.put("title", map.get("title"));
            values.put("litpic", map.get("litpic"));
            values.put("shorttitle", map.get("shorttitle"));
            values.put("description", map.get("description"));
            long id = db.insert("mynews", null, values);

            return true;
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (db != null && db.isOpen()) { // &&短路与
                db.close();
            }
        }
        return false;
    }

    public Cursor getAllnewsCursor() {
        SQLiteDatabase db = null; // alt + 方向键
        Cursor cursor = null;
        List<HashMap<String,String>> data = new ArrayList<>();
        try {
            // 1获取SqliteDataBase对象
            db = helper.getReadableDatabase(); // ctrl +1
            // cursor =
            // db.rawQuery("select stuNo as _id,stuName,address,money,age from student",
            // null);
            cursor = db.query("mynews", new String[] { "litpic", "shorttitle" }, null, null, null,
                    null, null);

            return cursor;

        } catch (Exception e) {
            // TODO: handle exception
        } finally {

        }

        return null;
    }

    /**
     * 返回所有的学生list map集合
     *
     * @return
     */
    public List<HashMap<String, String>> getAllnewsMapList() {
        Cursor cursor = getAllnewsCursor();
        // 把Cursor转成List<HashMap>

        return cursortToList(cursor);
    }

    /**
     * 把Cursor转成List<HashMap>
     *
     * @return
     */
    private List<HashMap<String, String>> cursortToList(Cursor cursor) {
        try {
            // 集合
            List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
            while (cursor.moveToNext()) { // 每循环一条数据 ，其实就是一个hashMap
                HashMap<String, String> map = new HashMap<String, String>();
                // 1获取所有的字段名
                String[] columnNames = cursor.getColumnNames();

                for (int i = 0; i < columnNames.length; i++) {
                    // 2值
                    Object value = null;
                    // 3获取每列的数据的类型
                    int type = cursor.getType(i);
                    switch (type) {
                        case Cursor.FIELD_TYPE_INTEGER:
                            value = cursor.getInt(i);
                            break;
                        case Cursor.FIELD_TYPE_STRING:
                            value = cursor.getString(i);
                            break;
                        case Cursor.FIELD_TYPE_FLOAT:
                            value = cursor.getDouble(i);
                            break;
                        case Cursor.FIELD_TYPE_NULL:
                            value = null;
                            break;
                        case Cursor.FIELD_TYPE_BLOB:
                            value = cursor.getBlob(i);
                            break;
                        default:
                            break;
                    }

                    map.put(columnNames[i], (String) value);

                }
                data.add(map);

            }
            return data;
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (cursor != null && !cursor.isClosed())
                cursor.close();
        }
        return null;
    }



}
