package com.source.find.find.home;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.find.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Adapter.GridViewAdapter;
import InterfaceRealization.PostListViewOperator;
import Tool.ImageHandle;

public class PostDetailActivity extends AppCompatActivity {

    ListView lv_listview;
    int[] screenWidthAndHeight;
    ArrayList<Map<String,Object>> list_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        Init();
        screenWidthAndHeight = getScreenHeightAndWidth();
        list_data = getLists();

        LayoutInflater inflater = LayoutInflater.from(this);
        View headview_1 = inflater.inflate(R.layout.postdetailhead,lv_listview,false);
        headview_1.getLayoutParams().height = (int)(0.47 * screenWidthAndHeight[1]);

        int headwidth = (int)(screenWidthAndHeight[0]*0.125);
        Bitmap head = ImageHandle.decodeSampledBitmapFromResource(R.mipmap.bird1,headwidth,headwidth,getResources());
        ((ImageView)headview_1.findViewById(R.id.head)).setImageBitmap(head);

        int width = (int)(screenWidthAndHeight[0]*0.31);

        headview_1.findViewById(R.id.ll_picture).getLayoutParams().height = width;
        Bitmap picture = ImageHandle.decodeSampledBitmapFromResource(R.mipmap.example5,width,width,getResources());
        ((ImageView)headview_1.findViewById(R.id.imageView1)).setImageBitmap(picture);
        ((ImageView)headview_1.findViewById(R.id.imageView2)).setImageBitmap(picture);
        ((ImageView)headview_1.findViewById(R.id.imageView3)).setImageBitmap(picture);



        int width_0 = (int)(screenWidthAndHeight[0]*0.048);
        Bitmap love = ImageHandle.decodeSampledBitmapFromResource(R.mipmap.love,width_0,width_0,getResources());
        Bitmap saw = ImageHandle.decodeSampledBitmapFromResource(R.mipmap.saw,width_0,width_0,getResources());
        Bitmap comment = ImageHandle.decodeSampledBitmapFromResource(R.mipmap.comment,width_0,width_0,getResources());

        ((ImageView)headview_1.findViewById(R.id.im_love)).setImageBitmap(love);
        ((ImageView)headview_1.findViewById(R.id.im_saw)).setImageBitmap(saw);
        ((ImageView)headview_1.findViewById(R.id.im_comment)).setImageBitmap(comment);

        int otherhead_width = (int)(screenWidthAndHeight[0]*0.085);
        Bitmap other_1 = ImageHandle.decodeSampledBitmapFromResource(R.mipmap.example6,otherhead_width,otherhead_width,getResources());
        Bitmap other_2 = ImageHandle.decodeSampledBitmapFromResource(R.mipmap.example7,otherhead_width,otherhead_width,getResources());
        Bitmap other_3 = ImageHandle.decodeSampledBitmapFromResource(R.mipmap.example8,otherhead_width,otherhead_width,getResources());

        ((ImageView)headview_1.findViewById(R.id.im_head_1)).setImageBitmap(other_1);
        ((ImageView)headview_1.findViewById(R.id.im_head_2)).setImageBitmap(other_2);
        ((ImageView)headview_1.findViewById(R.id.im_head_3)).setImageBitmap(other_3);

         headview_1.findViewById(R.id.rl_commentNum).getLayoutParams().height = (int)(0.045 * screenWidthAndHeight[1]);


        lv_listview.addHeaderView(headview_1);
        lv_listview.setAdapter(new GridViewAdapter(this,list_data,new PostListViewOperator()));

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

    public void Init(){
        lv_listview = (ListView)findViewById(R.id.lv_listview);
        screenWidthAndHeight = getScreenHeightAndWidth();
    }

    public int[] getScreenHeightAndWidth(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        return new int[]{dm.widthPixels,dm.heightPixels};
    }
}
