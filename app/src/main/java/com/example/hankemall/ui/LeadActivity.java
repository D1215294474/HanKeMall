package com.example.hankemall.ui;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.hankemall.R;
import com.example.hankemall.adapter.LeadImgAdapter;

import java.util.ArrayList;
import java.util.List;
public class LeadActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private LeadImgAdapter adapter;
    //引导图片
    private List<View> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        list.add(getLayoutInflater().inflate(R.layout.lead_1,null));
        list.add(getLayoutInflater().inflate(R.layout.lead_2,null));
        adapter=new LeadImgAdapter(list);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
