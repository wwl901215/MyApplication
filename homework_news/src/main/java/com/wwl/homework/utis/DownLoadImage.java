package com.wwl.homework.utis;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2016/6/24.
 */
public class DownLoadImage {
    public static String downAndSaveImage(String urlpath){
        byte[] imagedata=HttpUtil.request(urlpath);
        String[] getname =urlpath.split("/");
        String imagename=getname[getname.length-1];
        try {
           return saveFile(imagedata,imagename);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("aaa","伤心太平洋");
        return null;
    }


    public static  String saveFile(byte[] data,String filename) throws Exception{
       String absolutepath=null;
        if(data!=null) {
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File file = new File(root, filename);
                absolutepath= file.getAbsolutePath();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(data, 0, data.length);
                fileOutputStream.close();
            }
        }else{
            Log.i("aaa","网络有异常，并且保存图片失败----------");
        }

        return absolutepath;
    }

}
