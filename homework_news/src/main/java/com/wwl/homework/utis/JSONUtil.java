package com.wwl.homework.utis;



import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2016/6/24.
 */
public class JSONUtil {
    public static List<HashMap<String,String>>  requestJson(String json){
        List<HashMap<String,String>> datalist=new ArrayList<HashMap<String, String>>();
        try {

            Log.i("aaa","进入json解析---------------------");
            JSONObject data1=new JSONObject(json);
            JSONObject data=data1.getJSONObject("data");
            Log.i("aaa","进入json解析---------------------"+data.getJSONObject(0+"").toString());

            for (int i=0;i<10;i++){
               JSONObject object= data.getJSONObject(i+"");
                String title=object.getString("title");
                String litpic=object.getString("litpic");
                String shorttitle=object.getString("shorttitle");
                String description=object.getString("description");
                HashMap<String,String> map=new HashMap<>();
                map.put("title",title);
                map.put("litpic","http://www.3dmgame.com"+litpic);
                map.put("shorttitle",shorttitle);
                map.put("description",description);
                Log.i("aaa","title:"+title+"/r/nlitpic:"+litpic);
                datalist.add(map);

            }
            Log.i("aaa",datalist.toString()+".....................大小："+datalist.size());
            return datalist;


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
}
