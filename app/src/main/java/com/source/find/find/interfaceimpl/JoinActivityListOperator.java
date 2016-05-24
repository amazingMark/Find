package com.source.find.find.interfaceimpl;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.find.HomePage.GridViewInterface;
import com.example.find.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by hanjun on 2016/5/23.
 */
public class JoinActivityListOperator implements GridViewInterface{

    public View handle(View convertView, ViewGroup parent, int position,
                       Context context, ArrayList<Map<String, Object>> list){
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.join_activity_list_item,parent, false);
            holder.im_head = (ImageView) convertView
                    .findViewById(R.id.im_head);
            holder.tv_name = (TextView) convertView
                    .findViewById(R.id.tv_name);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.im_head.setImageBitmap((Bitmap)list.get(position).get("im_head"));
        holder.tv_name.setText((String)list.get(position).get("tv_name"));

        return convertView;
    }

    private class ViewHolder{
        ImageView im_head;
        TextView tv_name;
    }
}
