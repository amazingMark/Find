package com.source.find.find.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;


import com.source.find.find.R;
import com.source.find.find.adapter.GridViewAdapter;
import com.source.find.find.interfaceimpl.TopicListViewOperator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TopicActivity extends AppCompatActivity {

    ListView lv_listview;
    ArrayList<Map<String,Object>> list_data;
    int[] screenWidthAndHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        Init();
        list_data = getLists();

        LayoutInflater inflater = LayoutInflater.from(this);
        View headview_1 = inflater.inflate(R.layout.homepage_listitem_topic_layout,lv_listview,false);
        headview_1.getLayoutParams().height = (int)(0.159 * screenWidthAndHeight[1]);

        lv_listview.addHeaderView(headview_1);
        lv_listview.setAdapter(new GridViewAdapter(this,list_data,new TopicListViewOperator()));

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

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.mipmap.bird1);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.mipmap.example6);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(),R.mipmap.example7);
        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(),R.mipmap.example8);

        int width = (int)(screenWidthAndHeight[0]*0.085);
        Bitmap bitmap5 = decodeSampledBitmapFromResource(R.mipmap.example6,width,width);
        Bitmap bitmap6 = decodeSampledBitmapFromResource(R.mipmap.example7,width,width);
        Bitmap bitmap7 = decodeSampledBitmapFromResource(R.mipmap.example8,width,width);

        int width_0 = (int)(screenWidthAndHeight[0]*0.048);
        Bitmap love = decodeSampledBitmapFromResource(R.mipmap.love,width_0,width_0);
        Bitmap saw = decodeSampledBitmapFromResource(R.mipmap.saw,width_0,width_0);
        Bitmap comment = decodeSampledBitmapFromResource(R.mipmap.comment,width_0,width_0);


        for(int i=0;i<10;i++){
			
            map.put("head",bitmap1);
            map.put("name","金小洛");
            map.put("club","武大印包");
            map.put("content","一个是华丽短暂的梦，一个事残酷漫长的现实。你会怎么选？");
            map.put("picture1",bitmap2);
            map.put("picture2",bitmap3);
            map.put("picture3",bitmap4);

            map.put("love","10");
            map.put("saw","20");
            map.put("comment","200");
            map.put("otherHead1",bitmap5);
            map.put("otherHead2",bitmap6);
            map.put("otherHead3",bitmap7);

            map.put("loveicon",love);
            map.put("sawicon",saw);
            map.put("commenticon",comment);
            listdata.add(map);
            map = new HashMap<>();
        }
        return listdata;
    }

    /**
     * 根据计算的inSampleSize，得到压缩后图片
     *
     * @param id
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    private Bitmap decodeSampledBitmapFromResource(int id,
                                                   int reqWidth, int reqHeight)
    {
        // 第一次解析将inJustDecodeBounds设置为true，来获取图片大小
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(),id,options);
        // 调用上面定义的方法计算inSampleSize值
        options.inSampleSize = calculateInSampleSize(options, reqWidth,
                reqHeight);
        // 使用获取到的inSampleSize值再次解析图片
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),id, options);
        return bitmap;
    }

    /**
     * 计算inSampleSize，用于压缩图片
     *
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    private int calculateInSampleSize(BitmapFactory.Options options,
                                      int reqWidth, int reqHeight)
    {
        // 源图片的宽度
        int width = options.outWidth;
        int height = options.outHeight;
        int inSampleSize = 1;

        if (width > reqWidth && height > reqHeight)
        {
            // 计算出实际宽度和目标宽度的比率
            int widthRatio = Math.round((float) width / (float) reqWidth);
            int heightRatio = Math.round((float) height / (float) reqHeight);
            inSampleSize = Math.max(widthRatio, heightRatio);
        }
        return inSampleSize;
    }


}
