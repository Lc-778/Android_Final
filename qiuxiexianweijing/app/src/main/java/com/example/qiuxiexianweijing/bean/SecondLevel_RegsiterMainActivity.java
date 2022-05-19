package com.example.qiuxiexianweijing.bean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.qiuxiexianweijing.DBOpenhelper;
import com.example.qiuxiexianweijing.MainActivity;
import com.example.qiuxiexianweijing.R;
import com.example.qiuxiexianweijing.SPSave;
import com.example.qiuxiexianweijing.Saveusername;
import com.example.qiuxiexianweijing.utils.ToastUtil;

import java.util.Map;

public class SecondLevel_RegsiterMainActivity extends AppCompatActivity implements View.OnClickListener {
private ImageButton MIMGreturn;
private EditText Met_register_username,Met_register_pwd;
private Button MBtn_register;
private DBOpenhelper MDBOpenhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_level_regsiter_main);
        initview();
        MDBOpenhelper=new DBOpenhelper(this);


    }

    private void initview() {
        MIMGreturn=findViewById(R.id.IMG_return);
        MBtn_register=findViewById(R.id.SecondBtn_register);
        Met_register_pwd=findViewById(R.id.Secondet_register_pwd);
        Met_register_username=findViewById(R.id.Secondet_register_username);
        MIMGreturn.setOnClickListener(this);
        MBtn_register.setOnClickListener(this);
     }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.IMG_return:
                Intent intent_return=new Intent();
                intent_return.setClass(SecondLevel_RegsiterMainActivity.this, MainActivity.class);
                startActivity(intent_return);
                break;
            case R.id.SecondBtn_register:
                String username = Met_register_username.getText().toString().trim();
                String pwd = Met_register_pwd.getText().toString().trim();

                User user=new User();
                user.setUsername(username);
                user.setUserpwd(pwd);


                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(pwd)){
                    MDBOpenhelper.insertUserData(user);
                    Intent intent_regsiter = new Intent(this, MainActivity.class);
                    startActivity(intent_regsiter);
                    finish();
                    ToastUtil.toastLong(SecondLevel_RegsiterMainActivity.this, "注册通过，注册成功");
                }else{
                    ToastUtil.toastLong(SecondLevel_RegsiterMainActivity.this, "未完善信息，注册失败");
                }



                break;
        }
    }
}