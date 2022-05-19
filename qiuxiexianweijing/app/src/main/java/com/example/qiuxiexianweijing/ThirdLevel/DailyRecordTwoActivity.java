package com.example.qiuxiexianweijing.ThirdLevel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qiuxiexianweijing.DBrecord;
import com.example.qiuxiexianweijing.R;
import com.example.qiuxiexianweijing.utils.DailyrecordUtil;

public class DailyRecordTwoActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView record_back;
    TextView record_time;
    EditText content;
    ImageView delete;
    ImageView record_save;
    DBrecord mDBrecord;
    TextView recordName;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_record_two);
        record_back = (ImageView) findViewById(R.id.record_two_back);
        record_time = (TextView)findViewById(R.id.tv_time);
        content = (EditText) findViewById(R.id.record_content);
        delete = (ImageView) findViewById(R.id.delete);
        record_save = (ImageView) findViewById(R.id.record_save);
        recordName = (TextView) findViewById(R.id.record_two_name);
        record_back.setOnClickListener(this);
        delete.setOnClickListener(this);
        record_save.setOnClickListener(this);
        initData();


    }

    private void initData() {
        mDBrecord = new DBrecord(this);
        recordName.setText("添加记录");
        Intent intent = getIntent();
        if(intent!= null){
            id = intent.getStringExtra("id");
            if (id != null){
                recordName.setText("修改记录");
                content.setText(intent.getStringExtra("content"));
                record_time.setText(intent.getStringExtra("time"));
                record_time.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.record_two_back:
                finish();
                break;
            case R.id.delete:
                content.setText("");
                break;
            case R.id.record_save:
                String recordContent=content.getText().toString().trim();
                if (id != null){
                    if (recordContent.length()>0){
                        if (mDBrecord.updateData(id, recordContent, DailyrecordUtil.getTime())){
                            showToast("修改成功");
                            setResult(2);
                            finish();
                        }else {
                            showToast("修改失败");
                        }
                    }else {
                        showToast("修改内容不能为空!");
                    }
                }else {

                    if (recordContent.length()>0){
                        if (mDBrecord.insertData(recordContent, DailyrecordUtil.getTime())){
                            showToast("保存成功");
                            setResult(2);
                            finish();
                        }else {
                            showToast("保存失败");
                        }
                    }else {
                        showToast("修改内容不能为空!");
                    }
                }
                break;
        }
    }
    public void showToast(String message){
        Toast.makeText(DailyRecordTwoActivity.this,message,Toast.LENGTH_SHORT).show();
    }
}