package com.source.find.find.interfaceimpl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.find.HomePage.GridViewInterface;
import com.example.find.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by hanjun on 2016/5/22.
 */
public class PostListViewOperator implements GridViewInterface {

    public View handle(View convertView, ViewGroup parent, int position,
                       Context context, ArrayList<Map<String, Object>> list){
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            int rl_blank_height = (int)(getScreenHeightAndWidth(context)[1]*0.035);

            convertView = inflater.inflate(R.layout.post_list_item,parent, false);
            holder.head = (ImageView) convertView
                    .findViewById(R.id.head);
            holder.tv_lovenum = (TextView) convertView
                    .findViewById(R.id.tv_lovenum);
            holder.name = (TextView) convertView
                    .findViewById(R.id.name);
            holder.time = (TextView) convertView
                    .findViewById(R.id.time);
            holder.content = (TextView) convertView
                    .findViewById(R.id.content);
            holder.rl_blank = (RelativeLayout) convertView
                    .findViewById(R.id.rl_blank);
            holder.rl_blank.getLayoutParams().height = rl_blank_height;
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.head.setImageBitmap((Bitmap)list.get(position).get("head"));
        holder.tv_lovenum.setText((String)list.get(position).get("lovenum"));
        holder.name.setText((String)list.get(position).get("name"));
        holder.time.setText((String)list.get(position).get("time"));
        holder.content.setText((String)list.get(position).get("content"));
        return convertView;
    }

    private class ViewHolder{
        ImageView head;
        TextView tv_lovenum;
        TextView name;
        TextView time;
        TextView content;
        RelativeLayout rl_blank;
    }
    public int[] getScreenHeightAndWidth(Context context){
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        return new int[]{dm.widthPixels,dm.heightPixels};
    }
}
