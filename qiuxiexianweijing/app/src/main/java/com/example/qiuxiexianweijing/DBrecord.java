package com.example.qiuxiexianweijing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.qiuxiexianweijing.bean.Record;
import com.example.qiuxiexianweijing.utils.DailyrecordUtil;

import java.util.ArrayList;
import java.util.List;

public class DBrecord extends SQLiteOpenHelper {
    private SQLiteDatabase dBrecord;





    public DBrecord(Context context){
        super(context, DailyrecordUtil.DATABASE_NAME, null, DailyrecordUtil.DATABASE_VERION);
        dBrecord = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table "+DailyrecordUtil.DATABASE_TABLE+"("+DailyrecordUtil.RECORD_ID+
                " integer primary key autoincrement,"+ DailyrecordUtil.RECORD_CONTENT +
                " text," + DailyrecordUtil.RECORD_TIME+ " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {}




    public boolean insertData(String userContent,String userTime){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DailyrecordUtil.RECORD_CONTENT,userContent);
        contentValues.put(DailyrecordUtil.RECORD_TIME,userTime);
        return
                dBrecord.insert(DailyrecordUtil.DATABASE_TABLE,null,contentValues)>0;
    }

    public boolean deleteData(String id){
        String sql=DailyrecordUtil.RECORD_ID+"=?";
        String[] contentValuesArray=new String[]{String.valueOf(id)};
        return
                dBrecord.delete(DailyrecordUtil.DATABASE_TABLE,sql,contentValuesArray)>0;
    }


    public boolean updateData(String id,String content,String userYear){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DailyrecordUtil.RECORD_CONTENT,content);
        contentValues.put(DailyrecordUtil.RECORD_TIME,userYear);
        String sql=DailyrecordUtil.RECORD_ID+"=?";
        String[] strings=new String[]{id};
        return
                dBrecord.update(DailyrecordUtil.DATABASE_TABLE,contentValues,sql,strings)>0;
    }

    public List<Record> query(){
        List<Record> list=new ArrayList<Record>();
        Cursor cursor=dBrecord.query(DailyrecordUtil.DATABASE_TABLE,null,null,null,
                null,null,DailyrecordUtil.RECORD_ID+" desc");
        if (cursor!=null){
            while (cursor.moveToNext()){
                Record recordInfo=new Record();
                String id = String.valueOf(cursor.getInt
                        (cursor.getColumnIndex(DailyrecordUtil.RECORD_ID)));
                String content = cursor.getString(cursor.getColumnIndex
                        (DailyrecordUtil.RECORD_CONTENT));
                String time = cursor.getString(cursor.getColumnIndex
                       (DailyrecordUtil.RECORD_TIME));
                recordInfo.setId(id);
                recordInfo.setRecordContent(content);
                recordInfo.setRecordTime(time);
                list.add(recordInfo);
            }
            cursor.close();
        }
        return list;
    }

}
