package com.example.qiuxiexianweijing.bean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.qiuxiexianweijing.R;

import java.util.List;

public class RecordAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<Record> list;
    public RecordAdapter(Context context,List<Record> list){
        this.layoutInflater=LayoutInflater.from(context);
        this.list=list;
    }
    @Override
    public int getCount() {
        return list==null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=layoutInflater.inflate(R.layout.record_item,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        Record noteInfo=(Record) getItem(position);
        viewHolder.tvRecordContent.setText(noteInfo.getRecordContent());
        viewHolder.tvRecordTime.setText(noteInfo.getRecodTime());



        return convertView;
    }
    class ViewHolder{
        TextView tvRecordContent;;
        TextView tvRecordTime;
        public ViewHolder(View view){
            tvRecordContent=(TextView) view.findViewById(R.id.item_record_content);
            tvRecordTime=(TextView) view.findViewById(R.id.item_record_time);
        }
    }
}
