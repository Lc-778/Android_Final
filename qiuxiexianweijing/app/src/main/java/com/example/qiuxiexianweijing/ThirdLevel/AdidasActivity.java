package com.example.qiuxiexianweijing.ThirdLevel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.qiuxiexianweijing.R;

public class AdidasActivity extends AppCompatActivity {
private Button mBtn_detail,mBtn_clear;
private TextView mAdidas_1,mAdidas_2;
private String adidasone,adidastwo,adidasCl1,adidasCl2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adidas);
        initview();

        mBtn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdidas_1.setText(adidasone);
                mAdidas_2.setText(adidastwo);
            }
        });
        mBtn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdidas_1.setText(adidasCl1);
                mAdidas_2.setText(adidasCl2);
            }
        });
    }

    private void initview() {
        mBtn_detail=findViewById(R.id.Btn_detail);
        mBtn_clear=findViewById(R.id.Btn_clear);
        mAdidas_1=findViewById(R.id.Tv_adidas_one);
        mAdidas_2=findViewById(R.id.Tv_adidas_two);
        adidasone="adidas（阿迪达斯）创办于1949年，是德国运动用品制造商阿迪达斯AG成员公司。以其创办人阿道夫·阿迪·达斯勒（Adolf Adi Dassler）命名，1920年在黑措根奥拉赫开始生产鞋类产品。\n" +
                "1949年8月18日以adidas AG名字登记。";
        adidastwo="作为阿迪达斯boost的顶级鞋款，ub已经升级到了4.0，主要改变在Primeknit鞋面上进行调整，2.0开始升级马牌大地，更加耐磨，一体鞋舌设计。";
        adidasCl1="";
        adidasCl2="";
    }
}