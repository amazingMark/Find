package com.source.find.find.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.find.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Adapter.GridViewAdapter;
import InterfaceRealization.ChatGroupGridViewOperator;

public class ChatGroupActivity extends AppCompatActivity {

    GridView gridview;
    ArrayList<Map<String, Object>> ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_group);
        gridview = (GridView)findViewById(R.id.gridView);
        ls=getLs();
        gridview.setAdapter(new GridViewAdapter(this,ls,new ChatGroupGridViewOperator()));
    }

    public ArrayList<Map<String, Object>> getLs(){
        ArrayList<Map<String, Object>> ls = new ArrayList();
        Map map = new HashMap();
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.mipmap.example6);

        for(int i=0;i<10;i++){
            map.put("imageview",bitmap2);
            map.put("title","天涯聊天室");
            map.put("content","在线20人");
            ls.add(map);
            map = new HashMap();
        }
        return ls;
    }
}
