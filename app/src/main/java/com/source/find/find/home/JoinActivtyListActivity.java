package com.source.find.find.home;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.find.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Adapter.GridViewAdapter;
import InterfaceRealization.JoinActivityListOperator;

public class JoinActivtyListActivity extends AppCompatActivity {

    ListView lv_listview;
    int[] screenWidthAndHeight;
    ArrayList<Map<String,Object>> list_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_activty_list);
        Init();
        setTranslucent(this);
        list_data = getLists();
        lv_listview.setAdapter(new GridViewAdapter(this,list_data,new JoinActivityListOperator()));
    }

    public void Init() {
        lv_listview = (ListView) findViewById(R.id.lv_listview);
        screenWidthAndHeight = getScreenHeightAndWidth();
    }

    public ArrayList<Map<String,Object>> getLists(){
        ArrayList<Map<String,Object>> listdata = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();

        Bitmap head = BitmapFactory.decodeResource(getResources(),R.mipmap.bird1);

        for(int i=0;i<10;i++){
            map.put("im_head",head);
            map.put("tv_name","金小洛");
            listdata.add(map);
            map = new HashMap<>();
        }
        return listdata;
    }

    public int[] getScreenHeightAndWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        return new int[]{dm.widthPixels, dm.heightPixels};
    }
    public static void setTranslucent(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
}
