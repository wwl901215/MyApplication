package com.wwl.homework.utis;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wwl.homework.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/6/25.
 */
public class MyAdapter extends BaseAdapter {
    private List<HashMap<String, String>> data;
    private Context context;
    public MyAdapter( Context context) {
        super();
        this.data =new createSqlitDb(context).getAllnewsMapList();
        this.context = context;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewholder holder=null;
        if (view==null){
            view=View.inflate(context, R.layout.listview_item,null);
            holder=new viewholder();
            holder.iv= (ImageView) view.findViewById(R.id.iv);
            holder.tv= (TextView) view.findViewById(R.id.tv);
            view.setTag(holder);
        }else{
            holder= (viewholder) view.getTag();
        }
        holder.tv.setText(data.get(i).get("shorttitle").toString());
        String imgfilepath=data.get(i).get("litpic");
        Log.i("aaa","在MyAdapter中，刚获得imgfilepath路径："+imgfilepath);
        try {
            FileInputStream is=new FileInputStream(new File(imgfilepath));
            Bitmap bitmap= BitmapFactory.decodeStream(is);
            holder.iv.setImageBitmap(bitmap);
            Log.i("aaa","成功把图片取出并放入imageview控件中（目前还在MyAdapter中）");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return view;
    }
    class viewholder {
        ImageView iv;
        TextView tv;
    }

}
