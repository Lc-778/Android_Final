package com.example.qiuxiexianweijing.bean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.qiuxiexianweijing.R;
import com.example.qiuxiexianweijing.ThirdLevel.AdidasActivity;
import com.example.qiuxiexianweijing.ThirdLevel.DailyRecordActivity;
import com.example.qiuxiexianweijing.ThirdLevel.NikeActivity;
import com.example.qiuxiexianweijing.ThirdLevel.PensonalWebActivity;
import com.example.qiuxiexianweijing.ThirdLevel.PumaActivity;

public class SecondLevelMainActivity extends AppCompatActivity implements View.OnClickListener {
private ImageView mimg_nike,mimg_adidas,mimg_puma,mimg_gerenzhuye,
    mimg_dongtai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_level_main);
        initview();
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_nike:
                Intent intent_nike=new Intent();
                intent_nike.setClass(SecondLevelMainActivity.this, NikeActivity.class);
                startActivity(intent_nike);
                break;
            case R.id.img_adidas:
                Intent intent_adidas=new Intent();
                intent_adidas.setClass(SecondLevelMainActivity.this, AdidasActivity.class);
                startActivity(intent_adidas);
                break;
            case R.id.img_puma:
                Intent intent_puma=new Intent();
                intent_puma.setClass(SecondLevelMainActivity.this, PumaActivity.class);
                startActivity(intent_puma);
                break;

            case R.id.img_gerenzhuye:
                Intent intent_gerenzhuye=new Intent();
                intent_gerenzhuye.setClass(SecondLevelMainActivity.this, PensonalWebActivity.class);
                startActivity(intent_gerenzhuye);
                break;
            case R.id.img_dongtai:
                Intent intent_dongtai=new Intent();
                intent_dongtai.setClass(SecondLevelMainActivity.this, DailyRecordActivity.class);
                startActivity(intent_dongtai);
                break;
        }

    }
    private void initview() {
    mimg_nike=findViewById(R.id.img_nike);
    mimg_adidas=findViewById(R.id.img_adidas);
    mimg_puma=findViewById(R.id.img_puma);

    mimg_gerenzhuye=findViewById(R.id.img_gerenzhuye);
    mimg_dongtai=findViewById(R.id.img_dongtai);

    mimg_nike.setOnClickListener(this);
    mimg_adidas.setOnClickListener(this);
    mimg_puma.setOnClickListener(this);

    mimg_gerenzhuye.setOnClickListener(this);
    mimg_dongtai.setOnClickListener(this);

    }
}