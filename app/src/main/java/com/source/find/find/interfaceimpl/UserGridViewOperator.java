package com.source.find.find.interfaceimpl;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.source.find.find.R;
import com.source.find.find.home.GridViewInterface;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by hanjun on 2016/5/20.
 */
public class UserGridViewOperator implements GridViewInterface {

    public View handle(View convertView, ViewGroup parent, int position,
                       Context context, ArrayList<Map<String, Object>> list){
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.user_griditem_layout,parent, false);
            DisplayMetrics dm = new DisplayMetrics();
            ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(dm);
            convertView.getLayoutParams().height = (int)(dm.heightPixels*0.053);
            holder.tv_club = (TextView) convertView
                    .findViewById(R.id.tv_club);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_club.setText((String)list.get(position).get("club"));

        return convertView;
    }

    private class ViewHolder{
        TextView tv_club;
    }
}
