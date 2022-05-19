package com.example.qiuxiexianweijing.ThirdLevel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.qiuxiexianweijing.R;

public class PumaActivity extends AppCompatActivity {
private int puma1,puma2,puma3,puma4,puma5,intpuma1all,intpuma2all,intpuma3all,intpuma4all,intpuma5all,intPumacont1,intPumacont2,intPumacont3,intPumacont4,intPumacont5,IntFinal;
private String Strpumacont1,Strpumacont2,Strpumacont3,Strpumacont4,Strpumacont5,Strpumaall1,Strpumaall2,Strpumaall3,Strpumaall4,Strpumaall5,StrFinal;
private EditText pumacont,pumacont1,pumacont2,pumacont3,pumacont4;
private TextView mpriceall,mpriceall1,mpriceall2,mpriceall3,mpriceall4,mFinalprice;
private Button mBtn_buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puma);
        initview();
        mBtn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Strpumacont1=pumacont.getText().toString().trim();
                intPumacont1+=Integer.parseInt(Strpumacont1);
                intpuma1all=puma1*intPumacont1;
                Strpumaall1=String.valueOf(intpuma1all);

                mpriceall.setText(Strpumaall1);



                Strpumacont2=pumacont1.getText().toString().trim();
                intPumacont2+=Integer.parseInt(Strpumacont2);
                intpuma2all=puma2*intPumacont2;
                Strpumaall2=String.valueOf(intpuma2all);

                mpriceall1.setText(Strpumaall2);


                Strpumacont3=pumacont2.getText().toString().trim();
                intPumacont3+=Integer.parseInt(Strpumacont3);
                intpuma3all=puma3*intPumacont3;
                Strpumaall3=String.valueOf(intpuma3all);

                mpriceall2.setText(Strpumaall3);

                Strpumacont4=pumacont3.getText().toString().trim();
                intPumacont4+=Integer.parseInt(Strpumacont4);
                intpuma4all=puma4*intPumacont4;
                Strpumaall4=String.valueOf(intpuma4all);

                mpriceall3.setText(Strpumaall4);

                Strpumacont5=pumacont4.getText().toString().trim();
                intPumacont5+=Integer.parseInt(Strpumacont5);
                intpuma5all=puma5*intPumacont5;
                Strpumaall5=String.valueOf(intpuma5all);

                mpriceall4.setText(Strpumaall5);


                IntFinal=intpuma1all+intpuma2all+intpuma3all+intpuma4all+intpuma5all;
                StrFinal=String.valueOf(IntFinal);
                mFinalprice.setText(StrFinal);
            }
        });

    }






    private void initview() {
        puma1=999;
        puma2=488;
        puma3=699;
        puma4=309;
        puma5=480;
        intPumacont1=0;
        intPumacont2=0;
        intPumacont3=0;
        intPumacont4=0;
        intPumacont5=0;
        pumacont=findViewById(R.id.price_count);
        pumacont1=findViewById(R.id.price_count1);
        pumacont2=findViewById(R.id.price_count2);
        pumacont3=findViewById(R.id.price_count3);
        pumacont4=findViewById(R.id.price_count4);

        mpriceall=findViewById(R.id.price_all);
        mpriceall1=findViewById(R.id.price_all1);
        mpriceall2=findViewById(R.id.price_all2);
        mpriceall3=findViewById(R.id.price_all3);
        mpriceall4=findViewById(R.id.price_all4);

        mFinalprice=findViewById(R.id.text_Final);
        mBtn_buy=findViewById(R.id.Btn_buy);

    }
}