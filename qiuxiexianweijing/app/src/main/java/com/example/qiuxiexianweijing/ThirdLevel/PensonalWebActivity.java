package com.example.qiuxiexianweijing.ThirdLevel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qiuxiexianweijing.DBOpenhelper;
import com.example.qiuxiexianweijing.MainActivity;
import com.example.qiuxiexianweijing.R;
import com.example.qiuxiexianweijing.bean.SecondLevel_RegsiterMainActivity;
import com.example.qiuxiexianweijing.bean.User;
import com.example.qiuxiexianweijing.utils.ToastUtil;

import org.w3c.dom.Text;

import java.util.List;

public class PensonalWebActivity extends AppCompatActivity implements View.OnClickListener {
private ImageView mIMGusername,mIMGuserpwd;
private TextView mTVshowPerSonal;
private DBOpenhelper MDBOpenhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pensonal_web);
        MDBOpenhelper=new DBOpenhelper(this);
        initview();
    }



    public void onClick(View view) {
        switch (view.getId()){
            case R.id.showname:
                SQLiteDatabase db =MDBOpenhelper.getReadableDatabase();
                List<User> users = MDBOpenhelper.queryAllthing();
                 if (!users.isEmpty())
                  {
                       showData(users);
                       return;
                    }
                 else {
            ToastUtil.toastShort(this, "没有查询到数据");
                      }
                break;
            case R.id.updatepwd:
                Intent intentupdatepwd =new Intent();
                intentupdatepwd.setClass(this,personalupdatepwd.class);
                startActivity(intentupdatepwd);
                break;


        }
     }
    private void initview() {
        mIMGusername=findViewById(R.id.showname);
        mIMGuserpwd=findViewById(R.id.updatepwd);
        mTVshowPerSonal=findViewById(R.id.TVshowpersonal);
    }


    private void showData(List<User> users) {
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : users) {
            stringBuilder.append("用户姓名:");
            stringBuilder.append(user.getUsername());
        }
        mTVshowPerSonal.setText(stringBuilder.toString());
    }
}