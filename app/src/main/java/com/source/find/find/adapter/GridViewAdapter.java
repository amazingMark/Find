package com.source.find.find.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.find.HomePage.GridViewInterface;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by hanjun on 2016/5/15.
 */
public class GridViewAdapter extends BaseAdapter {

    ArrayList<Map<String, Object>> ls;
    Context mContext;
    GridViewInterface Interface;

    public GridViewAdapter(Context context, ArrayList<Map<String,Object>> list,GridViewInterface Interface){
        mContext = context;
        ls = list;
        this.Interface =Interface;
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
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       return Interface.handle(convertView,parent,position,mContext,ls);
    }
}
