package com.source.find.find.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.source.find.find.activity.MainActivity;
import com.source.find.find.fragment.ClubFrament;
import com.source.find.find.fragment.HomeFragment;
import com.source.find.find.fragment.MsgFragment;
import com.source.find.find.fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amazi on 2016/5/12.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList = new ArrayList<>();
    private HomeFragment mHomeFragment;
    private ClubFrament mClubFragment;
    private MsgFragment mMsgFragment;
    private SettingFragment mSettingFragment;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        mHomeFragment = new HomeFragment();
        mClubFragment = new ClubFrament();
        mMsgFragment = new MsgFragment();
        mSettingFragment = new SettingFragment();
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
}
