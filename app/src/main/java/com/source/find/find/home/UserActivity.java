package com.source.find.find.home;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.find.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Adapter.GridViewAdapter;
import InterfaceRealization.UserGridViewOperator;
import InterfaceRealization.UserListViewOperator;

public class UserActivity extends AppCompatActivity {

    ListView lt_listview;
    GridView gl_club;
    ArrayList<Map<String,Object>> grid_data;
    ArrayList<Map<String,Object>> list_data;
    int lineNum;
    android.support.percent.PercentRelativeLayout rl_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        setTranslucent(this);

        Init();
        grid_data = getGridData();
        list_data = getLists();
        lineNum = (grid_data.size()+1)/2;
        int screenHeight = getScreenHeightAndWidth()[1];

        LayoutInflater inflater = LayoutInflater.from(this);
        android.support.percent.PercentRelativeLayout headview_1 = (android.support.percent.PercentRelativeLayout)inflater.inflate(R.layout.user_list_headview1_layout,lt_listview,false);
        headview_1.getLayoutParams().height = (int)(0.53 * screenHeight);
        ((ImageView)headview_1.findViewById(R.id.im_background)).setImageResource(R.mipmap.example2);

        View headview_2 = inflater.inflate(R.layout.user_list_headview2_layout,lt_listview,false);
        headview_2.findViewById(R.id.rl_title_2).getLayoutParams().height =  (int)(0.08 * screenHeight);
        gl_club = (GridView)headview_2.findViewById(R.id.gl_club);
        gl_club.getLayoutParams().height = (int)(0.054*lineNum * screenHeight);
        gl_club.setAdapter(new GridViewAdapter(this,grid_data,new UserGridViewOperator()));

        lt_listview.addHeaderView(headview_1);
        lt_listview.addHeaderView(headview_2);
        lt_listview.setAdapter(new GridViewAdapter(this,list_data,new UserListViewOperator()));

       }

    public ArrayList<Map<String,Object>> getLists(){
        ArrayList<Map<String,Object>> listdata = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.mipmap.bird1);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.mipmap.example6);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(),R.mipmap.example7);
        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(),R.mipmap.example8);
        for(int i=0;i<10;i++){
            map.put("head",bitmap1);
            map.put("name","金小洛");
            map.put("club","武大印包");
            map.put("content","一个是华丽短暂的梦，一个事残酷漫长的现实。你会怎么选？");
            map.put("picture1",bitmap2);
            map.put("picture2",bitmap3);
            map.put("picture3",bitmap4);
            listdata.add(map);
            map = new HashMap<>();
        }
        return listdata;
    }

    public int[] getScreenHeightAndWidth(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        return new int[]{dm.widthPixels,dm.heightPixels};
    }

    public ArrayList<Map<String,Object>> getGridData(){
        ArrayList<Map<String,Object>> listdata = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();

        for(int i=0;i<6;i++){
            map.put("club","武汉大学体育部");
            listdata.add(map);
            map = new HashMap<>();
        }
        return listdata;
    }


    public void Init(){
        lt_listview = (ListView)findViewById(R.id.lt_listview);
    }

    public static void setTranslucent(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

        public int getStatusHeight(Context context) {

            int statusHeight = -1;
            try {
                Class<?> clazz = Class.forName("com.android.internal.R$dimen");
                Object object = clazz.newInstance();
                int height = Integer.parseInt(clazz.getField("status_bar_height")
                        .get(object).toString());
                statusHeight = context.getResources().getDimensionPixelSize(height);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return statusHeight;
        }

}
