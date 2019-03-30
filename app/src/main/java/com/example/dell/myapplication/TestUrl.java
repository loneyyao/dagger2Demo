package com.example.dell.myapplication;

import android.text.TextUtils;
import android.util.Log;

/**
 * create by lizejun
 * date 2018/7/23
 */
public class TestUrl {
    public static void main(String args[]){
        makeUrl("http://guanyu.rce-dev.rongcloud.net////////////////////////////////api/////////////////////////groups//////////////zDSgjqQgSNIoDysxhYMxx4/////////////////////////////////////////////////////////////////////////name");
    }

    public static void makeUrl(String url){
        String[] split = url.split("/");
        StringBuilder builder = new StringBuilder();
        for(String str :split){
            if(!TextUtils.isEmpty(str)){
               if(str.startsWith("http")){
                   builder.append(str+"//");
               }else{
                   //todo 最后一组不加斜杠 以及转移斜杠的处理
                   builder.append(str+"/");
               }
            }
        }

        Log.d("lizejun", builder.toString());
    }


}
