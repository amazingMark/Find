package com.source.find.find.Club;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.source.find.find.R;
import com.source.find.find.activity.MainActivity;


public class CreateClubActivity extends Activity implements View.OnClickListener {

    private ImageButton btn_pre;
    private Button btn_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_club);
        init();
    }

    public void init() {
        btn_pre = (ImageButton) findViewById(R.id.btn_create_club_pre);
        btn_create = (Button) findViewById(R.id.btn_create_club_create);
        btn_pre.setOnClickListener(this);
        btn_create.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_create_club_pre:
                intent.setClass(CreateClubActivity.this,MainActivity.class);
            case R.id.btn_create_club_create:
                intent.setClass(CreateClubActivity.this,MainActivity.class);
        }
        startActivity(intent);
    }
}
