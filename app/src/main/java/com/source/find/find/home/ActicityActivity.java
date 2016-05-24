package com.source.find.find.home;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.source.find.find.R;
import com.source.find.find.tool.ImageHandle;
import com.source.find.find.adapter.*;
import com.source.find.find.interfaceimpl.PostListViewOperator;


public class ActicityActivity extends AppCompatActivity {

    ListView lv_listview;
    ArrayList<Map<String,Object>> list_data;
    int[] screenWidthAndHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acticity);
        setTranslucent(this);

        Init();
        list_data = getLists();


        LayoutInflater inflater = LayoutInflater.from(this);
        View headview_1 = inflater.inflate(R.layout.activity_head_1_layout,lv_listview,false);
        headview_1.getLayoutParams().height = (int)(0.282 * screenWidthAndHeight[1]);
        Bitmap activity_bp = BitmapFactory.decodeResource(getResources(),R.mipmap.example6);
        ((ImageView)headview_1.findViewById(R.id.im_activity)).setImageBitmap(activity_bp);

        View headview_2 = inflater.inflate(R.layout.activity_head_2_layout,lv_listview,false);
        int width = (int)(screenWidthAndHeight[0]*0.078);
        Bitmap picture = ImageHandle.decodeSampledBitmapFromResource(R.mipmap.bird1,width,width,getResources());

        ((ImageView)headview_2.findViewById(R.id.im_head_1)).setImageBitmap(picture);
        ((ImageView)headview_2.findViewById(R.id.im_head_2)).setImageBitmap(picture);
        ((ImageView)headview_2.findViewById(R.id.im_head_3)).setImageBitmap(picture);

        int width_0 = (int)(screenWidthAndHeight[0]*0.11);
        Bitmap head = ImageHandle.decodeSampledBitmapFromResource(R.mipmap.bird1,width_0,width_0,getResources());
        ((ImageView)headview_2.findViewById(R.id.head)).setImageBitmap(head);

        lv_listview.addHeaderView(headview_1);
        lv_listview.addHeaderView(headview_2);
        lv_listview.setAdapter(new GridViewAdapter(this,list_data,new PostListViewOperator()));

    }

    public static void setTranslucent(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    public void Init(){
        lv_listview = (ListView)findViewById(R.id.lv_listview);
        screenWidthAndHeight = getScreenHeightAndWidth();
    }

    public int[] getScreenHeightAndWidth(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        return new int[]{dm.widthPixels,dm.heightPixels};
    }

    public ArrayList<Map<String,Object>> getLists(){
        ArrayList<Map<String,Object>> listdata = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();

        int width = (int)(screenWidthAndHeight[0]*0.11);
        Bitmap head = ImageHandle.decodeSampledBitmapFromResource(R.mipmap.bird1,width,width,getResources());


        for(int i=0;i<10;i++){
            map.put("head",head);
            map.put("name","金小洛");
            map.put("time","今天12点");
            map.put("content","一个是华丽短暂的梦，一个事残酷漫长的现实。你会怎么选？");
            map.put("lovenum","10");
            listdata.add(map);
            map = new HashMap<>();
        }
        return listdata;
    }


}
