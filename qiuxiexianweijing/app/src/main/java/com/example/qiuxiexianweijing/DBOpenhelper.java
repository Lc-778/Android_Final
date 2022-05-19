package com.example.qiuxiexianweijing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import com.example.qiuxiexianweijing.bean.User;

import java.util.ArrayList;
import java.util.List;

public class DBOpenhelper extends SQLiteOpenHelper {
    private static final String DB_NAME="MySQLite.db";
    private static final String TABLE_NAME_USER="user";
    private static final String CREATE_TABLE_SQL_User="create table " + TABLE_NAME_USER +
            " (_id integer primary key autoincrement, name text,password text)";
    //创建学生表 注意空格
    public DBOpenhelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBOpenhelper(Context context){
        super(context,DB_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL_User);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public long insertUserData(User user){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",user.getUsername());
        contentValues.put("password",user.getUserpwd());

        return db.insert(TABLE_NAME_USER,null,contentValues);
    }
    public ArrayList<User> getAllData(){
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<User> Userlist = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME_USER,null,null,null,null,null,"name DESC");
        if ( cursor != null){
            while(cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String password = cursor.getString(cursor.getColumnIndex("password"));

                User user =new User () ;
                user.setUsername(name);
                user.setUserpwd(password);
                Userlist.add(user);
            }
            cursor.close();
        }
        return Userlist;
    }
    public List<User> queryAllthing() {
        SQLiteDatabase db = getReadableDatabase();
        List<User> Userlist = new ArrayList<>();
        if (db.isOpen()) {
            Cursor cursor = db.query(TABLE_NAME_USER, null,null,
                    null, null, null, null);
            while (cursor.moveToNext()) {
                String user_name = cursor.getString(1);
                User user = new User();
                user.setUsername(user_name);

                Userlist.add(user);
            }
            cursor.close();
        }
        return Userlist;
    }



    public int updateData ( User user) {
        SQLiteDatabase db = getWritableDatabase ( ) ;
        ContentValues values = new ContentValues ( ) ;
        values.put ("name", user.getUsername() ) ;
        values.put ("password" , user.getUserpwd()) ;

        return db.update(TABLE_NAME_USER,values,"name like ?", new String[]{user.getUsername()});
    }




}
