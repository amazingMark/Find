package com.source.find.find.application;

import android.app.Application;
import android.content.Context;


/**
 * Created by amazing on 2016/5/16.
 */
public class FindApplication extends Application {

    private static FindApplication app = new FindApplication();
    private int screenHeight = 0;
    private int screenWidth = 0;

    private FindApplication() {

    }

    public static FindApplication getInstance() {
        return app;
    }


    public int getScreenY(Context context) {

        return this.screenHeight;
    }

    public int getScreenX() {
        return this.screenWidth;
    }

    public void setScreenHeight(int h) {
        screenHeight = h;
    }

    public void setScreenWidth(int w) {
        screenWidth = w;
    }
}
