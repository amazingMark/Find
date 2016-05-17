package com.source.find.find.activity;

import android.bluetooth.le.AdvertiseData;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.source.find.find.R;
import com.source.find.find.adapter.FragmentAdapter;
import com.source.find.find.application.FindApplication;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private ViewPager mViewPager;
//    private RadioGroup mRadioGroup;
//    private RadioButton mHome;
//    private RadioButton mClub;
//    private RadioButton mMsg;
//    private RadioButton mSetting;

    private RelativeLayout mTabHome;
    private RelativeLayout mTabClub;
    private RelativeLayout mTabMsg;
    private RelativeLayout mTabSetting;
    private List<RelativeLayout> mTabs;
    private int currentTab;
    private FindApplication app;
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initScreen();
        initTab();
        initViewPager();
    }

    public void init() {
        app = FindApplication.getInstance();
        currentTab = 0;

//        mRadioGroup = (RadioGroup) findViewById(R.id.rg_home);
//        mHome = (RadioButton) findViewById(R.id.rb_home_home);
//        mClub = (RadioButton) findViewById(R.id.rb_home_club);
//        mMsg = (RadioButton) findViewById(R.id.rb_home_msg);
//        mSetting = (RadioButton) findViewById(R.id.rb_home_setting);
//        mRadioGroup.setOnCheckedChangeListener(this);
        mTabHome = (RelativeLayout) findViewById(R.id.rl_main_home);
        mTabClub = (RelativeLayout) findViewById(R.id.rl_main_club);
        mTabMsg = (RelativeLayout) findViewById(R.id.rl_main_msg);
        mTabSetting = (RelativeLayout) findViewById(R.id.rl_main_setting);
//        mTabs = new ArrayList<>();
//        mTabs.add(0, mTabHome);
//        mTabs.add(1, mTabClub);
//        mTabs.add(2, mTabMsg);
//        mTabs.add(3, mTabSetting);
    }


    public void initScreen() {

        if (app.getScreenX() == 0) {
            //若没有，就获取
            int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
            int screenHeight = getWindowManager().getDefaultDisplay().getHeight();
            app.setScreenHeight(screenHeight);
            app.setScreenWidth(screenWidth);
        }
    }


    public void initTab() {
//        float scale = getResources().getDisplayMetrics().density;
//
//        Drawable drawableClub = getResources().getDrawable(R.mipmap.club_unselected);
//        if (drawableClub != null)
//        drawableClub.setBounds(0, 0, (int) (20 * scale + 0.5f), (int) (20 * scale + 0.5f));
//
//        mClub.setCompoundDrawablesWithIntrinsicBounds(null,drawableClub,null,null);
        mTabHome.setOnClickListener(this);
        mTabClub.setOnClickListener(this);
        mTabMsg.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
    }

    public void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.vp_home);
        mViewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        mViewPager.setCurrentItem(currentTab);
        addClickEffect(currentTab);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == 2) {
                    clearClickEffect(currentTab);
                    addClickEffect(mViewPager.getCurrentItem());
                    currentTab = mViewPager.getCurrentItem();
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //清除之前显示的tab
                //clearClickEffect(mViewPager.getCurrentItem());
            }

            @Override
            public void onPageSelected(int position) {

            }
        });

    }

//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        switch (checkedId) {
//            case R.id.rb_home_home:
//                mViewPager.setCurrentItem(PAGE_ONE);
//                break;
//            case R.id.rb_home_club:
//                mViewPager.setCurrentItem(PAGE_TWO);
//                break;
//            case R.id.rb_home_msg:
//                mViewPager.setCurrentItem(PAGE_THREE);
//                break;
//            case R.id.rb_home_setting:
//                mViewPager.setCurrentItem(PAGE_FOUR);
//                break;
//        }
//    }

    public void clearClickEffect(int position) {

        switch (position) {
            case PAGE_ONE:
                ((ImageView) findViewById(R.id.iv_main_tab_home)).setImageResource(R.drawable.home_unselected);
                ((TextView) findViewById(R.id.tv_main_tab_home)).setTextColor(getResources().getColor(R.color.ColorTabText));
                break;
            case PAGE_TWO:
                ((ImageView) findViewById(R.id.iv_main_tab_club)).setImageResource(R.drawable.club_unselected);
                ((TextView) findViewById(R.id.tv_main_tab_club)).setTextColor(getResources().getColor(R.color.ColorTabText));
                break;
            case PAGE_THREE:
                ((ImageView) findViewById(R.id.iv_main_tab_msg)).setImageResource(R.drawable.msg_unselected);
                ((TextView) findViewById(R.id.tv_main_tab_msg)).setTextColor(getResources().getColor(R.color.ColorTabText));
                break;
            case PAGE_FOUR:
                ((ImageView) findViewById(R.id.iv_main_tab_setting)).setImageResource(R.drawable.setting_unselected);
                ((TextView) findViewById(R.id.tv_main_tab_setting)).setTextColor(getResources().getColor(R.color.ColorTabText));
                break;
        }
    }

    public void addClickEffect(int position) {

        switch (position) {
            case PAGE_ONE:
                ((ImageView) findViewById(R.id.iv_main_tab_home)).setImageResource(R.drawable.home_selected);
                ((TextView) findViewById(R.id.tv_main_tab_home)).setTextColor(getResources().getColor(R.color.ColorTitleBar));
                break;
            case PAGE_TWO:
                ((ImageView) findViewById(R.id.iv_main_tab_club)).setImageResource(R.drawable.club_selected);
                ((TextView) findViewById(R.id.tv_main_tab_club)).setTextColor(getResources().getColor(R.color.ColorTitleBar));
                break;
            case PAGE_THREE:
                ((ImageView) findViewById(R.id.iv_main_tab_msg)).setImageResource(R.drawable.msg_selected);
                ((TextView) findViewById(R.id.tv_main_tab_msg)).setTextColor(getResources().getColor(R.color.ColorTitleBar));
                break;
            case PAGE_FOUR:
                ((ImageView) findViewById(R.id.iv_main_tab_setting)).setImageResource(R.drawable.setting_selected);
                ((TextView) findViewById(R.id.tv_main_tab_setting)).setTextColor(getResources().getColor(R.color.ColorTitleBar));
                break;
        }
    }



    @Override
    public void onClick(View v) {
        //clearClickEffect(currentTab);
        switch (v.getId()) {
            case R.id.rl_main_home:
                mViewPager.setCurrentItem(PAGE_ONE);
                //currentTab = PAGE_ONE;
                break;
            case R.id.rl_main_club:
                //addClickEffect(PAGE_TWO);
                mViewPager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rl_main_msg:
                //addClickEffect(PAGE_THREE);
                mViewPager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rl_main_setting:
                //addClickEffect(PAGE_FOUR);
                mViewPager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }
}
