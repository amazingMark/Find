package com.source.find.find.setting;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


import com.source.find.find.R;
import com.source.find.find.adapter.GridViewAdapter;
import com.source.find.find.interfaceimpl.SchoolActivityOperator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class MyActivityActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Map<String, Object>> ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        listView = (ListView)findViewById(R.id.listView);
        ls=getLs();
        listView.setAdapter(new GridViewAdapter(this,ls,new SchoolActivityOperator()));
    }

    public ArrayList<Map<String, Object>> getLs(){
        ArrayList<Map<String, Object>> ls = new ArrayList();
        Map map = new HashMap();
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.mipmap.example6);

        for(int i=0;i<10;i++){
            map.put("activity",bitmap2);
            map.put("month","5月");
            map.put("date","10");
            map.put("school","武汉大学");
            map.put("club","武汉大学印包摄影协会");
            ls.add(map);
            map = new HashMap();
        }
        return ls;
    }
}
