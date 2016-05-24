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
import com.source.find.find.scrollpicsview.RoundImageView;

import java.util.ArrayList;
import java.util.Map;



/**
 * Created by hanjun on 2016/5/22.
 */
public class TopicListViewOperator implements GridViewInterface {
    public View handle(View convertView, ViewGroup parent, int position,
                       Context context, ArrayList<Map<String, Object>> list){
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.topic_listitem_dynamic_layout,
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
            holder.tv_lovenum = (TextView) convertView
                    .findViewById(R.id.tv_lovenum);
            holder.tv_saw = (TextView) convertView
                    .findViewById(R.id.tv_saw);
            holder.tv_comment = (TextView) convertView
                    .findViewById(R.id.tv_comment);
            holder.otherHead[0] = (ImageView) convertView
                    .findViewById(R.id.im_head_1);
            holder.otherHead[1] = (ImageView) convertView
                    .findViewById(R.id.im_head_2);
            holder.otherHead[2] = (ImageView) convertView
                    .findViewById(R.id.im_head_3);

            holder.icon[0] = (ImageView) convertView
                    .findViewById(R.id.im_love);
            holder.icon[1] = (ImageView) convertView
                    .findViewById(R.id.im_saw);
            holder.icon[2] = (ImageView) convertView
                    .findViewById(R.id.im_comment);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.head.setImageBitmap((Bitmap)list.get(position).get("head"));
        holder.name.setText((String)list.get(position).get("name"));
        holder.club.setText((String)list.get(position).get("club"));
        holder.content.setText((String)list.get(position).get("content"));
        holder.picture[0].setImageBitmap((Bitmap)list.get(position).get("picture1"));
        holder.picture[1].setImageBitmap((Bitmap)list.get(position).get("picture2"));
        holder.picture[2].setImageBitmap((Bitmap)list.get(position).get("picture3"));
        holder.tv_lovenum.setText((String)list.get(position).get("love"));
        holder.tv_saw.setText((String)list.get(position).get("saw"));
        holder.tv_comment.setText((String)list.get(position).get("comment"));
        holder.otherHead[0].setImageBitmap((Bitmap)list.get(position).get("otherHead1"));
        holder.otherHead[1].setImageBitmap((Bitmap)list.get(position).get("otherHead2"));
        holder.otherHead[2].setImageBitmap((Bitmap)list.get(position).get("otherHead3"));
        holder.icon[0].setImageBitmap((Bitmap)list.get(position).get("loveicon"));
        holder.icon[1].setImageBitmap((Bitmap)list.get(position).get("sawicon"));
        holder.icon[2].setImageBitmap((Bitmap)list.get(position).get("commenticon"));

        return convertView;
    }

    private class ViewHolder{
        RoundImageView head;
        TextView name;
        TextView club;
        TextView content;
        ImageView[] picture = new ImageView[3];
        TextView tv_lovenum;
        TextView tv_saw;
        TextView tv_comment;
        ImageView[] otherHead = new ImageView[3];
        ImageView[] icon = new ImageView[3];


    }
}
