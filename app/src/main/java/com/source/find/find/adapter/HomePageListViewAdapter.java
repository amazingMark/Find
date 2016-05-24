package com.source.find.find.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import com.source.find.find.scrollpicsview.RoundImageView;
import com.source.find.find.scrollpicsview.ScrollViewPager;
import com.source.find.find.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.source.find.find.tool.ViewPagerScroller;

/**
 * Created by hanjun on 2016/5/14.
 */
public class HomePageListViewAdapter extends BaseAdapter {

    ArrayList<Map<String, Object>> ls;
    Context mContext;
    List<Bitmap> viewLists;
    private LinkedList<View> mViews; // 用于显示的View
    private ScheduledExecutorService scheduledExecutorService;

    final int VIEW_TYPE = 3;
    final int TYPE_1 = 0;
    final int TYPE_2 = 1;
    final int TYPE_3 = 2;

    ViewHolder1 holder1 = null;
    ViewHolder2 holder2 = null;
    ViewHolder3 holder3 = null;
    Map<String,Object> topicMap;

    public HomePageListViewAdapter(Context context,
                          ArrayList<Map<String,
                                  Object>> list,Map<String,Object> topicMap,List<Bitmap> viewLists,
                                   LinkedList<View> mViews,
                                   ScheduledExecutorService scheduledExecutorService) {

        mContext = context;
        this.topicMap = topicMap;
        this.viewLists=viewLists;
        this.mViews = mViews;
        ls = list;

        this.scheduledExecutorService = scheduledExecutorService;
    }

    @Override
    public int getCount() {
        return ls.size();
    }

    @Override
    public Object getItem(int position) {
        return ls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 每个convert view都会调用此方法，获得当前所需要的view样式
    @Override
    public int getItemViewType(int position) {

        if (position == 0)
            return TYPE_1;
        else if (position == 1)
            return TYPE_2;
        else
            return TYPE_3;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int type = getItemViewType(position);
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            // 按当前所需的样式，确定new的布局
            switch (type) {
                case TYPE_1:

                    convertView = inflater.inflate(R.layout.homepage_listitem_activity_layout,
                            parent, false);

                    holder1 = new ViewHolder1();
                    holder1.vp_activity = (ScrollViewPager) convertView
                            .findViewById(R.id.vp_activity);
                    convertView.setTag(holder1);
                    break;
                case TYPE_2:
                    convertView = inflater.inflate(R.layout.homepage_listitem_topic_layout,
                            parent, false);

                    holder2 = new ViewHolder2();
                    holder2.fl_topic_background = (ImageView) convertView
                            .findViewById(R.id.fl_topic_background);
                    holder2.topic_title = (TextView) convertView
                            .findViewById(R.id.topic_title);
                    convertView.setTag(holder2);
                    break;
                case TYPE_3:
                    convertView = inflater.inflate(R.layout.homepage_listitem_dynamic_layout,
                            parent, false);
                    holder3 = new ViewHolder3();

                    holder3.head = (RoundImageView) convertView
                            .findViewById(R.id.head);
                    holder3.name = (TextView) convertView
                            .findViewById(R.id.name);
                    holder3.club = (TextView) convertView
                            .findViewById(R.id.club);
                    holder3.content = (TextView) convertView
                            .findViewById(R.id.content);
                    holder3.picture[0] = (ImageView) convertView
                            .findViewById(R.id.imageView1);
                    holder3.picture[1] = (ImageView) convertView
                            .findViewById(R.id.imageView2);
                    holder3.picture[2] = (ImageView) convertView
                            .findViewById(R.id.imageView3);
                    convertView.setTag(holder3);
                    break;
                default:
                    break;
            }

        } else {
            switch (type) {
                case TYPE_1:
                   // holder1 = (ViewHolder1) convertView.getTag();
                    return convertView;
               // break;
                case TYPE_2:
                  //  holder2 = (ViewHolder2) convertView.getTag();
                    return convertView;
               // break;
                case TYPE_3:
                    holder3 = (ViewHolder3) convertView.getTag();
                    break;
            }
        }
        // 设置资源
        switch (type) {
            case TYPE_1:
                int rootHeight = parent.getRootView().getHeight();
                convertView.getLayoutParams().height=(int)(rootHeight*0.27);
                handleViewPager(holder1.vp_activity);
                break;
            case TYPE_2:

                FrameLayout fl_topic= (FrameLayout)convertView.findViewById(R.id.fl_topic);
                fl_topic.getLayoutParams().height=(int)(parent.getRootView().getHeight()*0.28);

                holder2.fl_topic_background.setImageBitmap((Bitmap)topicMap.get("image"));
                holder2.topic_title.setText((String)topicMap.get("title"));
                break;

            case TYPE_3:
                holder3.head.setImageBitmap((Bitmap)ls.get(position-2).get("head"));
                holder3.name.setText((String)ls.get(position-2).get("name"));
                holder3.club.setText((String)ls.get(position-2).get("club"));
                holder3.content.setText((String)ls.get(position-2).get("content"));
                holder3.picture[0].setImageBitmap((Bitmap)ls.get(position-2).get("picture1"));
                holder3.picture[1].setImageBitmap((Bitmap)ls.get(position-2).get("picture2"));
                holder3.picture[2].setImageBitmap((Bitmap)ls.get(position-2).get("picture3"));
                break;
        }

        return convertView;
    }

