package com.source.find.find.interfaceimpl;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.source.find.find.R;
import com.source.find.find.home.GridViewInterface;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by hanjun on 2016/5/16.
 */
public class SchoolActivityOperator implements GridViewInterface {
    public View handle(View convertView, ViewGroup parent, int position,
                       Context context, ArrayList<Map<String, Object>> list){
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.school_listview_item_layout,parent, false);
            convertView.getLayoutParams().height = parent.getHeight()/3;
            holder.iv_activity = (ImageView) convertView
                    .findViewById(R.id.iv_activity);
            holder.tv_month = (TextView) convertView
                    .findViewById(R.id.tv_month);
            holder.tv_date = (TextView) convertView
                    .findViewById(R.id.tv_date);
            holder.tv_school = (TextView) convertView
                    .findViewById(R.id.tv_school);
            holder.tv_club = (TextView) convertView
                    .findViewById(R.id.tv_club);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.iv_activity.setImageBitmap((Bitmap)list.get(position).get("activity"));
        holder.tv_month.setText((String)list.get(position).get("month"));
        holder.tv_date.setText((String)list.get(position).get("date"));
        holder.tv_school.setText((String)list.get(position).get("school"));
        holder.tv_club.setText((String)list.get(position).get("club"));
        return convertView;
    }

    private class ViewHolder{
        ImageView iv_activity;
        TextView tv_month;
        TextView tv_date;
        TextView tv_school;
        TextView tv_club;
    }
}
