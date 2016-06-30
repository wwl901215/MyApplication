package com.wwl.homework;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.wwl.homework.utis.DownLoadImage;
import com.wwl.homework.utis.HttpUtil;
import com.wwl.homework.utis.JSONUtil;
import com.wwl.homework.utis.createSqlitDb;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //下载文字，下载图片
        final String path= intent.getStringExtra("urlpath");
        Log.i("aaa","新闻地址："+path);
        new Thread(new Runnable() {
            @Override
            public void run() {
                //从网络中得到json字符流
                Log.i("aaa","新闻地址：-----"+path);
                byte[] newbyte= HttpUtil.request(path);
                if (newbyte!=null){
                    try {
                        String json=new String(newbyte,"UTF-8");
                        //解析json，返回list集合
                        Log.i("aaa","网页内容===================================="+json);
                      List<HashMap<String,String>> listdata=  JSONUtil.requestJson(json);

                            if(listdata==null){
                                Log.i("aaa","json解析失败。。。。。。。。。。。。。。。。");
                            }

                        //可以在子线程中在new数个新的线程吗？？？这样可以提高耗时操作的效率。
                        List<HashMap<String,String>> newlistdata=new ArrayList<HashMap<String, String>>();

                        for (HashMap<String,String> map:listdata){//本地方报空指针异常。。。。。。。。。。。
                          String imageurlpath = map.get("litpic");
                            //在此处实现从list集合中获得图片地址，下载，保存到sd卡，返回图片在手机中的绝对路径
                           String imageSDpath= DownLoadImage.downAndSaveImage(imageurlpath) ;
                            map.remove("litpic");
                            map.put("litpic",imageSDpath);
                            newlistdata.add(map);
                        }


                        //获得图片在手机中的地址后才把list集合加入数据库
                    for (HashMap<String,String> map:newlistdata){
                        new createSqlitDb(getApplicationContext()).insert(map);
                    }

                        NotificationManager manager= (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
                        NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext());
                        builder.setTicker("广播来了");
                        builder.setSmallIcon(R.mipmap.ic_launcher);
                        builder.setContentTitle("下载完毕");
                        builder.setContentText("经百世人生，历万载轮回，苦攀珠峰，总得善果，，，，，终于把图片下载下来啦！！！");

                        manager.notify(100,builder.build());


                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }else{
                    Log.i("aaa","网络内容下载失败");
                }


            }
        }).start();


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
