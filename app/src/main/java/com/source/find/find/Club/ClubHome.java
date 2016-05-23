package com.source.find.find.club;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.source.find.find.R;
import com.source.find.find.chat.ChatGroupActivity;

public class ClubHome extends AppCompatActivity implements View.OnClickListener {

    private ImageButton ibToDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_home);

        init();
    }

    public void init() {

        ibToDetail = (ImageButton) findViewById(R.id.ib_club_home_title_down);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.ib_club_home_title_pre:
                intent.setClass(ClubHome.this, ClubFrament.class);
                break;
            case R.id.ib_club_home_title_down:
                intent.setClass(ClubHome.this,ClubDetail.class);
                break;
            case R.id.btn_club_home_title_chatgroup:
                intent.setClass(ClubHome.this,ChatGroupActivity.class);
                break;
        }

        startActivity(intent);
    }
}
