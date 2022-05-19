package com.example.qiuxiexianweijing.ThirdLevel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.qiuxiexianweijing.DBOpenhelper;
import com.example.qiuxiexianweijing.R;
import com.example.qiuxiexianweijing.bean.User;
import com.example.qiuxiexianweijing.utils.ToastUtil;

public class personalupdatepwd extends AppCompatActivity {
private EditText metName,metPwd,metconfirm;
private DBOpenhelper mDBopenhelper;
private Button mUPdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalupdatepwd);
        initview();
        mDBopenhelper=new DBOpenhelper(this);
    }



    public void onClick(View view) {
         String username =metName.getText().toString().trim();
        String confirmpwd=metconfirm.getText().toString().trim();
         String pwd=metPwd.getText().toString().trim();

         if(  (username!="") && (confirmpwd!="") && (pwd!="") && (confirmpwd.equals(pwd))
                 &&(confirmpwd.length() != 0) && (pwd.length() != 0) ){
             User user=new User();
             user.setUsername(username);
             user.setUserpwd(pwd);
             int rowId =mDBopenhelper.updateData(user) ;
             if (rowId > 0)
             {
                 ToastUtil.toastShort(this,"密码更新成功!"); ;
             }
             else {
                 ToastUtil.toastShort(this,"密码更新失败。");
             }
         }
         else{
             ToastUtil.toastShort(this,"两次密码输入不一致，或用户与密码输入为空，请重新输入");
         }
    }




    private void initview() {
        metName=findViewById(R.id.ETUPName);
        metPwd=findViewById(R.id.ETUPPWD);
        metconfirm=findViewById(R.id.ETconfirm);
        mUPdate=findViewById(R.id.Button_Update);
    }

}