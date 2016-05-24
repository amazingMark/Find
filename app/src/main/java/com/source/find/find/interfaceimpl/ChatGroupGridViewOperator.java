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
 * Created by hanjun on 2016/5/15.
 */
public class ChatGroupGridViewOperator implements GridViewInterface {
    public View handle(View convertView, ViewGroup parent, int position,
                       Context context,ArrayList<Map<String, Object>> list){
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.chatgroup_griditem_layout,parent, false);
            convertView.getLayoutParams().height = parent.getRootView().getHeight()/5;
            holder.imageview = (ImageView) convertView
                    .findViewById(R.id.imageview);
            holder.title = (TextView) convertView
                    .findViewById(R.id.title);
            holder.content = (TextView) convertView
                    .findViewById(R.id.content);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageview.setImageBitmap((Bitmap)list.get(position).get("imageview"));
        holder.content.setText((String)list.get(position).get("content"));
        holder.title.setText((String)list.get(position).get("title"));
        return convertView;
    }

    private class ViewHolder{
        ImageView imageview;
        TextView title;
        TextView content;
    }
}
