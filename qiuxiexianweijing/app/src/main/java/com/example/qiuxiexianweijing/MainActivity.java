package com.example.qiuxiexianweijing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qiuxiexianweijing.bean.SecondLevelMainActivity;
import com.example.qiuxiexianweijing.bean.SecondLevel_RegsiterMainActivity;
import com.example.qiuxiexianweijing.bean.User;
import com.example.qiuxiexianweijing.utils.ToastUtil;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button MBtn_login,MBtn_regsiter,MBtn_rember;
private EditText MEt_Name,MEt_pwd;
private DBOpenhelper MDBOpenhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        MDBOpenhelper=new DBOpenhelper(this);
        Map<String,String> userInfo= SPSave.getUserInfo(this);
        if (userInfo !=null){
            MEt_Name.setText(userInfo.get(Saveusername.ACCOUNT));
            MEt_pwd.setText(userInfo.get(Saveusername.PASSWORD));
        }




    }

    private void initview() {
        MBtn_login=findViewById(R.id.Btn_login);
        MBtn_regsiter=findViewById(R.id.Btn_register);
        MBtn_rember=findViewById(R.id.Btn_rember);
        MEt_Name=findViewById(R.id.Et_name);
        MEt_pwd=findViewById(R.id.Et_password);
        MBtn_login.setOnClickListener(this);
        MBtn_regsiter.setOnClickListener(this);
        MBtn_rember.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.Btn_login:
                    String name =MEt_Name.getText().toString().trim();
                    String password=MEt_pwd.getText().toString().trim();
                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)){
                        ArrayList<User> data=MDBOpenhelper.getAllData();
                        Boolean match=false;
                        for (int i=0;i<data.size();i++){
                            User user=data.get(i);
                            if(name.equals(user.getUsername())&& password.equals(user.getUserpwd())){
                                match=true;
                                break;
                            } else {
                                match=false;
                            }
                        }
                        if (match) {
                            ToastUtil.toastLong(this,"登录成功");
                            Intent intent_login=new Intent();
                            intent_login.setClass(MainActivity.this, SecondLevelMainActivity.class);
                            startActivity(intent_login);
                            finish();
                        } else {
                            ToastUtil.toastLong(this,"用户名或密码不正确，请重新输入，或注册");
                        }
                    } else {
                        ToastUtil.toastLong(this,"请输入你的用户名或密码");
                    }
                    break;
                case R.id.Btn_rember:
                    String username = MEt_Name.getText().toString().trim();
                    String pwd = MEt_pwd.getText().toString().trim();
                    User user=new User();
                    user.setUsername(username);
                    user.setUserpwd(pwd);
                    boolean s=SPSave.saveUserInfo(this,username,pwd);
                    if (s){
                        ToastUtil.toastShort(MainActivity.this,"账号密码保存成功");
                    }else {
                        ToastUtil.toastShort(MainActivity.this,"账号密码保存失败");
                    }
                    break;

                case R.id.Btn_register:
                    Intent intent_regsiter=new Intent();
                    intent_regsiter.setClass(MainActivity.this, SecondLevel_RegsiterMainActivity.class);
                    startActivity(intent_regsiter);
                    break;
            }
    }
}