    public class ViewHolder1 {
        ScrollViewPager vp_activity;
    }

    public class ViewHolder2 {
        ImageView fl_topic_background;
        TextView topic_title;

    }

    public class ViewHolder3 {
        RoundImageView head;
        TextView name;
        TextView club;
        TextView content;
        ImageView[] picture = new ImageView[3];
    }

    public void handleViewPager(ScrollViewPager vp_activity){

        vp_activity.setAdapter(new HomePageActivityAdapter(mViews));
        vp_activity.setOnPageChangeListener(new PageChangeListener(viewLists,vp_activity));
        vp_activity.setCurrentItem(1);

        if(!scheduledExecutorService.isShutdown()) {
            scheduledExecutorService.shutdown();
        }
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(vp_activity), 1, 3, TimeUnit.SECONDS);
        setViewPagerScrollSpeed(vp_activity,200);
    }

    private class ScrollTask implements Runnable {

        ViewPager vp_activity;

        public ScrollTask(ViewPager viewPager){
            vp_activity = viewPager;
        }
        public void run() {

                Message message=handler.obtainMessage();
                message.arg1 = (vp_activity.getCurrentItem()+ 1)
                        % vp_activity.getAdapter().getCount();
                message.what=0x123;
                message.sendToTarget();

        }

    }

    Handler handler = new Handler(){

        public void handleMessage(Message msg) {
            if(msg.what==0x123){
                holder1.vp_activity.setCurrentItem(msg.arg1);
            }
        }
    };

    private void setViewPagerScrollSpeed(ViewPager viewPager, int speed) {
        try {
            Field field = ViewPager.class.getDeclaredField("mScroller");
            field.setAccessible(true);
            ViewPagerScroller viewPagerScroller = new ViewPagerScroller(viewPager.getContext(), new OvershootInterpolator(0.6F));
            field.set(viewPager, viewPagerScroller);
            viewPagerScroller.setDuration(speed);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //页面改变监听器
    public class PageChangeListener implements ViewPager.OnPageChangeListener {

        List<Bitmap> viewLists;
        ViewPager viewPager;
        public PageChangeListener(List<Bitmap> viewLists,ViewPager viewPager){
            this.viewLists = viewLists;
            this.viewPager = viewPager;
        }

        @Override
        public void onPageSelected(int arg0) {
            Log.d("显示", "onPageSelected:" + arg0);
            viewPager.getParent().requestDisallowInterceptTouchEvent(true);
            if ( mViews.size() > 1) { //多于1，才会循环跳转
                if ( arg0 < 1) { //首位之前，跳转到末尾（N）
                    arg0 = viewLists.size(); //注意这里是mList，而不是mViews
                    viewPager.setCurrentItem(arg0, false);
                } else if ( arg0 > viewLists.size()) { //末位之后，跳转到首位（1）
                    viewPager.setCurrentItem(1, false); //false:不显示跳转过程的动画
                }
            }
        }
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }


}