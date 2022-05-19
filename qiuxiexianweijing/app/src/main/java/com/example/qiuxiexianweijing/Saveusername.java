package com.example.qiuxiexianweijing;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Saveusername {
    public static final String ACCOUNT ="account" ;
    public static final String PASSWORD = "password";
    private static final String FILENAME ="data.txt";


    public static boolean saveUserInfo(Context context,String account,String password){
        FileOutputStream fos =null;
        try {
            fos=context.openFileOutput(FILENAME,Context.MODE_PRIVATE);
            fos.write((account+":"+password).getBytes());
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            if (fos !=null){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }
    }


    public static Map<String,String> getUserInfo(Context context){
        String content= "";
        FileInputStream fis=null;
        try {
            fis=context.openFileInput(FILENAME);
            byte[]buffer=new byte[fis.available()];
            fis.read(buffer);
            content=new String(buffer);
            Map<String,String> userMap =new HashMap<String,String>();
            String[] infos=content.split(":");
            userMap.put(ACCOUNT,infos[0]);
            userMap.put(PASSWORD,infos[1]);
            return userMap;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try {
                if (fis !=null){
                    fis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
