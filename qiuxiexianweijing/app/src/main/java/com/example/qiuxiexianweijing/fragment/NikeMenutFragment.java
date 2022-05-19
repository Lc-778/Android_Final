package com.example.qiuxiexianweijing.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qiuxiexianweijing.R;
import com.example.qiuxiexianweijing.bean.Shoes;

public class NikeMenutFragment extends Fragment {
    private View view;
    private Shoes shoesDataBean;
    private LayoutInflater inflaterGetView;
    private ListView mLisetView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.nike_menu_fragment,container,false);
       if (view!=null){
           initView();
       }
        shoesDataBean=new Shoes();
        inflaterGetView = getLayoutInflater();
        mLisetView.setAdapter(new NikewMenuAdapter());
        mLisetView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NikeContentFragment nikeContentFragment=(NikeContentFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.Nike_content);
                nikeContentFragment.setContentText(shoesDataBean.getNikeTexts()[position]);
            }
        });
        return view;
    }

    private void initView() {
        mLisetView=view.findViewById(R.id.ListView_NikeMenu);
    }

    class NikewMenuAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return shoesDataBean.getNikeMenuNames().length;
        }

        @Override
        public Object getItem(int positon) {
            return shoesDataBean.getNikeMenuNames()[positon];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int positon, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView==null){
                convertView = inflaterGetView.inflate(R.layout.nike_item_list,null);
                holder = new ViewHolder();
                holder.menuimg = convertView.findViewById(R.id.nike_icon);
                holder.menuText = convertView.findViewById(R.id.nike_name);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.menuimg.setBackgroundResource(shoesDataBean.getNikeMenuIcons()[positon]);
            holder.menuText.setText(shoesDataBean.getNikeMenuNames()[positon]);

            return convertView;
        }
        class ViewHolder{
            private ImageView menuimg;
            private TextView menuText;
        }
    }
}
