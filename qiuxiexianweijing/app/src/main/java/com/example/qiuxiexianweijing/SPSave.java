package com.example.qiuxiexianweijing;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class SPSave {
    public final static String ACCOUNT="account";
    public final static String PASSWORD="password";
    public static boolean saveUserInfo(Context context,String account,String password)
    {
        SharedPreferences sp=
                context.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(ACCOUNT,account);
        editor.putString(PASSWORD,password);
        editor.commit();
        return true;
    }
    public  static Map<String,String>getUserInfo(Context context){
        SharedPreferences sp=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        String account=sp.getString(ACCOUNT,"");
        String password= sp.getString(PASSWORD,"");
        Map<String,String>userMap=new HashMap<String,String>();
        userMap.put("account",account);
        userMap.put("password",password);
        return userMap;
    }
}
