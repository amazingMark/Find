package com.source.find.find.interfaceimpl;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.source.find.find.R;
import com.source.find.find.home.GridViewInterface;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by hanjun on 2016/5/16.
 */
public class ChangeHeadGridViewOperator implements GridViewInterface {
    public View handle(View convertView, ViewGroup parent, int position,
                       Context context, ArrayList<Map<String, Object>> list){
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.change_head_griditem_layout,parent, false);
            convertView.getLayoutParams().height = (int)(parent.getRootView().getWidth()/3);
            convertView.getLayoutParams().width = convertView.getLayoutParams().height;
            holder.im_content = (ImageView) convertView
                    .findViewById(R.id.im_content);
            holder.im_sign = (ImageView) convertView
                    .findViewById(R.id.im_sign);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.im_content.setImageBitmap((Bitmap)list.get(position).get("content"));
        holder.im_sign.setImageResource(R.mipmap.selected);
        return convertView;
    }

    private class ViewHolder{
        ImageView im_content;
        ImageView im_sign;
    }
}
