package com.james.viewpager;

import android.content.Intent;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;//viewpager
    private List<View> viewList;//把需要滑动的页卡添加到这个list中
    private RadioGroup mRadiogroup ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        final LayoutInflater mInflater = getLayoutInflater().from(this);

        View v1 = mInflater.inflate(R.layout.intro_layout_1, null);
        View v2 = mInflater.inflate(R.layout.intro_layout_2, null);
        View v3 = mInflater.inflate(R.layout.intro_layout_3, null);
        View v4 = mInflater.inflate(R.layout.intro_layout_4, null);

        viewList = new ArrayList<View>();
        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);
        viewList.add(v4);

        mRadiogroup = (RadioGroup)findViewById(R.id.radiogroup);
        mViewPager.setAdapter(new MyViewPagerAdapter(viewList));
        mViewPager.setCurrentItem(0);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mRadiogroup.check(R.id.radioButton);
                        break;
                    case 1:
                        mRadiogroup.check(R.id.radioButton2);
                        break;
                    case 2:
                        mRadiogroup.check(R.id.radioButton3);
                        break;
                    case 3:
                        mRadiogroup.check(R.id.radioButton4);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
