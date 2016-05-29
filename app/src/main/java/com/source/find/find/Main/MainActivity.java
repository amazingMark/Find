package com.source.find.find.main;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.source.find.find.R;
import com.source.find.find.adapter.FragmentAdapter;
import com.source.find.find.application.FindApplication;


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

    private int currentTab = 0;
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
        //initScreen();
        initTab();
        initViewPager();
    }

    public void init() {
        app = FindApplication.getInstance();
        currentTab = 0;

        mTabHome = (RelativeLayout) findViewById(R.id.rl_main_home);
        mTabClub = (RelativeLayout) findViewById(R.id.rl_main_club);
        mTabMsg = (RelativeLayout) findViewById(R.id.rl_main_msg);
        mTabSetting = (RelativeLayout) findViewById(R.id.rl_main_setting);
    }


//    public void initScreen() {
//
//        if (app.getScreenX() == 0) {
//            int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
//            int screenHeight = getWindowManager().getDefaultDisplay().getHeight();
//            app.setScreenHeight(screenHeight);
//            app.setScreenWidth(screenWidth);
//        }
//    }


    public void initTab() {

        mTabHome.setOnClickListener(this);
        mTabClub.setOnClickListener(this);
        mTabMsg.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
    }

    public void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.vp_home);
        mViewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        mViewPager.setCurrentItem(currentTab);
        addClickEffect(currentTab);//初始化当前效果

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

            }

            @Override
            public void onPageSelected(int position) {

            }
        });

    }



    public void clearClickEffect(int position) {

        switch (position) {
            case PAGE_ONE:
                ((ImageView) findViewById(R.id.iv_main_tab_home)).setImageResource(R.mipmap.home_unselected);
                ((TextView) findViewById(R.id.tv_main_tab_home)).setTextColor(getResources().getColor(R.color.ColorTabText));
                break;
            case PAGE_TWO:
                ((ImageView) findViewById(R.id.iv_main_tab_club)).setImageResource(R.mipmap.club_unselected);
                ((TextView) findViewById(R.id.tv_main_tab_club)).setTextColor(getResources().getColor(R.color.ColorTabText));
                break;
            case PAGE_THREE:
                ((ImageView) findViewById(R.id.iv_main_tab_msg)).setImageResource(R.mipmap.msg_unselected);
                ((TextView) findViewById(R.id.tv_main_tab_msg)).setTextColor(getResources().getColor(R.color.ColorTabText));
                break;
            case PAGE_FOUR:
                ((ImageView) findViewById(R.id.iv_main_tab_setting)).setImageResource(R.mipmap.setting_unselected);
                ((TextView) findViewById(R.id.tv_main_tab_setting)).setTextColor(getResources().getColor(R.color.ColorTabText));
                break;
        }
    }

    public void addClickEffect(int position) {

        switch (position) {
            case PAGE_ONE:
                ((ImageView) findViewById(R.id.iv_main_tab_home)).setImageResource(R.mipmap.home_selected);
                ((TextView) findViewById(R.id.tv_main_tab_home)).setTextColor(getResources().getColor(R.color.ColorTitleBar));
                break;
            case PAGE_TWO:
                ((ImageView) findViewById(R.id.iv_main_tab_club)).setImageResource(R.mipmap.club_selected);
                ((TextView) findViewById(R.id.tv_main_tab_club)).setTextColor(getResources().getColor(R.color.ColorTitleBar));
                break;
            case PAGE_THREE:
                ((ImageView) findViewById(R.id.iv_main_tab_msg)).setImageResource(R.mipmap.msg_selected);
                ((TextView) findViewById(R.id.tv_main_tab_msg)).setTextColor(getResources().getColor(R.color.ColorTitleBar));
                break;
            case PAGE_FOUR:
                ((ImageView) findViewById(R.id.iv_main_tab_setting)).setImageResource(R.mipmap.setting_selected);
                ((TextView) findViewById(R.id.tv_main_tab_setting)).setTextColor(getResources().getColor(R.color.ColorTitleBar));
                break;
        }
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.rl_main_home:
                mViewPager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rl_main_club:
                mViewPager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rl_main_msg:
                mViewPager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rl_main_setting:
                mViewPager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }
}
