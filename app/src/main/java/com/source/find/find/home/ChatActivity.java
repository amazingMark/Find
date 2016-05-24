package com.source.find.find.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.source.find.find.R;


public class ChatActivity extends AppCompatActivity {

    EditText et_input;
    ImageView tv_add;
    View rl_input,rl_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Init();
        et_input.getLayoutParams().height = (int)(getScreenHeightAndWidth()[1]*0.044);
        rl_title.getLayoutParams().height = (int)(getScreenHeightAndWidth()[1]*0.11);
        rl_input.getLayoutParams().height = (int)(getScreenHeightAndWidth()[1]*0.07);

    }

    public void Init(){
        et_input = (EditText)findViewById(R.id.et_input);
        tv_add = (ImageView)findViewById(R.id.tv_add);
        rl_input = findViewById(R.id.rl_input);
        rl_title = findViewById(R.id.rl_title);
    }

    public int[] getScreenHeightAndWidth(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        return new int[]{dm.widthPixels,dm.heightPixels};
    }
}
