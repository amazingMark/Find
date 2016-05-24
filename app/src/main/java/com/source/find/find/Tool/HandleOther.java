package com.source.find.find.Tool;

import android.app.Activity;
import android.os.Build;
import android.view.WindowManager;

/**
 * Created by hanjun on 2016/5/23.
 */
public class HandleOther {
    public static void setTranslucent(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

}
