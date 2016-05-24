package com.source.find.find.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * Created by hanjun on 2016/5/12.
 */
public class HomePageActivityAdapter extends PagerAdapter {
    List<View> viewLists;


    public HomePageActivityAdapter(List<View> lists)
    {
        viewLists = lists;
    }

    //获得size
    @Override
    public int getCount() {

        return viewLists.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {

        return arg0 == arg1;
    }

    //销毁Item
    @Override
    public void destroyItem(View view, int position, Object object)
    {
        ((ViewPager) view).removeView(viewLists.get(position));
    }

    //实例化Item
    @Override
    public Object instantiateItem(View view, int position)
    {
        ((ViewPager) view).addView(viewLists.get(position), 0);
        return viewLists.get(position);
    }
}
