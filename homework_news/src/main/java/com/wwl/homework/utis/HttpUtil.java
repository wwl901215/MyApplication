package com.wwl.homework.utis;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/6/24.
 */
public class HttpUtil {
    public static byte[] request(String path){
        ByteArrayOutputStream baos=null;
        try {
            URL url=new URL(path);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            connection.connect();
            if(connection.getResponseCode()==200){
                baos=new ByteArrayOutputStream();
                InputStream is=connection.getInputStream();
                byte[] b=new byte[1024];
                int len =-1;
                while ((len=is.read(b,0,b.length))!=-1){
                    baos.write(b,0,len);
                }
                is.close();
                return baos.toByteArray();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
