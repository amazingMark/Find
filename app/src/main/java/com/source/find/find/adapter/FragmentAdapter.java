package com.source.find.find.adapter;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.source.find.find.home.HomePageFragment;
import com.source.find.find.main.MainActivity;
import com.source.find.find.club.ClubFrament;
import com.source.find.find.message.MsgFragment;
import com.source.find.find.setting.PersonSettingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amazi on 2016/5/12.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList = new ArrayList<>();
    private HomePageFragment mHomeFragment;
    private ClubFrament mClubFragment;
    private MsgFragment mMsgFragment;
    private PersonSettingFragment mSettingFragment;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        mHomeFragment = new HomePageFragment();
        mClubFragment = new ClubFrament();
        mMsgFragment = new MsgFragment();
        mSettingFragment = new PersonSettingFragment();
        mFragmentList.add(mHomeFragment);
        mFragmentList.add(mClubFragment);
        mFragmentList.add(mMsgFragment);
        mFragmentList.add(mSettingFragment);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = mFragmentList.get(MainActivity.PAGE_ONE);
                break;
            case MainActivity.PAGE_TWO:
                fragment = mFragmentList.get(MainActivity.PAGE_TWO);
                break;
            case MainActivity.PAGE_THREE:
                fragment = mFragmentList.get(MainActivity.PAGE_THREE);
                break;
            case MainActivity.PAGE_FOUR:
                fragment = mFragmentList.get(MainActivity.PAGE_FOUR);
                break;

        }
        return fragment;
    }

//
//    @Override
//    public android.support.v4.app.Fragment getItem(int position) {
//
//        android.support.v4.app.Fragment fragment = null;
//        switch (position) {
//            case MainActivity.PAGE_ONE:
//                fragment = mFragmentList.get(MainActivity.PAGE_ONE);
//                break;
//            case MainActivity.PAGE_TWO:
//                fragment = mFragmentList.get(MainActivity.PAGE_TWO);
//                break;
//            case MainActivity.PAGE_THREE:
//                fragment = mFragmentList.get(MainActivity.PAGE_THREE);
//                break;
//            case MainActivity.PAGE_FOUR:
//                fragment = mFragmentList.get(MainActivity.PAGE_FOUR);
//                break;
//
//        }
//        return fragment;
//    }
}
