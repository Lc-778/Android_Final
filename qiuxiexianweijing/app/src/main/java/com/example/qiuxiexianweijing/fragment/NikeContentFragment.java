package com.example.qiuxiexianweijing.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.qiuxiexianweijing.R;

public class NikeContentFragment extends Fragment {
    private View view;
    private TextView mTvContent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.nike_content_fragment,container,false);
        if(view != null){
            initView();
        }
        setContentText("欢迎来到NIKE馆");
        return view;
    }
    public void setContentText(String text){
        mTvContent.setText(text);
    }

    private void initView() {
        mTvContent = view.findViewById(R.id.TextView_nike_content);
    }
}
