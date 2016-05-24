package com.source.find.find.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by hanjun on 2016/5/15.
 */
public interface GridViewInterface {
    public View  handle(View convertView, ViewGroup parent, int position, Context context, ArrayList<Map<String,
            Object>> list);
}
