package com.example.qiuxiexianweijing.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyrecordUtil {
    public static final String DATABASE_NAME = "record.db";//数据库名
    public static final String DATABASE_TABLE = "record";  //表名
    public static final int DATABASE_VERION = 1;          //数据库版本
    //数据库表中的列名
    public static final String RECORD_ID = "id";
    public static final String RECORD_CONTENT = "content";
    public static final String RECORD_TIME = "recordtime";
    //获取当前日期
    public static final String getTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }
}
