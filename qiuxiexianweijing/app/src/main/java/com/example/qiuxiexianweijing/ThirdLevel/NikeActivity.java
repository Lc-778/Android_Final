package com.example.qiuxiexianweijing.ThirdLevel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.qiuxiexianweijing.R;
import com.example.qiuxiexianweijing.fragment.NikeContentFragment;
import com.example.qiuxiexianweijing.fragment.NikeMenutFragment;

public class NikeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nike);
        NikeMenutFragment nikeMenutFragment=new NikeMenutFragment();
        NikeContentFragment nikeContentFragment=new NikeContentFragment();

        FragmentManager supportFragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=supportFragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.list_Nike_menu,nikeMenutFragment);
        fragmentTransaction.replace(R.id.Nike_content,nikeContentFragment);
        fragmentTransaction.commit();

    }
}