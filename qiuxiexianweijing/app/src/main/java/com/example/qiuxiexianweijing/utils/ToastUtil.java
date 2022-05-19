package com.example.qiuxiexianweijing.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

    public static void toastShort (Context context,String info){
        Toast.makeText (context, info, Toast.LENGTH_SHORT).show();
    }
    public static void toastLong (Context context, String info){
        Toast.makeText (context, info,Toast.LENGTH_LONG).show() ;
    }

}
