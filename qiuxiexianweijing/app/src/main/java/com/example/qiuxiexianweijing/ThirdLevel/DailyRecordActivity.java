package com.example.qiuxiexianweijing.ThirdLevel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qiuxiexianweijing.DBrecord;
import com.example.qiuxiexianweijing.R;
import com.example.qiuxiexianweijing.bean.Record;
import com.example.qiuxiexianweijing.bean.RecordAdapter;

import java.util.List;

public class DailyRecordActivity extends AppCompatActivity {
    ListView listView;
    List<Record> list;
    DBrecord mDBrecord;
    RecordAdapter recordAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_record);


        listView = (ListView) findViewById(R.id.listview);
        ImageView back = (ImageView) findViewById(R.id.record_back);
        ImageView add = (ImageView) findViewById(R.id.record_add);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DailyRecordActivity.this,
                        DailyRecordTwoActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        initData();



    }

    private void initData() {
        mDBrecord=new DBrecord(this);
        showQueryRecordData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Record record = list.get(position);
                Intent intent = new Intent(DailyRecordActivity.this, DailyRecordTwoActivity.class);
                intent.putExtra("id", record.getId());
                intent.putExtra("time", record.getRecodTime());
                intent.putExtra("content", record.getRecordContent());
                DailyRecordActivity.this.startActivityForResult(intent, 1);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int
                    position, long id) {
                AlertDialog dialog;
                AlertDialog.Builder builder = new AlertDialog.Builder( DailyRecordActivity.this)
                        .setMessage("是否要删除此事件？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Record record = list.get(position);
                                if(mDBrecord.deleteData(record.getId())){
                                    list.remove(position);
                                    recordAdapter.notifyDataSetChanged();
                                    Toast.makeText(DailyRecordActivity.this,"删除成功",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                dialog =  builder.create();
                dialog.show();
                return true;
            }
        });

    }

    private void showQueryRecordData() {
        if (list!=null){
            list.clear();
        }
        //从数据库中查询数据(保存的标签)
        list = mDBrecord.query();
        recordAdapter = new RecordAdapter(this, list);
        listView.setAdapter(recordAdapter);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==2){
            showQueryRecordData();
        }
    }
}