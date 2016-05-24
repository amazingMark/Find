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

import MyView.RoundImageView;

/**
 * Created by hanjun on 2016/5/20.
 */
public class UserListViewOperator implements GridViewInterface {

    public View handle(View convertView, ViewGroup parent, int position,
                       Context context, ArrayList<Map<String, Object>> list) {
        ViewHolder holder;
        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.homepage_listitem_dynamic_layout,
                    parent, false);
            holder = new ViewHolder();

            holder.head = (RoundImageView) convertView
                    .findViewById(R.id.head);
            holder.name = (TextView) convertView
                    .findViewById(R.id.name);
            holder.club = (TextView) convertView
                    .findViewById(R.id.club);
            holder.content = (TextView) convertView
                    .findViewById(R.id.content);
            holder.picture[0] = (ImageView) convertView
                    .findViewById(R.id.imageView1);
            holder.picture[1] = (ImageView) convertView
                    .findViewById(R.id.imageView2);
            holder.picture[2] = (ImageView) convertView
                    .findViewById(R.id.imageView3);
            convertView.setTag(holder);


        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.head.setImageBitmap((Bitmap)list.get(position).get("head"));
        holder.name.setText((String)list.get(position).get("name"));
        holder.club.setText((String)list.get(position).get("club"));
        holder.content.setText((String)list.get(position).get("content"));
        holder.picture[0].setImageBitmap((Bitmap)list.get(position).get("picture1"));
        holder.picture[1].setImageBitmap((Bitmap)list.get(position).get("picture2"));
        holder.picture[2].setImageBitmap((Bitmap)list.get(position).get("picture3"));

        return convertView;
    }
    public class ViewHolder {
        RoundImageView head;
        TextView name;
        TextView club;
        TextView content;
        ImageView[] picture = new ImageView[3];
    }
}
